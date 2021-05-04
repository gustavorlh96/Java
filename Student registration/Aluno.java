public class Aluno{
    // Atributos
    private String nome;
    private Faculdade curso;
    private Data nascimento;
    private int matricula, semestre;
    private double trabGA, provaGA, trabGB, provaGB, mediaFinal;
    
    // Metodos Construtores
    public Aluno(String nome, Faculdade curso, Data nascimento, int matricula, int semestre){
        this.nome = nome;
        this.curso = null;
        this.matricula = matricula;
        this.semestre = semestre;
        this.nascimento = null;
        this.trabGA = 0;
        this.trabGB = 0;
        this.provaGA = 0;
        this.provaGB = 0;
    }
    
    // Metodos get e set
    public String getNome(){
        return nome;
    }
       
    public Faculdade getCurso(){
        return curso;
    }
       
    public Data getNascimento(){
        return nascimento;
    }
    
    public int getMatricula(){
        return matricula;
    }
    
    public int getSemestre(){
        return semestre;
    }
    
    public double getTrabGA(){
        return trabGA;
    }
    
    public void setTrabGA(double trabGA){
        this.trabGA = trabGA;
    }
    
    public double getProvaGA(){
        return provaGA;
    }
    
    public void setProvaGA(double provaGA){
        this.provaGA = provaGA;
    }
    
    public double getTrabGB(){
        return trabGB;
    }
    
    public void setTrabGB(double trabGB){
        this.trabGB = trabGB;
    }
    
    public double getProvaGB(){
        return provaGB;
    }
    
    public void setProvaGB(double provaGB){
        this.provaGB = provaGB;
    }
    
    // Metodos
    public void calculaMediaFinal(){
        this.mediaFinal = (((trabGA * 0.4 + provaGA*0.6) + (trabGB * 0.4 + provaGB * 0.6)) * 2) / 3;
    }
    
    public String toString(){
        
    }
    /*
    public void imprimeAluno(){ // Não precisa ser String com retorno, void basta!
        System.out.println("\n========================================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de nascimento: " + this.nascimento);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Curso: " + this.curso);
        System.out.println("Nota trabalhos GA: " + this.trabGA);
        System.out.println("Nota prova GA: " + this.provaGA);
        System.out.println("Nota trabalhos GB: " + this.trabGB);
        System.out.println("Nota prova GB: " + this.provaGB);
        System.out.printf("Média final: %.2f\n", this.mediaFinal);
        System.out.println("========================================");
    }
    */
}