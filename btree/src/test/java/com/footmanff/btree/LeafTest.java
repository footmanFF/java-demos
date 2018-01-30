package com.footmanff.btree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author footmanff on 30/01/2018.
 */
public class LeafTest {

    /**
     * Srinivasan - Wu
     */
    @Test
    public void addItemInLimit() {
        Leaf<String> leaf = TestUtil.testLeaf();
        leaf.addItemInLimit("A");
        assertEquals(leaf.getHeadItem().getValue(), "A");
        assertEquals(leaf.getHeadItem().getNext().getValue(), "Srinivasan");
        assertEquals(leaf.getHeadItem().getNext().getNext().getValue(), "Wu");

        leaf = TestUtil.testLeaf();
        leaf.addItemInLimit("T");
        assertEquals(leaf.getHeadItem().getValue(), "Srinivasan");
        assertEquals(leaf.getHeadItem().getNext().getValue(), "T");
        assertEquals(leaf.getHeadItem().getNext().getNext().getValue(), "Wu");

        leaf = TestUtil.testLeaf();
        leaf.addItemInLimit("Z");
        assertEquals(leaf.getHeadItem().getValue(), "Srinivasan");
        assertEquals(leaf.getHeadItem().getNext().getValue(), "Wu");
        assertEquals(leaf.getHeadItem().getNext().getNext().getValue(), "Z");
    }

    /**
     * Srinivasan - Wu
     */
    @Test
    public void getByIndex()  {
        Leaf<String> leaf = TestUtil.testLeaf();
        LeafItem<String> item = leaf.getByIndex(1);
        assertEquals(item.getValue(), "Srinivasan");

        item = leaf.getByIndex(2);
        assertEquals(item.getValue(), "Wu");
    }
}