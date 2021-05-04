import java.util.Scanner;

public class TestaSociedade
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("\tDigite o tamanho do array:");
        int tamanhoArray = in.nextInt();
        in.nextLine();
        
        SociedadeDeAtletas sc1 = new SociedadeDeAtletas("we live in a society lmao", tamanhoArray);
        
        System.out.printf("\nInsira %d peso(s) no array: ", tamanhoArray);
        for (int i = 0; i < tamanhoArray; i++){
            int insertPeso = in.nextInt();
            in.nextLine();
            sc1.insert(insertPeso);
        }
        
        System.out.println("" + sc1.toString());
        System.out.println("" + sc1.calculaMedia());
    }
}