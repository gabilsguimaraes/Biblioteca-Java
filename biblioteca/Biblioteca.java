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
        List<Livro> livros = FileManager.lerLivros();
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        switch (criterio) {
            case 1:
                livrosOrdenados.sort(Comparator.comparing(Livro::getTitulo));
                break;
            case 2:
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getAutor().getNome()));
                break;
            case 3:
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getEditora().getNome()));
                break;
            default:
                System.out.println("Critério de ordenação inválido.");
                return null;
        }
        return livrosOrdenados;
    }
}
