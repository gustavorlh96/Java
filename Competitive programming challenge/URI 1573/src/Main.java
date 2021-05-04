import java.util.*;
public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in) ;
        int A,B,C,bar,res;
        while(true)
        {
            A = input.nextInt() ;
            B = input.nextInt() ;
            C = input.nextInt() ;
            
            if( A == 0 || B == 0 || C == 0 )
            {
                break ;
            }
            else
            {
                bar = A * B * C;
                res = (int) Math.cbrt(bar);
                System.out.println(res);
            }

        }
    }

}