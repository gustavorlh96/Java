public class Atleta
{
    // Atributos
    private int idade;
    private double peso;
    
    // Construtores
    public Atleta(int idade, double peso)
    {
        this.idade = idade;
        this.peso = peso;
    }
    
    public Atleta()
    {
        this.idade = 0;
        this.peso = 0;
    }
    
    // Metodos
    public int getIdade()
    {
        return idade;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
    
    public double getPeso()
    {
        return peso;
    }
    
    public void setPeso(double peso)
    {
        this.peso = peso;
    }
    
    public String determinaCategoria()
    {
        String categ = "";    
        
        if (this.idade <= 12){
            categ = "Infantil";
            System.out.println("" + categ);
            return categ;
        }
        else if (this.idade >= 13 && this.idade <= 16 && this.peso <= 40){
            categ = "Juvenil leve";
            System.out.println("" + categ);
            return categ;
        }
        else if (this.idade >= 13 && this.idade <= 16 && this.peso > 40){
            categ = "Juvenil pesado";
            System.out.println("" + categ);
            return categ;
        }
        else if (this.idade >= 17 && this.idade <= 24 && this.peso <= 45){
            categ = "Senior leve";
            System.out.println("" + categ);
            return categ;
        }
        else if (this.idade >= 17 && this.idade <= 24 && this.peso <= 60){
            categ = "Senior medio";
            System.out.println("" + categ);
            return categ;
        }
        else if (this.idade >= 17 && this.idade <= 24 && this.peso > 60){
            categ = "Senior pesado";
            System.out.println("" + categ);
            return categ;
        }
        else {
            categ = "Veterano";
            System.out.println("" + categ);
            return categ;
        }
    }
}