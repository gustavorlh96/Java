import java.util.*;
public class Main
{
 public static boolean isPrime(int number)
    {
        if(number %2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(number) ; i+=2 )
        {

            if(number%i == 0)
                return false;
        }
        return true;
    }
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        int count=1,speed=0,hour,day;
        int weight = input.nextInt();

        while(count <= 10) {

            if(isPrime(weight))
            {
                speed+=weight;
                count++ ;
            }
            weight++;
        }
        hour = 60000000 / speed;     /// convert hour
        day = hour / 24 ;
        System.out.println(speed+" km/h") ;
        System.out.println(hour+" h / "+ day + " d") ;
    }

}