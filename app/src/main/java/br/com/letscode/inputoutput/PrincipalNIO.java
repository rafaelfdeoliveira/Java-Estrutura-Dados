package br.com.letscode.inputoutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class PrincipalNIO {

    public static void main(String[] args) {
        lerConteudo();
    }

    public static void lerConteudo() {
        // Essas duas linhas abaixo fazem a mesma coisa
        Path path = Paths.get("meuarquivo.txt");
//        Path path = Path.of("meuarquivo.txt");

        try {
//            String conteudo = Files.readString(path);
            // readALlLines joga todo o arquivo na memória e lê lá. Não recomendado para arquivos muito grades.
            List<String> linhas = Files.readAllLines(path);

            System.out.println(linhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escreverConteudo() {
        Path caminhoMeuArquivo = Paths.get("meuarquivo.txt");
        String conteudo = "Escrevendo no meu arquivo através da api new IO";

        try {
            Files.write(caminhoMeuArquivo, conteudo.getBytes());

            List<String> arrayDeStrings = Arrays.asList("Assunto:", "Segue em anexo...", "arr., Jorge");
            Files.write(caminhoMeuArquivo, arrayDeStrings);

            Stream<String> stream = Files.lines(caminhoMeuArquivo);
            stream.forEach(System.out::println);

            // writeString só tem com o Java 11
            Files.writeString(caminhoMeuArquivo, "Conteudo a ser escrito", APPEND);
            Files.writeString(caminhoMeuArquivo, "Conteudo a ser escrito", CREATE, APPEND);
            Files.writeString(caminhoMeuArquivo, "Conteudo a ser escrito", CREATE_NEW);

            Files.write(caminhoMeuArquivo, "conteudo".getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
