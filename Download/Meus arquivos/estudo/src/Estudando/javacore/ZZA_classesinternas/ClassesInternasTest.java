package Estudando.javacore.ZZA_classesinternas;

    /***
     * CLASSES INTERNAS:
     * Classes dentro de outras classes, funcionam como métodos,
     * mas com mais possibilidades
     */

        public class ClassesInternasTest {

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
            ClassesInternasTest externa = new ClassesInternasTest();

            // Depois, é criada a variavel da propria classe interna,
            // referenciando a externa
            ClassesInternasTest.Interna in = externa.new Interna();

            // Usar a classe
            in.verClasseExterna(); //Nós meio q criamos um caminho com um objeto de uma classe e usamos dele para ir a
                                   //outro objeto de outra classe

            // Da forma mais complexa:
//            Caso vc n tenha/queira usar o objeto da classe externa
            ClassesInternasTest.Interna in2 = new ClassesInternasTest().new Interna();
            in2.verClasseExterna();
        }
    }