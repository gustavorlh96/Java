public class SociedadeDeAtletas
{
    private String nome;
    private double[] pesos;
    private int numAtletas;
    
    public SociedadeDeAtletas(String nome, int capMax){
        this.nome = nome;
        this.pesos = new double[capMax];
        this.numAtletas = 0;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getNumAtletas(){
        return this.numAtletas;
    }
    
    public void setNumAtletas(int numAtletas){
        this.numAtletas = numAtletas;
    }
    
    public void insert(double peso){
        pesos[numAtletas] = peso;
        numAtletas++;
    }
    
    public double getPeso(int pos){
        if (pos < numAtletas){
            return pesos[pos];
        }
        else {
            return -1;
        }
    }
    
    public String toString(){
        String temp = "";
        for (int i = 0; i < pesos.length; i++){
            temp += pesos[i] + ", ";
        }
        return temp;
    }
    
    public double calculaMedia(){
        double somatorio = 0, media = 0;
        for (int i = 0; i < pesos.length; i++){
            somatorio += pesos[i];
        }
        media = somatorio / numAtletas;
        return media;
    }
}