import java.io.IOException;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in);
    	
    	int T = in.nextInt();
    	in.nextLine();
    	
    	for (int i = 0; i < T; i++) {
    		boolean verif = false;
    		int num = in.nextInt();
    		in.nextLine();
    		int base = 2;
    		String resFinal = "";
    		
    		do {
    			String[] restos = new String[1000];
    	    	String seq = "";
    	    	String seqRev = "";
    			int j = 0;
    			int N = num;
    			int resto = 0;
    			
    			while (N > 0) {
    				resto = N % base;
    				if (base > 10) {
    					if (resto == 10) {
    						restos[j] = "A";
    					}
    					else if (resto == 11) {
    						restos[j] = "B";
    					}
    					else if (resto == 12) {
    						restos[j] = "C";
    					}
    					else if (resto == 13) {
    						restos[j] = "D";
    					}
    					else if (resto == 14) {
    						restos[j] = "E";
    					}
    					else if (resto == 15) {
    						restos[j] = "F";
    					}
    					else {
    						restos[j] = String.valueOf(resto);
    					}
    				}
    				else {
    					restos[j] = String.valueOf(resto);
    				}
    				N = N / base;
    				j++;
    			}
    			
    			for (int k = j - 1; k >= 0; k--) {
    				seq += String.valueOf(restos[k]);
    			}
    			
    			for (int k = 0; k < j; k++) {
    				seqRev += String.valueOf(restos[k]);
    			}
    			
    			if (seq.equals(seqRev)) {
    				verif = true;
    				resFinal += String.valueOf(base + " ");
    			}
    			
    			base++;
    		} while (base <= 16);
    		
    		if (verif == true) {
    			resFinal = resFinal.substring(0, resFinal.lastIndexOf(" "));
    			System.out.print(resFinal);
    		}
    		
    		else {
    			resFinal += String.valueOf(-1);
    			System.out.print(resFinal);
    		}
    		System.out.print("\n");
    	}
    }
}