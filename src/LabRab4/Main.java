package LabRab4;

// Задание: Дано N-дерево. Найти все поддеревья,
// листья которых находятся в заданном диапазоне
// высот от корня поддерева.

public class Main {
    public static void main(String[] args) {

        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        // Дети узла 1
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        // Дети узла 2
        n2.children.add(n5);
        n2.children.add(n6);

        // Дети узла 4
        n4.children.add(n7);
        n4.children.add(n8);

        // Ребёнок узла 7
        n7.children.add(n9);

        // Задаём диапазон
        int min = 1;
        int max = 2;

        // Запускаем поиск
        TreeSearch.findSubtrees(root, min, max);
    }
}
