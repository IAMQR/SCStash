package sc.lab4.company;

import sc.lab4.Bill;
import sc.lab4.Building;
import sc.lab4.Task;

public class BuildingCompany {
	private String name;

	private Order[] orders = new Order[10];

	private Manager manager;
	private Designer designer;

	// Constructors

	public BuildingCompany(String name) {
		this.name = name;

		manager = new Manager(null, null, null, this);
		designer = new Designer(null, null, null);
	}

	public BuildingCompany(String name, Manager manager, Designer designer) {
		this.name = name;
		this.manager = manager;
		this.designer = designer;
	}

	// Process task and add order to array

	public void addOrder(Task task) {
		Order order = null;

		try {
			order = manager.registerTask(task);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		orders[order.orderNumber] = order;
		System.out.printf("Order number %d added succesfully.", order.orderNumber);
	}

	// Complete order which number is specified in paid bill

	public Building completeOrder(Bill bill) {
		if (bill == null || bill.isPaid()) {
			System.out.printf("The bill for order %d doesn't exist or is not paid!", bill.orderNumber);
			return null;
		}

		return null;
	}

	// Get index of the first unassigned element in orders

	int getFreeElement() {
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] == null) {
				return i;
			}
		}

		return -1;
	}

	// Accessor & mutator methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
