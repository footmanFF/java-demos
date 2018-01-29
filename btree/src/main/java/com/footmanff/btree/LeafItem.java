package com.footmanff.btree;

/**
 * 叶子节点的索引项
 * 
 * @author zhangli on 26/01/2018.
 */
public class LeafItem<V extends Comparable<V>> {

    /**
     * 索引项值
     */
    private V value;

    /**
     * 持久化数据
     */
    private PersistentData<V> data;

    /**
     * 下一个索引项
     */
    private LeafItem<V> next;

    /**
     * 索引项所属叶子节点
     */
    private Leaf<V> leaf;

    public V getValue() {
        return value;
    }

    public LeafItem<V> setValue(V value) {
        this.value = value;
        return this;
    }

    public PersistentData<V> getData() {
        if (data == null) {
            PersistentData<V> temp = new PersistentData<>();
            temp.setKey(this.value);
            return temp;
        }
        return data;
    }

    public LeafItem<V> setData(PersistentData<V> data) {
        this.data = data;
        return this;
    }

    public LeafItem<V> getNext() {
        return next;
    }

    public LeafItem<V> setNext(LeafItem<V> next) {
        this.next = next;
        return this;
    }

    public Leaf<V> getLeaf() {
        return leaf;
    }

    public LeafItem<V> setLeaf(Leaf<V> leaf) {
        this.leaf = leaf;
        return this;
    }
}