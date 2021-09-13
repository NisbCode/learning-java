package Estudando.introducao.EstudoInicio;

public class OperadoresDeAtribuicao {
    public static void main(String[] args) {
        int salario = 1800;
        // caso queira somar ele mesmo com um acrescimo de 10%
        // você escrever (int) força o número dps de multiplicar por decimal à ficar inteiro, senão ele pediria double
        salario += (int) (salario * 0.1);
        System.out.println(salario);
    }
}
