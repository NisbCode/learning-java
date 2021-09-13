package br.com.abc.javacore.Vio.teste;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/***
 * ARQUIVOS COM A CLASSE IO
 */

public class FileTest {
    public static void main(String[] args) {
        File file = new File("Aruivo.txt");
        // try-catch porque o método create new file
        // exige tratamento de exceção
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);

            /***
             * MÉTODOS INTERESSANTES:
             */
            // Checa se o arquivo existe
            boolean existe = (file.exists());
            // Checa se tem permissão de leitura
            System.out.println("Permissão de leitura?: " + file.canRead());
            // Pega o caminho do arquivo
            System.out.println("Caminho?: " + file.getPath());
            // Pega o caminho inteiro do caminho
            System.out.println("Caminho?: " + file.getAbsolutePath());
            // Para saber se um diretório
            System.out.println("É um diretório?: " + file.isDirectory());
            // Para saber se é um arquivo oculto
            System.out.println("É um arquivo oculto?: " + file.isHidden());
            // Para saber a ultima vez que esse arquivo foi modificado,
            // repare no objeto date criado, só o método lasModified traz m número long
            System.out.println("É um arquivo oculto?: " + new Date(file.lastModified()));
            // Se o arquivo existir...
            if (existe){
                // ...deletar
                System.out.println("Deletado?: " + file.delete());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
