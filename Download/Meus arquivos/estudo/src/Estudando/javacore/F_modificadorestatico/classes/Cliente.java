package Estudando.javacore.F_modificadorestatico.classes;

public class Cliente {
    private static int[] parcelas;

//Como a parecela terá 100 para todos osobjetos, não há necessidade de deixar ele se repetir, coisa que aconteceria
//caso tivessemos mais de um cliente
    static {
        //Vc n vai colocar número por número, então você coloca assim:
        parcelas = new int[100];
        System.out.println("Dentro do bloco de inicialização");
        for (int i = 1; i <= 100; i++) {
            parcelas[i - 1] = i;
        }
    }


    public Cliente() {
    }


    public int[] getParcelas() {
        return parcelas;
    }

    public void setParcelas(int[] parcelas) {
        this.parcelas = parcelas;
    }
}
