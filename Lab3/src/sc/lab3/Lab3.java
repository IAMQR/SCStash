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
			choice = acceptNumber("Your choice : ", 0, 3);

			switch (choice) {
			case 1: // Display patients
				displayPatients(patients);
				break;
			case 2: // Add patients
				displayPatientAdditionMenu();
				choice = acceptNumber("Your choice : ", 0, 2);
				switch (choice) {
				case 0: // Iterate anew if 'Go back' was selected
					continue;
				case 1:
					patients = Tools.addElement(patients, i++, PatientGenerator.generatePatient());
					break;
				case 2:
					patients=Tools.addElement(patients, i++, askForPatient());
					break;
				default:
					break;
				}
				break;
			case 3: // Search patients
				displaySearchMenu();

				choice = acceptNumber("Your choice : ", 0, 2);

				if (choice == 0) { // Iterate anew if 'Go back' was selected
					continue;
				} else if (choice == 1) {
					System.out.print("Diagnosis : ");
				} else if (choice == 2) {
					System.out.print("Range (enter as \"StartN-EndN\") : ");
				}

				String query = scanner.nextLine().trim().toLowerCase();
				try {
					displayPatients(Tools.findPatients(patients, choice, query));
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
	
	private static Patient askForPatient() {
		// TODO
		return null;
	}

	private static int acceptNumber(String promptMessage, int lowerBound, int upperBound) { // Accept input while in
																							// menu
		int number = 0;

		do {
			System.out.print(promptMessage);
			try {
				number = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Incorrect input, try again");
			}
		} while (number > upperBound || number < lowerBound); // Ask again if input is incorrect

		System.out.println();
		return number;
	}

	private static void displayPatients(Patient[] array) { // Display table of patients
		if (array == null) {
			System.out.println("No patients to display");
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
		System.out.println();
	}

	private static void displayMenu() { // Display available actions
		System.out.println("1. Display patients");
		System.out.println("2. Add patient");
		System.out.println("3. Find patients");
		System.out.println("0. Exit");
	}

	private static void displaySearchMenu() {
		System.out.println("Search by :");
		System.out.println("1. Diagnosis");
		System.out.println("2. Medical card number in range");
		System.out.println("0. Go back");
	}

	private static void displayPatientAdditionMenu() {
		System.out.println("Add patient :");
		System.out.println("1. Generate random");
		System.out.println("2. Enter manually");
		System.out.println("0. Go back");
	}
}
