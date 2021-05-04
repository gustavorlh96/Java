import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in);
    	
    	boolean verif = false;
    	
    	while (verif == false) {
    		double res = 0;
    		int lajota = in.nextInt();
    		in.nextLine();
        	double raizqCinco = Math.sqrt(5);
    		
    		if (lajota != 0 && lajota != 1) {
    			res = Math.pow((1 + raizqCinco) / 2, (++lajota)) * (1 / raizqCinco);
    			res -= Math.pow((1 - raizqCinco) / 2, (++lajota)) * (1 / raizqCinco);
    			res = Math.round(res);
    			DecimalFormat resFinal = new DecimalFormat("0.#");
    			System.out.print(resFinal.format(res));
    			System.out.print("\n");
    		}
    		else if (lajota == 1) {
    			System.out.print(1);
    			System.out.print("\n");
    		}
    		else {
    			verif = true;
    		}
    	}
    }
}