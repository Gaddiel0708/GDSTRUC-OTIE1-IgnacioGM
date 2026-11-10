package Quiz6;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (data == value) {
            System.out.println("Node of the same value already exists. Aborting insert.");
            return;
        }

        if (value < data) {
            if (leftChild != null) {
                leftChild.insert(value);
            } else {
                leftChild = new Node(value);
            }
        } else {
            if (rightChild != null) {
                rightChild.insert(value);
            } else {
                rightChild = new Node(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        System.out.println(this);

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public Node get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            } else {
                return null;
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            } else {
                return null;
            }
        }
    }

    public Node getMin() {
        if (leftChild == null) {
            return this;
        }
        return leftChild.getMin();
    }

    public Node getMax() {
        if (rightChild == null) {
            return this;
        }
        return rightChild.getMax();
    }

    public void traverseInOrderDescending() {
        if (rightChild != null) {
            rightChild.traverseInOrderDescending();
        }

        System.out.println(this);

        if (leftChild != null) {
            leftChild.traverseInOrderDescending();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node" +
                "data=" + data +
                '}';
    }
}