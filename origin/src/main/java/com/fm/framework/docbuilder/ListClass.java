package com.fm.framework.docbuilder;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;

/**
 * @author footmanff on 2017/8/12.
 */
public class ListClass {

    public static boolean start(RootDoc root) {
        ClassDoc[] classes = root.classes();
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i]);
            ClassDoc classDoc = classes[i];
            if(classDoc.toString().contains("Tt")){
                Tag[] tags1 = classDoc.tags("code");
                Tag[] tags2 = classDoc.tags("desc");
                Tag[] tags3 = classDoc.tags("app");
                int a = 0;
            }
        }
        return true;
    }

}
