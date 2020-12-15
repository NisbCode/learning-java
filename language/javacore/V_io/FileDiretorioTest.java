package Estudando.javacore.V_io;

import java.io.File;
import java.io.IOException;

//                   SÓ AVISANDO, APAGA A PASTA FOLDER2 ANTES DE APERTAR EM RUN

public class FileDiretorioTest {
//    N é adequado usar o trows no main pq se n funcionar, n vai ter cm outro método resolver, vai lançar a exceção logo
    public static void main(String[] args) throws IOException {

        File diretorio = new File("folder");
        boolean mkdir = diretorio.mkdir();   //Método p criar diretório: file.mkdir
        System.out.println("Diretório criado " + mkdir);

        File arquivo = new File(diretorio, "arquivo.txt");
//      Ps.: Vc usar "diretorio" faz o arquivo ir diretamente p onde foi criado um diretorio
        boolean newFile = arquivo.createNewFile();        //Cria um arquivo no diretório criado
        System.out.println("Arquivo criado " + newFile);

        File arquivoNovoNome = new File(diretorio, "Arquivo_renomeado.txt");
        boolean renamed = arquivo.renameTo(arquivoNovoNome);  //Renomeia o arquivo no diretório criado
        //PS2.: Ao renomear vc precisa repassar o diretório
        System.out.println("Renomeado " + renamed);

        File diretorioRenomeado  = new File("folder2");
        boolean diretorioRenamed = diretorio.renameTo(diretorioRenomeado);
        System.out.println("diretório renomeado: " + diretorioRenamed);  //Renomeia o diretório criado
        buscarArquivos();
    }
    public  static void buscarArquivos(){      //Buscando usando a Classe File
        File file = new File("C:\\Users\\natyb\\IdeaProjects\\JavaOnline.estudo\\src\\Estudando\\javacore\\J_modificadorfinal");//Põe o diretório aq
        String[] list = file.list();           //Lista os arquivos
        for(String arquivo : list){            //Escreve essa lista
            System.out.println(arquivo);
        }
    }
}