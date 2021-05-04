import java.util.Scanner;

public class Principal
{
    public static void main(String[] args){
        System.out.println("\t*** Seja bem-vindes! insira os dados dos(as) alunos(as) abaixo: ***\n");
        
        for (int i = 1; i <= 10; i++){
            Aluno aluno;
            aluno = criaAluno();
            avaliaAluno(aluno);
            System.out.println("" + aluno.imprimeAluno());
        }
    }
    
    public static Aluno criaAluno(){
        System.out.println("\n*** Dados básicos do(a) aluno(a) ***");
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do(a) aluno(a): ");
        String nome = in.nextLine();
        System.out.println("Digite o curso do(a) aluno(a): ");
        String curso = in.nextLine();
        System.out.println("Digite a data de nascimento (DD/MM/AAAA): ");
        String nascimento = in.nextLine();
        System.out.println("Digite o numero de matrícula: ");
        int matricula = in.nextInt();
        System.out.println("Digite o semestre: ");
        int semestre = in.nextInt();
        
        return new Aluno(nome, curso, nascimento, matricula, semestre);
    }
    
    public static void avaliaAluno(Aluno aluno){
        System.out.println("\n*** Avaliações do(a) aluno(a) ***");
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a nota do trabalho do Grau A: ");
        Double nota1 = in.nextDouble();
        aluno.setTrabGA(nota1);
        
        System.out.println("Digite a nota da prova do Grau A: ");
        Double nota2 = in.nextDouble();
        aluno.setProvaGA(nota2);
        
        System.out.println("Digite a nota do trabalho do Grau B: ");
        Double nota3 = in.nextDouble();
        aluno.setTrabGB(nota3);
        
        System.out.println("Digite a nota da prova do Grau B: ");
        Double nota4 = in.nextDouble();
        aluno.setProvaGB(nota4);
        
        aluno.calculaMediaFinal();
    }
}