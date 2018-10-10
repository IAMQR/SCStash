package sc.lab3;

import java.util.Scanner;

public class Lab3 {
	static final int SIZE = 10; // Initial size of arrays for storing patients
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Patient[] patients = new Patient[SIZE];
		int i = 0, choice;
		
		// Main program loop
		while (true) {
			displayMenu();
			choice = acceptNumber("Your choice : ");

			switch (choice) {
			case 1:
				displayPatients(patients);
				break;
			case 2:
				// TODO add patients (fill with random data or accept input from keyboard)

				patients = Tools.addElement(patients, i, new Patient());
				break;
			case 3:
				displaySearchMenu();
				int type;

				do {
					type = acceptNumber("Your choice : ");
				} while (type > 2 || type < 0); // Ask again if input is incorrect

				if (type == 0) { // Iterate anew if 'Go back' was selected
					continue;
				} else if (type == 1) {
					System.out.print("Diagnosis : ");
				} else if (type == 2) {
					System.out.print("Range (enter as \"StartN-EndN\") : ");
				}

				String query = scanner.nextLine().trim().toLowerCase();
				try {
					displayPatients(Tools.findPatients(patients, type, query));
				} catch (NumberFormatException e) { // handle if Integer.parseInt in findPatients throws an exception
					System.out.println("Number conversion error");
				}
				break;
			case 0:
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

	private static void displayMenu() { // Display available actions
		System.out.println("1. Display patients");
		System.out.println("2. Add patient");
		System.out.println("3. Find patients");
		System.out.println("0. Exit");
	}

	private static int acceptNumber(String promptMessage) { // Accept input while in menu
		int number = 0;

		while (true) {
			System.out.print(promptMessage);
			try {
				number = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Incorrect input, try again");
			}
		}

		return number;
	}

	private static void displayPatients(Patient[] array) { // Display table of patients
		if (array == null) {
			System.out.println("No patients to diplay");
		}

		String format = "%-25s"; // column alignment
		System.out.printf(format, "PatientID");
		System.out.printf(format, "MCardN");
		System.out.printf(format, "Diagnosis");
		System.out.printf(format, "FirstN");
		System.out.printf(format, "MiddleN");
		System.out.printf(format, "LastN");
		System.out.printf(format, "Address");
		System.out.printf("%s%n", "PhoneN");

		for (Patient patient : array) {
			if (patient != null) {
				System.out.println(patient);
			}
		}
	}

	private static void displaySearchMenu() {
		System.out.println("Search by :");
		System.out.println("1. Diagnosis");
		System.out.println("2. Medical card number in range");
		System.out.println("0. Go back");
	}
}
