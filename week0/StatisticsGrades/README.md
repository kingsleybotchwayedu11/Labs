# Lab: Analyzing Student Grades and Generating a Dynamic Bar Chart

## Project Objectives

In this lab, you will practice the following skills:

- **Creating, initializing, and manipulating arrays** to store data.
- **Using conditional statements** to categorize and analyze data.
- **Understanding string formatting techniques** to display results clearly and concisely.
- **Developing algorithms** to efficiently solve the problem by generating a dynamic bar chart in the console.

## Description

In this lab, you will write a Python program to read the grades of N students in a class on an assignment and store them in an array named `scores`. Based on the input, the program will:

- Calculate and display:
  - The maximum grade in the class.
  - The minimum grade in the class.
  - The average grade of the class.
  
- Establish an array `stats` of size 5, which will contain the following information:
  - `stats[4]`: The number of grades above 80.
  - `stats[3]`: The number of grades from 61 to 80.
  - `stats[2]`: The number of grades from 41 to 60.
  - `stats[1]`: The number of grades from 21 to 40.
  - `stats[0]`: The number of grades from 0 to 20.
  
- Generate a dynamic bar chart in the console using the symbol `#######` to represent the number of students falling into each grade range.

### Sample Input:

The program will accept a series of grades for N students, with grades ranging from 0 to 100.

**Example Input (for 20 students):**

2 20 21 22 23 30 48 49 50 55 60 65 72 63 76 80 68 90 85 98


---

## Requirements

- **Input Handling:** Read student grades from the user or a given input list.
- **Array Manipulation:** Store student grades in an array and perform operations such as finding max, min, and calculating averages.
- **Conditional Logic:** Use conditional statements to categorize grades into the appropriate ranges (0-20, 21-40, etc.).
- **Bar Chart Generation:** Generate a bar chart in the console where the height of the bars is proportional to the count of students in each grade range.
- **String Formatting:** Display the results (max grade, min grade, average, and stats array) in a clear and organized manner.

--
