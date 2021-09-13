package br.com.abc.javacore.Wnio.teste;

/***
 * CLASSE PosixFileAttribute
 * Comandos básicos da classe NIO para linux
 * Deve ser testada com uma máquina virtual de linux
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTeste {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/Amanda/dev/arquivoPosix");
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        // Esse método retorna as permissões da pasta
        System.out.println(posix.permissions());
        System.out.println("Alterando permissões");
        PosixFileAttributeView viewPermissoes = Files.getFileAttributeView(path, PosixFileAttributeView.class);
                                                            // Aqui diz-se que o dono do arquivo,
                                                            // os grupos e outros, em ordem, tem permissão de
                                                            // leitura e escrita
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw");
        Files.setPosixFilePermissions(path, permissions);
        // Lendo novamente o atributo posix e o imprimindo, com as atualizações
        posix = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println(posix.permissions());
    }
}
