package JavawithDSA;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int regNo;
    String name;
    String branch;
    int marks;
    int totalClasses;
    int attendedClasses;

    Student(int regNo, String name, String branch, int marks,
            int totalClasses, int attendedClasses) {
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    double getAttendance() {
        return ((double) attendedClasses / totalClasses) * 100;
    }

    char getGrade() {
        if (marks >= 90)
            return 'A';
        else if (marks >= 80)
            return 'B';
        else if (marks >= 70)
            return 'C';
        else if (marks >= 60)
            return 'D';
        else
            return 'F';
    }

    void display() {
        System.out.println("Reg No      : " + regNo);
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + getGrade());
        System.out.println("Attendance  : " + getAttendance() + "%");
        System.out.println("--------------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 1. Add Student
    static void addStudent() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        System.out.print("Enter Student Name: ");
        String name = sc.next();

        System.out.print("Enter Branch: ");
        String branch = sc.next();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        System.out.print("Enter Total Classes: ");
        int total = sc.nextInt();

        System.out.print("Enter Attended Classes: ");
        int attended = sc.nextInt();

        students.add(new Student(
                regNo, name, branch, marks, total, attended));

        System.out.println("Student Added Successfully!");
    }

    // 2. Display Students
    static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available!");
            return;
        }

        System.out.println("\n===== STUDENT DETAILS =====");

        for (Student s : students) {
            s.display();
        }
    }

    // 3. Search Student
    static void searchStudent() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.regNo == regNo) {
                System.out.println("\nStudent Found!");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    // 4. Update Student
    static void updateStudent() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student s : students) {

            if (s.regNo == regNo) {

                System.out.print("Enter New Name: ");
                s.name = sc.next();

                System.out.print("Enter New Branch: ");
                s.branch = sc.next();

                System.out.print("Enter New Marks: ");
                s.marks = sc.nextInt();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 5. Delete Student
    static void deleteStudent() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student s : students) {

            if (s.regNo == regNo) {
                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 6. Grade
    static void calculateGrade() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student s : students) {

            if (s.regNo == regNo) {
                System.out.println("Marks: " + s.marks);
                System.out.println("Grade: " + s.getGrade());
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 7. Percentage
    static void calculatePercentage() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student s : students) {

            if (s.regNo == regNo) {

                // Assuming marks are out of 100
                double percentage = s.marks;

                System.out.println("Percentage: "
                        + percentage + "%");

                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 8. Login
    static boolean login() {

        System.out.println("\n===== STUDENT LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        if (username.equals("student")
                && password.equals("1234")) {

            System.out.println("Login Successful!");
            return true;

        } else {

            System.out.println("Invalid Username or Password!");
            return false;
        }
    }

    // 9. Attendance
    static void attendance() {

        System.out.print("Enter Registration Number: ");
        int regNo = sc.nextInt();

        for (Student s : students) {

            if (s.regNo == regNo) {

                double percentage = s.getAttendance();

                System.out.println("Attendance: "
                        + percentage + "%");

                if (percentage >= 75)
                    System.out.println("Status: Eligible");
                else
                    System.out.println("Status: Not Eligible");

                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // 10. Main Menu
    public static void main(String[] args) {

        if (!login()) {
            return;
        }

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Calculate Percentage");
            System.out.println("8. Attendance");
            System.out.println("9. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    calculateGrade();
                    break;

                case 7:
                    calculatePercentage();
                    break;

                case 8:
                    attendance();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);
    }
}