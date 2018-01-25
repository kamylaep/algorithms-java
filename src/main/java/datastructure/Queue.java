package datastructure;

public class Queue<E> {
    private LinkedList<E> linkedList = new LinkedList<>();

    public E enqueue(E e) {
        this.linkedList.addLast(e);
        return this.linkedList.peekLast();
    }

    public E dequeue(E e) {
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
