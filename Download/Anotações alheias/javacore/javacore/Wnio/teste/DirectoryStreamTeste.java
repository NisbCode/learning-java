package br.com.abc.javacore.Wnio.teste;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/***
 * CLASSE DirectoryStram
 */

public class DirectoryStreamTeste {
    public static void main(String[] args) {
        Path dir = Paths.get("pasta");
        // Saporra aqui vai ser ensinada depois, calme
        // É pra mostrar os arquivos da pasta listados
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path itemPath : stream){
                System.out.println(itemPath.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
