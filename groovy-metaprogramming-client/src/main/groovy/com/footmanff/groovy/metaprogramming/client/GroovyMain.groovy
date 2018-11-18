package com.footmanff.groovy.metaprogramming.client

import com.footmanff.groovy.metaprogramming.WithLogging

/**
 * @author footmanff on 2018/11/18.
 */
class GroovyMain {
    
    @WithLogging
    def greet() {
        println "Hello World"
    }

    static void main(String[] args) {
        def main = new GroovyMain()
        main.greet()
    }
}
