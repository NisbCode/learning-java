package br.com.abc.javacore.Wnio.teste;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

class AcharTodosOsBkp extends SimpleFileVisitor<Path>{
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        // Se o arquivo terminar com ".bkp"...
        if (file.getFileName().toString().endsWith(".bkp")){
            // ... Imprima o nome dele
            System.out.println(file.getFileName());
        }
        // Após isso, continue rodando a pasta até
        // terminar, se não encontrar nada, volte
        // uma pasta
        return FileVisitResult.CONTINUE;
    }

}


public class FileVisitorTeste {
    public static void main(String[] args) throws IOException {
        // Aqui deve ser dado nos parametros um caminho de start e um filho da classe
        // SimpleFileVisitor
        Files.walkFileTree(Paths.get("pasta"), new PrintDirs());

        // Para fazer o mesmo com a classe AcharTodosOsBkp
//        Files.walkFileTree(Paths.get("pasta"), new AcharTodosOsBkp());
    }
}

class PrintDirs extends SimpleFileVisitor<Path>{
    // Para uma pré visita do arquivo
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
        System.out.println("pré visita: " + dir);
        return FileVisitResult.CONTINUE;
    }
    // Visitar a pasta
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
        /***
         * Outros métodos como o FileVisitResult.CONTINUE:
         * FileVisitResult.TERMINATE: para a execução quando chega
         * na pasta determinada pelo desenvolvedor através de um
         * if(dir.getFileName().toString.equals(+nomezin da pasta aq+))
         * FileVisitResult.SKIP_SUBTREE: vai eliminar da busca todos que
         * estiverem abaixo das pastas determinada no if
         * FileVisitResult.SKIP_SUBTREE: vai eliminar da busca todos que
         * estiverem no mesmo nivel das pastas determinada no if
         */

        //
    }
    // Caso a visita falhe
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException
    {
        return FileVisitResult.CONTINUE;
    }
    // E, no fim, uma pós visita
    public FileVisitResult postVisitDirectory(Path dir, IOException exc){
        System.out.println("pós-visita: " + dir);
        return FileVisitResult.CONTINUE;
    }


}





