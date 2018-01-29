package com.footmanff.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * B+树对象
 *
 * @param <V> 索引字段类型
 * @author zhangli on 26/01/2018.
 */
public class BTree<V extends Comparable<V>> {

    private Node root;

    public void setTree(Trunk<V> root) {
        this.root = root;
    }

    /**
     * 往B+树中写入一行数据
     */
    public void insert(V id, PersistentData data) {
        if (root == null) {
            root = new Leaf<V>();
            
        } else {
            
        }
        
    }

    /**
     * 在B+树上查找id对应的数据行
     */
    public List<PersistentData<V>> find(V id) {
        if (root == null) {
           throw new RuntimeException("B树未初始化"); 
        }
        if (root instanceof Leaf && ((Leaf) root).getHeadItem() == null) {
            return Collections.emptyList();
        }
        // TODO 处理根节点就是叶子的情况
        Node node = root;
        // 从根开始逐层去找满足区间条件的叶子节点
        while (node != null && node instanceof Trunk) {
            Trunk<V> trunk = (Trunk)node;
            node = findNextNode(trunk, id);
        }
        // 理论上的B+树，这里的node不会为Null
        Leaf<V> leaf = (Leaf)node;
        LeafItem leafItem = leaf.getHeadItem();
        
        Leaf<V> nextLeaf = leaf;
        List<PersistentData<V>> result = new ArrayList<>();
        
        // 在叶子节点上收集和id一致的数据节点
        while (leafItem != null) {
            if (leafItem.getValue().equals(id)) {
                result.add(leafItem.getData());
            }
            leafItem = leafItem.getNext();
            if (leafItem == null) {
                // 同一个key多行数据的情况，需要用next指针去收集可能的其他的数据行
                nextLeaf = nextLeaf.getNextLeaf();
                if (nextLeaf == null) {
                    break;
                }
                leafItem = nextLeaf.getHeadItem();
            }
            // 应为叶子节点的数据节点是排序好的
            // 所以一点节点的值大于请求参数，即可结束查找
            if (leafItem.getValue().compareTo(id) > 0) {
                break;
            }
        }
        return result;
    }

    /**
     * 查找id在树干节点上对应的满足区间条件的子节点
     * 
     * @param trunk 树干节点
     * @param id 查找的值
     */
    private Node findNextNode(Trunk<V> trunk, V id){
        TrunkItem<V> thisItem = trunk.getHeadItem(); // 不会为null
        while (id.compareTo(thisItem.getValue()) >= 0) {
            if (id.compareTo(thisItem.getValue()) == 0) {
                break;
            }
            if (thisItem.getNext() == null) {
                break;
            }
            thisItem = thisItem.getNext();
        }
        int compare = id.compareTo(thisItem.getValue());
        if (compare < 0) {
            return thisItem.getLeft();
        } else {
            return thisItem.getRight();
        }
    }

    /**
     * 从B+树中删除一行数据
     */
    public void delete(V id) {
        // TODO
    }

    public void display() {
        // TODO 图形化展示
    }
    
}
