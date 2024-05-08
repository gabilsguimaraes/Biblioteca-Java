package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.modelos.Autor;
import biblioteca.modelos.Editora;
import biblioteca.modelos.Genero;
import biblioteca.modelos.Livro;

public class FileManager {
    private static final String CAMINHO_ARQUIVO = "C:/Users/Gabi/Documents/UP/3 periodo/JAVA/biblioteca/livros.txt";

    public static void salvarLivros(List<Livro> livros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Livro livro : livros) {
                writer.write(livro.toString());
                writer.newLine();
            }
            System.out.println("Livros salvos com sucesso!");
        } catch (IOException e) {
            handleIOException("Erro ao salvar livros.", e);
        }
    }

    public static List<Livro> lerLivros() {
        List<Livro> livros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Livro livro = extrairLivro(linha);
                if (livro != null) {
                    livros.add(livro);
                }
            }
        } catch (IOException e) {
            handleIOException("Erro ao ler os livros do arquivo.", e);
        }
        return livros;
    }

    public static Livro encontrarLivroPorTitulo(String titulo) {
        //testar enquanto houver uma linha
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Livro livro = extrairLivro(linha);
                if (livro != null && livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        } catch (IOException e) {
            handleIOException("Erro ao encontrar o livro.", e);
        }
        return null;
    }

    public static void removerLivro(String tituloRemover) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Livro livro = extrairLivro(linha);
                if (livro != null && !livro.getTitulo().equalsIgnoreCase(tituloRemover)) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            handleIOException("Erro ao encontrar o livro.", e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Livro removido com sucesso.");
        } catch (IOException e) {
            handleIOException("Erro ao escrever no arquivo.", e);
        }
    }

    private static Livro extrairLivro(String linha) {
        //separa o livro em 4 partes: titulo, autor, genero e editora, ao invés de salvar tudo em 1 string
        String[] partes = linha.split(",");
        if (partes.length >= 4) {
            String titulo = partes[0].substring(partes[0].indexOf(":") + 2).trim();
            Autor autor = new Autor(partes[1].substring(partes[1].indexOf(":") + 2).trim());
            Genero genero = new Genero(partes[2].substring(partes[2].indexOf(":") + 2).trim());
            Editora editora = new Editora(partes[3].substring(partes[3].indexOf(":") + 2).trim());
            return new Livro(titulo, autor, genero, editora);
        }
        return null;
    }

    private static void handleIOException(String message, IOException e) {
        System.out.println(message);
        e.printStackTrace();
    }
}
