package LabRab4;

import java.util.ArrayList;

public class Node {

    int value;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }
}
