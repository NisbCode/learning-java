package br.com.abc.javacore.ZZAclassesinternas.teste;

/***
 * CLASSES INTERNAS:
 * Classes dentro de putras classes, funcionam como métodos,
 * mas com mais possibilidades
 */

public class ClassesInternasTeste {
    private String nome = "Nathália";

    class Interna{
        public void verClasseExterna(){
            System.out.println(nome);
            // this: usado para referenciar
            // o objeto com que se lida no momento,
            // nesse caso, a classe Interna
            System.out.println(this);
        }
    }


    public static void main(String[] args) {
        // Primeiro é criada uma variavel de referencia
        // da maior classe
        ClassesInternasTeste externa = new ClassesInternasTeste();
        // Depois, é criada a variavel da propria classe interna,
        // referenciando a externa
        ClassesInternasTeste.Interna in = externa.new Interna();
        // Usar a classe
        System.out.println("Dentro do modo mais rapido:");
        in.verClasseExterna();

        // Da forma mais complexa:
        ClassesInternasTeste.Interna in2 = new ClassesInternasTeste().new Interna();
        System.out.println("Dentro do modo mais rapido:");
        in2.verClasseExterna();
    }

}


