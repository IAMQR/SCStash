package sc.lab2_1;

import java.util.Arrays;
import java.util.Scanner;

public class Tools {

	// Accept integer from user
	public static int acceptNumber(String promptMessage, Scanner scanner) {
		System.out.print(promptMessage);
		int number = Integer.parseInt(scanner.nextLine());
		
		return number;
	}

	/*
	 * Search for patients in the specified array basing on type and query variables
	 */
	public static Patient[] findPatients(Patient[] patients, int type, String query) { // type should be either 1 or 2
		if (type == 1) {
			return findByDiagnosis(patients, query);
		} else {
			String[] temp = query.split("-");
			int start = Integer.parseInt(temp[0].trim());
			int finish = Integer.parseInt(temp[1].trim());

			return findByMediCardInRange(patients, start, finish);
		}
	}

	/* Get patients with specified diagnosis */
	private static Patient[] findByDiagnosis(Patient[] patients, String diagnosis) {
		Patient[] result = new Patient[patients.length];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (diagnosis.equals(patients[i].getDiagnosis())) {
				result = addElement(result, j++, patients[i]);
			}
		}

		return result;
	}

	/* Get patients whose medical card number is within specified boundaries */
	private static Patient[] findByMediCardInRange(Patient[] patients, int start, int finish) {
		Patient[] result = new Patient[patients.length];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (patients[i].getMedicalCardNumber() >= start && patients[i].getMedicalCardNumber() <= finish) {
				result = addElement(result, j++, patients[i]);
			}
		}

		return result;
	}

	/*
	 * Assign patient to element at index, expand and return the expanded array if
	 * index exceeds boundaries
	 */
	public static Patient[] addElement(Patient[] array, int index, Patient patient) {
		Patient[] result = array;

		if (index >= result.length) {
			result = Arrays.copyOf(array, (int) (array.length * 1.5));
		}

		result[index] = patient;

		return result;
	}

	// Check if array contains no initialised elements
	public static boolean empty(Patient[] arr) {
		if (arr == null || arr.length == 0) {
			return true;
		}

		for (Patient patient : arr) {
			if (patient != null) {
				return false;
			}
		}

		return true;
	}
}
