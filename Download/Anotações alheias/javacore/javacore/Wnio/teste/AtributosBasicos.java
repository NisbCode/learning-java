package br.com.abc.javacore.Wnio.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/***
 * ATRIBUTOS BÁSICOS:
 * Atributos comuns a qualquer sustema operacional,
 * vindos das interfaces BasicFileAttributes,
 * PosixFileAttributes, DosFilesAttributes
 */

public class AtributosBasicos {
    public static void main(String[] args) throws IOException {
        Date primeiroDezembro = new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime();
        File arquivoChangeDate = new File("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\Folder2", "arquivoChangeDate.txt");
        // LEMBRETE: Criando ainda com classe IO
        arquivoChangeDate.createNewFile();

        arquivoChangeDate.setLastModified(primeiroDezembro.getTime());
        System.out.println(arquivoChangeDate.lastModified());
        arquivoChangeDate.delete();

        // LEMBRETE: Agora criando com NIO
        Path pathChangeDate = Paths.get("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\Folder2", "arquivoChangeDate_path.txt");
        Files.createFile(pathChangeDate);

        // Criando um atributo de data associada a um arquivo
        FileTime dataArquivo = FileTime.fromMillis(primeiroDezembro.getTime());
        Files.setLastModifiedTime(pathChangeDate, dataArquivo);
        System.out.println(Files.getLastModifiedTime(pathChangeDate));
        Files.deleteIfExists(pathChangeDate);

        pathChangeDate = Paths.get("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\src\\br\\com\\abc\\javacore\\Aintroducaoclasses\\classe\\CarroOptional.java");
        System.out.println("Dá pra ler?: " + Files.isReadable(pathChangeDate));
        System.out.println("Dá pra escrever em cima?: " + Files.isReadable(pathChangeDate));
        System.out.println("Executável?: " + Files.isReadable(pathChangeDate));

        // Introdução aos atributos básicos
        BasicFileAttributes atributosBasicos = Files.readAttributes(pathChangeDate, BasicFileAttributes.class);
        System.out.println("Data de criação: " + atributosBasicos.creationTime());
        System.out.println("Último acesso: " + atributosBasicos.lastAccessTime());
        System.out.println("Última modificação: " + atributosBasicos.lastModifiedTime());
        System.out.println("--------------------------------------------------------------");

        /***
         * Cada interface tem suas classes de mudança de atributo:
         * BasicFileAttributes = BasicFileAttributesView,
         * PosixFileAttributes = PosixFileAttributesView,
         * DosFileAttributes = DosFileAttributesNew
         * E ainda mais duas:
         * FileOwnerAttributeView e AclFileAttributeNew
         */

        BasicFileAttributeView basicView = Files.getFileAttributeView(pathChangeDate, BasicFileAttributeView.class);
        FileTime lastModified = atributosBasicos.lastModifiedTime();
        FileTime created = atributosBasicos.creationTime();
        FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());

        basicView.setTimes(lastModified, lastAccess, created);

        atributosBasicos = Files.readAttributes(pathChangeDate, BasicFileAttributes.class);
        System.out.println("Data de criação: " + atributosBasicos.creationTime());
        System.out.println("Último acesso: " + atributosBasicos.lastAccessTime());
        System.out.println("Última modificação: " + atributosBasicos.lastModifiedTime());
    }
}
