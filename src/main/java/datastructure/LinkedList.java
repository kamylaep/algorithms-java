package datastructure;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addFirst(E data) {
        Node first = this.head;
        Node node = new Node(null, data, first);
        this.head = node;
        if (first == null) {
            this.tail = node;
        } else {
            first.previous = node;
        }

        increaseSize();
    }

    public void addLast(E data) {
        Node last = this.tail;
        Node node = new Node(last, data, null);
        this.tail = node;

        if (last == null) {
            this.head = node;
        } else {
            last.next = node;
        }

        increaseSize();
    }

    public E remove(E data) {
        if (this.head == null) {
            return null;
        }

        Node curr = this.head;

        while (curr != null) {
            if (curr.data.equals(data)) {
                curr.previous.next = curr.next;
                curr.next.previous = curr.previous;
                reduceSize();
                return (E) curr.data;
            }
            curr = curr.next;
        }

        return null;
    }

    public E removeFirst() {
        if (this.size == 0) {
            return null;
        }

        Node first = this.head;
        this.head = this.head.next;

        reduceSize();
        return (E) first.data;
    }

    public E removeLast() {
        if (this.size == 0) {
            return null;
        }

        Node last = this.tail;
        this.tail = this.tail.previous;

        reduceSize();

        return (E) last.data;
    }

    public E peekFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.data;
    }

    public E peekLast() {
        if (this.tail == null) {
            return null;
        }
        return this.tail.data;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean contains(E data) {
        if (this.head == null) {
            return false;
        }

        Node curr = this.head;

        while (curr != null) {
            if (curr.data.equals(data)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public void reverseHead() {
        if (this.head == null) {
            return;
        }

        LinkedList<E> newLinkedList = new LinkedList<>();
        Node curr = this.head;
        while (curr != null) {
            newLinkedList.addLast((E) curr.data);
            curr = curr.next;
        }
        this.head = newLinkedList.head;
        this.tail = newLinkedList.tail;
    }

    public void reverseTail() {
        if (this.head == null) {
            return;
        }

        LinkedList<E> newLinkedList = new LinkedList<>();
        Node curr = this.tail;
        while (curr != null) {
            newLinkedList.addLast((E) curr.data);
            curr = curr.previous;
        }
        this.head = newLinkedList.head;
        this.tail = newLinkedList.tail;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void increaseSize() {
        this.size++;
    }

    private void reduceSize() {
        this.size--;
    }

    private static class Node<E> {

        private E data;

        private Node<E> previous;
        private Node<E> next;

        Node(Node previous, E data, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }
}
