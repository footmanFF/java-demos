package com.footmanff.jdktest.gc;

import com.footmanff.jdktest.Utils;
import com.footmanff.jdktest.Utils;
import org.junit.Test;

/**
 * @author footmanff on 2017/11/18.
 */
public class G1Test {

    /**
     * -ea -XX:+PrintGCDetails -XX:+UseG1GC
     */
    @Test
    public void test2() {
        int loop = 100000000;
        int memory = 1024;   // 1M
        for (int i = 0; i < loop; i++) {
            byte[] bs = new byte[memory];
        }
        Utils.sleep(30000);
    }
    
}
