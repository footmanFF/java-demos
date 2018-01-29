package com.footmanff.btree;

/**
 * 树中的叶子节点
 * 
 * @author zhangli on 26/01/2018.
 */
public class Leaf<V extends Comparable<V>> implements Node {

    /**
     * 父节点
     */
    private Trunk<V> parent;

    /**
     * 一个叶子节点的内部索引项的链表
     */
    private LeafItem<V> headItem;

    /**
     * 下一个叶子节点
     */
    private Leaf<V> nextLeaf;

    public Trunk<V> getParent() {
        return parent;
    }

    public void setParent(Trunk<V> parent) {
        this.parent = parent;
    }

    public LeafItem<V> getHeadItem() {
        return headItem;
    }

    public void setHeadItem(LeafItem<V> headItem) {
        this.headItem = headItem;
    }

    public Leaf<V> getNextLeaf() {
        return nextLeaf;
    }

    public void setNextLeaf(Leaf<V> nextLeaf) {
        this.nextLeaf = nextLeaf;
    }
}
