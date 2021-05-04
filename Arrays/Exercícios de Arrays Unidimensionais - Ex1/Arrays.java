public class Arrays
{
    public static void main(String[] args){
        //exercicio1a();
        //exercicio1b();
        //exercicio1c();
        exercicio1d();
    }
    
    public static void exercicio1a(){
        //10 9 8 7 6 5 4 3 2 1
        int[] arrayA = new int[10];
        for (int i = 0; i < arrayA.length; i++){
            arrayA[i] = 10 - i;
        }
        
        System.out.println("\tO array de 'a' contém os seguintes números:");
        for (int i = 0; i < arrayA.length; i++){
            System.out.printf("%d ", arrayA[i]);
        }
    }
    
    public static void exercicio1b(){
        //0 1 4 9 16 25 36 49 64 81 100
        int[] arrayB = new int[11];
        for (int i = 0; i < arrayB.length; i++){
            arrayB[i] = i * i;
        }
        
        System.out.println("\tO array de 'b' contém os seguintes números:");
        for (int i = 0; i < arrayB.length; i++){
            System.out.printf("%d ", arrayB[i]);
        }
    }
    
    public static void exercicio1c(){
        //1 2 3 4 5 10 20 30 40 50
        int[] arrayC = new int[10];
        for (int i = 0; i < arrayC.length; i++){
            if (i <= 4){
                arrayC[i] = i + 1;
            }
            
            else {
                arrayC[i] = (i - 4) * 10;
            }
        }
        
        System.out.println("\tO array de 'c' contém os seguintes números:");
        for (int i = 0; i < arrayC.length; i++){
            System.out.printf("%d ", arrayC[i]);
        }
    }
    
    public static void exercicio1d(){
        //3 4 7 12 19 28 39 52 67 84
        int temp = 0;
        double[] arrayD = new double[10];
        for (int i = 0; i < arrayD.length; i++){
            arrayD[i] = Math.pow(i, 2) + 3;
        }
        
        System.out.println("\tO array de 'd' contém os seguintes números:");
        for (int i = 0; i < arrayD.length; i++){
            System.out.printf("%.0f ", arrayD[i]);
        }
    }
}
