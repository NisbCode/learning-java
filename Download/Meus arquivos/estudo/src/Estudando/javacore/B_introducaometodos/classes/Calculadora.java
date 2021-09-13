package Estudando.javacore.B_introducaometodos.classes;

public class Calculadora {
    public void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    public void subtracaoDoisNumeros() {
        System.out.println(5 - 3);
    }

    public void multiplicacaoDoisNumeros(double num1, int num2) {
        System.out.println(num1 * num2);
    }

    public double divisaoDoisNumeros(double num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return 0;
        }
    }

    public void imprimindoDoisNumerosDivididos(double num1, double num2) {
        if (num2 != 0) {
            System.out.println(num1 / num2);
        } else {
            System.out.println("Não é possível dividir por 0");
        }
    }

    public void alterandoImpressoes(int num1, int num2) {
        num1 = 30;
        num2 = 40;
        System.out.println("Números da classe: ");
        System.out.println(num1);
        System.out.println(num2);
    }

    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }


    //O ruim dele é que ele só aceita um tipo por vez para ser criado
    //Ele também pede que você coloque o valor args por ultimo pra que ele entenda qual é qual
    //     public void somaVarArgs(double valorDouble, int... numeros) {
    // nesse caso ele vai dizer que o "1" é o double e o resto args, reverter a ordem causará num erro
    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }
}

