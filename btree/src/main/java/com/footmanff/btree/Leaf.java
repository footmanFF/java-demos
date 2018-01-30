package com.footmanff.btree;

/**
 * 树中的叶子节点
 *
 * @author footmanff on 26/01/2018.
 */
class Leaf<V extends Comparable<V>> implements Node<V> {

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

    /**
     * headItem指向的链表的节点数
     */
    private int itemCount = 0;

    @Override
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 根据下表获取链表中的某个节点
     * 
     * @param i [1, itemCount]
     */
    public LeafItem<V> getByIndex(int i) {
        if (i <= 0 || i > itemCount) {
            throw new RuntimeException("节点下标超出范围(1 - " + itemCount +")");
        }
        LeafItem<V> item = headItem;
        int c = 0;
        while (item != null) {
            c ++;
            if (i == c) {
                return item;
            }
            item = item.getNext();
        }
        return null;
    }

    /**
     * 在叶子的节点链表中添加一项，自动从小到大排序
     */
    public void addItemInLimit(V v) {
        PersistentData<V> data = new PersistentData<>();
        data.setKey(v);
        addItemInLimit(v, data);        
    }
    
    /**
     * 在叶子的节点链表中添加一项，自动从小到大排序
     */
    public void addItemInLimit(V v, PersistentData<V> data) {
        if (v == null || data == null) {
            throw new NullPointerException("v或data不得为null");
        }
        // 如果链表为空就新建
        if (headItem == null) {
            headItem = new LeafItem<>();
            headItem.setLeaf(this);
            headItem.setValue(v);
            headItem.setData(data);
            itemCount++;
            return;
        }
        // 如果v小于或等于链表中的第一个节点就将v加在最前端
        if (v.compareTo(headItem.getValue()) <= 0) {
            LeafItem item = new LeafItem<>();
            item.setLeaf(this);
            item.setValue(v);
            item.setNext(headItem);
            item.setData(data);
            headItem = item;
            itemCount++;
            return;
        }
        // 寻找一个K1<=v<=K2的位置去将v插入链表 
        LeafItem<V> item = headItem;
        while (item != null) {
            LeafItem<V> next = item.getNext();
            if (v.compareTo(item.getValue()) >= 0 && (next == null || v.compareTo(next.getValue()) <= 0)) {
                break;
            }
            item = next;
        }
        LeafItem newItem = new LeafItem<>();
        newItem.setLeaf(this);
        newItem.setValue(v);
        newItem.setNext(item.getNext());
        newItem.setData(data);
        item.setNext(newItem);
        itemCount++;
    }

    @Override
    public Trunk<V> getParent() {
        return parent;
    }

    @Override
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

    public int getItemCount() {
        return itemCount;
    }

}
