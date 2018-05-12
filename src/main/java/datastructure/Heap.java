package datastructure;

import java.util.Arrays;

public class Heap<E extends Comparable<E>> {

    private int capacity = 20;
    private int size = 0;

    private Object[] heap = new Object[this.capacity];

    public void add(E data) {
        ensureCapacity();
        this.heap[this.size] = data;
        increaseSize();
        reorderUp();
    }

    public E pop() {
        if (this.size == 0) {
            return null;
        }

        E element = (E) this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        decreaseSize();
        reorderDown();
        return element;
    }

    public E peek() {
        if (this.size == 0) {
            return null;
        }
        return (E) this.heap[0];
    }

    public boolean contains(E e) {
        return false;
    }

    public void traverse() {

    }

    private void reorderDown() {
        int index = 0;
        while (hasLeft(index)) {
            int smallerIndex = getLeftIndex(index);
            if (hasRight(smallerIndex) && right(index).compareTo((E) left(index)) < 0) {
                smallerIndex = getRightIndex(index);
            }

            if (((E) this.heap[index]).compareTo((E) this.heap[smallerIndex]) < 0) {
                break;
            }

            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    private void reorderUp() {
        int index = this.size - 1;
        while (hasParent(index) && parent(index).compareTo((E) this.heap[index]) > 0) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private int getLeftIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeft(int index) {
        return getLeftIndex(index) < this.size;
    }

    private boolean hasRight(int index) {
        return getRightIndex(index) < this.size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private E left(int index) {
        return (E) this.heap[getLeftIndex(index)];
    }

    private E right(int index) {
        return (E) this.heap[getRightIndex(index)];
    }

    private E parent(int index) {
        return (E) this.heap[getParentIndex(index)];
    }

    private void ensureCapacity() {
        if (this.size < this.capacity) {
            return;
        }
        this.capacity *= 2;
        this.heap = Arrays.copyOf(this.heap, this.capacity);
    }

    private void increaseSize() {
        this.size++;
    }

    private void decreaseSize() {
        this.size--;
    }

    private void swap(int indexOne, int indexTwo) {
        Object temp = this.heap[indexOne];
        this.heap[indexOne] = this.heap[indexTwo];
        this.heap[indexTwo] = temp;
    }
}
