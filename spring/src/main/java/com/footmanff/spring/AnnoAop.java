package com.footmanff.spring;

import java.lang.annotation.*;

/**
 * @author footmanff on 2017/12/12.
 */
@Target({ElementType.METHOD})
@Retention( RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnoAop {
}
