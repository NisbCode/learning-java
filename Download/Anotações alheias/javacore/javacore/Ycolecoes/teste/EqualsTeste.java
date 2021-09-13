package br.com.abc.javacore.Ycolecoes.teste;

import br.com.abc.javacore.Ycolecoes.classe.Celular;

/***
 * MÉTODO EQUALS
 * Importante para o entendimento das coleções,
 * um dos assuntos mais essenciais do java
 */

public class EqualsTeste {
    public static void main(String[] args) {
        // Relembrando como o método equals funcionava em String
        String nome1 = "Amanda Porto";
//        String nome2 = "Amanda Porto";
        // O caso anterior daria true porque ambas as
        // Strings estão armazenadas no pool de strings
        String nome2 = new String("Amanda Porto");
        // Já nesse caso, é um objeto, está num local
        // diferente do pool de strings, num endereço de memória,
        // diferente, por isso vai retornar false
        // (A explicação acima é válida pra qualquer classe Wrapper)
        // O equals é usado justamente para comparar o significado
        // de ambos, independente dos endereços de memória
        System.out.println(nome1.equals(nome2));

        // Agora, criando um objeto celular
        Celular iPhone = new Celular("iPhone", "1253");
        Celular iPhone2 = new Celular("iPhone", "1253");
        System.out.println(iPhone.equals(iPhone2));


    }
}
