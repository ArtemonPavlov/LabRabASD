package LabRab5;

public class BinarySearchTree {

    TreeNode root;
    // это чё за поебень я хуй знает
    public BinarySearchTree() {
        root = null;
    }

    // Методы для удобного пользования деревом извне
    public boolean insert(String key) {
        if (search(key)) {
            return false;
        }
        root = insertNode(root, key);
        return true;
    }

    public boolean search(String key) {
        return searchNode(root, key);
    }

    public boolean delete(String key) {
        if (!search(key)) {
            return false;
        }
        root = deleteNode(root, key);
        return true;
    }
    //--Методы для удобного пользования деревом извне

    // Внутренние методы
    private TreeNode insertNode(TreeNode node, String key) {
        if (node == null) {
            return new TreeNode(key);
        }

        if (key.compareTo(node.key) < 0) { // compareTo: -1 (a<b), 0 (a=b), 1 (a>b)
            node.left = insertNode(node.left, key);
        } else {
            node.right = insertNode(node.right, key);
        }

        // Возвращаем прежний корень, что бы ссылка на него сохраниласьэ
        return node;
    }

    private boolean searchNode(TreeNode node, String key) {
        if (node == null) {
            return false;
        }

        int result = key.compareTo(node.key);

        if (result == 0) {
            return true;
        }

        if (result < 0) {
            return searchNode(node.left, key);
        }

        return searchNode(node.right, key);
    }

    private TreeNode deleteNode(TreeNode node, String key) {
        if (node == null) {
            return null;
        }

        int result = key.compareTo(node.key);

        if (result < 0) {
            node.left = deleteNode(node.left, key);
        }
        else if (result > 0) {
            node.right = deleteNode(node.right, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            TreeNode min = findMin(node.right);

            node.key = min.key;

            node.right = deleteNode(node.right, min.key);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    //--Внутренние методы
}
