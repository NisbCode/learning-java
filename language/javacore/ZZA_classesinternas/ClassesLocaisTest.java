package Estudando.javacore.ZZA_classesinternas;

/***
 * CLASSES LOCAIS:
 * Classes internas dentro de métodos
 */

public class ClassesLocaisTest {
    private String nome = "Naty";

    // Adendo: Até o Java 7, os atributos dentro desse método e classe
    // deviam ser finais, para que o heap não descarte a
    // existência deles
    // A partir do Java 8, a própria linguagem ja considera
    // os atributos apresentados como finais, sem possibilidade
    // de mudança ao serem criados
//    Isso pq variáveis locais somem da memória dps de usadas, e uma classe local pode
//    ser usada dps, mas se não existirem, terá um erro de compilação
    public void fazAlgumaCoisa(){

        // Classes locais não podem ter modificadores public,
        // private ou protected, apenas final e abstract q é oq o método suporta

//        Para exemplificar melhor isso de final:
        //String sobrenome = "Ignácio";  //<---Isso daria um erro pq essa variável local dentro do método
                                         //Some primeiro que na classe
        class Interna{
            public void imprimeNomeExterno(){
                System.out.println(nome);
//                System.out.println(sobrenome);   // Aí esse código n daria certo ISSO ATÉ O JAVA 8
                                                   //Ele vai ver q sempre vai ser efetivamente final
            }

        }
        // Isso não vai funcionar se for chamado do jeito
        // ensinado anteriormente justo por ser uma classe local
        // Então deve-se fazer assim:
        Interna in = new Interna();
        in.imprimeNomeExterno();
    }

    public static void main(String[] args) {
        ClassesLocaisTest externa = new ClassesLocaisTest();
        // Nisso, ao chamar aqui, estamos chamando o
        // objeto e o método criados la dentro
        externa.fazAlgumaCoisa();
    }

}
