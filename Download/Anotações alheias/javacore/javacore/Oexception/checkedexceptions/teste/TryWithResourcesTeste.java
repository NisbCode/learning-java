package br.com.abc.javacore.Oexception.checkedexceptions.teste;

import br.com.abc.javacore.Oexception.checkedexceptions.classes.Leitor1;
import br.com.abc.javacore.Oexception.checkedexceptions.classes.Leitor2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResourcesTeste {
    public static void main(String[] args) {
        lerArquivo();
    }

    //Até o java 6 era algo assim, bem escrotinho:
//    public static void lerArquivo(){
//        Reader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("Text.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (reader != null){
//                    reader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    //No java 7 voce pode deixar o prorpior java se
    // encarregar de fechar a conexão
    public static void lerArquivo() {

        //No java 7, as variaveis são criadas entre parenteses
        //depois do try, desde que implementem a interface
        // Closeable do java, pode ter varias
        //Sempre executa de baixo para cima
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2();) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
