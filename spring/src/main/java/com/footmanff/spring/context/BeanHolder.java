package com.footmanff.spring.context;

import com.footmanff.spring.aop.SomeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author footmanff on 06/02/2018.
 */
@Component
public class BeanHolder {
    
    @Autowired
    private SomeBean someBean;
    
}
