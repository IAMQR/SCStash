package sc.lab4.company;

import sc.lab4.Person;
import sc.lab4.Task;

public class Manager extends Person {

	private BuildingCompany placeOfWork;

	public Manager(String firstName, String lastName, String telNumber, BuildingCompany placeOfWork) {
		super(firstName, lastName, telNumber);
		this.placeOfWork = placeOfWork;
	}

	public Order registerTask(Task task) throws Exception {
		int orderIndex = placeOfWork.getFreeElement();
		if (orderIndex == -1) {
			throw new Exception(System.out.format("%s is busy, try again later.", placeOfWork.getName()).toString());
		}

		return new Order(orderIndex, task.client, task.floorsNumber, task.sizeM2);
	}
}
