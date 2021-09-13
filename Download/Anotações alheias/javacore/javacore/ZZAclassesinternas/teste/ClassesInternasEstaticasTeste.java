package br.com.abc.javacore.ZZAclassesinternas.teste;

/***
 * CLASSES EXTERNAS ESTATICAS
 */

class Externa {
    private static String nome;
    static class Interna{
        public void imprimir(){
            System.out.println("oie");
            // Se o nome não for estatico também,
            // não vai dar pra acessar dessa classe
            System.out.println(nome);
        }
    }
}
public class ClassesInternasEstaticasTeste {
    public static void main(String[] args) {
        // Para chamar a classe interna estática
        Externa.Interna teste = new Externa.Interna();
        teste.imprimir();
        // Para o caso da classe interna estar dentro do main
        Interna2 teste2 = new Interna2();
        teste2.imprimir();

    }
    static class Interna2{
        public void imprimir(){
            System.out.println("Oie de dentro do Interna2");
        }
    }
}
