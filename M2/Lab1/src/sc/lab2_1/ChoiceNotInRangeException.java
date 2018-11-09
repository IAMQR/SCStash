package sc.lab2_1;

class ChoiceNotInRangeException extends Exception {
	int choice;
	
	ChoiceNotInRangeException(int choice) {
		this.choice = choice;
	}
	
	@Override
	public String getMessage() {
		return String.format("The specified choice is not in range : %d\n", choice);
	}
}
