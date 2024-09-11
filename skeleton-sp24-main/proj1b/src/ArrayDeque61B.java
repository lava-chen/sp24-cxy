import java.util.ArrayDeque;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private T[] items;
    private int size;
    public ArrayDeque61B(){
        items = (T[]) new Object[100];
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        T[] a = (T[]) new Object[items.length+1];
        System.arraycopy(items,0,a,1,size);
        items = a;
        items[0] = x;
        size +=1;
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length){
            resize(size * 2);
        }
        items[0] = x;
        size +=1 ;
    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T her = items[0];
        T[] a = (T[]) new Object[items.length-1];
        System.arraycopy(items,1,a,0,size);
        items = a;
        size -=1;
        return her;
    }

    @Override
    public T removeLast() {
        size -= 1;
        return items[size+1];
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
