package com.fm.framework.docbuilder;

import com.sun.tools.javadoc.Main;

/**
 * @author zhangli on 2017/8/12.
 */
public class DocBuilder {

    /**
     * hello
     * @param args
     */
    public static void main(String[] args) {
        String[] params = new String[]{
                "-doclet", "com.fm.framework.docbuilder.ListClass",
                // "-d", "/tmp/doc",
                "-sourcepath", "/Users/zhangli/Work/idea_workspace/java-demos/src/main/java",
                "-subpackages", "com.fm.framework.docbuilder"
        };
        Main.main(params);
    }

}
