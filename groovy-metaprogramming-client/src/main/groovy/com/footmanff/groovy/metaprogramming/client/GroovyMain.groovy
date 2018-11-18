package com.footmanff.groovy.metaprogramming.client

/**
 * @author footmanff on 2018/11/18.
 */
class GroovyMain {
    def greet() {
        println "Hello World"
    }

    static void main(String[] args) {
        def main = new GroovyMain()
        main.greet()
    }
}
