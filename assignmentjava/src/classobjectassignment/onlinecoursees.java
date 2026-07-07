package classobjectassignment;

import java.util.Scanner;

public class onlinecoursees {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			CourseStudent student = new CourseStudent();

			// Read student name (may contain spaces)
			System.out.print("Enter student name: ");
			String studentName = sc.nextLine().trim();
			student.setStudentName(studentName);

			// Read course name
			System.out.print("Enter course name: ");
			String courseName = sc.nextLine().trim();
			student.setCourseName(courseName);

			// Read course fee (double, non-negative)
			double fee = -1.0;
			while (fee < 0) {
				System.out.print("Enter course fee (non-negative number): ");
				if (sc.hasNextDouble()) {
					fee = sc.nextDouble();
					if (fee < 0) {
						System.out.println("Course fee cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next(); // consume invalid token
				}
			}
			student.setCourseFee(fee);

			// Read discount percent (0-100)
			double discount = -1.0;
			while (discount < 0 || discount > 100) {
				System.out.print("Enter discount percent (0-100): ");
				if (sc.hasNextDouble()) {
					discount = sc.nextDouble();
					if (discount < 0 || discount > 100) {
						System.out.println("Discount percent must be between 0 and 100. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			student.setDiscountPercent(discount);

			// Print student details and final payable fee (calculated by getter)
			System.out.println();
			System.out.println("Student Name: " + student.getStudentName());
			System.out.println("Course Name: " + student.getCourseName());
			System.out.printf("Final Fee: %.2f%n", student.getFinalFee());
		}
	}

}

// Package-private helper class implementing the required CourseStudent
class CourseStudent {
	private String studentName;
	private String courseName;
	private double courseFee;
	private double discountPercent;

	public CourseStudent() {
	}

	// Setters
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	// Getters for basic fields
	public String getStudentName() {
		return studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	// Getter that calculates and returns the final payable fee
	public double getFinalFee() {
		return courseFee - (courseFee * discountPercent / 100.0);
	}
}
