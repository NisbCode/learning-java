package Estudando.javacore.ZZHlambdas.classe;


public class ComparadorCarro {
    public static int comparePorCor(Carro c1, Carro c2){
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }

    public int comparePorAno(Carro c1, Carro c2){
        return ((Integer) c1.getAno()).compareTo(c2.getAno());
    }
}


