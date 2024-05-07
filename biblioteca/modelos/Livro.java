package biblioteca.modelos;

import java.util.ArrayList;
import java.util.List;

//criação da classe
public class Livro {
    //declaração das variáveis
    private String titulo;
    private ArrayList<Autor> autores;
    private Genero genero;
    private Editora editora;

    //construtor
    public Livro(String titulo, Genero genero, Editora editora) {
        this.titulo = titulo;
        this.autores = new ArrayList<>();
        this.genero = genero;
        this.editora = editora;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void removerAutor(Autor autor) {
        autores.remove(autor);
    }

    public void listarAutores() {
        for (Autor autor : autores) {
            System.out.println(autor.getNome());
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        if (!autores.isEmpty()) {
            return autores.get(0);
        } else {
            return null;
        }
    }
    public List<Autor> getAutores() {
        return autores;
    }

    public Editora getEditora() {
        return editora;
    }
    
    @Override
    public String toString() {
        return "Livro: " + titulo + ", Gênero: " + genero.getNome() + ", Editora: " + editora.getNome();
    }
}
