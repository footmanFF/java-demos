package com.fm.framework.docbuilder;

import com.sun.tools.javadoc.Main;

/**
 * @author footmanff on 2017/8/12.
 */
public class DocBuilder {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        String[] params = new String[]{
                "-doclet", "com.fm.framework.docbuilder.ListClass",
                // "-d", "/tmp/doc",
                // "-sourcepath", "/Users/zhangli/Work/idea_workspace/java-demos/src/main/java",
                "-sourcepath", "./src/main/java",
                "-subpackages", "com.fm.framework.docbuilder"
        };
        Main.execute(params);
    }

}
