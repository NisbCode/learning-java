package Estudando.javacore.ZA_generics.test;


import Estudando.javacore.ZA_generics.classes.Carro;

import java.util.ArrayList;
import java.util.List;

public class ClasseNaoGenericaTest {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.alugaCarroDisponivel();
        System.out.println("Usando o carro por um mês vrumvrum");
        carroAlugavel.devolverCarro(carroAlugado);
    }
}

class CarroAlugavel {
    private List<Carro> carrosDisponiveis = new ArrayList<>();
    // Bloco de inicialização, lembra? Nem eu
    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));
    }

    // Método para alugar o carro: cada carro alugado será
    // removido da lista
    public Carro alugaCarroDisponivel(){
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro " + c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
        return c;
    }

    // Para devolver o carro: carro como parâmetro e esse
    // parâmetro é adicionado a carrosDisponiveis
    public void devolverCarro (Carro c){
        System.out.println("Devolvendo carro " + c);
        carrosDisponiveis.add(c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
    }

    // Quase uma telinha de menu que mostra você escolhendo
    // e depositando carros hahaha

    /***
     * E se você quisesse fazer isso com outros tipos de produtosw
     * Não teria que copiar esse mesmo código, criar a nova classe
     * e mudar apenas o tipo? Muita coisa pra programação
     * dá pra simplificar isso
     */

}
