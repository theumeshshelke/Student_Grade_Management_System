import java.util.*;

public class StudentGradeManagementSystem {

    private static HashMap<String, Integer> studentGrades = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add Student Grade");
            System.out.println("2. View All Students");
            System.out.println("3. Sort Students by Grade");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> sortStudents();
                case 4 -> generateReport();
                case 5 -> {
                    System.out.println("Exiting system...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Add student name and grade
    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Grade: ");
        int grade = scanner.nextInt();

        studentGrades.put(name, grade);
        System.out.println("Student record added successfully.");
    }

    // Display all students
    private static void viewStudents() {
        if (studentGrades.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Sort students based on grades
    private static void sortStudents() {
        if (studentGrades.isEmpty()) {
            System.out.println("No records to sort.");
            return;
        }

        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(studentGrades.entrySet());

        list.sort(Map.Entry.comparingByValue());

        System.out.println("\nStudents Sorted by Grades (Ascending):");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Generate report
    private static void generateReport() {
        if (studentGrades.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String topStudent = "";
        String lowStudent = "";

        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            int grade = entry.getValue();
            total += grade;

            if (grade > max) {
                max = grade;
                topStudent = entry.getKey();
            }

            if (grade < min) {
                min = grade;
                lowStudent = entry.getKey();
            }
        }

        double average = (double) total / studentGrades.size();

        System.out.println("\n=== Grade Report ===");
        System.out.println("Total Students: " + studentGrades.size());
        System.out.println("Average Grade: " + average);
        System.out.println("Top Student: " + topStudent + " (" + max + ")");
        System.out.println("Lowest Student: " + lowStudent + " (" + min + ")");
    }
}
