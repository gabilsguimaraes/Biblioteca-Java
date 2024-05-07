package biblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import biblioteca.modelos.Livro;

public class FileManager {
    public static void salvarLivros(List<Livro> livros, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Livro livro : livros) {
                writer.write(livro.toString());
                writer.newLine(); 
            }
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}