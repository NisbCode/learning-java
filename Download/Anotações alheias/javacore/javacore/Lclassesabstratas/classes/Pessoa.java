package br.com.abc.javacore.Lclassesabstratas.classes;

/***
 * ORDEM DE LÓGICA DESSE PACOTE:
 * 1- PessoaOptional
 * 2- Funcionario
 * 3- Vendedor e Gerente
 */

    /***
     * CLASSES ABSTRATAS DANDO ORIGEM
     * A OUTRA CLASSES
     */

     //novamente o abstract indicando que a classe
    // não vai ser instanciada, apenas herdada
public abstract class Pessoa {
     protected String nome;


         /***
          * 1- No momento em que um método for
          * declarado na primeira classe abstrata,
          * é recomendavel que ele seja sobrescrito na
          * segunda classe abstrada, porque, senão,
          * você terá que sobrescrever em todas as classes
          * concretas derivadas da segunda
          */
     public abstract void imprime();


     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }
 }
