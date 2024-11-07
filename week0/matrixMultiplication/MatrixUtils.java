import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for handling matrix multiplication operations.
 * 
 * This class allows the user to input two matrices, check if they are compatible for multiplication,
 * perform the multiplication, and output the resulting matrix.
 */
class MatrixUtils {
    // Matrix A dimensions
    private int matrixARow;
    private int matrixAColumn;
    private int[][] matrixA;

    // Matrix B dimensions
    private int matrixBRow;
    private int matrixBColumn;
    private int[][] matrixB;

    // Result matrix after multiplication
    private int[][] resultMatrix;

    // Scanner instance for reading input
    final Scanner input = new Scanner(System.in);

    /**
     * Validates if the given dimension is greater than or equal to 1.
     * 
     * @param dimension The dimension of the matrix.
     * @return true if the dimension is valid (>= 1), false otherwise.
     */
    private boolean validateDimension(int dimension) {
        if (dimension < 1) {
            System.out.println("The dimensions of the matrix cannot be less than 1. Please enter a valid number.");
            return false;
        }
        return true;
    }

    /**
     * Collects the dimensions for both matrices (A and B) from the user.
     * Ensures that the user inputs valid dimensions for the matrices.
     */
    private void matrixDimensionsCollection() {
        // Matrix A dimension collection
        System.out.println("Entering Matrix A Dimensions");
        System.out.println("Enter rows for matrix A: ");
        do {
            this.matrixARow = input.nextInt();
        } while (!validateDimension(matrixARow)); // Ensure valid row count for matrix A

        System.out.println("Enter columns for matrix A: ");
        do {
            this.matrixAColumn = input.nextInt();
        } while (!validateDimension(matrixAColumn)); // Ensure valid column count for matrix A

        // Matrix B dimension collection
        System.out.println("Entering Matrix B Dimensions");
        System.out.println("Enter rows for matrix B: ");
        do {
            this.matrixBRow = input.nextInt();
        } while (!validateDimension(matrixBRow)); // Ensure valid row count for matrix B

        System.out.println("Enter columns for matrix B: ");
        do {
            this.matrixBColumn = input.nextInt();
        } while (!validateDimension(matrixBColumn)); // Ensure valid column count for matrix B
    }

    /**
     * Checks if Matrix A and Matrix B are compatible for multiplication.
     * The number of columns in Matrix A must equal the number of rows in Matrix B.
     * 
     * @return true if the matrices are compatible for multiplication, false otherwise.
     */
    private boolean checkCompatibility() {
        return this.matrixAColumn == this.matrixBRow; // Columns of A must match rows of B
    }

    /**
     * Collects data for both matrices A and B.
     * This method ensures that the matrices are compatible for multiplication.
     * 
     * @return true if data collection is successful, false if the matrices are incompatible.
     */
    private boolean matrixDataCollection() {
        // Check if the matrices are compatible for multiplication
        if (!checkCompatibility()) {
            System.out.println("The matrices are not compatible for multiplication.");
            return false;
        }

        // Initialize matrices A and B with the given dimensions
        this.matrixA = new int[this.matrixARow][this.matrixAColumn];
        this.matrixB = new int[this.matrixBRow][this.matrixBColumn];

        // Collect data for Matrix A
        System.out.println("Collecting data for Matrix A");
        for (int i = 0; i < this.matrixARow; i++) {
            for (int j = 0; j < this.matrixAColumn; j++) {
                System.out.println("Enter value for Matrix A[" + (i + 1) + "][" + (j + 1) + "]: ");
                this.matrixA[i][j] = input.nextInt();
            }
        }

        // Collect data for Matrix B
        System.out.println("Collecting data for Matrix B");
        for (int i = 0; i < this.matrixBRow; i++) {
            for (int j = 0; j < this.matrixBColumn; j++) {
                System.out.println("Enter value for Matrix B[" + (i + 1) + "][" + (j + 1) + "]: ");
                this.matrixB[i][j] = input.nextInt();
            }
        }
        return true; // Return true if data collection is successful
    }

    /**
     * Multiplies Matrix A and Matrix B.
     * The result is stored in the resultMatrix.
     * 
     * @return true if multiplication is successful, false if the matrices are not compatible.
     */
    private boolean multiplyMatrix() {
        // Check if matrices are compatible for multiplication
        if (!this.checkCompatibility()) {
            return false; // If matrices are not compatible, return false
        }

        // Initialize the result matrix with dimensions (rows of A) x (columns of B)
        this.resultMatrix = new int[this.matrixARow][this.matrixBColumn];

        // Perform matrix multiplication: resultMatrix = matrixA * matrixB
        for (int i = 0; i < this.matrixARow; i++) { // For each row of matrix A
            for (int j = 0; j < this.matrixBColumn; j++) { // For each column of matrix B
                for (int x = 0; x < this.matrixAColumn; x++) { // Loop through the common dimension
                    resultMatrix[i][j] += this.matrixA[i][x] * this.matrixB[x][j]; // Compute the sum of products
                }
            }
        }
        return true; // Return true if multiplication is successful
    }

    /**
     * Prints the result matrix to the console in a readable format.
     */
    private void printMatrix() {
        // Format and print the result matrix
        for (int[] row : resultMatrix) { // For each row in the result matrix
            String rowOutput = "| ";
            for (int i = 0; i < row.length; i++) {
                rowOutput += row[i] + " "; // Add each element to the row output
            }
            rowOutput += "|"; // Closing the row with a '|' symbol for formatting
            System.out.println(rowOutput); // Print the formatted row
        }
    }

    /**
     * Starts the entire matrix multiplication process.
     * collect matrix dimensions and data, performs the multiplication,
     * and prints the resulting matrix.
     */
    public void startOperation() {
        try {
            // Collect matrix dimensions from the user
            this.matrixDimensionsCollection();

            // Collect matrix data from the user (if compatible for multiplication)
            if (!this.matrixDataCollection()) {
                return; // Return if matrix data collection is unsuccessful
            }

            // Perform matrix multiplication
            if (!this.multiplyMatrix()) {
                return; // Return if multiplication fails
            }

            // Print the result matrix
            this.printMatrix();

        } catch (InputMismatchException ex) {
            // Handle invalid input (non-numeric values)
            System.out.println("Invalid input. Please input only numeric values.");
            System.out.println("Program exiting.");
        } catch (Exception ex) {
            System.out.println("Error occured");
        }
    }
}
