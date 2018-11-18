package com.footmanff.groovy.metaprogramming

/**
 * @author footmanff on 2018/11/18.
 */
class Main {

    @WithLogging
    def greet() {
        println "Hello World"
    }

    static void main(String[] args) {
        def main = new Main()
        main.greet()
    }

}
