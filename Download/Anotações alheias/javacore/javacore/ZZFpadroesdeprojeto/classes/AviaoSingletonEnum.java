package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * ALTERNATIVA AO AviaoSingleton
 */

public enum AviaoSingletonEnum {
    INSTANCE;
    private Set<String> assentosDisponiveis;

    // Lembrando que o modificador padrão de cada método
    // do enum é privado
    AviaoSingletonEnum(){
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean escolherAssento(String assento){
        return assentosDisponiveis.remove(assento);
    }

    public static void agendarAssento(String assento){
        AviaoSingletonEnum a = AviaoSingletonEnum.INSTANCE;
        System.out.println(a.escolherAssento(assento));
    }
}
