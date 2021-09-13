package br.com.abc.javacore.Vio.teste;

import java.io.*;

/***
 * BUFFERED WRITER E BUFFERED READER
 * Uma forma mais dinâmica e rápida de trabalhar com arquivos
 */

public class BufferedTeste {
    public static void main(String[] args) {
        File file = new File("Arquivo3.txt");

        // Agora feito no modo try-with-resources
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            // Escrita
            bufferedWriter.write("Escrevendo uma mensagem no arquivo");
            bufferedWriter.newLine(); // Método para pular linha baseado no sistema operacional usado
            bufferedWriter.write("E pulando linha");
            bufferedWriter.flush();

            // Leitura
            String stringTeste = null;
            while((stringTeste = bufferedReader.readLine()) != null){
                System.out.println(stringTeste);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sem o try-with-resources
//        try {
//            /***
//             * PARA ESCREVER O ARQUIVO
//             */
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//            bufferedWriter.write("Escrevendo uma mensagem no arquivo");
//            bufferedWriter.newLine(); // Método para pular linha baseado no sistema operacional usado
//            bufferedWriter.write("E pulando linha");
//            bufferedWriter.flush();
//            bufferedWriter.close();
//
//            /***
//             * PARA LER O ARQUIVO
//             */
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            // Ao invés de ler caracter por caracter, o bufferedReader
//            // vai ler linha por linha e transofrmar em String
////            bufferedReader.readLine();
//
//            // Ou caso o texto seja muito grande, é possível colocar
//            // um while para percorrer ele
//            String stringTeste = null;
//            while((stringTeste = bufferedReader.readLine()) != null){
//                System.out.println(stringTeste);
//            }
//            bufferedReader.close();
//
//            // LEMBRETE: É melhor fechar o arquivo através
//            // do TryWithResources, mas mantive assim pra ficar
//            // melhor a visualização para estudo
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
