package Estudando.javacore.P_assertions;

public class AssertTest {
    public static void main(String[] args) {
        calculaSalario(-1000);
    }

    private static void calculaSalario(double salario){
        assert salario > 0 : "O salário não deve ser menor que zero, ele veio: " + salario;
//        calculo de salario
    }

    public static void diasDaSemana(int dia){
        switch (dia){
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            default: assert false;
        }
    }
}
