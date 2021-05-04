import java.util.Scanner;

public class TestaArrays
{
    public static void main(String[] args){
        int[] a = new int[5];
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("\t*** Digite 5 números inteiros! ***");
        for (int i = 0; i < a.length; i++){
            a[i] = in.nextInt();
        }
        
        System.out.println("Os números lidos foram: ");
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
