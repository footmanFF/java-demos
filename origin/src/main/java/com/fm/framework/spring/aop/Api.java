package com.fm.framework.spring.aop;

import java.lang.annotation.*;

/**
 * @author zhangli on 2017/8/23.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Api {

    String[] value() default {};

}
