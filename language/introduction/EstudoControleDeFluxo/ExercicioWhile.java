package Estudando.introducao.EstudoControleDeFluxo;

public class ExercicioWhile {
    public static void main(String[] args) {
        int contador = 0;
        while (contador <= 100000) {
            contador++;
            if (contador % 2 == 0) {
                System.out.println(contador);
            }
        }
    }
}
