package com.footmanff.btree;

/**
 * 树中的树干节点
 *
 * @author footmanff on 26/01/2018.
 */
public class Trunk<V extends Comparable<V>> implements Node<V> {

    /**
     * 父树干节点
     */
    private Trunk<V> parent;

    /**
     * 一个树干节点的内部索引项的链表
     */
    private TrunkItem<V> headItem;

    /**
     * 链表的尾部
     */
    private TrunkItem<V> tailItem;
    
    /**
     * 初始默认使用{@link #Trunk(Node, Node, Comparable)}
     */
    @Deprecated
    public Trunk() {
    }

    /**
     * 构建一个初始包含一个节点的树干节点
     *
     * @param left  左区间
     * @param right 右区间
     * @param value 节点索引值
     */
    public Trunk(Node<V> left, Node<V> right, V value) {
        TrunkItem<V> item = new TrunkItem<>();
        item.setTrunk(this);
        item.setValue(value);
        item.setLeft(left);
        item.setRight(right);
        headItem = item;
        tailItem = item;
    }

    /**
     * 在树干节点的末尾增加一个数据索引项
     *
     * @param value   索引值
     * @param subNode 索引指向的子节点
     */
    public void appendItem(V value, Node subNode) {
        TrunkItem<V> newItem = new TrunkItem<>();
        newItem.setLeft(tailItem.getRight());
        newItem.setRight(subNode);
        newItem.setValue(value);
        newItem.setTrunk(this);
        tailItem.setNext(newItem);
        tailItem = newItem;
    }

    @Override
    public boolean isRoot() {
        return parent == null;
    }

    @Override
    public Trunk<V> getParent() {
        return parent;
    }

    @Override
    public void setParent(Trunk<V> parent) {
        this.parent = parent;
    }

    public TrunkItem<V> getHeadItem() {
        return headItem;
    }

    public Trunk setHeadItem(TrunkItem<V> headItem) {
        this.headItem = headItem;
        return this;
    }

    public TrunkItem<V> getTailItem() {
        return tailItem;
    }

    public Trunk<V> setTailItem(TrunkItem<V> tailItem) {
        this.tailItem = tailItem;
        return this;
    }
    
}