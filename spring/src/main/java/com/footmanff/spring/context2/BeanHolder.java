package com.footmanff.spring.context2;

/**
 * @author footmanff on 06/02/2018.
 */
public class BeanHolder {
    
    private SomeBean someBean;

    public SomeBean getSomeBean() {
        return someBean;
    }

    public BeanHolder setSomeBean(SomeBean someBean) {
        this.someBean = someBean;
        return this;
    }
    
}
