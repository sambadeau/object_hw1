import java.util.*;

public class Customer{
	private static int CUST_ARRIVAL_PCT;
	public Customer(int percentage){
			this.percentage = CUST_ARRIVAL_PCT;
	}


	private static boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}

	private static int howManyItems() {
		int n = (int) (Math.random() * 10);
		return n + 1;
	}

}