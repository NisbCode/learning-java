package Estudando.javacore.V_io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
//Caso vc queira q ele crie em tal diretório, só copiar o path e colar assim:(Ps.: P ver se funcionou, apague o método Delete)

        File file = new File("C:\\Users\\natyb\\IdeaProjects\\JavaOnline.estudo\\src\\Estudando\\javacore\\V_io\\Arquivo.txt");
        try {
            System.out.println(file.createNewFile());   //O uso de sout n faz c q ele imprima se foi ou n apenas, ele tb executa
            boolean exists = file.exists(); //Retorna se eixte ou não
            System.out.println("Permissão de leitura?" + file.canRead()); //Mostra se podemos ler ele
            System.out.println("path " + file.getPath());  //Mostra o nome do arquivo
                                                           // (PS.: se vc colocou o diretório junto, ele vira o nome
            System.out.println("path " + file.getAbsolutePath());
            System.out.println("diretório?" + file.isDirectory());     //Mostra se é um diretório
            System.out.println("hidden?" + file.isHidden());           //Mostra se é um arquivo oculto
            System.out.println("Last Modified" + new Date(file.lastModified()));   //Mostra quando foi modificado pela ultima vez
//            System.out.println("Last Modified" + file.lastModified());  //Assim ele mostra em milisegundos

            if (exists) {                                          //Aq ele diz q se o arquivo existir(delete)
                System.out.println("Deletado?" + file.delete());   //Método de apagar
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}