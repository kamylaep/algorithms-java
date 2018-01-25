package datastructure;

public class Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    public E push(E item) {
        this.linkedList.addFirst(item);
        return this.linkedList.peekFirst();
    }

    public E pop() {
        return this.linkedList.removeFirst();
    }

    public E peek() {
        return this.linkedList.peekFirst();
    }

    public int size() {
        return this.linkedList.size();
    }

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    public boolean contains(E e) {
        return this.linkedList.contains(e);
    }

    public void clear() {
        this.linkedList.clear();
    }
}
