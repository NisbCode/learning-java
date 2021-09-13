package Estudando.javacore.W_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder2\\teste.txt");
        try {
            if (Files.notExists(path))
                Files.createFile(path); //Aq ele criou o arquivo pedido na variável path
            Files.setAttribute(path, "dos:hidden", true);  //1- vc seta
            Files.setAttribute(path, "dos:readonly", true);

//            Vc cria o Files pq a classe DosFile pede porém ela n é feita p mudar
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class); //2- lê a resposta
            System.out.println(dos.isHidden()); //3- Diz a resposta
            System.out.println(dos.isReadOnly());

//          Setando agr p falso da forma de DosFileAttributesView q serve p alterar deixando mais fácil e sendo a recomendada
            DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
            dosView.setHidden(false);
            dosView.setReadOnly(false);
            dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}