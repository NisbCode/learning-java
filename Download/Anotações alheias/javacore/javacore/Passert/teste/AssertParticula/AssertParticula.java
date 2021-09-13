package br.com.abc.javacore.Passert.teste.AssertParticula;

public class AssertParticula {
    private static final Integer QUILOMETRO_POR_SEGUNDO = 0;
    private static final Integer METROS_POR_SEGUNDO = 1;
    private static final Integer VELOCIDADE_LUZ = 300000;

    public static void main(String[] args) {
        calculaVelocidadeParticula(10000000);
    }

    private static void calculaVelocidadeParticula(Integer velocidadeParticula){
        assert (velocidadeParticula > VELOCIDADE_LUZ) : "A velocidade da partícula não pode ser maior que a da luz";
    }


}
