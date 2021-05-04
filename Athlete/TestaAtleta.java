import java.util.Scanner;

public class TestaAtleta
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int idade = in.nextInt();
        double peso = in.nextDouble();
        
        Atleta a1 = new Atleta(idade, peso);
        
        a1.determinaCategoria();
    }
}