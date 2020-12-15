package Estudando.javacore.W_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

//                        Primeiro q o IntelliJ n tem suporte p isso ENTÃO NÃO EXECUTA
public class PosixFileAttributesTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/Naty/dev/arquivo");
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());
        System.out.println("Alterando as permissões");
//                                                         Eu posso ler e escrever------  O gp tb
//                                                                                      |   |  |----------------Outros tb
//        rw ===> Leitura e escrita; r===> Leitura; w===> Escrita
        Set<PosixFilePermission> permissions = PosixFilePermissions .fromString("rw-rw-rw-");
        Files.setPosixFilePermissions(path, permissions);
        posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());
    }
}