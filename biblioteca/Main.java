package biblioteca;

import java.util.List;
import java.util.Scanner;

import biblioteca.modelos.Autor;
import biblioteca.modelos.Editora;
import biblioteca.modelos.Genero;
import biblioteca.modelos.Livro;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        List<Livro> livrosLidos = FileManager.lerLivros();
        biblioteca.getLivros().addAll(livrosLidos);
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Pesquisar livro");
            System.out.println("4. Listar todos os livros");
            System.out.println("5. Listar todos os livros ordenados");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    //adicionar um livro
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o nome do autor:");
                    String nomeAutor = scanner.nextLine(); 
                    Autor autor = new Autor(nomeAutor);

                    System.out.println("Digite o nome do gênero:");
                    String nomeGenero = scanner.nextLine();
                    Genero genero = new Genero(nomeGenero);

                    System.out.println("Digite o nome da editora:");
                    String nomeEditora = scanner.nextLine();
                    Editora editora = new Editora(nomeEditora);
                    Livro novoLivro = new Livro(titulo, autor, genero, editora);
                    
                    biblioteca.adicionarLivro(novoLivro);
                    FileManager.salvarLivros(biblioteca.getLivros());
                    break;

                case 2:
                    // remove livro
                    System.out.println("Digite o título do livro que deseja remover:");
                    String tituloRemover = scanner.nextLine();
                    FileManager.removerLivro(tituloRemover);
                    break;

                case 3:
                    // pesquisa livro
                    System.out.println("Digite o título do livro que deseja pesquisar:");
                    String tituloPesquisa = scanner.nextLine();
                    Livro livroPesquisado = FileManager.encontrarLivroPorTitulo(tituloPesquisa);
                    if (livroPesquisado != null) {
                        System.out.println("Livro encontrado:");
                        System.out.println(livroPesquisado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                    
                case 4:
                    // lista
                    List<Livro> livros = FileManager.lerLivros(); 
                    for (Livro livro : livros) {
                        System.out.println(livro);
                    }
                    break;
                    
                case 5:
                    // lista por ordem
                    System.out.println("Escolha o critério de ordenação:");
                    System.out.println("1. Título do livro");
                    System.out.println("2. Nome do autor");
                    System.out.println("3. Nome da editora");
                    int criterioOrdenacao = scanner.nextInt();
                    List<Livro> livrosOrdenados = biblioteca.listarLivrosOrdenados(criterioOrdenacao);
                    for (Livro livro : livrosOrdenados) {
                        System.out.println(livro);
                    }
                    FileManager.lerLivros();
                    break;

                case 6:
                    // sai
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
        scanner.close();
    }
}
