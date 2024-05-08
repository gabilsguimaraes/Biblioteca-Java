package biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import biblioteca.modelos.Autor;
import biblioteca.modelos.Genero;
import biblioteca.modelos.Livro;
import biblioteca.modelos.Editora;
public class FileManager {
    public static void salvarLivros(List<Livro> livros, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Livro livro : livros) {
                writer.write(livro.toString() + "\n"); // add newline character
            }
            System.out.println("Dados salvos com sucesso em " + caminhoArquivo);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
    public static void carregarLivros(Biblioteca biblioteca, String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line;
            while ((line = reader.readLine())!= null) {
                // Parse the line and create a Livro object
                String[] parts = line.split(",");
                Livro livro = new Livro(parts[0], new Autor(parts[1]), new Genero(parts[2]), new Editora(parts[3]));
                biblioteca.adicionarLivro(livro);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }


    public static List<Livro> lerLivros(String caminhoArquivo) {
        List<Livro> livros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line;
            while ((line = reader.readLine())!= null) {
                // assume Livro has a constructor that takes a string
                livros.add(new Livro(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
        return livros;
    }
}
