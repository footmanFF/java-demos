package com.footmanff.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * B+树对象
 *
 * @param <V> 索引字段类型
 * @author footmanff on 26/01/2018.
 */
public class BTree<V extends Comparable<V>> {

    private final int ITEM_LIMIT = 4;
    private Node root;

    public void setTree(Node root) {
        this.root = root;
    }

    /**
     * 往B+树中写入一行数据
     */
    public void insert(V id, PersistentData data) {
        if (root == null) {
            Leaf<V> leaf = new Leaf<>();
            leaf.addItemInLimit(id, data);
            root = leaf;
        } else {
            // 理论上的B+树，这里的leaf不会为Null
            Leaf<V> leaf = findLeaf(id);
            if (leaf.getItemCount() < ITEM_LIMIT) {
                // 当小于每个叶子可以包含的节点数限制时直接新增节点
                leaf.addItemInLimit(id, data);
            } else {
                // 大于节点数限制，需要分裂叶子节点
                // 先将新id增加进树叶
                leaf.addItemInLimit(id, data);
                // 新建一个叶子并连接进树
                Leaf<V> newLeaf = new Leaf<>();
                newLeaf.setParent(leaf.getParent());
                newLeaf.setNextLeaf(leaf.getNextLeaf());
                leaf.setNextLeaf(newLeaf);

                // 将数据节点拆分并分配给新叶子和老叶子
                LeafItem<V> leftTail = leaf.getByIndex(ITEM_LIMIT / 2);
                LeafItem<V> rightHead = leftTail.getNext();
                leftTail.setNext(null);
                newLeaf.setHeadItem(rightHead);

                // insert into parent
                
            }
        }
    }

    /**
     * 子节点拆分，修改父节点结构以适应B+树结构
     *
     * @param originNode     拆分前的子节点
     * @param newNode        拆分出来的新子节点
     * @param newNodeMiniKey 新子节点的最小key(最左侧的key)
     */
    private void adaptSplitInParent(Node originNode, Node newNode, V newNodeMiniKey) {
        if (originNode.isRoot()) {
            Trunk<V> newRoot = new Trunk<>(originNode, newNode, newNodeMiniKey);
            originNode.setParent(newRoot);
            newNode.setParent(newRoot);
            return;
        }
        Trunk<V> parent = originNode.getParent();
        if (parent.getItemCount() < ITEM_LIMIT) {
            // parent.appendItem(newNodeMiniKey, newNode);
        } else {
            
        }
    }

    private Leaf<V> findLeaf(V id) {
        Node node = root;
        // 从根开始逐层去找满足区间条件的叶子节点
        while (node != null && node instanceof Trunk) {
            Trunk<V> trunk = (Trunk) node;
            node = findNextNode(trunk, id);
        }
        return (Leaf) node;
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
        if (root instanceof Trunk && ((Trunk) root).getHeadItem() == null) {
            return Collections.emptyList();
        }

        // 理论上的B+树，这里的leaf不会为Null
        Leaf<V> leaf = findLeaf(id);
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
     * @param id    查找的值
     */
    private Node findNextNode(Trunk<V> trunk, V id) {
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
