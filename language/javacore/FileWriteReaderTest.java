package Estudando.javacore.V_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteReaderTest {
    public static void main(String[] args) {

        //Está é a forma mais eficaz de criar:

        File file = new File("Arquivo.txt");
        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)) {   //Sobreescreve a menos q vc ponha "file, append" Aí ele só completa no fim
            fw.write("Escrevendo uma mensagem no arquivo \nE pulando uma linha 3"); // Se vc alterar aq, vc sobreescreve
            fw.flush();       //Faz vc ter ctz q td q vc mandou de fato chegou no local, vc usa sempre c a escrita
            //fw.close();   //Filha de clase cloaseable n é necessário usar esse método, vc usa c leitura e escrita
            char[] in = new char[500];
            int size = fr.read(in);      //Mostra o número de caracteres
            System.out.println("tamanho " + size);
            for (char c : in) {      //Aq ele leu oq colocamos
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//        try(FileWriter fw = new FileWriter(file);
//            FileReader fr = new FileReader(file)) {
//            fw.write("Escrevendo uma mensagem no arquivo \nE pulando uma linha 3");
//            fw.flush();
//            fw.close();   //Filha de clase cloaseable n é necessário usar esse método, vc usa c leitura e escrita
//
//        try(FileReader fw = new FileReader(file);
//            char[] in = new char[500];
//            int size = fr.read(in);
//            System.out.println("tamanho " + size);
//            for (char c : in) {
//                System.out.print(c);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//}