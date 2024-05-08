package biblioteca.modelos;

//criação da classe
public class Livro {
    //declaração das variáveis
    private String titulo;
    private Autor autor;
    private Genero genero;
    private Editora editora;

    //construtor
    public Livro(String titulo,Autor autor, Genero genero, Editora editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
    }

    public Livro(String line) {
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editora getEditora() {
        return editora;
    }
    
    @Override
    public String toString() {
        return  titulo + autor.getNome() + genero.getNome() + editora.getNome();
    }
}
