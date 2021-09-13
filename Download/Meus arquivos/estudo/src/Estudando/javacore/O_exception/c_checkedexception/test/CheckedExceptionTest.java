package Estudando.javacore.O_exception.c_checkedexception.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {

        try {
            criarArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void criarArquivo() throws IOException {
        File file = new File("Teste.txt");
        try {
            System.out.println("Arquivo criado? " + file.createNewFile());
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void abrirArquivo() {
        try {
            System.out.println("Abrindo arquivo? ");
            System.out.println("Abrindo o arquivo");
            System.out.println("Lendo o arquivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando o arquivo");
        }

    }
}

