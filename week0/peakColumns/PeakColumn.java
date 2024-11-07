import java.util.*;

public class PeakColumn {

    /**
     * Finds the indexes of the maximum values in a row and returns their column positions.
     * 
     * @param row The array representing a single row of the matrix.
     * @return List of column indexes where the maximum values are located.
     */
    public static ArrayList<Integer> findRowMaxValueColumnIndex(int[] row) {
        // Initialize the column index where the maximum value is assumed to be
        int columnIndex = 0;

        // Loop through the row to find the column of the maximum value
        for (int i = 1; i < row.length; i++) { // Start from 1 because we've assumed column 0 is the max initially
            if (row[i] > row[columnIndex]) {
                columnIndex = i; // Update column index if a new max is found
            }
        }

        // Handle the case of multiple columns with the same maximum value
        ArrayList<Integer> maxIndexes = new ArrayList<>();
        maxIndexes.add(columnIndex);

        // Check for any other columns that have the same maximum value
        for (int i = 0; i < row.length; i++) {
            if (row[i] == row[columnIndex] && i != columnIndex) {
                maxIndexes.add(i); // Add other columns with the same value
            }
        }

        return maxIndexes;
    }

    /**
     * Checks if the given element is a peak value in the matrix.
     * A peak value is defined as being the largest in its row and the smallest in its column.
     * 
     * @param maxRowIndex Row index of the potential peak value.
     * @param maxColumnIndex Column index of the potential peak value.
     * @param data The matrix to check in.
     * @return True if the element is a peak value, false otherwise.
     */
    public static boolean checkPeak(int maxRowIndex, int maxColumnIndex, int[][] data) {
        int value = data[maxRowIndex][maxColumnIndex]; // The potential peak value

        // Check if the value is the smallest in the column
        for (int row = 0; row < data.length; row++) {
            if (value > data[row][maxColumnIndex]) { // If any element in the column is smaller, return false
                return false;
            }
        }

        return true; // If no smaller element was found, it's a peak
    }

    /**
     * Finds and prints the peak values in the given matrix.
     * 
     * @param matrix The matrix to search for peak values.
     */
    public static void findPeakValues(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            // Get column indexes of the max values in the current row
            ArrayList<Integer> columnIndexes = findRowMaxValueColumnIndex(matrix[row]);

            // For each max column in the row, check if it's a peak
            for (int columnIndex : columnIndexes) {
                if (checkPeak(row, columnIndex, matrix)) {
                    System.out.println("(" + (row + 1) + "," + (columnIndex + 1) + ") = " + matrix[row][columnIndex]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 3},
            {2, 5, 1},
            {3, 6, 2}
        };

        findPeakValues(matrix); // Call the method to find and print peak values
    }
}
