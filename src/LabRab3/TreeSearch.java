package LabRab3;

public class TreeSearch {

    // Сравниваем структуры двух деревьев
    public static boolean sameStructure(Node a, Node b) {
        // Если оба узла отсутствуют, структуры совпадают
        if (a == null && b == null) {
            return true;
        }
        // Если отсутствует только один узел, структуры разные
        if (a == null || b == null) {
            return false;
        }
        // Сравниваем левые и правые поддеревья
        return sameStructure(a.right, b.right) && sameStructure(a.left, b.left);
    }

    // Ходим по основному дереву, выбираем узлы для проверки
    public static void findSubtrees(Node root, Node pattern) {
        // Если дошли до конца ветки
        if (root == null) {
            return;
        }
        // Проверяем поддерево текущего узла
        if (sameStructure(root, pattern)) {
            System.out.println("Найдено поддерево, схожее по структуре с заданным, его корень: " + root.value);
        }
        // Ищем в левом поддереве
        findSubtrees(root.left, pattern);
        // Ищем в правом поддереве
        findSubtrees(root.right, pattern);
    }
}
