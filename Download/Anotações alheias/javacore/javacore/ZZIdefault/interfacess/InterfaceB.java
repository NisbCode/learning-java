package br.com.abc.javacore.ZZIdefault.interfacess;

public interface InterfaceB extends InterfaceA {
    @Override
    default void oi() {
        System.out.println("Dentro do oi de B");
    }

    default void relevanciaClasseOuInterface(){
        System.out.println("Interface é mais relevante");
    }


}
