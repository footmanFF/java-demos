package com.footmanff.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fm on 2017/3/19.
 */
@Component
public class InitializationTimeBeanPostProcessor implements BeanPostProcessor, ApplicationListener, Ordered {

    public static Map<String, Long> timeMap = new ConcurrentHashMap<>();
    public static Map<String, Long> timeMapCost = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        timeMap.put(beanName, System.currentTimeMillis());
        System.out.println("Initializing bean " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " cost:" + (System.currentTimeMillis() - timeMap.get(beanName)));
        timeMapCost.put(beanName, (System.currentTimeMillis() - timeMap.get(beanName)));
        return bean;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        postProcessBeanFactory();
    }

    public void postProcessBeanFactory() {
        List<Map.Entry<String, Long>> list = new ArrayList<>();
        list.addAll(timeMapCost.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        list.forEach((entry) -> {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        });
    }

    @Override
    public int getOrder() {
        return 0; // TODO
    }

}
