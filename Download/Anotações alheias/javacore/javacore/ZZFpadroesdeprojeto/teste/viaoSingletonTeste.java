package br.com.abc.javacore.ZZFpadroesdeprojeto.teste;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingleton;

public class viaoSingletonTeste {
    public static void main(String[] args) {
        System.out.println("Assento agendado?: ");
        agendarAssento("1A");
        System.out.println("Assento agendado?: ");
        agendarAssento("1A");
    }

    private static void agendarAssento(String assento){
        // Agora, nesse caso, o objeto é especificamente
        // o que tá dentro do método getINSTANCE, o que
        // vai impedir que objetos sejam removidos duplamente
        AviaoSingleton a = AviaoSingleton.getINSTANCE();
        System.out.println(a.escolherAssento(assento));
    }
}
