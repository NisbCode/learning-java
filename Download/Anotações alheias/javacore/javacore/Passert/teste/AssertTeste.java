package br.com.abc.javacore.Passert.teste;

/***
 * ASSERTIVAS:
 * Semelhante ao if e o else
 * Quando você usa, ele garante que a condição é true,
 * pois se for false, há um erro muito serio no código
 * Usado durante a fase de desnvolvimento
 * Quando habilitadas, são erros, ou seja, não devem ser
 * tratadas, a lógica inteira deve ser reformulado
 */

public class AssertTeste {
    public static void main(String[] args) {
//        AssertTeste.calculaSalario(-1000);
        Assert testeAssert = new Assert();
        testeAssert.calculaSalario();


//        diaDaSemana(9);
    }

    //PRIVADO: é prática ruim ser publico
    //pois outras pessoas podem ver/editar isso
    private static void calculaSalario(double salario) {
        assert (salario < 0) : "O salário não deve ser menor que 0";

        /***
         * O assert é por padrão desligado na execução,
         * para ativar deve ir em run -> edit configurations ->
         * vm option -> escrever "-ea"
         * Para desabilitar, é só ir la de novo e tirar o -ea
         * ou escrever -da
         * É possível também ativar apenas uma classe, é só ir
         * no mesmo local e dar "-ea" + endereço do pacote da classe
         * Para habilitar e desabiltar apenas pra uma, escreva
         * "-ea -da: pacotedaclassedesabilitada
         */

    }

//
}

