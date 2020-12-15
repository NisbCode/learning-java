package Estudando.javacore.O_exception.c_checkedexception.test;

import Estudando.javacore.O_exception.c_checkedexception.classes.Leitor1;
import Estudando.javacore.O_exception.c_checkedexception.classes.Leitor2;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) {
        lerArquivo();
    }
    //    Ele vai fechar de baixo para cima
    public static void lerArquivo() {
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    Assim que se fechava um arquivo no Java 6 ///5.74 600
    public static void lerArquivoOldJava6() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}