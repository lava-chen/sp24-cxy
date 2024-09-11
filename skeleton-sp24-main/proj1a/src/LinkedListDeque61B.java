

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    public class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;
        public IntNode(T i,IntNode p,IntNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private IntNode t = new IntNode(null,null,null);
    private int size;

    public LinkedListDeque61B(){
        t = new IntNode(null,null,null);
        t.next = t;
        t.prev = t;
        size = 0;
    }

    public LinkedListDeque61B(T x){ //构造函数
        t =new IntNode(x,null,null);
        t.next = t;
        t.prev = t;
        size = 1;
    }

    @Override
    public void addFirst(T x) {
        IntNode p = new IntNode(x,t,t.next);
        t.next.prev = p;
        t.next = p;
        size +=1 ;
    }

    @Override
    public void addLast(T x) {
        IntNode p = new IntNode(x,t.prev,t);
        t.prev.next = p;
        t.prev = p;
        size +=1 ;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
            IntNode current = t.next;
            while (current != t) {
                returnList.add(current.item);
                current = current.next;
            }
            return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        IntNode her = t.next;
        t.next = t.next.next;
        t.next.next.prev = t;
        return her.item;
    }

    @Override
    public T removeLast() {
        IntNode her = t.next;
        t.prev = t.prev.prev;
        t.prev.prev.next = t;
        return her.item;
    }

    @Override
    public T get(int index) {
        IntNode her = t.next;
        int i = 0;
        while(i < index){
            her = her.next;
            i+=1;
        }
        return her.item;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
    //<T>可以使LinkedListDeque61B接受不同的类型

}
