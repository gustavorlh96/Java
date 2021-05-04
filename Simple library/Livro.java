public class Livro
{
    protected String titulo, autor;
    protected int ano;
    protected double preco;
    
    public Livro(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = 0;
    }
    
    public Livro(String titulo, String autor, int ano, double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public String toString(){
        return "\"" +  this.titulo + "\", escrito por " + "\"" + this.autor + "\", de " + this.ano + " por " + this.preco + " reais.";
    }
}