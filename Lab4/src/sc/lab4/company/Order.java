package sc.lab4.company;

import sc.lab4.Client;

public class Order {
	public final int orderNumber;
	public final Client client;
	public final int floorsNumber;
	public final int sizeM2;

	Order(int orderNumber, Client client, int floorsNumber, int sizeM2) {
		this.orderNumber = orderNumber;
		this.client = client;
		this.floorsNumber = floorsNumber;
		this.sizeM2 = sizeM2;
	}
}
