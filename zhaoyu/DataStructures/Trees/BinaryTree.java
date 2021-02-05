package zhaoyu.DataStructures.Trees;

import java.util.function.Consumer;

/**
 * @Description: 二叉树，二叉树每个节点有两个子节点。左子节点通常小于父节点，父节点小于右节点。
 *  二叉树由于结构简单，所以得到广泛的应用。
 * @Author: zhaoyu
 * @Date: 2021/1/27
 */
public class BinaryTree <E>{
    static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;
        private BinaryTree<E> containerTree;

        public Node(Node<E> parent,BinaryTree<E> containerTree,E value) {
            this.value=value;
            this.parent=parent;
            this.containerTree=containerTree;
        }

        public E getValue(){
            return value;
        }
    }

    private Node<E> root;

    public void addRoot(E value){
        root = new Node<>(null, this, value);
    }

    public Node<E> getRoot(){
        return root;
    }

    public Node<E> addChild(Node<E> parent, E value, boolean left) {
        if (parent == null) {
            throw new NullPointerException("父节点为空");
        } else if (parent.containerTree != this) {
            throw new IllegalArgumentException("父节点不属于当前树");
        } else {
            Node<E> child = new Node<E>(parent, this, value);
            if (left) {
                parent.left = child;
            } else {
                parent.right=child;
            }
            return child;
        }
    }

    public Node<E> addLeft(Node<E> parent,E value){
        return addChild(parent, value, true);
    }

    public Node<E> addRight(Node<E> parent,E value){
        return addChild(parent, value, false);
    }

    /**
     * 深度遍历的类型，深度遍历类型有，先序（父左右），中序（左父右），后续（左右父），可看到是以父节点在遍历中的顺序区分的。
     */


    /**
     * 深度遍历类型定义
     * @author: zhaoyu
     * @date: 2021/2/5
     */
    public static enum DepthFirstTraversalType{
        PREORDER,
        INORDER,
        POSTORDER
    }

    /**
     * 递归遍历树，基本思路，按照遍历类型对<左节点处理><右节点处理><父节点处理>进行排序。
     * @param consumer
     * @param current
     * @param tOrder
     */
    public void traverseDepthFirst(Consumer<E> consumer,Node<E> current,DepthFirstTraversalType tOrder){
        if (current == null) {
            return;
        }
        //使用if判断控制当前节点的处理顺序
        if(tOrder == DepthFirstTraversalType.PREORDER){
            consumer.accept(current.value);
        }
        traverseDepthFirst(consumer, current.left, tOrder);
        if(tOrder == DepthFirstTraversalType.INORDER){
            consumer.accept(current.value);
        }
        traverseDepthFirst(consumer, current.right, tOrder);
        if(tOrder == DepthFirstTraversalType.POSTORDER){
            consumer.accept(current.value);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addRoot(1);
        BinaryTree.Node n1 = tree.getRoot();
        Node<Integer> n2 = tree.addChild(n1, 2, true);
        Node<Integer> n3 = tree.addChild(n1, 3, false);
        Node<Integer> n4 = tree.addChild(n2, 4, true);
        Node<Integer> n5 = tree.addChild(n2, 5, false);
        Node<Integer> n6 = tree.addChild(n3, 6, true);
        Node<Integer> n7 = tree.addChild(n3, 7, false);
        Node<Integer> n8 = tree.addChild(n4, 8, true);
        Node<Integer> n9 = tree.addChild(n4, 9, false);
        Node<Integer> n10 = tree.addChild(n5, 10, true);

        tree.traverseDepthFirst(System.out::print, tree.getRoot(),
                DepthFirstTraversalType.PREORDER);
        System.out.println();

        tree.traverseDepthFirst(System.out::print, tree.getRoot(),
                DepthFirstTraversalType.INORDER);
        System.out.println();

        tree.traverseDepthFirst(System.out::print, tree.getRoot(),
                DepthFirstTraversalType.POSTORDER);
        System.out.println();
    }
}
