import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in) ;
        int[] arr = new int[100005];
        int n;

        arr[3] = 1;
        for(int i = 4; i <= 100000; i++)
        {
            arr[i] = (int)((arr[i - 1] * 1L *i) % 1000000009L);
        }

        while(true)
        {
            n = input.nextInt() ;
            if(n==0)
            {
                break;
            }
            System.out.println(arr[n]);
        }

    }

}