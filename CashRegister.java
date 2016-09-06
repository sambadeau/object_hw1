import java.util.*;

public class CashRegister{
		private static int NUM_REGISTERS;

		public CashRegister(int registers){
			this.registers = NUM_REGISTERS;

		}

		private static int smallestRegister() {
			int currentSmallest = 0;
			for (int r=1; r<NUM_REGISTERS; r++)
				if (arrivalTimes[r].size() < arrivalTimes[currentSmallest].size())
					currentSmallest = r;
				return currentSmallest;
	}
	
}