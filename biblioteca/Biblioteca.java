package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import biblioteca.modelos.Autor;
import biblioteca.modelos.Livro;

public class Biblioteca {
    private List<Livro> livros;
    private List<Autor> autores;


    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        Autor autorLivro = livro.getAutor();
        if (autorLivro != null && !autores.contains(autorLivro)) {
            autores.add(autorLivro);
        }
        System.out.println("Livro adicionado com sucesso!");
    }

    public void removerLivro(Livro livro) {
        if (livros.contains(livro)) {
            livros.remove(livro);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    public Livro pesquisarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado na biblioteca.");
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
        } else {
            System.out.println("Livros na biblioteca:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }


    public void listarLivrosOrdenados(int criterio) {
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        switch (criterio) {
            case 1:
                // Ordenar por título do livro
                livrosOrdenados.sort(Comparator.comparing(Livro::getTitulo));
                break;
            case 2:
                // Ordenar por nome do autor
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getAutores().get(0).getNome()));
                break;
            case 3:
                // Ordenar por nome da editora
                livrosOrdenados.sort(Comparator.comparing(livro -> livro.getEditora().getNome()));
                break;
            default:
                System.out.println("Critério de ordenação inválido.");
                return;
        }
        for (Livro livro : livrosOrdenados) {
            System.out.println(livro);
        }
    }
    
}