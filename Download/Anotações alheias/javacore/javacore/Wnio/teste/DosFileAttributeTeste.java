package br.com.abc.javacore.Wnio.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/***
 * INTERFACE DOSFILEATTRIBUTE
 */

public class DosFileAttributeTeste {
    public static void main(String[] args) {
        Path path = Paths.get("Folder\\testeDos.txt");
        try {

//            Files.createFile(path);
             // Setando os atributos: se é oculto ou se dá apenas pra ler
             // É possível criar com essa forma, mas usando o dosView fica mais fácil/limpo
            Files.setAttribute(path, "dos:hidden", true);
            Files.setAttribute(path, "dos:readonly", true);
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
            dos.isHidden();
            dos.isReadOnly();
            System.out.println("É legível?: " + dos.isHidden());
            System.out.println("É apenas para leitura?: " + dos.isReadOnly());


            DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);

            dosView.setHidden(true);
            dosView.setReadOnly(true);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
