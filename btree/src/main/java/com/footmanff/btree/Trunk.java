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
     * 索引节数
     */
    private int itemCount = 0;
    
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
        itemCount = 1;
    }

    /**
     * 在树干节点中新增一个数据索引项
     *
     * @param value   索引值
     * @param subNode 索引指向的子节点
     */
    public void addItem(V value, Node subNode) {
        TrunkItem<V> item = headItem;
        // TODO
//        if (value.compareTo(item.getValue()) >= 0) {
//        }
        while (item != null) {
            TrunkItem<V> next = item.getNext();
            if (value.compareTo(item.getValue()) >= 0 && (next == null || value.compareTo(next.getValue()) <= 0)) {
                break;
            }
            item = next;
        }
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

    public int getItemCount() {
        return itemCount;
    }
}