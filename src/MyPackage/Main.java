package MyPackage;

import java.util.Scanner;

class Student {
    int rollno;
    String name;
    int[] marks = new int[3];
    float average;
    String grade;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];
        System.out.println();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter data for student " + (i + 1) + ":");
            students[i] = new Student();
            inputStudentData(students[i], scanner);
            calculateAverage(students[i]);
            calculateGrade(students[i]);
        }

        System.out.println("Rollno\tName\tMarks\t   Average\tGrade");
        for (int i = 0; i < numStudents; i++) {
            displayStudentData(students[i]);
        }

        scanner.close();
    }

    static void inputStudentData(Student s, Scanner scanner) {
        System.out.print("Rollno: ");
        s.rollno = scanner.nextInt();

        System.out.print("Name: ");
        s.name = scanner.next();

        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            s.marks[i] = scanner.nextInt();
        }
    }

    static void calculateAverage(Student s) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += s.marks[i];
        }
        s.average = (float) sum / 3;
    }

    static void calculateGrade(Student s) {
        if (s.average >= 75) {
            s.grade = "Distinction";
        } else if (s.average >= 60) {
            s.grade = "First";
        } else if (s.average >= 50) {
            s.grade = "Second";
        } else if (s.average >= 40) {
            s.grade = "Congrats!! Pass ";
        } else {
            s.grade = "Fail";
        }
    }

    static void displayStudentData(Student s) {
        System.out.println(s.rollno + "\t" + s.name + "\t" + s.marks[0] + " " + s.marks[1] + " " + s.marks[2]
                + "   " + s.average + "\t" + s.grade);
        System.out.println();
    }
}