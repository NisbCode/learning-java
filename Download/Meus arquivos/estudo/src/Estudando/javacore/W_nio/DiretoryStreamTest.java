package Estudando.javacore.W_nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiretoryStreamTest {     //É uma das classes mais simples p pegar arquivos ou diretórios mas é limitada
                                      // AINDA S É BEM IMPORTANTE
    public static void main(String[] args) {
        Path dir = Paths.get("pasta");

//        N podemos usar o new aq, então tamos usando dnv o Files p criar
//        Essa stream vai funcionar cm um array
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { //Tô falando q eu quero q faça uma string q é um jogo de bytespassando por um determinado canal p essa classe Path
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
