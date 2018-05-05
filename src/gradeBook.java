

import java.util.ArrayList;
import java.util.Scanner;

public class gradeBook {

	static ArrayList<Student> students = new ArrayList<Student>();

	public static void generate(int n) {
		for (int i = 0; i < n; i++) {
			Student st = new Student();
			st.generateFirstName();
			st.generateLastName();
			st.generateID(students);
			st.generateQuiz1();
			st.generateQuiz2();
			st.generateProject();
			st.generateMidterm();
			st.generateFinall();
			st.average();
			st.letterGrade();
			students.add(st);
		}
	}

	public static void printArray() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

	public static String searchFor(String id) {
		String message = "No such student is found.";
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getID().equals(id)) {
				students.remove(i);
				message = "Student with ID " + id + " is deleted.";
			}
		}
		return message;
	}

	public static String getAverage() throws Exception {
		int quiz1 = 0;
		int quiz2 = 0;
		int project = 0;
		int midterm = 0;
		int finalExam = 0;
		double average = 0.0;
		String letterGrade = "";
		int numberOfStudents = students.size();

		for (int i = 0; i < students.size(); i++) {
			quiz1 += students.get(i).getQuiz1();
			quiz2 += students.get(i).getQuiz2();
			project += students.get(i).generateProject();
			midterm += students.get(i).getMidterm();
			finalExam += students.get(i).getFinall();
			average += students.get(i).getAverage();
		}

		quiz1 = quiz1 / numberOfStudents;
		quiz2 = quiz2 / numberOfStudents;
		project = project / numberOfStudents;
		midterm = midterm / numberOfStudents;
		finalExam = finalExam / numberOfStudents;
		average = average / numberOfStudents;

		if (average >= 0 && average < 30) {
			letterGrade = "F";
		} else if (average >= 30 && average < 50) {
			letterGrade = "D";
		} else if (average >= 50 && average < 60) {
			letterGrade = "D+";
		} else if (average >= 60 && average < 65) {
			letterGrade = "C-";
		} else if (average >= 65 && average < 70) {
			letterGrade = "C";
		} else if (average >= 70 && average < 75) {
			letterGrade = "C+";
		} else if (average >= 75 && average < 80) {
			letterGrade = "B-";
		} else if (average >= 80 && average < 85) {
			letterGrade = "B";
		} else if (average >= 85 && average < 90) {
			letterGrade = "B+";
		} else if (average >= 90 && average < 95) {
			letterGrade = "A-";
		} else {
			letterGrade = "A";
		}
		return String.format("\n%-21s%-15s%-9d%-8d%-11d%-11d%-9d%-11.2f%s\n", "", "AVERAGE:", quiz1, quiz2, project,
				midterm, finalExam, average, letterGrade);
	}

	public static void work() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		try {
			boolean work = true;
			while (work == true) {

				System.out.println("Enter 1 to add students.");
				System.out.println("Enter 2 to remove a student.");
				System.out.println("Enter 3 to see the grade list.");
				System.out.println("Enter 4 to clear the grade list.");
				System.out.println("Enter 5 to exit.");
				int input = scan.nextInt();
				if (input == 1) {
					System.out.println("Enter how many students you want to add.");

					int numberOfStudents = scan.nextInt();
					generate(numberOfStudents);
					System.out.println(
							numberOfStudents + " students are added. Total number of students is: " + students.size());

				}

				else if (input == 2) {

					System.out.println("Enter the ID of the student you want to remove from the list.");
					String id = scan.next();
					System.out.println(searchFor(id));
				} else if (input == 3) {

					System.out.println(
							"NAME     LAST NAME   ID             QUIZ1    QUIZ2   PROJECT    MIDTERM    FINAL    AVERAGE    LETTER GRADE");
					System.out.println(
							"------------------------------------------------------------------------------------------------------------");

					printArray();
					try {
						System.out.println(getAverage());
					} catch (Exception e) {

						System.out.println();
					}
					System.out.println(
							"------------------------------------------------------------------------------------------------------------");

				} else if (input == 4) {
					students.clear();
					System.out.println("Student list is cleared.");
				} else if (input == 5) {

					work = false;
					System.out.println("Bye.");
					System.exit(0);
				}

				else
					System.out.println("Invalid selection.");
			}
		} catch (Exception e) {

			System.out.println("Invalid input.");
			work();

		}
	}

	public static void main(String[] args) {

		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			System.out.println("Enter hom many student you want to generate.");
			int x = s.nextInt();
			generate(x);
			System.out.println(x + " Students are generated.");
			work();
		} catch (Exception e) {
			System.out.println("Invalid input.");
			main(args);

		}
	}
}