package br.com.abc.javacore.Oexception.exercicioexceptions;

public class Questao1 {
    public static void main(String[] args) {
        System.out.println("inicio do main");
        metodo1();
        System.out.println("fim do main");
    }

    static void metodo1(){
        System.out.println("inicio do metodo 1");
        metodo2();
        System.out.println("fim do metodo 1");
    }


    static void metodo2(){
        int[] array = new int[10];
        try{
            for (int i = 0; i <= 15; i++){
                array[i] = i;
                    System.out.println(i);
                }
            } catch (ArrayIndexOutOfBoundsException e){
                e.getCause();
            }

            System.out.println("fim do metodo 2");
        }

}




