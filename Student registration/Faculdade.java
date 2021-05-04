public class Faculdade{
    private String curso;
    
    public Faculdade(String curso){
        this.curso = curso;
    }
    
    public String getCurso(){
        return this.curso;
    }
    
    public String toString(){
        return "Curso " + this.curso;
    }
}