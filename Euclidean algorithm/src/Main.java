import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main m1 = new Main();
		long A, B;
		
		System.out.println("\t\t*** Euclidean algorithm ***");
		while (true) {
			try {
				System.out.println("[1/2] Insert an integer: ");
				A = in.nextLong();
				in.nextLine();
					
				
				System.out.println("[2/2] Insert another integer: ");
				B = in.nextLong();
				in.nextLine();
				
				if (B <= 0 || A <= 0)
					System.out.println("[ERROR] The numbers can't zero or less. Try again.");
				else
					break;
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] Invalid input, needs to be an integer. Try again.");
				in.nextLine();
			}
		}
		in.close();
		
		if (A > B)
			System.out.println("The GCD for (" + A + ", " + B + ") is " + m1.greatestCommonDivisor(A, B) + ".");
		else
			System.out.println("The GCD for (" + A + ", " + B + ") is " + m1.greatestCommonDivisor(B, A) + ".");
	}

	private long greatestCommonDivisor(long A, long B) {
		if (A == B) return A;
		else if (A > B) return greatestCommonDivisor(A - B, B);
		else return greatestCommonDivisor(A, B - A);
	}
}