import java.util.*;

public class BetterDiningHallSimulation{
		private static final int SIMULATION_TIME = 50000;  // A simulation is for 50,000 seconds.
		private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
		private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.
		private static Customer customer();
		private static CashRegister cashRegister();
		// info about customers waiting at the cash registers
		private static List<Integer>[] arrivalTimes = (List<Integer>[]) new List[NUM_REGISTERS];
		private static List<Integer>[] serviceTimes = (List<Integer>[]) new List[NUM_REGISTERS];   


		// statistics about the cash registers

		private static int[] customersServed = new int[NUM_REGISTERS];
		private static int[] totalWaitTimes = new int[NUM_REGISTERS];

		public static void main(String[] args){

				// First, initialize the cash register arrays.
		for (int r=0; r<NUM_REGISTERS; r++) {
			arrivalTimes[r] = new LinkedList<Integer>();
			serviceTimes[r] = new LinkedList<Integer>();
			customersServed[r] = 0;
			totalWaitTimes[r]  = 0;
		}

		// Then perform the simulation for the specified number of seconds.
		for (int t=0; t<SIMULATION_TIME; t++) {
			if (customer.aCustomerArrives()) {
				// The new customer goes into the smaller line.
				int chosenRegister = customer.smallestRegister(); 
				arrivalTimes[chosenRegister].add(t);
				serviceTimes[chosenRegister].add(2*customer.howManyItems() + 10);
			}

			for (int r=0; r<NUM_REGISTERS; r++)
				elapseOneSecond(r, t);  // Simulate each register for one second.
		}

		// Print out the statistics.
		for (int r=0; r<NUM_REGISTERS; r++) {
			System.out.println("Register " + r);
			System.out.println("\tNumber of arrivals = " + customersServed[r]);
			System.out.println("\tAverage wait time = " + (totalWaitTimes[r] / customersServed[r]));
		}

	}

	private static void elapseOneSecond(int reg, int currentTime) {
		// If the list is empty, there are no customers to process.
		if (arrivalTimes[reg].size() == 0)
			return;

		// Otherwise, the first customer in line gets processed.
		int timeLeft = serviceTimes[reg].get(0) - 1;
		if (timeLeft > 0) { 
			serviceTimes[reg].set(0, timeLeft);
		}
		else { // We are done with this customer.
			// First update the register's statistics.
			customersServed[reg]++;
			totalWaitTimes[reg] += currentTime - arrivalTimes[reg].get(0);

			// Then remove the customer.
			arrivalTimes[reg].remove(0);
			serviceTimes[reg].remove(0);
		}
	}
}