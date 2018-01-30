package com.footmanff.btree;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * @author footmanff on 29/01/2018.
 */
public class BTreeTest {

    private String[] testKeys = {"Wu", "Srinivasan", "Mozart", "Kim", "Katz", "Gold", 
            "ElSaid", "Einstein", "Crick", "Caliﬁeri", "Brandt", "Adams"};

    @Test
    public void find() {
        for (String key : testKeys) {
            BTree<String> tree = TestUtil.testTree();
            List<PersistentData<String>> list = tree.find(key);
            assertEquals(list.size(), 1);
            assertEquals(list.get(0).getKey(), key);
        }
    }

    @Test
    public void find2() {
        BTree<String> tree = TestUtil.testTree();
        List<PersistentData<String>> list = tree.find("Singh");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getKey(), "Singh");
        assertEquals(list.get(1).getKey(), "Singh");
    }

    @Test
    public void find3() {
        BTree<String> tree = TestUtil.testTree();
        List<PersistentData<String>> list = tree.find("aaaa");
        assertEquals(list.size(), 0);
    }

    @Test
    public void find4() {
        BTree<String> tree = TestUtil.testTree2();
        List<PersistentData<String>> list = tree.find("Srinivasan");
        assertEquals(list.size(), 1);

        list = tree.find("Wu");
        assertEquals(list.size(), 1);
        
        list = tree.find("aaa");
        assertEquals(list.size(), 0);
    }
    
}