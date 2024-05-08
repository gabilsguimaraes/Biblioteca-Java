package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import biblioteca.modelos.Livro;

public class FileManager {
    public static void salvarLivros(List<Livro> livros, String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoArquivo))) {
            for (Livro livro : livros) {
                writer.println(livro.toString());
            }
            System.out.println("Dados salvos com sucesso em " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}
