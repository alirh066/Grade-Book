

import java.util.ArrayList;
import java.util.Random;

public class Student {
	private String firstName;
	private String lastName;
	private String ID;
	private int quiz1;
	private int quiz2;
	private int project;
	private int midterm;
	private int finall;
	private double average;
	private String letterGrade;
	Random rand = new Random();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getQuiz1() {
		return quiz1;
	}

	public void setQuiz1(int quiz1) {
		this.quiz1 = quiz1;
	}

	public int getQuiz2() {
		return quiz2;
	}

	public void setQuiz2(int quiz2) {
		this.quiz2 = quiz2;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getFinall() {
		return finall;
	}

	public void setFinall(int finall) {
		this.finall = finall;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public String generateFirstName() {
		int limit = rand.nextInt(6) + 3;
		String name = "";
		for (int i = 0; i < limit; i++) {
			char character = (char) (rand.nextInt(26) + 'a');
			name += character;
		}
		firstName = name.substring(0, 1).toUpperCase() + name.substring(1);
		return firstName;
	}

	public String generateLastName() {
		int limit = rand.nextInt(6) + 3;
		String name = "";
		for (int i = 0; i < limit; i++) {
			char c = (char) (rand.nextInt(26) + 'a');
			name += c;
		}
		lastName = name.toUpperCase();
		return lastName;
	}

	public String generateID(ArrayList<Student> students) {
		String id = generateNumber();
		while (idExist(students, id) == true) {
			id = generateNumber();
		}
		return ID = id;
	}
  
	public String generateNumber() {
		String result = "";
		for (int i = 1; i <= 11; i++) {
			int number = rand.nextInt(10);
			result += number;
		}
		return result;
	}

	public boolean idExist(ArrayList<Student> students, String id) {
		for (int i = 0; i < students.size(); i++) {
			if (id.equals(students.get(i).getID())) {
				return true;
			}
		}
		return false;
	}

	public int generateQuiz1() {
		return quiz1 = rand.nextInt(101);
	}

	public int generateQuiz2() {
		return quiz2 = rand.nextInt(101);
	}

	public int generateProject() {
		return project = rand.nextInt(101);
	}

	public int generateMidterm() {
		return midterm = rand.nextInt(101);
	}

	public int generateFinall() {
		return finall = rand.nextInt(101);
	}

	public double average() {
		average = (quiz1 + quiz2 + project + midterm + finall) / 5.0;
		return average;
	}

	public String letterGrade() {
		if (average >= 0 && average < 30) {
			return letterGrade = "F";
		} else if (average >= 30 && average < 50) {
			return letterGrade = "D";
		} else if (average >= 50 && average < 60) {
			return letterGrade = "D+";
		} else if (average >= 60 && average < 65) {
			return letterGrade = "C-";
		} else if (average >= 65 && average < 70) {
			return letterGrade = "C";
		} else if (average >= 70 && average < 75) {
			return letterGrade = "C+";
		} else if (average >= 75 && average < 80) {
			return letterGrade = "B-";
		} else if (average >= 80 && average < 85) {
			return letterGrade = "B";
		} else if (average >= 85 && average < 90) {
			return letterGrade = "B+";
		} else if (average >= 90 && average < 95) {
			return letterGrade = "A-";
		} else {
			return letterGrade = "A";
		}
	}

	public String toString() {
		return String.format("%-9s%-12s%-15s%-9d%-8d%-11d%-11d%-9d%-11.2f%s\n", firstName, lastName, ID, quiz1, quiz2,
				project, midterm, finall, average, letterGrade);
	}
}
