import java.util.Scanner;

public class TestaArrays
{
    public static void main(String[] args){
        int[] a = {10, 5, 8, 7, 6, 5, 4, 3, 5, 1};
        int cont = 0, temp = 0, x = 0;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um número para verificar quantas vezes ele aparece no array: ");
        x = in.nextInt();
        
        for (int i = 0; i < a.length; i++){
            temp = a[i];
            
            if (temp == x){
                cont++;
            }
        }
        
        if (cont == 0){
            System.out.println(x + " não aparece nenhuma vez no array!");
        }
        else {
            System.out.println(x + " aparece " + cont + " vez(es) no array!");
        }
    }
}