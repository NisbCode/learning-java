package br.com.abc.javacore.Wnio.teste;

/***
 * CLASSE NIO:
 * Agora tanmbém com a interface Path e
 * as classes Paths e Files
 * Principais metodos da classe contidos aqui
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CriandoPathTeste {
    public static void main(String[] args) {
        // O argumento desse get pode vir de 3 formas:
        Path p1 = Paths.get("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\Arquivo2.txt");
        Path p2 = Paths.get("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline","Arquivo2.txt");
        Path p3 = Paths.get("C:","Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\Arquivo2.txt");
        Path p4 = Paths.get("C:","Users, Amanda Porto, IdeaProjects, JavaOnline, Arquivo2.txt");
        // Método para exibit o path
        System.out.println(p4.toAbsolutePath());

        // A classe path foi feita para substituir a
        // classe file, aqui um modo de converter um
        // para o outro
        File file = p4.toFile();
        Path path = file.toPath();

        // Para criar diretórios aqui
        Path pathDiretorio = Paths.get("pasta");
        Path pathDiretorio2 = Paths.get("pasta2\\subpasta\\subsubpasta");
        Path arquivo = Paths.get("pasta2\\subpasta\\subsubpasta\\file.txt");

        try {
            if(Files.notExists(pathDiretorio2)){
                // Apenas um diretorio
//                Files.createDirectory(pathDiretorio);
                // Firetorio com subpasta
                Files.createDirectories(pathDiretorio2);
            }
            if(Files.notExists(arquivo)){
                Files.createFile(arquivo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } // Pasta criada, se isso for executado novamente,
        // diferente do Files que retorna falso, vai retornar
        // um erro em tempo de execução dizendo que ja existe

        // PAra copiar arquivo
        Path source = Paths.get("Folder2\\arquivo.txt");
        Path target = Paths.get("Folder2\\arquivoCopiado.txt");
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Para copiar arquivo para outro diretorio
        Path sourceDiretoriosDiferentes = Paths.get("Folder2\\arquivo.txt");
        Path targetDiretoriosDiferentes = Paths.get("Folder","arquivoCopiadoDoFolder2.txt");
        try {
                                                                        // É possível adicionar opções
                                                                        // como, por exemplo, substituir o arquivo
                Files.copy(sourceDiretoriosDiferentes, targetDiretoriosDiferentes, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
