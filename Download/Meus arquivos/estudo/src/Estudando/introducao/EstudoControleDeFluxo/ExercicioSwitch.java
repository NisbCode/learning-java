package Estudando.introducao.EstudoControleDeFluxo;

public class ExercicioSwitch {
    public static void main(String[] args) {
        byte dia = 7;
        switch (dia) {
            case 1:case 7:
                System.out.println("Não é dia útil");
                break;
            case 2:case 3:case 4:case 5:case 6:
                System.out.println("É dia útil");
                break;
        }
    }
}
