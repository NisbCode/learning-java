package Estudando.javacore.R_string;

public class StringPerformaceTest {
    public static void main(String[] args) {

//      Calculando quantos milisegundos em média meu pc demora para carregar 30,000 Strings
        long inicio = System.currentTimeMillis();
        concatString(30000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto String " + (fim - inicio) + " ms");

//      Calculando quantos milisegundos em média meu pc demora para carregar 100,000 StringsBuilders
        inicio = System.currentTimeMillis();
        concatStringBuilder(100000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto StringBuilder " + (fim - inicio) + " ms");

//      Calculando quantos milisegundos em média meu pc demora para carregar 100,000 StringsBuffers
        inicio = System.currentTimeMillis();
        concatStringBuffer(100000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto StringBuffer " + (fim - inicio) + " ms");
    }
//  Aq tá o corpo do método, ele só tá criando tantas Strings quanto ditos ali em cima
    private static void concatString(int tam){
        String string = "";
        for(int i = 0; i <tam; i++){
            string += i;
        }
    }
//  Okay, aqui vemos q StringBuilder DE LONGE é menos pesado para rodar msm em grande escala de Strings
    private static void concatStringBuilder(int tam){
        StringBuilder sb = new StringBuilder(tam);
        for(int i = 0; i <tam; i++){
            sb.append(i);
        }
    }
//  E aq vemos q StringBuffer é mais rápido q uma String só q ela perde processamento pois ela meio q trata métodos
//  Ela tb é td sincronizada
    private static void concatStringBuffer(int tam){
        StringBuffer sb = new StringBuffer(tam);
        for(int i = 0; i <tam; i++){
            sb.append(i);
        }
    }

}
