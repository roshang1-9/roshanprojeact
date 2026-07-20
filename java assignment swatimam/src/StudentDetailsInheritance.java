/**
 * Demonstrates inheritance to show student details.
 *
 * Classes:
 * - Person (base class)
 * - Student (extends Person)
 * - InternationalStudent (extends Student)
 *
 * The program creates several students and prints their details, showing
 * how subclasses inherit fields/methods and can extend/override behaviour.
 */
public class StudentDetailsInheritance {

    // Base class
    static class Person {
        protected String name;
        protected int age;
        protected String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getBasicInfo() {
            return String.format("Name: %s, Age: %d, Gender: %s", name, age, gender);
        }

        // can be overridden by subclasses to include more details
        public void showDetails() {
            System.out.println(getBasicInfo());
        }
    }

    // Student extends Person
    static class Student extends Person {
        protected String studentId;
        protected String course;
        protected double gpa;

        public Student(String name, int age, String gender, String studentId, String course, double gpa) {
            super(name, age, gender);
            this.studentId = studentId;
            this.course = course;
            this.gpa = gpa;
        }

        public String getStudentInfo() {
            return String.format("ID: %s, Course: %s, GPA: %.2f", studentId, course, gpa);
        }

        @Override
        public void showDetails() {
            System.out.println(getBasicInfo() + ", " + getStudentInfo());
        }
    }

    // International student adds country field
    static class InternationalStudent extends Student {
        private String country;

        public InternationalStudent(String name, int age, String gender, String studentId, String course, double gpa, String country) {
            super(name, age, gender, studentId, course, gpa);
            this.country = country;
        }

        @Override
        public void showDetails() {
            System.out.println(getBasicInfo() + ", " + getStudentInfo() + ", Country: " + country);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Student Details using Inheritance ---\n");

        Student s1 = new Student("Rohan", 20, "Male", "S1001", "Computer Science", 8.75);
        Student s2 = new Student("Sneha", 19, "Female", "S1002", "Information Technology", 9.10);
        InternationalStudent s3 = new InternationalStudent("Liam", 22, "Male", "I2001", "Mechanical", 7.80, "Canada");

        // Direct calls
        s1.showDetails();
        s2.showDetails();
        s3.showDetails();

        System.out.println();
        // Demonstrate polymorphism: a Person reference can point to a Student
        Person p = new Student("Aisha", 21, "Female", "S1003", "Electrical", 8.20);
        p.showDetails(); // calls Student.showDetails() because of dynamic dispatch

        System.out.println("\n--- End ---");
    }
}
