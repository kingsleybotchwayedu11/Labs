import java.util.Scanner;

/**
 * A class for collecting and processing student grades to generate statistics.
 * It computes the maximum, minimum, and average grades, and provides a visual representation
 * of how many students fall into specific grade bands.
 */

//Launcher
//Test Calss
public class StatsGradesLauncher {

    public static void main(String[] args) {
        //instantiate student statistics object
        StudentGradeStats programingJavaAmlitecNsp2024 = new StudentGradeStats();
        programingJavaAmlitecNsp2024.startApplication();
    }
}
class StudentGradeStats {
    // Array to store student grades
    private double[] grades;

    // Variables to store max, min, and average grade
    private double maxGrade; 
    private double minGrade;
    private double average;

    // Array to store the count of grades in each band
    private int[] bands = {0, 0, 0, 0, 0};

    /**
     * Validates that a grade is within the range 0 to 100 inclusive.
     * 
     * @param grade The grade to be validated.
     * @return true if the grade is between 0 and 100 inclusive, false otherwise.
     */
    private boolean validateGrade(double grade) {
        if (!(grade >= 0 && grade <= 100)) {
            System.out.println("Student grade should fall in the range 0-100 inclusive, please enter student grade again.");
            return false;
        }
        return true;
    }

    /**
     * Collects grades for each student.
     * 
     * The method prompts the user to input the total number of students and then asks for each student's grade.
     * The grades are validated before being stored.
     */
    private void gradesCollection() {
        Scanner input = new Scanner(System.in);

        // Get total number of students
        System.out.println("Enter total number of students");
        int totalStudents = 0;

        // Prevent entering negative or zero values for total students
        do {
            totalStudents = input.nextInt();
            if (totalStudents <= 0) {
                System.out.println("The total number of students cannot be negative or zero. Please enter a valid number.");
            }
        } while (totalStudents <= 0);

        // Create an array to store the grades for the students
        this.grades = new double[totalStudents];

        // Ask for each student's grade and store it in the grades array
        double studentGrade;
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Enter the grade for student " + (i + 1));

            // Ensure the user enters a valid grade
            do {
                studentGrade = input.nextDouble();
            } while (!this.validateGrade(studentGrade));

            grades[i] = studentGrade;
        }

        input.close();
    }

    /**
     * Computes the grade band for a given grade and updates the band count.
     * The bands are defined as follows:
     * - 0-20 -> index 0
     * - 21-40 -> index 1
     * - 41-60 -> index 2
     * - 61-80 -> index 3
     * - 81-100 -> index 4
     * 
     * @param grade The grade to compute the band for.
     */
    private void computeBands(double grade) {
        if (grade < 21) {
            bands[0] += 1;
        } else if (grade < 41) {
            bands[1] += 1;
        } else if (grade < 61) {
            bands[2] += 1;
        } else if (grade < 81) {
            bands[3] += 1;
        } else {
            bands[4] += 1;
        }
    }

    /**
     * Computes the statistics for the grades, including:
     * - Maximum grade
     * - Minimum grade
     * - Average grade
     * - The number of students in each grade band
     * 
     * @return true if statistics are successfully computed, false if there are no grades to compute.
     */
    private boolean computeStats() {
        // Check if the grades array is populated
        if (grades == null || grades.length == 0) {
            return false;
        }

        // Initialize max and min grades with the first grade
        maxGrade = grades[0];
        minGrade = grades[0];

        // Variable to store the sum of all grades for computing average
        double sumGrades = 0;

        // Loop through all grades to compute statistics
        for (double grade : grades) {
            // Update maxGrade and minGrade based on the current grade
            if (grade > maxGrade) {
                maxGrade = grade;
            }
            if (grade < minGrade) {
                minGrade = grade;
            }

            // Accumulate sum of grades
            sumGrades += grade;

            // Update grade bands
            this.computeBands(grade);
        }

        // Compute the average grade
        this.average = sumGrades / grades.length;
        return true;
    }

    /**
     * Displays a graphical representation of the grade bands.
     * The graph shows how many students fall within each band.
     */
    private void bandsGraph() {
        // String representation of bars and empty spaces for the graph
        final String bar = "  ########  ";
        final String nobar = "            ";
        final String horizontalPadding = "  ";                           
        final String xAxisLine  = horizontalPadding + "+-----------+-----------+-----------+-----------+-----------+";
        final String xAxisNumbering = horizontalPadding + "I    0-20   I   21-40   I   41-60   I    61-80   I  81-100   I";
        
        // Find the maximum value in the bands to determine the scale for the Y-axis
        int maxYaxis = this.bands[0];
        for (int band : this.bands) {
            if (band > maxYaxis) {
                maxYaxis = band;
            }
        }

        // Display the graph
        for (int yAxis = maxYaxis; yAxis > 0; yAxis--) { // Print Y-axis values
            System.out.print(yAxis + " < ");
            for (int band : this.bands) {
                // Print a bar if the band has enough students for the current Y-axis level
                if (band >= yAxis) {
                    System.out.print(bar);
                } else {
                    System.out.print(nobar);
                }
            }
            System.out.println(""); // Move to the next Y-axis level
        }

        // Print X-axis line and labels
        System.out.println(xAxisLine);
        System.out.println(xAxisNumbering);
    }

    /**
     * Displays a summary of the computed statistics: 
     * - Maximum grade
     * - Minimum grade
     * - Average grade
     * - Graphical representation of the grade bands
     */
    private void displaySummary() {

        System.out.println("\tValues\n");
        System.out.println("\tThe maximum grade is " + this.maxGrade);
        System.out.println("\tThe minimum grade is " + this.minGrade);
        System.out.println("\tThe average grade is " + this.average + "\n\n\n");

        // Display the grade bands graph
        this.bandsGraph();
    }

    /**
     * Starts the application by collecting grades, computing statistics,
     * and displaying the summary.
     */
    void startApplication() {
        // Collect grades from the user
        this.gradesCollection();

        // Compute statistics (min, max, average, bands)
        boolean computed = this.computeStats();

        // If stats couldn't be computed, exit the function
        if (!computed) {
            System.out.println("Couldn't compute statistics. No grades available.");
            return;
        }

        // Display the summary of computed statistics
        this.displaySummary();
    }

}


