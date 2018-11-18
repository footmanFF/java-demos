package com.footmanff.groovy.metaprogramming;

import org.codehaus.groovy.transform.GroovyASTTransformationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author footmanff on 2018/11/18.
 */
@Retention( RetentionPolicy.SOURCE )
@Target( ElementType.METHOD )
@GroovyASTTransformationClass( "com.footmanff.groovy.metaprogramming.WithLoggingASTTransformation" )
public @interface WithLogging {


}