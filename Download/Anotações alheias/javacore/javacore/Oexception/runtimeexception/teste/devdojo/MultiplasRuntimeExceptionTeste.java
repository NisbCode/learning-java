package br.com.abc.javacore.Oexception.runtimeexception.teste.devdojo;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiplasRuntimeExceptionTeste {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
            /***
             * TRATAMENTO DE MULTIPLAS EXCEÇÕES
             * começar sempre das subclasses e ir
             * subindo para a classe mãe na ordem,
             * porque se começar pela classe geral, é
             * essa que vai tratar os erros, tirando o
             * sentido de ter as outras
             */
            //Até o Java 6 era feito assim
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        } catch (IllegalArgumentException exception) {
            System.out.println("Dentro do IllegalArgumentException");
        } catch (ArithmeticException exception) {
            System.out.println("Dentro do ArithmeticException");
        } catch (RuntimeException exception) {
            System.out.println("Dentro do RuntimeException");
        }
        System.out.println("Final do programa");

        //Esse try ta capturando o metodo talvezLanceExcecao
        try {
            talvezLanceException();
            //Multi-catch: atualização do Java 7 para colocar
            // vários catchs numa unica linha
            // Nesse exemplo, não poderiamos colocar SQLException,
            // IOExeption e FileNotFoundException pq ao tratar
            // de IO, FileNotFound já vai ser tratad
                          //IOException pode ser chamado por ser
                          //mãe de FileNotFoundException, isso é
                          //polimorfismo
        } catch (SQLException | IOException exception){
        //} catch (Exception exception){: Possivel, mas não recomendavel



        }

    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
