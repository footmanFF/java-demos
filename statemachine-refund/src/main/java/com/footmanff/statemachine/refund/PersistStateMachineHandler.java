package com.footmanff.statemachine.refund;

import java.util.Iterator;
import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.access.StateMachineFunction;
import org.springframework.statemachine.listener.AbstractCompositeListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.util.Assert;

/**
 * {@code PersistStateMachineHandler} is a recipe which can be used to
 * handle a state change of an arbitrary entity in a persistent storage.
 *
 * @author Janne Valkealahti
 *
 */
public class PersistStateMachineHandler {

    private final StateMachine<String, String> stateMachine;
    private final PersistingStateChangeInterceptor interceptor = new PersistingStateChangeInterceptor();
    private final CompositePersistStateChangeListener listeners = new CompositePersistStateChangeListener();

    /**
     * Instantiates a new persist state machine handler.
     *
     * @param stateMachine the state machine
     */
    public PersistStateMachineHandler(StateMachine<String, String> stateMachine) {
        Assert.notNull(stateMachine, "State machine must be set");
        this.stateMachine = stateMachine;
    }

    public void init() {
        stateMachine.getStateMachineAccessor().doWithAllRegions(new StateMachineFunction<StateMachineAccess<String,String>>() {
            @Override
            public void apply(StateMachineAccess<String, String> stateMachineAccess) {
                stateMachineAccess.addStateMachineInterceptor(interceptor);
            }
        });
    }

    /**
     * Handle event with entity.
     *
     * @param event the event
     * @param state the state
     * @return true if event was accepted
     */
    public boolean handleEventWithState(Message<String> event, String state) {
        stateMachine.stop();
        
        List<StateMachineAccess<String, String>> withAllRegions = stateMachine.getStateMachineAccessor().withAllRegions();
        for (StateMachineAccess<String, String> a : withAllRegions) {
            a.resetStateMachine(new DefaultStateMachineContext<String, String>(state, null, null, null));
        }
        stateMachine.start();
        return stateMachine.sendEvent(event);
    }

    /**
     * Adds the persist state change listener.
     *
     * @param listener the listener
     */
    public void addPersistStateChangeListener(PersistStateChangeListener listener) {
        listeners.register(listener);
    }

    /**
     * The listener interface for receiving persistStateChange events.
     * The class that is interested in processing a persistStateChange
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addPersistStateChangeListener</code> method. When
     * the persistStateChange event occurs, that object's appropriate
     * method is invoked.
     */
    public interface PersistStateChangeListener {

        /**
         * Called when state needs to be persisted.
         *
         * @param state the state
         * @param message the message
         * @param transition the transition
         * @param stateMachine the state machine
         */
        void onPersist(State<String, String> state, Message<String> message, Transition<String, String> transition,
                StateMachine<String, String> stateMachine);
    }

    private class PersistingStateChangeInterceptor extends StateMachineInterceptorAdapter<String, String> {

        @Override
        public void preStateChange(State<String, String> state, Message<String> message,
                Transition<String, String> transition, StateMachine<String, String> stateMachine) {
            listeners.onPersist(state, message, transition, stateMachine);
        }
    }

    private class CompositePersistStateChangeListener extends AbstractCompositeListener<PersistStateChangeListener> implements
            PersistStateChangeListener {

        @Override
        public void onPersist(State<String, String> state, Message<String> message,
                Transition<String, String> transition, StateMachine<String, String> stateMachine) {
            for (Iterator<PersistStateChangeListener> iterator = getListeners().reverse(); iterator.hasNext();) {
                PersistStateChangeListener listener = iterator.next();
                listener.onPersist(state, message, transition, stateMachine);
            }
        }
    }

}
