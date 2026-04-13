import java.util.ArrayList;
import java.util.Scanner;

class Subject {
    String subjectName;
    int credits;

    Subject(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    void displaySubject() {
        System.out.println("  - " + subjectName + " (" + credits + " credits)");
    }
}

class Student {
    String name;
    String studentID;
    ArrayList<Subject> registeredSubjects;

    Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.registeredSubjects = new ArrayList<>();
    }

    void registerSubject(String subjectName, int credits) {
        registeredSubjects.add(new Subject(subjectName, credits));
    }

    int calculateTotalCredits() {
        int totalCredits = 0;
        for (Subject subject : registeredSubjects) {
            totalCredits += subject.credits;
        }
        return totalCredits;
    }

    boolean isEligible() {
        return calculateTotalCredits() >= 15;
    }

    void displayStudentDetails() {
        System.out.println("\n========== STUDENT REGISTRATION DETAILS ==========");
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("\nRegistered Subjects:");
        
        if (registeredSubjects.isEmpty()) {
            System.out.println("  No subjects registered");
        } else {
            for (Subject subject : registeredSubjects) {
                subject.displaySubject();
            }
        }
        
        int totalCredits = calculateTotalCredits();
        System.out.println("\nTotal Credits: " + totalCredits);
        
        String eligibilityStatus = isEligible() ? "ELIGIBLE" : "NOT ELIGIBLE";
        System.out.println("Eligibility Status: " + eligibilityStatus);
        System.out.println("===================================================\n");
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== COURSE REGISTRATION SYSTEM ==========\n");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

   
        Student student = new Student(name, studentID);

        System.out.print("\nHow many subjects do you want to register? ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("\nSubject " + i + " Name: ");
            String subjectName = scanner.nextLine();

            System.out.print("Subject " + i + " Credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            student.registerSubject(subjectName, credits);
        }
      student.displayStudentDetails();

        scanner.close();
    }
}
