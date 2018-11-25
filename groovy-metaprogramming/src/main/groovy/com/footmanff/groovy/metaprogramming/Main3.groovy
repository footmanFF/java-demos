package com.footmanff.groovy.metaprogramming

/**
 * @author footmanff on 2018/11/25.
 */
class Main3 {

    static void main(String[] args) {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(Main3.classLoader)
        def gclass = groovyClassLoader.parseClass(new File("groovy-metaprogramming/src/main/groovy/com/footmanff/groovy/metaprogramming/Main.groovy"))
    }
    
}
