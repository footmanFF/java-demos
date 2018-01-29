package com.footmanff.btree;

/**
 * 树中的树干节点
 * 
 * @author zhangli on 26/01/2018.
 */
public class Trunk<V extends Comparable<V>> implements Node {

    /**
     * 父树干节点
     */
    private Trunk<V> parent;

    /**
     * 一个树干节点的内部索引项的链表
     */
    private TrunkItem<V> headItem;

    public Trunk<V> getParent() {
        return parent;
    }

    public Trunk setParent(Trunk<V> parent) {
        this.parent = parent;
        return this;
    }

    public TrunkItem<V> getHeadItem() {
        return headItem;
    }

    public Trunk setHeadItem(TrunkItem<V> headItem) {
        this.headItem = headItem;
        return this;
    }
}