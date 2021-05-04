import java.util.Scanner;

public class TestaArrays
{
    public static void main(String[] args){
        double[] d = new double[10];
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("\t*** Digite dez números ***");
        for (int i = 0; i < d.length; i++){
            System.out.println("Digite um número para armazenar na posição " + i + ":");
            double temp = in.nextDouble();
            d[i] = temp;
        }
        
        System.out.println("O array contém esses números: ");
        for (int i = 0; i < d.length; i++){
            System.out.println(d[i]);
        }
    }
}
