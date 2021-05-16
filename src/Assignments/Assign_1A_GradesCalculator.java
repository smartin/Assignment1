package Assignments;

import java.util.Random;
import java.util.Scanner;

public class Assign_1A_GradesCalculator {

    final String errorMsg = "*** ERROR *** : you can only enter whole numbers or the letter 'N', 'Q' or 'X'";

    public static void main(String[] args)
    {
        // START Do-while loop to allow user to start over with a fresh round of grade entries.
        String startOver = "Y";
        do
        {

            float gradeCount = 0.0f;
            int failCount = 0;
            int passCount = 0;
            int cStudentCount = 0;
            float gradeSum = 0.0f;
            int maxGrade = 0;
            int minGrade = 100;
            float gradeAverage = 0.0f;

            final int STARTINGNUMBER = 2;
            StringBuilder sb = new StringBuilder("\n");
            sb.append("STUDENT GRADE CALCULATOR\n");
            sb.append("Note: The following " + STARTINGNUMBER + " grades have already been entered.\n");
            System.out.println(sb.toString());

            // Display 10 random grades
            int randomGradeNum = 0;
            int ranNum = 0;
            String ranNumletterGrade = "";
            for (int i = 1; i <= STARTINGNUMBER; i++)
            {
                randomGradeNum = ++randomGradeNum;
                ranNum = new Random().nextInt(100) + 1;
                /* Instead of the following seven updates, a method should be used.
                This method does not work :

                //updateStatistics(ranNum);
                */

                // Increment count of grades
                gradeCount++;

                // Add every grade value to sum of all grades
                gradeSum += ranNum;

                // Update highest grade value
                if (ranNum > maxGrade)
                {
                    maxGrade = ranNum;
                }

                // Update lowest grade value
                if (ranNum < minGrade)
                {
                    minGrade = ranNum;
                }

                // Increment the count of failing grades
                if (ranNum <= 59)
                {
                    failCount++;
                }

                // Increment the count of passing grades
                if (ranNum >= 60)
                {
                    passCount++;
                }

                // Increment the count of students who got a C
                if (ranNum >= 60 && ranNum <= 69)
                {
                    cStudentCount++;
                }

                // Assign letter grades to ranges of number grades for starting random numbers
                System.out.println("Grade #" + randomGradeNum + ": " + ranNum + " (" + convertToLetter(ranNum) + ")");
            }

            while (true)
            {
                String continueOrStopMessage = "\nEnter another grade to continue\nor enter 'N','Q' or 'X' to stop and get a statistical summary -->";
                System.out.println(continueOrStopMessage);
                Scanner sc = new Scanner(System.in);
                String answer = sc.next();

                if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("q") || answer.equalsIgnoreCase("x"))
                {
                    break;
                }

                int currentGrade = Integer.parseInt(answer);

            /* If grade is outside accepted range :
            - Print an error message.
            - Dismiss it from summary results.
            - Don't print the grade as a list item.*/
                if (currentGrade < 0 || currentGrade > 100)
                {
                    System.out.println("*** ERROR *** : You can only enter a grade between 0 and 100.");
                } else
                {
                    // Counters: If grade is within accepted range;

                    /* Instead of the following seven updates, a method should be used.
                This method does not work :

                //updateStatistics(currentGrade);
                */
                    // Increment count of grades
                    gradeCount++;

                    // Add current grade value to sum of all grades
                    gradeSum += currentGrade;

                    // Update highest grade
                    if (currentGrade > maxGrade)
                    {
                        maxGrade = currentGrade;
                    }

                    // Update lowest grade
                    if (currentGrade < minGrade)
                    {
                        minGrade = currentGrade;
                    }

                    // Increment the count of failing grades
                    if (currentGrade <= 59)
                    {
                        failCount++;
                    }

                    // Increment the count of passing grades
                    if (currentGrade >= 60)
                    {
                        passCount++;
                    }

                    // Increment the count of students who got a C
                    if (currentGrade >= 60 && currentGrade <= 69)
                    {
                        cStudentCount++;
                    }

                    System.out.println("Grade #" + gradeCount + ": " + currentGrade + " (" + convertToLetter(currentGrade) + ")");
                }
            }

            // String bulding : Display the statistical summary
            StringBuilder su = new StringBuilder("\n");
            su.append("---------------------------------------------------------\nSTATISTICAL SUMMARY FOR GRADES (based on " + gradeCount + " total grades.)\n---------------------------------------------------------\n");
            su.append("-The largest grade achieved is " + maxGrade + ".\n");
            su.append("-The lowest grade achieved is " + minGrade + ".\n");
            su.append("-The average for the class is " + (gradeSum / gradeCount) + ", which is grade " + convertToLetter((gradeSum / gradeCount)) + ".\n");
            su.append("-" + passCount + " students are passing, and " + failCount + " are failing the course.\n");
            su.append("-" + cStudentCount + " students have a grade which will result in a warning (\"C\").");
            System.out.println(su.toString());

            // Give user option to start a fresh round of grade entries:
            System.out.println("\n***** Would you like to start over with a fresh round of grade entries? \nEnter \"Y\" to start over, or enter \"N\" to end the program.");
            Scanner st = new Scanner(System.in);
            startOver = st.next();

        }// END Do-while loop to allow user to start over with a fresh round of grade entries.
        while (!startOver.equalsIgnoreCase("N"));
        System.out.println("Bye.");
    }

    /**
     * Converts a numerical grade to an alphabetical grade
     *
     * @param a Integer : A numerical grade
     * @return A string character ex. A+, B-, C etc.
     */
    public static String convertToLetter(float a)
    {

        if (a > 94)
        {
            return ("A+");
        }

        if (a > 89)
        {
            return ("A");
        }

        if (a > 84)
        {
            return ("A-");
        }

        if (a > 79)
        {
            return ("B+");
        }

        if (a > 74)
        {
            return ("B");
        }

        if (a > 69)
        {
            return ("B-");
        }

        if (a > 59)
        {
            return ("C");
        }

        return ("F");

    }

//    /**
//     *
//     * @param a Float
//     * @return int values calculating :
//     * -sum of grades
//     * -highest grade
//     * -lowest grade
//     * -total count of grades
//     * -count of failing grades
//     * -count of passing grades
//     * -count of C grades.
//     */
//
//    public static int updateStatistics (int a) *** METHOD NOT WORKING ***
//    {
//        // Increment count of grades
//        return (gradeCount++);
//
//        // Add current grade value to sum of all grades
//        return (gradeSum =+ a);
//
//        // Update highest grade
//        if (a > maxGrade)
//        {
//            return (maxGrade = a);
//        }
//
//        // Update lowest grade
//        if (a < minGrade)
//        {
//            return (minGrade = a);
//        }
//
//        // Increment the count of failing grades
//        if (a <= 59)
//        {
//            return (failCount++);
//        }
//
//        // Increment the count of passing grades
//        if (a >= 60)
//        {
//            return (passCount++);
//        }
//
//        // Increment the count of students who got a C
//        if (a >= 60 && a <= 69)
//        {
//            return (cStudentCount++);
//        }
//
//    }
}
