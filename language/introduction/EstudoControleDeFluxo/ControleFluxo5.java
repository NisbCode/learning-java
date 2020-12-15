package Estudando.introducao.EstudoControleDeFluxo;

public class ControleFluxo5 {
    public static void main(String[] args) {
        double valorTotal = 30000;
        for (int parcela = 1; parcela <= valorTotal; parcela++) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela >= 1000) {
                System.out.println("A Parcela " + parcela + " R$" + valorParcela);
            }
        }
    }
}
