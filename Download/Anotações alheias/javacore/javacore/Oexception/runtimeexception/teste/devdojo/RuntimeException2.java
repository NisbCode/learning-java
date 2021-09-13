package br.com.abc.javacore.Oexception.runtimeexception.teste.devdojo;

public class RuntimeException2 {
    public static void main(String[] args) {
        try{
            divisao(10,0);
        } catch (RuntimeException e){
            //Pega a mensagem do construção do throw e passa para string
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void divisao(int num1, int num2){
        //throw new:
        //Se num 2 for igual a 0:
        if(num2 == 0){
            //IllegalArgumentException: para argumentos invalidos
            //lance uma exceção do tipo IllegalArgumentException
            throw new IllegalArgumentException("Passe um valor diferente de 0 para num 2");
        }
        int result = num1/num2;
        System.out.println(result);
    }
}
