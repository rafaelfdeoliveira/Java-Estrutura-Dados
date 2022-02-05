package br.com.letscode.inputoutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PrincipalIO {
    public static void main(String[] args) {
        File meuObjeto = new File("meuarquivo.txt");


    }

    public static void lerArquivoComScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("meuarquivo.txt"));

        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void copiarArquivoNIO() {
//        Paths.get("user", "document", "download", "meuarquivo.txt");
        Path path = Paths.get("meuarquivo.txt");
        // o s no final das classes indica que é uma classe utilitário. Path no singular é uma interface
        for (int i = 0; i < 3; i++) {
            try {
                byte[] arrayDeBytes = Files.readAllBytes(path);
                Path pathTo = Paths.get("meuarquivo" + i + ".txt");
                Files.write(pathTo, arrayDeBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copiarArquivoIO() {
        for (int i = 0; i < 4; i++) {
            File meuarquivo = new File("meuarquivo.txt");
            byte[] arrayDeByte = new byte[(int) meuarquivo.length()];

//            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;

            // Try catch with resources permite abrir o arquivo e fechar automaticamente depois
            try (FileInputStream fileInputStream = new FileInputStream(meuarquivo)) {

//                new BufferedInputStream();

                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader =  new BufferedReader(inputStreamReader); // recebe um InputStreamReader que recebe um FileInputStream

                String line = bufferedReader.readLine();
                System.out.println(line);

                fileInputStream.read(arrayDeByte);

                File arquivoParaDuplicar = new File("meuarquivo"+i+".txt");
                fileOutputStream = new FileOutputStream(arquivoParaDuplicar);
                fileOutputStream.write(arrayDeByte);
                fileOutputStream.close();

            } catch (IOException e) {
                System.out.println("Problema com a escrita");
                e.printStackTrace();
            }
        }
    }

    public static void criarArquivo(File meuObjeto) {
        try {
            boolean isArquivoCriado = meuObjeto.createNewFile();
            if (isArquivoCriado) {
                System.out.println("O arquivo foi criado com sucesso");
            } else {
                System.out.println("Não foi possível criar o arquivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
