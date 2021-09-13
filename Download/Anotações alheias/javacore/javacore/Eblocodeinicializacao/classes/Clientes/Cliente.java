package br.com.abc.javacore.Eblocodeinicializacao.classes.Clientes;

public class Cliente {
//    REGRA DE INICIALIZAÇÃO DO JAVA:
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
    private int[] parcelas;

    /***
     * BLOCO DE INICIALIZAÇÃO:
     * As boas práticas dizem para se criar antes do construtor
     */
    {
        parcelas = new int[100];
        System.out.println("Dentro do bloco de inicialização");
        for(int contagemParcelas = 1; contagemParcelas<=100; contagemParcelas++){
            parcelas[contagemParcelas-1] = contagemParcelas;
        }

    }

    public Cliente(){
        System.out.println("Dentro do construtor    ");
        for(int parcela : this.parcelas) {
            System.out.print(parcela + " ");
        }
    }

    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
