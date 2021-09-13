package br.com.abc.javacore.ZZAclassesinternas.teste;

/***
 * CLASSES LOCAIS:
 * Classes internas dentro de métodos
 */

public class ClassesLocaisTeste {
    private String nome = "Amanda";

    // Adendo: Até o Java 7, os atributos dentro desse método e classe
    // deviam ser finais, para que o heap não descarte a
    // existência deles
    // A partir do Java 8, a própria linguagem ja considera
    // os atributos apresentados como finais, sem possibilidade
    // de mudança ao serem criados
    public void metodo(){
        // Classes internas não podem ter modificadores public,
        // private ou protected, apenas final e abstract
        class Interna{
            public void imprimeNomeExtwrno(){
                System.out.println(nome);
            }

        }
    // Isso não vai funcionar se for chamado do jeito
    // ensinado anteriormente justo por ser uma classe local
    // Então deve-se fazer assim:
    Interna in = new Interna();
    in.imprimeNomeExtwrno();
    }

    public static void main(String[] args) {
        ClassesLocaisTeste externa = new ClassesLocaisTeste();
        // Nisso, ao chamar aqui, estamos chamando o
        // objeto e o método criados la dentro
        externa.metodo();    }

}

