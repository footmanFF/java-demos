package com.footmanff.btree;

/**
 * 模拟持久化的表行
 * 
 * @author zhangli on 26/01/2018.
 */
public class PersistentData<K> {

    /**
     * 索引的键值
     */
    private K key;

    /**
     * 其他信息
     */
    private String info;

    public K getKey() {
        return key;
    }

    public PersistentData<K> setKey(K key) {
        this.key = key;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public PersistentData<K> setInfo(String info) {
        this.info = info;
        return this;
    }
    
}
