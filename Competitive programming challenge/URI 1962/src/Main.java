import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in);
    	
    	int num = in.nextInt();
    	
    	for (int i = 0; i < num; i++) {
    		int ano = in.nextInt();
    		
    		if (ano < 2015) {
    			ano = 2015 - ano;
    			System.out.println(ano + " D.C.");
    		}
    		else {
    			ano = ano - 2014;
    			System.out.println(ano + " A.C.");
    		}
    	}
    }
}