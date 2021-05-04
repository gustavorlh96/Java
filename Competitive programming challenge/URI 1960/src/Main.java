import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in);
    	
    	int[] numArab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	int i = 0;
    	
    	int num = in.nextInt();

    	if (num > 0 && num <= 1000) {
    		while (num > 0) {
    			if (num >= numArab[i]) {
    				num -= numArab[i];
    				
    				if (numArab[i] == 1000) {
    					System.out.print("M");
    				}
    				else if (numArab[i] == 900) {
    					System.out.print("CM");
    				}
    				else if (numArab[i] == 500) {
    					System.out.print("D");
    				}
    				else if (numArab[i] == 400) {
    					System.out.print("CD");
    				}
    				else if (numArab[i] == 100) {
    					System.out.print("C");
    				}
    				else if (numArab[i] == 90) {
    					System.out.print("XC");
    				}
    				else if (numArab[i] == 50) {
    					System.out.print("L");
    				}
    				else if (numArab[i] == 40) {
    					System.out.print("XL");
    				}
    				else if (numArab[i] == 10) {
    					System.out.print("X");
    				}
    				else if (numArab[i] == 9) {
    					System.out.print("IX");
    				}
    				else if (numArab[i] == 5) {
    					System.out.print("V");
    				}
    				else if (numArab[i] == 4) {
    					System.out.print("IV");
    				}
    				else if (numArab[i] == 1) {
    					System.out.print("I");
    				}
    			}
    			else {
    				i++;
    			}
    		}
        }
        System.out.print("\n");
    }
}