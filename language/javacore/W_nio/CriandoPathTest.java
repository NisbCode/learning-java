package Estudando.javacore.W_nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {
    public static void main(String[] args) {
//      Forma de pegar os arquivos no package NIO:

        Path p1 = Paths.get("C:\\Users\\natyb\\IdeaProjects\\JavaOnline.estudo\\Arquivo.txt");
        Path p2 = Paths.get("C:\\Users\\natyb\\IdeaProjects\\JavaOnline.estudo", "Arquivo.txt");
        Path p3 = Paths.get("C:", "Users\\natyb\\IdeaProjects\\JavaOnline.estudo\\Arquivo.txt");
        Path p4 = Paths.get("C:", "Users", "natyb", "IdeaProjects", "JavaOnline/estudo", "Arquivo.txt");
        System.out.println(p4.toAbsolutePath());    //Assim que imprime
//        Path foi feito p substituir a classe File, então tem cm converter de um p o outro:
        File file = p4.toFile();
        Path path = file.toPath();

//        Pegar o caminho relativo n pode usar "\\" antes
        Path path1 = Paths.get("pasta");                             //Nome da pasta criada*1
        Path path2 = Paths.get("pasta\\subpasta\\subsubpasta\\");    //Caso vc queira criar esses diretórios de pastas dentro de pastas*2
        Path arquivo = Paths.get("pasta\\subpasta\\subsubpasta\\file.txt"); //P criar um arquivo dentro de um diretório*3
        try {
//            if(Files.notExists(path1))               //Aq ele diz p criar apenas SE a pasta n existir p n ter uma exceção
//            Files.createDirectory(path1);         //Cm criar essa pasta*1 //getParent serve p pegar apenas os diretórios(IGNORAR O ULTIMO Q VEM DPS DE \\), previnindo q sem querer ele crie uma pasta c nome file.txt
            if (Files.notExists(path2))
                Files.createDirectories(path2); //N esqueça de mudar p "createDirectories"*2
            if (Files.notExists(arquivo))
                Files.createFile(arquivo);  //Criando o arquivo*3
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path source = Paths.get("folder2\\arquivo.txt");  //Copiei um arquivo deste diretório
        Path target = Paths.get(path2.toString() + "\\arquivoCopiado.txt");  //Colei o arquivo mudando o nome
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING); //Copia sem mudar o nome
            Files.deleteIfExists(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}