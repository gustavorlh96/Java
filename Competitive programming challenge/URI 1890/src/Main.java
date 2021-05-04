import java.util.*;  
public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int cases,c,d,answer;
        answer = 1; 
        cases = input.nextInt(); // test case input
        while(cases>0)
        {

            c = input.nextInt() ;
            d = input.nextInt() ;
            if(c == 0 && d == 0)
                answer = 0;
            while(c>0)
            {
                answer = answer * 26 ;
                c-- ;
            }
            while(d>0)
            {
                answer = answer * 10 ;
                d-- ;
            }
            System.out.println(answer);
            cases-- ;
            answer = 1 ;
        }

    }

}