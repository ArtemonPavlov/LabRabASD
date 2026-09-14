package LabRab2;

public class CCSMatrix {

    private int size;
    private int[] values;
    private int[] rows;
    private int[] col_ptr;

    public CCSMatrix(int size, int[] values, int[] rows, int[] col_ptr) {
        this.size = size;
        this.values = values;
        this.rows = rows;
        this.col_ptr = col_ptr;
    }

    public int getSize() {return size;}

    public int[] getValues() {return values;}

    public int[] getRows() {return rows;}

    public int[] getCol_ptr() {return col_ptr;}

    // row = 0, col = 0:
    // col_ptr[0] = 0, col_ptr_[1] = 1 => k = 0
    //  => rows[0] == row (3 == 0)? нет => value = 0
    // row = 0, col = 1:
    // col_ptr[1] = 1, col_ptr[2] = 4 => k = 1,2,3
    // => rows[1](0) = row(0) => value = value[1] = 5 и т.д.
    public void printMatrix() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = 0;
                for (int k = col_ptr[col]; k < col_ptr[col + 1]; k++) {
                    if (rows[k] == row) {
                        value = values[k];
                    }
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
