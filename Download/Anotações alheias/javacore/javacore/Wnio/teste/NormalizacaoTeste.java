package br.com.abc.javacore.Wnio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

/***
 * NORMALIZACAO:
 * Isso é uma forma de fazer, no Java, o que você faz
 * no terminal ao sair e entrar de pastas usando cd ou cd..
 *
 */

public class NormalizacaoTeste {
    public static void main(String[] args) {
        String diretorioProjeto = "JavaOnline\\home\\amanda\\dev";
        String arquivoPastaAmanda = "..\\..\\arquivoTextoNormalize";

                            //onde você está      //aonde quer ir
        Path path1 = Paths.get(diretorioProjeto, arquivoPastaAmanda);

        System.out.println("Arquivo literalmente escrito: " + path1);
        System.out.println("Arquivo normalized: " + path1.normalize());
    }
}
