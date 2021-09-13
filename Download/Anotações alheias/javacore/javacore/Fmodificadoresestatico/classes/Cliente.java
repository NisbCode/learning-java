 package br.com.abc.javacore.Fmodificadoresestatico.classes;

public class Cliente {
//    REGRA DE INICIALIZAÇÃO DO JAVA:
//    0- bloco de inicialização estático é executado quando a JVM executar a classe
//    (é executado apenas uma vez)
//    1- Alocado espaço na memoria para o objeto
//    2- Cada atributo de classe é criado
//    e inicializado com seus valores default ou
//    valores explícitos
//    3- Bloco de inicialização é executado
//    4- O construtor é executado

    /***
     * Guardar a quantidade de vezes que um cliente
     * pode parcelar um prduto
     */
    private static int[] parcelas;
    {
        System.out.println("Bloco de inicialização não estático");
    }

    /***
     * BLOCO DE INICIALIZAÇÃO ESTÁTICO:
     * usado para iniciar variaveis estaticas
     * Será executado apenas uma vez, antes de qualquer coisa
     */
    static {
        parcelas = new int[100];
        System.out.println("Dentro do bloco de inicialização");
        for(int contagemParcelas = 1; contagemParcelas<=100; contagemParcelas++){
            parcelas[contagemParcelas-1] = contagemParcelas;
        }

    }
    //    Múltiplos blocos estáticos serão executados na ordem em que vierem
    static {
        System.out.println("Bloco estático 2");
    }
    static {
        System.out.println("Bloco estático 3");
    }

    public Cliente(){
    }

    public static int[] getParcelas() {
        return parcelas;
    }


}
