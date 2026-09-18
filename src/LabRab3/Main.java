package LabRab3;

// Задание: Дано бинарное дерево.
// Найти все поддеревья, структура которых совпадает с заданной.

public class Main {

    public static void main(String[] args) {
        // Создаём основное дерево
        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(15);
        root.right.right = new Node(25);

        // Создаём дерево-образец
        Node pattern = new Node(100);
        pattern.left = new Node(200);
        pattern.right = new Node(300);

        // Запускаем поиск
        TreeSearch.findSubtrees(root, pattern);
    }
}
