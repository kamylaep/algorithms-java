package datastructure;

import java.util.function.Consumer;

public class BinarySearchTreeUsingNode<E extends Comparable<E>> {

    private BinarySearchTreeNode<E> root;
    private int size;

    public BinarySearchTreeUsingNode(E... arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid empty array");
        }

        tree(arr);
    }

    public BinarySearchTreeUsingNode(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Invalid empty root");
        }

        this.root = new BinarySearchTreeNode<>(e);
        increaseSize();
    }

    public void insert(E e) {
        if (this.root == null || this.root.getData() == null) {
            this.root = new BinarySearchTreeNode<>(e);
        } else {
            this.root.insert(e);
        }
        increaseSize();
    }

    public E search(E e) {
        if (this.root == null || this.root.getData() == null || e == null) {
            return null;
        }
        return this.root.search(e);
    }

    public E remove(E e) {
        if (this.root == null || e == null) {
            return e;
        }

        BinarySearchTreeNode current = this.root;
        BinarySearchTreeNode parent = this.root;
        boolean isLeftChild = false;

        while (current != null && !current.getData().equals(e)) {
            parent = current;
            if (e.compareTo((E) current.getData()) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return null;
        }

        if (current.left == null && current.right == null) {
            if (current == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            decreaseSize();
            return (E) current.data;
        }

        if (current.right == null) {
            if (current == this.root) {
                this.root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            decreaseSize();
            return (E) current.data;
        }

        if (current.left == null) {
            if (current == this.root) {
                this.root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            decreaseSize();
            return (E) current.data;
        }

        BinarySearchTreeNode successor = getSuccessor(current);
        if (current == this.root) {
            this.root = successor;
        } else if (isLeftChild) {
            parent.left = successor;
        } else {
            parent.right = successor;
        }
        successor.left = current.left;
        decreaseSize();

        return (E) current.data;
    }

    private BinarySearchTreeNode getSuccessor(BinarySearchTreeNode node) {
        BinarySearchTreeNode parentOfSuccessor = node;
        BinarySearchTreeNode successor = node;
        BinarySearchTreeNode current = node.right;

        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            parentOfSuccessor.left = successor.right;
            successor.right = successor.left;
        }

        return successor;
    }

    public E min() {
        if (this.root == null || this.root.getData() == null) {
            return null;
        }

        BinarySearchTreeNode<E> curr = this.root;
        E min = this.root.getData();

        while (curr != null) {
            if (curr.getData().compareTo(min) <= 0) {
                min = curr.getData();
            }
            curr = curr.getLeft();
        }

        return min;
    }

    public E max() {
        if (this.root == null || this.root.getData() == null) {
            return null;
        }

        BinarySearchTreeNode<E> curr = this.root;
        E max = this.root.getData();

        while (curr != null) {
            if (curr.getData().compareTo(max) >= 0) {
                max = curr.getData();
            }
            curr = curr.getRight();
        }

        return max;
    }

    public void traverseInOrder(Consumer<E> consumer) {
        if (this.root == null) {
            return;
        }
        this.root.traverseInOrder(consumer);
    }

    public void traversePreOrder(Consumer<E> consumer) {
        if (this.root == null) {
            return;
        }
        this.root.traversePreOrder(consumer);
    }

    public void traversePosOrder(Consumer<E> consumer) {
        if (this.root == null) {
            return;
        }
        this.root.traversePosOrder(consumer);
    }

    public int height() {
        if (this.root == null || this.root.getData() == null) {
            return 0;
        }
        return this.root.height();
    }

    public int leafsNodeCount() {
        if (this.root == null || this.root.getData() == null) {
            return 0;
        }
        return this.root.leafsCount();
    }

    public int allNodesCount() {
        return this.size;
    }

    private void tree(E[] arr) {
        this.root = new BinarySearchTreeNode<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            this.root.insert(arr[i]);
        }
    }

    private void increaseSize() {
        this.size++;
    }

    private void decreaseSize() {
        this.size--;
    }

    private class BinarySearchTreeNode<E extends Comparable<E>> {

        E data;
        BinarySearchTreeNode<E> right;
        BinarySearchTreeNode<E> left;

        BinarySearchTreeNode(E data) {
            this.data = data;
        }

        E getData() {
            return this.data;
        }

        BinarySearchTreeNode<E> getRight() {
            return this.right;
        }

        BinarySearchTreeNode<E> getLeft() {
            return this.left;
        }

        void insert(E e) {
            if (e.compareTo(this.data) >= 0) {
                if (this.right == null) {
                    this.right = new BinarySearchTreeNode<>(e);
                } else {
                    this.right.insert(e);
                }
            } else {
                if (this.left == null) {
                    this.left = new BinarySearchTreeNode<>(e);
                } else {
                    this.left.insert(e);
                }
            }
        }

        int height() {
            if (isLeaf()) {
                return 1;
            }

            int leftHeight = 0;
            int rightHeight = 0;

            if (this.left != null) {
                leftHeight = this.left.height();
            }

            if (this.right != null) {
                rightHeight = this.right.height();
            }
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

        }

        boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        int leafsCount() {
            if (isLeaf()) {
                return 1;
            }

            int leftLeafsCount = 0;
            int rightLeafsCount = 0;

            if (this.left != null) {
                leftLeafsCount = this.left.leafsCount();
            }

            if (this.right != null) {
                rightLeafsCount = this.right.leafsCount();
            }

            return leftLeafsCount + rightLeafsCount;

        }

        E search(E e) {
            BinarySearchTreeNode<E> search = searchInternal(e);
            return search == null ? null : search.getData();
        }

        BinarySearchTreeNode<E> searchInternal(E e) {
            if (getData().equals(e)) {
                return this;
            }

            if (e.compareTo(getData()) <= 0 && this.left != null) {
                return this.left.searchInternal(e);
            }

            if (e.compareTo(getData()) > 0 && this.right != null) {
                return this.right.searchInternal(e);
            }

            return null;
        }

        void traverseInOrder(Consumer<E> consumer) {
            if (this.left != null) {
                this.left.traverseInOrder(consumer);
            }

            consumer.accept(this.data);

            if (this.right != null) {
                this.right.traverseInOrder(consumer);
            }
        }

        void traversePreOrder(Consumer<E> consumer) {
            consumer.accept(this.data);

            if (this.left != null) {
                this.left.traversePreOrder(consumer);
            }

            if (this.right != null) {
                this.right.traversePreOrder(consumer);
            }

        }

        void traversePosOrder(Consumer<E> consumer) {
            if (this.left != null) {
                this.left.traversePosOrder(consumer);
            }

            if (this.right != null) {
                this.right.traversePosOrder(consumer);
            }

            consumer.accept(this.data);
        }


        @Override
        public String toString() {
            return this.data + "";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof BinarySearchTreeNode)) {
                return false;
            }
            BinarySearchTreeNode otherNode = (BinarySearchTreeNode) obj;
            return this.data.equals(otherNode.getData());
        }

        @Override
        public int hashCode() {
            return this.data.hashCode();
        }

    }
}
