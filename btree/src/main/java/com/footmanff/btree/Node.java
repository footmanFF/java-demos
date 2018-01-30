package com.footmanff.btree;

/**
 * @author footmanff on 26/01/2018.
 */
public interface Node<V extends Comparable<V>> {

    /**
     * 获得B+树中节点的父节点
     */
    Trunk<V> getParent();

    /**
     * 设置父节
     */
    void setParent(Trunk<V> root);
    
    /**
     * 是否未根节点
     */
    boolean isRoot();
    
}
