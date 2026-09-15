package LabRab2;

public class MatrixMirror {

    public static CCSMatrix mirror(CCSMatrix matrix) {

        int n = matrix.getSize();

        int[] oldValues = matrix.getValues();
        int[] oldRows = matrix.getRows();
        int[] oldColPtr = matrix.getCol_ptr();

        int count = oldValues.length;

        int[] newValues = new int[count];
        int[] newRows = new int[count];
        int[] newColPtr = new int[n + 1];

        int index = 0;

        // Идём сразу по новым столбцам
        for (int newCol = 0; newCol < n; newCol++) {

            newColPtr[newCol] = index;

            // Перебираем все старые столбцы
            for (int oldCol = 0; oldCol < n; oldCol++) {

                // Перебираем ненулевые элементы старого столбца
                for (int k = oldColPtr[oldCol]; k < oldColPtr[oldCol + 1]; k++) {
                    int oldRow = oldRows[k];
                    // Куда попадёт элемент после отражения?
                    int resultCol = n - 1 - oldRow;
                    // Если попал в текущий новый столбец
                    if (resultCol == newCol) {
                        int resultRow = n - 1 - oldCol;
                        newValues[index] = oldValues[k];
                        newRows[index] = resultRow;
                        index++;
                    }
                }
            }
        }

        newColPtr[n] = index;

        return new CCSMatrix(n, newValues, newRows, newColPtr);
    }
}
