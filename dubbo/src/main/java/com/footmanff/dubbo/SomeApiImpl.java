package com.footmanff.dubbo;

import org.springframework.stereotype.Component;

/**
 * @author footmanff on 2018/1/4.
 */
@Component("someApi")
public class SomeApiImpl implements SomeApi {

    @Override
    public String call() {
        return "hello";
    }
    
}
