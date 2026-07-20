/**
 * Demonstrates multilevel inheritance in Java.
 *
 * Class hierarchy:
 *  Person (base) -> Student (extends Person) -> ScholarshipStudent (extends Student)
 *
 * Shows constructor chaining, field/method inheritance, method overriding and use of super.
 */
public class MultilevelInheritanceDemo {

    // Base class
    static class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void show() {
            System.out.println("Person: name=" + name + ", age=" + age);
        }
    }

    // Student extends Person
    static class Student extends Person {
        protected String studentId;
        protected String course;

        public Student(String name, int age, String studentId, String course) {
            super(name, age); // call Person constructor
            this.studentId = studentId;
            this.course = course;
        }

        @Override
        public void show() {
            // extend behaviour of show()
            System.out.println("Student: name=" + name + ", age=" + age + ", id=" + studentId + ", course=" + course);
        }
    }

    // ScholarshipStudent extends Student (multilevel inheritance)
    static class ScholarshipStudent extends Student {
        private double scholarshipAmount;

        public ScholarshipStudent(String name, int age, String studentId, String course, double scholarshipAmount) {
            super(name, age, studentId, course);
            this.scholarshipAmount = scholarshipAmount;
        }

        // override show() and also call super.show()
        @Override
        public void show() {
            super.show(); // show student details
            System.out.println("Scholarship amount: " + scholarshipAmount);
        }

        public double netFee(double baseFee) {
            // example method that uses scholarship to compute payable fee
            double payable = baseFee - scholarshipAmount;
            return payable < 0 ? 0 : payable;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Multilevel Inheritance Demo ---\n");

        Person p = new Person("Ramesh", 45);
        Student s = new Student("Priya", 20, "STU1001", "Computer Science");
        ScholarshipStudent ss = new ScholarshipStudent("Amit", 19, "STU1002", "Electronics", 1500.0);

        // Direct method calls
        p.show();
        System.out.println();
        s.show();
        System.out.println();
        ss.show();

        System.out.println();
        // Polymorphism: a Person reference to a ScholarshipStudent object
        Person polymorphic = new ScholarshipStudent("Neha", 18, "STU1003", "Mechanical", 2000.0);
        polymorphic.show(); // calls ScholarshipStudent.show() because of dynamic dispatch

        System.out.println();
        // Use subclass-specific method (need to cast)
        if (polymorphic instanceof ScholarshipStudent) {
            ScholarshipStudent casted = (ScholarshipStudent) polymorphic;
            double baseFee = 5000.0;
            System.out.println("Base fee: " + baseFee + ", payable after scholarship: " + casted.netFee(baseFee));
        }

        System.out.println("\n--- End ---");
    }
}
