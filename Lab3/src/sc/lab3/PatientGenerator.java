package sc.lab3;

import java.util.Random;

public class PatientGenerator {
	// TODO Generate classes of type Patient or at least some fields to instantiate
	private static Random random = new Random();

	private static String[] diagnosisPool = { "Bacterial meningitis", "Blastocystis hominis infection",
			"Reiter's syndrome", "Myoclonus", "Lupus erythematosus", "Anemia", "Black piedra",
			"Demyelinating neuropathies", "Cold agglutinin disease", "Typhoid fever" };
	private static String[] firstNamePool = { "Barrett", "Jayden", "Gustavo", "Cortez", "Jakob", "Nicole", "Alivia",
			"Reagan", "Abbie", "Siena" };
	private static String[] lastNamePool = { "Peck", "Flynn", "Ramirez", "Hatfield", "Bowers", "Sanford", "Mccormick",
			"Forbes", "Moses", "Fisher" };
	private static String[] addressPool = { "11 Inverness Ave. Westwood, NJ 07675",
			"7053 Glenwood Ave. North Wales, PA 19454", "7581 Newport Court Dearborn Heights, MI 48127",
			"8201 Homestead Street De Pere, WI 54115", "720 E. Nichols St. Palm Beach Gardens, FL 33410",
			"807 North Gartner Street Glastonbury, CT 06033", "79 Bridge Road lymouth, MA 02360",
			"41 Lexington St. Lady Lake, FL 32159", "9364 Goldfield Dr. Downingtown, PA 19335",
			"746 Green Drive Rahway, NJ 07065" };

	public static Patient generatePatient() {
		// TODO
		return null;
	}

	public static int generateIdentificationNumber() {
		// TODO
		return 0;
	}

	public static int generateMedicalCardNumber() {
		// TODO
		return 0;
	}

	public static String generateDiagnosis() {
		// TODO
		return null;
	}

	public static String generateFirstName() {
		// TODO
		return null;
	}

	public static String generateLastName() {
		// TODO
		return null;
	}

	public static String generateAddress() {
		// TODO
		return null;
	}

	public static String generatePhoneNumber() {
		// TODO
		return null;
	}
}
