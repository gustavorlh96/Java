public class Biblioteca
{
    protected Livro[] livros;
    protected int numLivros;
    
    public Biblioteca(){
        this.livros = new Livro[100];
        this.numLivros = 0;
    }
    
    public boolean adicionaLivro(Livro novoLivro){
        boolean temp = false;
        for (int i = 0; i < livros.length; i++){
            if (livros[i] == null){
                livros[i] = novoLivro;
                numLivros++;
                temp = true;
                return temp;
            }
            else {
                temp = false;
                continue;
            }
        }
        return temp;
    }
    
    /*public Livro[] buscaLivroTitulo(String strBusca){
        Livro[] arrayTemp = new Livro[numLivros];
        for (int i = 0; i < numLivros; i++){
            if (livros[i].getTitulo().contains(strBusca)){
                arrayTemp[i] = livros[i];
                continue;
            }
        }
        return arrayTemp;
    }
    
    public Livro[] buscaLivroAtePreco(double precoMax){
        Livro[] arrayTemp = new Livro[numLivros];
        for (int i = 0; i < numLivros; i++){
            double temp = livros[i].getPreco();
            if (livros[i] != null){
                if (temp < precoMax){
                    arrayTemp[i] = livros[i];
                    continue;
                }
            }
        }
        return arrayTemp;
    }*/
    
    public Livro[] buscaLivroTitulo(String strBusca){
        Livro[] arrayTemp = new Livro[100];
        int indice = 0;
        for (int i = 0; i < livros.length; i++){
            if(livros[i] != null && livros[i].getTitulo().contains(strBusca)){
                for (int j = 0; j < arrayTemp.length; j++){
                    if (arrayTemp[j] == null){
                        arrayTemp[j] = livros[i];
                        System.out.println("Livro selecionado por título: " + arrayTemp[j].getTitulo());
                        indice = j;
                        break;
                    }
                }
            }
        }
    
        return arrayTemp;
    }

    public Livro[] buscaLivroAtePreco(double precoMax){
        Livro[] arrayTemp = new Livro[100];
        int indice = 0;
        for(int i = 0; i < livros.length; i++){
            if (livros[i] != null && livros[i].getPreco() <= precoMax){
                for (int j = 0; j < arrayTemp.length; j++){
                    if (arrayTemp[j] == null){
                        arrayTemp[j] = livros[i];
                        System.out.println("Livro selecionado por preco: " + arrayTemp[j].getTitulo());
                        indice = j;
                        break;
                    }
                }
            }
        }
        return arrayTemp;
    }
    
    public void imprimeCatalogo(){
        System.out.println("\t*** Todos livros disponíveis na biblioteca: ***");
        System.out.println("=================================================");
        for (int i = 0; i < livros.length; i++){
            if (livros[i] != null){
                System.out.println("" + livros[i].toString());
            }
        }
        System.out.println("=================================================");
    }
}