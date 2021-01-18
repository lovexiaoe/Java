package zhaoyu.DataStructures.Stacks;

/**
 * 栈是一种先入后出的队列，下面使用节点实现栈。
 * @Author: zhaoyu
 * @Date: 2020/12/31
 */
public class NodeStack <T>{

    private Node head;
    private int size;

    public NodeStack(Node head,int size) {
        this.head = head;
    }

    public NodeStack(){
       this(null,0);
    }

    class Node<T>{
        T element;
        Node next;

        public Node(T element) {
            this.element = element;
        }
    }

    public void push(T element){
        Node current = new Node(element);
        current.next=head;
        head=current;
        size++;
    }

    public T pull(){
        if (size <1) {
            throw new NullPointerException("栈已经为空");
        }
        Node oldHead=head;
        head = head.next;
        size--;
        return (T) oldHead.element;
    }
}
