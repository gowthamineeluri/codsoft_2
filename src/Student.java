import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Student {

    public static HashMap<String, Integer> studentSub_marks;

    public static void main(String[] args) {
        studentSub_marks = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of subjects to take marks");
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice <= 0) {
                    System.out.println("Make sure to enter 1 or more subjects");
                }
                if (choice >= 1) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter only numbers");
                scanner.nextInt();
            }
        }


        for (int i = 0; i < choice; i++) {
            scanner.nextLine(); // Consume the newline character left by nextInt()
            System.out.println("Please enter Subject Name:");

            String subjectName = "";
            while (true) {
                try {
                    subjectName = scanner.nextLine();
                    if (subjectName.matches("^[a-zA-Z]+$")) {
                        break;
                    } else {
                        System.out.println("Please enter a valid subject name");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid subject name");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer
                }
            }


            int marks = -1;
            while (true) {
                try {
                    System.out.println("Enter marks (0-100):");
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        studentSub_marks.put(subjectName, marks);
                        break; // Exit the loop when valid marks are entered
                    } else {
                        System.out.println("Marks should be between 0 and 100");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter numbers only.");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer
                }
            }


        }

        calculate_Marks_display_result();
    }


    public static void calculate_Marks_display_result(){
        int total_marks=0;
        Collection<Integer> values = studentSub_marks.values();
        for(Integer i:values){
            total_marks+=i;
        }
        int average = total_marks / values.size();
        String grade=calculate_grade(average);

        System.out.println("Total Marks===> "+total_marks);
        System.out.println("Average===> "+average);
        System.out.println("Grade===> "+grade);


    }


    public static String calculate_grade(int marks){
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }


}
