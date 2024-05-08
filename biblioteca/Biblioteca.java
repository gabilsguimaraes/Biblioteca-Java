package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import biblioteca.modelos.Livro;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Livro> listarLivrosOrdenados(int criterio) {
        List<Livro> livros = FileManager.lerLivros(); // pega os livros do arquivo de texto
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        switch (criterio) {
            case 1:
                // ordena por título do livro
                livrosOrdenados.sort(Comparator.comparing(Livro::getTitulo));
                break;
            case 2:
                // ordena por nome do autor
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getAutor().getNome()));
                break;
            case 3:
                // ordena por nome da editora
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getEditora().getNome()));
                break;
            default:
                System.out.println("Critério de ordenação inválido.");
                return null;
        }
        return livrosOrdenados;
    }
}
