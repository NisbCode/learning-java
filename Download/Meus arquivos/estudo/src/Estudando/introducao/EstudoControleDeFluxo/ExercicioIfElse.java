package Estudando.introducao.EstudoControleDeFluxo;

public class ExercicioIfElse {
    public static void main(String[] args) {
        double salario = 5500;

        if (salario < 1000){
            salario *= 0.5;
        }else if (salario >= 1000 && salario < 2000){
            salario *= 0.10;
        }else if (salario >= 2000 && salario < 5000) {
            salario *= 0.15;
        }else{
            salario *= 0.20;
        }
        System.out.println("O salario com seu devido imposto ficará: "+salario);
    }
}
