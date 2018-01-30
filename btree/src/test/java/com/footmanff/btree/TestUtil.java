package com.footmanff.btree;

/**
 * @author footmanff on 27/01/2018.
 */
public class TestUtil {

    public static Leaf<String> testLeaf() {
        Leaf<String> leaf = new Leaf<>();
        leaf.addItemInLimit("Srinivasan");
        leaf.addItemInLimit("Wu");
        return leaf;
    }
    
    /**
     * 构建一个测试数据
     *
     * @return 返回一个BTree实例，树的结构访问：http://note-1255449501.file.myqcloud.com/2018-01-29-024038.png
     */
    public static BTree<String> testTree() {
        Trunk<String> root = new Trunk<>();
        BTree<String> tree = new BTree<>();
        tree.setTree(root);

        Leaf<String> level3_1 = new Leaf<>();
        Leaf<String> level3_2 = new Leaf<>();
        Leaf<String> level3_3 = new Leaf<>();
        Leaf<String> level3_4 = new Leaf<>();
        Leaf<String> level3_5 = new Leaf<>();
        Leaf<String> level3_6 = new Leaf<>();

        Trunk<String> level2_1 = new Trunk<>();
        Trunk<String> level2_2 = new Trunk<>();

        level2_1.setParent(root);
        level2_2.setParent(root);

        level3_1.setNextLeaf(level3_2);
        level3_2.setNextLeaf(level3_3);
        level3_3.setNextLeaf(level3_4);
        level3_4.setNextLeaf(level3_5);
        level3_5.setNextLeaf(level3_6);

        level3_1.setParent(level2_1);
        level2_2.setParent(level2_1);
        level3_3.setParent(level2_1);
        level3_4.setParent(level2_1);
        level3_5.setParent(level2_2);
        level3_6.setParent(level2_2);

        level3_6.addItemInLimit("Srinivasan");
        level3_6.addItemInLimit("Wu");

        level3_5.addItemInLimit("Mozart");
        level3_5.addItemInLimit("Singh");
        level3_5.addItemInLimit("Singh");

        level3_4.addItemInLimit("Gold");
        level3_4.addItemInLimit("Katz");
        level3_4.addItemInLimit("Kim");

        level3_3.addItemInLimit("Einstein");
        level3_3.addItemInLimit("ElSaid");

        level3_2.addItemInLimit("Caliﬁeri");
        level3_2.addItemInLimit("Crick");

        level3_1.addItemInLimit("Adams");
        level3_1.addItemInLimit("Brandt");

        TrunkItem<String> T_caliﬁeri = new TrunkItem<>();
        TrunkItem<String> T_einstein = new TrunkItem<>();
        TrunkItem<String> T_gold = new TrunkItem<>();
        TrunkItem<String> T_srinivasan = new TrunkItem<>();

        T_caliﬁeri.setLeft(level3_1)
                  .setRight(level3_2)
                  .setValue("Caliﬁeri")
                  .setTrunk(level2_1);

        T_einstein.setLeft(level3_2)
                  .setRight(level3_3)
                  .setValue("Einstein")
                  .setTrunk(level2_1);

        T_gold.setLeft(level3_3)
              .setRight(level3_4)
              .setValue("Gold")
              .setTrunk(level2_1);

        T_srinivasan.setLeft(level3_5)
                    .setRight(level3_6)
                    .setValue("Srinivasan")
                    .setTrunk(level2_2);

        T_caliﬁeri.setNext(T_einstein);
        T_einstein.setNext(T_gold);

        level2_1.setHeadItem(T_caliﬁeri);
        level2_2.setHeadItem(T_srinivasan);

        TrunkItem<String> rootMozart = new TrunkItem<>();
        rootMozart.setTrunk(root)
                  .setValue("Mozart")
                  .setLeft(level2_1)
                  .setRight(level2_2);

        root.setHeadItem(rootMozart);

        return tree;
    }

    public static BTree<String> testTree2() {
        BTree<String> tree = new BTree<>();
        Leaf<String> leaf = new Leaf<>();
        tree.setTree(leaf);

        // Wu
        LeafItem<String> wu = new LeafItem<>();
        wu.setValue("Wu")
          .setLeaf(leaf);

        // Srinivasan
        LeafItem<String> srinivasan = new LeafItem<>();
        srinivasan.setValue("Srinivasan")
                  .setLeaf(leaf)
                  .setNext(wu);

        leaf.setHeadItem(srinivasan);
        return tree;
    }

}
