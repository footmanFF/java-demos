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

    // TODO 增加一个方法来添加LeafItem

    public void addItemInLimit(V v) {
        if (headItem == null) {
            headItem = new LeafItem<>();
            headItem.setLeaf(this);
            headItem.setValue(v);
            return;
        }
        if (v.compareTo(headItem.getValue()) <= 0) {
            LeafItem item = new LeafItem<>();
            item.setLeaf(this);
            item.setValue(v);
            item.setNext(headItem);
            headItem = item;
            return;
        }
        LeafItem<V> item = headItem;
        
        while(item != null){
            LeafItem<V> next = item.getNext();
            // TODO 
            
            item = next;
        }
        
    }

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
