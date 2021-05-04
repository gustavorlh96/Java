public class TestaBiblioteca
{
    public static void main(String[] args){
        Biblioteca b1 = new Biblioteca();
        
        b1.adicionaLivro(new Livro("Harry Potter e a Pedra Filosofal - Ed. Ilustrada", "J. K. Rowling", 1997, 129.90));
        b1.adicionaLivro(new Livro("Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling", 1999, 32.90));
        b1.adicionaLivro(new Livro("O Senhor dos Aneis - Ed. Ilustrada", "J. R. R. Tolkien", 1954));
        b1.livros[2].setPreco(89.90);
        //b1.adicionaLivro(new Livro("tit1", "aut1", 1999, 29.90));
        //b1.adicionaLivro(new Livro("tit2", "aut2", 1996, 19.90));
        //b1.adicionaLivro(new Livro("tit3", "aut3", 1992, 39.90));
        
        b1.imprimeCatalogo();
        b1.buscaLivroTitulo("Potter");
        b1.buscaLivroTitulo("Ilustrada");
        b1.buscaLivroAtePreco(89.90);
    }
}