package sc.lab1;

import java.util.Random;

// TODO Calculate sum of elements in the same loop where we find indices

public class Lab1 {
	public static void main(String[] args) {
		int size = 0;
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		do {
			System.out.print("Enter size : ");
			try {
				size = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				size = 0;
			}

			if (size < 1) {
				System.out.println("Incorrect size.");
			}
		} while (size < 1);

		scanner.close();

		double[][] arr = new double[size][size];

		Random random = new Random();

		for (int i = 0; i < size; i++) // Fill matrix with values
			for (int j = 0; j < size; j++)
				arr[i][j] = random.nextDouble() - 0.5;

		int firstX, firstY, secondX, secondY; // Declare variables to store indices
		firstX = firstY = secondX = secondY = -1;

		exit: {
			for (int i = 0; i < size; i++) // Get indices of first and second negative elements
				for (int j = 0; j < size; j++) {
					if (arr[i][j] < 0) {
						if (firstX == -1) {
							firstY = secondY = i;
							firstX = secondX = j;
						} else {
							secondY = i;
							secondX = j;
							break exit;
						}
					}
				}
		}

		System.out.println("Mykola Demianko\n");

		for (int i = 0; i < size; i++) // Display the matrix
			for (int j = 0; j < size; j++) {
				System.out.format("%+f ", arr[i][j]);
				if (j == size - 1) {
					System.out.println();
				}
			}

		double sum = 0;

		exit: {
			for (int i = firstY; i < size; i++) // Calculate sum of elements between first and second negative numbers
				for (int j = firstX; j < size; j++) {
					if (i == firstY && j == firstX) {
						j++;

						if (j == size) {
							break;
						}
					}
					if (i == secondY && j >= secondX) {
						break exit;
					}
					sum += arr[i][j];
				}
		}

		System.out.format("\nSum : %f", sum);
	}
}
