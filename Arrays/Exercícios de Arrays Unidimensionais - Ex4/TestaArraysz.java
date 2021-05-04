public class TestaArraysz
{
    public static void main(String[] args){
        int[] a = {10, 9, -8, 7, 6, 5, 4, -3, 2, 1};
        int cont = 0;
    
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0){
                cont++;
            }
        }
        
        System.out.println("O total de números negativos no array é: " + cont);
    }
}