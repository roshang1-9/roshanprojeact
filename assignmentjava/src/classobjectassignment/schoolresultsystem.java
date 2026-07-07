package classobjectassignment;

import java.util.Scanner;

public class schoolresultsystem {

	// Reads student details from Scanner and displays total, average and grade
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter student name: ");
		String name = sc.nextLine();

		System.out.print("Enter math marks: ");
		double math = readDouble(sc);

		System.out.print("Enter science marks: ");
		double science = readDouble(sc);

		System.out.print("Enter english marks: ");
		double english = readDouble(sc);

		StudentResult student = new StudentResult(name, math, science, english);

		System.out.println();
		System.out.println(student);

		sc.close();
	}

	// Helper to read a double and handle invalid input
	private static double readDouble(Scanner sc) {
		while (true) {
			try {
				String token = sc.next();
				double val = Double.parseDouble(token);
				return val;
			} catch (NumberFormatException e) {
				System.out.print("Invalid number, please enter again: ");
			}
		}
	}

}

// StudentResult holds marks and computes total, average and grade
class StudentResult {
	private String studentName;
	private double mathMarks;
	private double scienceMarks;
	private double englishMarks;

	public StudentResult(String studentName, double mathMarks, double scienceMarks, double englishMarks) {
		this.studentName = studentName;
		this.mathMarks = mathMarks;
		this.scienceMarks = scienceMarks;
		this.englishMarks = englishMarks;
	}

	// Getters
	public String getStudentName() {
		return studentName;
	}

	public double getMathMarks() {
		return mathMarks;
	}

	public double getScienceMarks() {
		return scienceMarks;
	}

	public double getEnglishMarks() {
		return englishMarks;
	}

	// total of three subjects
	public double getTotal() {
		return getMathMarks() + getScienceMarks() + getEnglishMarks();
	}

	// average (percentage over 100 per subject)
	public double getAverage() {
		return getTotal() / 3.0;
	}

	// simple grading scheme based on average
	public String getGrade() {
		double avg = getAverage();
		if (avg >= 90) return "A+";
		if (avg >= 80) return "A";
		if (avg >= 70) return "B";
		if (avg >= 60) return "C";
		if (avg >= 50) return "D";
		return "F";
	}

	@Override
	public String toString() {
		return String.format("Student: %s\nMath: %.2f, Science: %.2f, English: %.2f\nTotal: %.2f, Average: %.2f, Grade: %s",
				getStudentName(), getMathMarks(), getScienceMarks(), getEnglishMarks(), getTotal(), getAverage(), getGrade());
	}
}
