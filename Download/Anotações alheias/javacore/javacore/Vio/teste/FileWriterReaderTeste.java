package br.com.abc.javacore.Vio.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/***
 * CLASSES FileWriter E FileReader:
 * Para a escrita e leitura de arquivo
 */

public class FileWriterReaderTeste {
    public static void main(String[] args) {
        File file = new File("Arquivo2.txt");
        try {
            /***
             * PARA ESCREVER O ARQUIVO
             */
            // Caso você já tenha escrito algo e não quer sobrescrever,
            // mas sim adicionar de novo ao final, mude o append para
            // true depois do file
            FileWriter fileWriter = new FileWriter(file);

            // Não é necessário aqui o método de criar arquivo,
            // só pelo objeto o arquivo ja é criado

            // Para escrever no arquivo
            fileWriter.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha 2");
            // Esse método funciona como uma stream e alguns dados podem não chegar,
            // para que o Java "cuspa" todos os bytes, use o método a seguir
            fileWriter.flush();
            // Sempre fechar o arquivo depois de ler ou escrever
            fileWriter.close();

            /***
             * PARA LER O ARQUIVO
             */
            FileReader fileReader = new FileReader(file);
            char[] entrada = new char[500];
            // O parâmetro daqui é um array
            int tamanho = fileReader.read(entrada);
            System.out.println("Tamanho: " + tamanho);
            for (char caracter: entrada){
                System.out.print(caracter);
            }
            fileReader.close();

            // LEMBRETE: É melhor fechar o arquivo através
            // do TryWithResources, mas mantive assim pra ficar
            // melhor a visualização para estudo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
