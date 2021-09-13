package br.com.abc.javacore.Vio.teste;

import java.io.File;
import java.io.IOException;

public class FileDiretorioTeste {
    public static void main(String[] args) {
        // Declarando o objeto
        File diretorio = new File("Folder");
        // Criando o diretório
        boolean mkdir = diretorio.mkdir();
        System.out.println("Diretório criado?: " + mkdir);

        // Criando o arquivo dentro do folder
        File arquivo = new File(diretorio, "Arquivo.txt");
//      ou:
//      File arquivo = new File("C:\\Users\\Amanda Porto\\IdeaProjects\\JavaOnline\\Folder\\Arquivo.txt");
        try {
            boolean newFileTxt = arquivo.createNewFile();
            System.out.println("Arquiv criado?: " + newFileTxt);

            // Renomeando arquivos
                                // Lembrando de dar o caminho antes do child
            File arquivoNovoNome = new File(diretorio,"arquivo_renomeado.txt");
            boolean foiRenomeado = arquivo.renameTo(arquivoNovoNome);
            System.out.println("Renomeado?: " + foiRenomeado);

            // Renomeando diretórios
            File diretorioRenomedo = new File("Folder2");
            boolean diretorioFoiRenomeado = diretorio.renameTo(diretorioRenomedo);
            System.out.println("O diretório foi renomeado?: " + diretorioFoiRenomeado);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Chamada do método para busca de arquivo:
        buscarArquivos();

    }

    // Para buscar arquivos
    public static void buscarArquivos(){
        File buscaDeFile = new File("Folder2");
        String[] list = buscaDeFile.list();
        for(String arquivoItemList: list){
            System.out.println(arquivoItemList);
        }
    }

}
