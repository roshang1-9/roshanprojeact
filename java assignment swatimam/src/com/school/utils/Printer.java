package com.school.utils;

import com.school.models.Student;

/**
 * Utility class in a different package to show importing and using classes
 * from other packages.
 */
public class Printer {
    public static void printStudent(Student s) {
        System.out.println("[Printer] " + s.toString());
    }
}
