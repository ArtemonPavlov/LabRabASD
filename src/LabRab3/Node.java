package LabRab3;

// Узел дерева
public class Node {

    int value;
    // дети
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}