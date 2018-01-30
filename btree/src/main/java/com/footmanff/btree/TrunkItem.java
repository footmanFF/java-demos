package com.footmanff.btree;

/**
 * 树干节点的索引项
 * 
 * @author footmanff on 26/01/2018.
 */
public class TrunkItem<V extends Comparable<V>> {

    /**
     * 索引项值
     */
    private V value;

    /**
     * 下一个索引项
     */
    private TrunkItem<V> next;

    /**
     * 左侧节点
     */
    private Node left;

    /**
     * 右侧节点
     */
    private Node right;

    /**
     * 索引项所属树干节点
     */
    private Trunk<V> trunk;

    public V getValue() {
        return value;
    }

    public TrunkItem<V> setValue(V value) {
        this.value = value;
        return this;
    }

    public TrunkItem<V> getNext() {
        return next;
    }

    public TrunkItem<V> setNext(TrunkItem<V> next) {
        this.next = next;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public TrunkItem<V> setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public TrunkItem<V> setRight(Node right) {
        this.right = right;
        return this;
    }

    public Trunk<V> getTrunk() {
        return trunk;
    }

    public TrunkItem<V> setTrunk(Trunk<V> trunk) {
        this.trunk = trunk;
        return this;
    }
}
