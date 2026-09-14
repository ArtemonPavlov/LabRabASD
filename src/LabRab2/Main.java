package LabRab2;

// Задание: Дана разреженная матрица (CCS).
// Вывести зеркальное отображение относительно диагонали,
// проходящей с левого нижнего угла к правому верхнему углу.

public class Main {

    public static void main(String[] args) {

        int[] values = {3, 5, 7, 9, 2};
        int[] rows = {3, 0, 1, 3, 1};
        int[] col_ptr = {0, 1, 4, 4, 5};

        CCSMatrix matrix = new CCSMatrix(4, values, rows, col_ptr);

        System.out.println("Исходная матрица:");

        matrix.printMatrix();

        CCSMatrix mirroredMatrix = MatrixMirror.mirror(matrix);

        System.out.println();

        System.out.println("Отзеркаленная матрица:");

        mirroredMatrix.printMatrix();
    }
}