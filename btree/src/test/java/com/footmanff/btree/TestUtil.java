package com.footmanff.btree;

/**
 * @author zhangli on 27/01/2018.
 */
public class TestUtil {

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

        // Wu
        LeafItem<String> wu = new LeafItem<>();
        wu.setValue("Wu")
          .setLeaf(level3_6);

        // Srinivasan
        LeafItem<String> srinivasan = new LeafItem<>();
        srinivasan.setValue("Srinivasan")
                  .setLeaf(level3_6)
                  .setNext(wu);

        // Singh
        LeafItem<String> singh = new LeafItem<>();
        singh.setValue("Singh")
             .setLeaf(level3_5)
             .setNext(srinivasan);

        // Singh2
        LeafItem<String> singh2 = new LeafItem<>();
        singh2.setValue("Singh")
             .setLeaf(level3_5)
             .setNext(singh);
        
        // Mozart
        LeafItem<String> mozart = new LeafItem<>();
        mozart.setValue("Mozart")
              .setLeaf(level3_5)
              .setNext(singh2);

        // Kim
        LeafItem<String> kim = new LeafItem<>();
        kim.setValue("Kim")
           .setLeaf(level3_4)
           .setNext(mozart);

        // Katz
        LeafItem<String> katz = new LeafItem<>();
        katz.setValue("Katz")
            .setLeaf(level3_4)
            .setNext(kim);

        // Gold
        LeafItem<String> gold = new LeafItem<>();
        gold.setValue("Gold")
            .setLeaf(level3_4)
            .setNext(katz);

        // ElSaid
        LeafItem<String> elSaid = new LeafItem<>();
        elSaid.setValue("ElSaid")
              .setLeaf(level3_3)
              .setNext(gold);

        // Einstein
        LeafItem<String> einstein = new LeafItem<>();
        einstein.setValue("Einstein")
                .setLeaf(level3_3)
                .setNext(elSaid);

        // Crick
        LeafItem<String> crick = new LeafItem<>();
        crick.setValue("Crick")
             .setLeaf(level3_2)
             .setNext(einstein);

        // Caliﬁeri
        LeafItem<String> caliﬁeri = new LeafItem<>();
        caliﬁeri.setValue("Caliﬁeri")
                .setLeaf(level3_2)
                .setNext(crick);

        // Brandt
        LeafItem<String> brandt = new LeafItem<>();
        brandt.setValue("Brandt")
              .setLeaf(level3_1)
              .setNext(caliﬁeri);

        // Adams
        LeafItem<String> adams = new LeafItem<>();
        adams.setValue("Adams")
             .setLeaf(level3_1)
             .setNext(brandt);

        level3_1.setHeadItem(adams);
        level3_2.setHeadItem(caliﬁeri);
        level3_3.setHeadItem(einstein);
        level3_4.setHeadItem(gold);
        level3_5.setHeadItem(mozart);
        level3_6.setHeadItem(srinivasan);

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

    public static void main(String[] args) {
        BTree bTree = TestUtil.testTree();
    }

}
