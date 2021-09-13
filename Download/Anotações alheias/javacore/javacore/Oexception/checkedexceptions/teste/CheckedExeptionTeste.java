package br.com.abc.javacore.Oexception.checkedexceptions.teste;

import java.io.File;
import java.io.IOException;

//ERROS TIPO CHECKED:
public class CheckedExeptionTeste {
    public static void main(String[] args) {
        abrirArquivo();
    }
    //IOException
    //um erro passivel de ocorrer quando se está lidando
    //com a classe file, que deve ser obrigatoriamente
    // tratado por ser uma exceção do tipo checked
//    public static void criarArquivo(){
//
//        File file = new File("Teste.txt");
//        file.createNewFile();
//    }
    //Tratamento:
    //Bloco de segurança(try): algo como "tente criar isso,
    // se não der, continua", usado quando há possibilidade
    //de exceção
                            //Esse throws avisa a quem vai chamar
                            //esse método que está passivel de erros
    public static void criarArquivo() throws IOException{
        File file = new File(("Teste.txt"));
        try {
                                        //file.createNewFile() retorna um valor boolean
            System.out.println("Arquivo criado?: " + file.createNewFile());
            System.out.println("Arquivo criado");
            //caso o código lance uma excessão, o proprio
            // java vai criar um objeto dessa isntancia,
            // nesse caso o objeto e
            //Só deve ser usadas se os códigos lancem
            //possiveis erros da classe exception e
            // derivados, caso isso seja desrespeitado,
            // o código nem compila
            //Significa: tente executar esse código, caso você
            // tenha algum problema, capture a IOExeption,
            // se ficar tudodo bem, ele executa o try e pula
            //o catch
        } catch(IOException e){
            //Por questões de manutenção, não é
            //bom deixar esse espaço vazio
            //Para preencher, chame a variavel de referencia
            // de IOException e o metodo printStackTrace, que
            // explica mais ou menos o que houve até ali
            e.printStackTrace();
            //avisa a quem vai chamar o metodo do erro, para
            //que o fulano possa tratar do jeito dele, mesmo que
            //eu ja tenha tratado
            throw e;
        }

        }

    public static void abrirArquivo(){
        File file = new File("Teste.txt");
        try{
            System.out.println(" ");
            System.out.println("Abrir arquivo");
            System.out.println("Executando a leitura do arquivo");
            throw new Exception();
            //System.out.println("Escrevendo no arquivo");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Dentro do catch");
        //Sempre será executado, independente se o codigo
        // executou normalmente, se o catch pegou algo ou até
        //mesmo diante de um return
        } finally {
            System.out.println("Fechar o arquivo");
        }


    }


}
