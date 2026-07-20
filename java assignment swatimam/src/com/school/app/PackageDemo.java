package com.school.app;

import com.school.models.Student;
import com.school.utils.Printer;

/**
 * Main class that demonstrates the use of packages and importing across packages.
 */
public class PackageDemo {
    public static void main(String[] args) {
        System.out.println("--- Package demo ---");
        Student s1 = new Student("S001", "Rohan", 20);
        Student s2 = new Student("S002", "Sneha", 19);

        // Use Printer from com.school.utils package
        Printer.printStudent(s1);
        Printer.printStudent(s2);

        System.out.println("--- End ---");
    }
}
