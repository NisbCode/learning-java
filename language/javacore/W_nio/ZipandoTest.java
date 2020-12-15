package Estudando.javacore.W_nio;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {
    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta/subpasta");           //vamos salvar ele aq
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");      //Ele tá aq
//        Cm eu quero q ele fique dentro do diretório de dirZip, o programa vai resolver cm de dirZip chegar em dirFiles
        Path zipFile = dirZip.resolve("arquivo.zip");        //O nome dele tá aq
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile())); //OutputStream q mexe c arquivos é File
//      Vc transforma um Path em file c o método .toFile, e vc precisa disso pq o construtor manda vc sobrecarregar c uma String ou File
//             Assim, ele criará nosso zip

//            Usamos um DirectoryStream p percorrer tds os arquivos e o Path é onde tá o diretório dos arquivos, ele vai percorrer lá
            DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) { //P n precisar fechar o Directory, eu coloquei c try-with-resouces
                for (Path path : stream) {
                    zip.putNextEntry(new ZipEntry(path.getFileName().toString()));  //Prepare a proxima entrada, ele pede o nome do arquivo
//                    Agt vai pegar o nome do próprio path e forçar ele a virar uma String já q path.getFileName retorna um Path
                    BufferedInputStream bf = new BufferedInputStream(new FileInputStream(path.toFile()));  //Lendo o arquivo
                    byte[] buff = new byte[2048];
                    int bytesRead;
                    while ((bytesRead = bf.read(buff)) > 0) {   //Enquanto tiver byte p ler ">0"
                    zip.write(buff, 0, bytesRead);         //Escreva eles
                }
                zip.flush();
                zip.closeEntry();
                bf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}