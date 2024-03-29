package Estudando.javacore.V_io;

import java.io.*;

public class StreamsTest {
    public static void main(String[] args) {
        gravadorTunado();
    }

    //  Para escrever:
    private static void gravador() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")) {
            gravador.write(dados);
            gravador.flush();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Para escrever:
    private static void gravadorTunado() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        //                                                                                                       tamanho da memória do buff
//        Oq intereça aq é q o BufferedOutputStream tenha um objeto do tipo OutputStream, e o File é por conta da herança          |
        try (BufferedOutputStream gravadorBuffer = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"), 4098)) {
            gravadorBuffer.write(dados);
            gravadorBuffer.flush();    //obriga a td q tiver de byte sair no caso de buffer
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Para ler:
    private static void leitor() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (FileInputStream leitor = new FileInputStream("pasta/stream.txt")) {
            int leitura;
            while ((leitura = leitor.read()) != -1) { //ele vai ler e quando chegar no fim, ele retorna -1; então aq vc manda ele ler até q chegue a isso
                byte b = (byte) leitura; //conversão de int p byte
                System.out.println(" " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    Usando o buffer:
    private static void leitorTunado() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"), 4098)) {
            int leitura;
            while ((leitura = leitorBuffer.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(" " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}