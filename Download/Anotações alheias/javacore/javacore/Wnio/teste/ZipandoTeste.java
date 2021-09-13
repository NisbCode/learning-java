package br.com.abc.javacore.Wnio.teste;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTeste {
    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta/subpasta");
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
        Path zipFile = dirZip.resolve("arquivo.zip");

        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
             // Vai ser necessário percorrer a pasta, então:
             DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {
            for (Path path : stream) {
                // deve-se colocar uma entrada nos arquivos Zip
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                // adicionar o zipEntry dentro do zip
                zip.putNextEntry(zipEntry);
                // fazer a leitura do arquivo
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                // Para escrever
                BufferedInputStream bf = new BufferedInputStream(fileInputStream);
                byte[] buff = new byte[2048];
                int bytesRead;
                while ((bytesRead = bf.read(buff)) > 0){
                    zip.write(buff,0,bytesRead);
                }
                zip.closeEntry();
                fileInputStream.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
