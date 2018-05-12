package datastructure;

import java.util.Arrays;
import java.util.function.Consumer;

public class BinarySearchTreeUsingArray<E extends Comparable<E>> {

    private Object[] tree;
    private int size;
    private int capacity = 20;

    public BinarySearchTreeUsingArray(E[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid empty array");
        }

        this.tree = arr;
    }

    public BinarySearchTreeUsingArray(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Invalid empty root");
        }
        this.tree = new Object[this.capacity];
        this.tree[0] = e;
        increaseSize();
    }

    public void insert(E e) {
        ensureCapacity();

        increaseSize();
    }

    public E search(E e) {
        return null;
    }

    public E remove(E e) {
        return null;
    }

    public E min() {
        return null;
    }

    public E max() {
        return null;
    }

    public void traverseInOrder(Consumer<E> consumer) {
    }

    public void traversePreOrder(Consumer<E> consumer) {
    }

    public void traversePosOrder(Consumer<E> consumer) {
    }

    public int height() {
        return -1;
    }

    public int leafsNodeCount() {
        return -1;
    }

    public int allNodesCount() {
        return this.size;
    }

    private void increaseSize() {
        this.size++;
    }

    private void decreaseSize() {
        this.size--;
    }

    private void ensureCapacity() {
        if (this.size < this.capacity) {
            return;
        }
        this.capacity *= 2;
        this.tree = Arrays.copyOf(this.tree, this.capacity);

    }
}
