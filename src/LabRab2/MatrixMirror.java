package LabRab2;

public class MatrixMirror {

    public static CCSMatrix mirror(CCSMatrix matrix) {

        int n = matrix.getSize();
        int[] oldValues = matrix.getValues();
        int[] oldRows = matrix.getRows();
        int[] oldCols = matrix.getCol_ptr();

        int count = oldValues.length;

        int[] newValues = new int[count];
        int[] newRows = new int[count];
        int[] newCols = new int[count];

        int index = 0;

        // Проходим по всем столбцам исходной матрицы
        for (int col = 0; col < n; col++) {
            // Проходим по ненулевым элементам текущего столбца
            for (int k = oldCols[col]; k < oldCols[col + 1]; k++) {
                int row = oldRows[k];
                int value = oldValues[k];

                int newRow = n - 1 - col;
                int newCol = n - 1 - row;

                newValues[index] = value;
                newRows[index] = newRow;
                newCols[index] = newCol;

                index++;
            }
        }

        // Теперь нужно расположить элементы в порядке CCS:
        // сначала по столбцам
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (newCols[i] > newCols[j]) {

                    int temp;

                    temp = newCols[i];
                    newCols[i] = newCols[j];
                    newCols[j] = temp;

                    temp = newRows[i];
                    newRows[i] = newRows[j];
                    newRows[j] = temp;

                    temp = newValues[i];
                    newValues[i] = newValues[j];
                    newValues[j] = temp;
                }
            }
        }

        // Формируем col_ptr
        int[] newColPtr = new int[n + 1];

        index = 0;

        for (int col = 0; col < n; col++) {
            newColPtr[col] = index;
            while (index < count && newCols[index] == col) {
                index++;
            }
        }

        newColPtr[n] = count;

        return new CCSMatrix(n, newValues, newRows, newColPtr);
    }
}
