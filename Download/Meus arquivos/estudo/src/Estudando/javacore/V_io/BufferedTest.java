package Estudando.javacore.V_io;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
//      Vc inicia normalmente dentro do try e inicializa o File tb (O qual é necessário inicializar junto de Buffered)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            BufferedReader br = new BufferedReader(new FileReader(file))){
            bw.write("Escrevendo uma mensagem ao arquivo");
            bw.newLine();      //pq tem sistemas q n pulam linha no \n
            bw.write("E pulando uma linha 3");
            bw.flush();
            String s;
            while((s = br.readLine()) != null){   //Enquanto ele detectar q tem caracteres diferentes de nulo, ele vai escrever
                System.out.println(s);
            }
        }catch(IOException e){
                e.printStackTrace();
        }
    }
}