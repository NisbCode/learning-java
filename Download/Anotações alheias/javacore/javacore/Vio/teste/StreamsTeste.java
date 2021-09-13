package br.com.abc.javacore.Vio.teste;

import java.io.*;

/***
 * InputStream E OutputStream
 * Stream: um fluxo de dados executado por um player
 * No InputStream: leitura de bytes
 * No OutputStream: escrita de bytes
 */

public class StreamsTeste {
    public static void main(String[] args) {
        leitorTunado();
    }

    private static void gravador(){
        byte[] dados = {65, 66, 67, 68, 69, 70};

                                                                 // O boolean no atributo é o append,
                                                                // se ficar em false (o padrão), o método
                                                                // será sobrescrito ao ser criado, mas ao
                                                                // adicionar true, ele será complementado
        try(FileOutputStream gravador = new FileOutputStream("pasta/stream.txt", true)){
            // Para escrever os bytes supracitados no arquivo:
//            for (Byte bytes : dados){
//                gravador.write(bytes);
//            }
            // Ou apenas:
            gravador.write(dados);
            System.out.println("Dados gravados com sucesso!");
            // Nesse caso serão exibidos os bytes ao invés das letras
            // que eles representam

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    // Agora usando buffer:
    private static void gravadorTunado(){
        // Se fosse com objeto
//        FileOutputStream gravador = new FileOutputStream("pasta/stream.txt", true);
//        BufferedOutputStream bufferedOutStream = new BufferedOutputStream(gravador);
        byte[] dados = {65, 66, 67, 68, 69, 70};
                                                                                                        // size: tamanho do buffer de memoria, o
                                                                                                        // máximo é 8196
        try(BufferedOutputStream gravadorBuffer = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"), 4098)){
            gravadorBuffer.write(dados);
            // método flush: fecha o stream antes de todos
            // os dados serem capturados
            // Como se fosse um "Cospe o que você tem antes de fechar"
            gravadorBuffer.flush();
            System.out.println("Dados gravados com sucesso!");
            // Nesse caso serão exibidos os bytes ao invés das letras
            // que eles representam

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    // Para ler esses dados gravados:
    private static void leitor(){
        try(FileInputStream leitor = new FileInputStream("pasta/stream.txt")){
            // No fim o arquivo vai retornar -1, ou seja,
            // não se sabe quando é o final do arquivo
            // Para contornar:
            int leitura;
            while((leitura = leitor.read()) != -1){
                byte b = (byte) leitura;
                System.out.println(" " + b);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void leitorTunado(){
        try(BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"), 4098)){

            int leitura;
            while((leitura = leitorBuffer.read()) != -1){
                byte b = (byte) leitura;
                System.out.println(" " + b);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }


}
