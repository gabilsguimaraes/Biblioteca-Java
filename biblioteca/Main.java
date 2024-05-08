package biblioteca;

import java.util.Scanner;

import biblioteca.modelos.Autor;
import biblioteca.modelos.Editora;
import biblioteca.modelos.Genero;
import biblioteca.modelos.Livro;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
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

                    FileManager.salvarLivros(biblioteca.getLivros(), "C:/Users/Gabi/Documents/UP/3 periodo/JAVA/biblioteca/livros.txt");
                    break;
                case 2:
                    //remover um livro
                    System.out.println("Digite o título do livro a ser removido:");
                    String tituloRemover = scanner.nextLine();
                    Livro livroRemover = biblioteca.pesquisarLivro(tituloRemover);
                    if (livroRemover != null) {
                        biblioteca.removerLivro(livroRemover);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }

                    FileManager.salvarLivros(biblioteca.getLivros(), "C:/Users/Gabi/Documents/UP/3 periodo/JAVA/biblioteca/livros.txt");
                    break;
                case 3:
                    //pesquisar um livro
                    System.out.println("Digite o título do livro a ser pesquisado:");
                    String tituloPesquisar = scanner.nextLine();
                    Livro livroPesquisado = biblioteca.pesquisarLivro(tituloPesquisar);
                    if (livroPesquisado != null) {
                        System.out.println("Livro encontrado:");
                        System.out.println(livroPesquisado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4:
                    //listar todos os livros
                    biblioteca.listarLivros();
                    break;
                case 5:
                    // Lógica para listar todos os livros ordenados
                    System.out.println("Escolha o critério de ordenação:");
                    System.out.println("1. Título do livro");
                    System.out.println("2. Nome do autor");
                    System.out.println("3. Nome da editora");
                    int criterioOrdenacao = scanner.nextInt();
                    biblioteca.listarLivrosOrdenados(criterioOrdenacao);
                    break;
                case 6:
                    // Sair do programa
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        // Salvar os dados da biblioteca em arquivos.txt
        FileManager.salvarLivros(biblioteca.getLivros(), "C:/Users/Gabi/Documents/UP/3 periodo/JAVA/biblioteca/livros.txt");

        // Fechar o scanner
        scanner.close();
    }
}
