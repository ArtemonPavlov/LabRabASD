package LabRab4;

public class TreeSearch {

    // Проверяем расстояния до всех листьев
    public static boolean checkLeaves(Node node, int height, int min, int max) {
        // Если у узла нет детей — это лист
        if (node.children.isEmpty()) {
            return height >= min && height <= max;
        }
        // Проверяем каждого ребёнка
        for (Node child : node.children) {
            if (!checkLeaves(child, height + 1, min, max)) {
                return false;
            }
        }
        // Все листья подошли
        return true;
    }

    // Ищем все подходящие поддеревья
    public static void findSubtrees(Node root, int min, int max) {
        if (root == null) {
            return;
        }
        // Проверяем поддерево текущего узла
        if (checkLeaves(root, 0, min, max)) {
            System.out.println("Подходит поддерево с корнем: " + root.value);
        }
        // Переходим ко всем детям
        for (Node child : root.children) {
            findSubtrees(child, min, max);
        }
    }
}