public class Aluno{
    // Atributos
    private String nome, curso, nascimento;
    private int matricula, semestre;
    private double trabGA, provaGA, trabGB, provaGB, mediaFinal;
    
    // Metodos Construtores
    public Aluno(String nome, String curso, String nascimento, int matricula, int semestre){
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
        this.nascimento = nascimento;
        this.trabGA = 0;
        this.trabGB = 0;
        this.provaGA = 0;
        this.provaGB = 0;
    }
    
    // Metodos get e set
    public String getNome(){
        return nome;
    }
       
    public String getCurso(){
        return curso;
    }
       
    public String getNascimento(){
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
        this.mediaFinal = Math.round(this.mediaFinal * 100.0) / 100.0; // Reduz o resultado para dois digitos!
    }
    
    public String imprimeAluno(){
        String impressao =
        "\n========================================" +
        "\nNome: " + this.nome +
        "\nData de nascimento: " + this.nascimento +
        "\nMatricula: " + this.matricula +
        "\nCurso: " + this.curso + " (" + this.semestre + "o semestre)" +
        "\nNota trabalhos GA: " + this.trabGA +
        "\nNota prova GA: " + this.provaGA +
        "\nNota trabalhos GB: " + this.trabGB +
        "\nNota prova GB: " + this.provaGB +
        "\nMédia final: " + this.mediaFinal +
        "\n========================================\n";
        
        return impressao;
    }
}