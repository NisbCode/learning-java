package Estudando.javacore.W_nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

//Aq tô criando uma classe q extenda onde um dos métodos será sobreescrito p q ele procure por tds arquivos q terminem em bkp
class AcharTodosOsBkp extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

//             Pegue o nome      String dele  Q termine em .bkp
//                        |          |        |
        if (file.getFileName().toString().endsWith(".bkp")) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;  //termos 4 opções de retorn. Esta diz: Sempre q vc achar um arquivo pedido, continue
    }
}

public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
//        Método walkFileTree caminha pelos diretórios q vc mandar
        Files.walkFileTree(Paths.get("pasta"), new AcharTodosOsBkp());  //Aq ele tá pegando o método extendido da
                                                                             // classe Simple... a qual é pedida cm parâmetro
    }
}

//Agr tamos usando os próprios métodos da classe SimpleFileVisitor
//Lembrete: ctrl+botãodireito nom nome da classe e vc pode olhar os métodos
//O fazAlgumaCoisa pré serve p dizer numa prévia oq o comando vai fazer
//Classe para imprimir os diretórios
class PrintDirs extends SimpleFileVisitor<Path> {
    public FileVisitResult preVisittDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("pre: " + dir);       // Mostrando ds diretórios
        if (dir.getFileName().toString().equals("subpasta")) { //Quando ele chegar nesse subpasta:
            return FileVisitResult.TERMINATE;       //Ele para
//            return FileVisitResult.SKIP_SUBTREE;  //Ele vai ignorar essa pasta das pesquisas
//            return FileVisitResult.SKIP_SIBLINGS; //Não olhe para nenhuma pasta q esteja no msm nível
        }
        return FileVisitResult.CONTINUE;
    }

//    Aq ele tá pegando os nomes do q for mandando
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("file: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

//    Estes ultimos lançam uma exceção p caso algo dê errado eles já resolvam ali msm

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("post: " + dir);
        return FileVisitResult.CONTINUE;
    }
}