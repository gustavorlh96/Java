public class TestaArrays
{
    public static void main(String[] args){
        int[] a = {1, 2, 3, 50, 5, 6, 7, 8, 9, 10};
        int maior = 0, pos = 0;
        
        for (int i = 0; i < a.length; i++){
            if (a[i] > maior){
                maior = a[i];
                pos = i;
            }
        }
        
        System.out.println("Maior número: " + maior + "\nPosição do número: " + pos);
    }
}