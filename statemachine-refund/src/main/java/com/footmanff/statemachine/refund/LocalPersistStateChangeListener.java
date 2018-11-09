package com.footmanff.statemachine.refund;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.transition.Transition;
import org.springframework.statemachine.state.State;

/**
 * @author footmanff on 2018/10/25.
 */
public class LocalPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {

    @Override
    public void onPersist(
            State<String, String> state,                // 跳转的源状态
            Message<String> message,                    // 事件消息
            Transition<String, String> transition,      // 一次状态跳转
            StateMachine<String, String> stateMachine   // 状态机对象
    ) {
        // message中保存了事件所带的数据
        Object obj1 = message.getHeaders().get("key1");

        // extendedState是一个执行上下文，在内部可以定义和传输业务需要的数据
        Object obj2 = stateMachine.getExtendedState().get("key2", Object.class);
    }
    
}
    
