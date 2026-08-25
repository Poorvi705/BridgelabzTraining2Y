import java.util.Scanner;

public class StudentMarksGrade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Arrays to store marks, percentage and grade
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter marks for Student " + (i + 1));

            // Physics
            System.out.print("Physics: ");
            int physics = sc.nextInt();

            if (physics < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }

            // Chemistry
            System.out.print("Chemistry: ");
            int chemistry = sc.nextInt();

            if (chemistry < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }

            // Maths
            System.out.print("Maths: ");
            int maths = sc.nextInt();

            if (maths < 0) {
                System.out.println("Marks cannot be negative. Please enter again.");
                i--;
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;

            // Calculate percentage
            int total = physics + chemistry + maths;
            percentage[i] = total / 3.0;

            // Calculate grade
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display results
        System.out.println("\n----------- Student Result -----------");

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics   : " + marks[i][0]);
            System.out.println("Chemistry : " + marks[i][1]);
            System.out.println("Maths     : " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade     : " + grade[i]);
        }

        sc.close();
    }
}