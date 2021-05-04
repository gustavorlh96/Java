public class TestaArrays
{
    public static void main(String[] args){
        int[] a = {10, 9, -8, 7, -6, -5, 4, 0, 2, 1};
        boolean[] b = new boolean[10];
        
        for (int i = 0; i < a.length; i++){
            if (a[i] <= 0){
                b[i] = false;
            }
            else {
                b[i] = true;
            }
        }
        
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
            System.out.println(b[i]);
        }
    }
}
