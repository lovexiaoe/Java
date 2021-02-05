package zhaoyu.DataStructures.Trees;

/**
 * @Description: 平衡二叉树，也称为AVL
 * @Author: zhaoyu
 * @Date: 2021/1/26
 */
public class AVLTree {

    class Node{
        private int key;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key,Node p) {
            this.key=key;
            this.parent=p;
        }
    }

    private Node root;

    public void insert(int key){

    }
}