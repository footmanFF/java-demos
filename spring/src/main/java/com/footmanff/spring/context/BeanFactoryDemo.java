package com.footmanff.spring.context;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author footmanff on 05/02/2018.
 */
public class BeanFactoryDemo {

    @Test
    public void t1(){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        com.footmanff.spring.context2.BeanHolder beanHolder = (com.footmanff.spring.context2.BeanHolder)ctx.getBean("beanHolder");

        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:spring.xml");
        
    }
    
}