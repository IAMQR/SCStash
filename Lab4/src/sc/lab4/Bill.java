package sc.lab4;

public class Bill {
	public final double sum;
	public final int orderNumber;
	private boolean paid; // true if bill has been paid

	public Bill(double sum, int orderNumber) {
		this.sum = sum;
		this.orderNumber = orderNumber;
	}

	public boolean isPaid() {
		return paid;
	}

	public void pay() {
		paid = true;
	}
}
