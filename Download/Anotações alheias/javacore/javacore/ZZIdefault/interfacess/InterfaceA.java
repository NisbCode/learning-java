package br.com.abc.javacore.ZZIdefault.interfacess;

public interface InterfaceA  {
    default void oi(){
        System.out.println("Dentro do oi de A");
    }

    default void relevanciaClasseOuInterface(){
        System.out.println("Interface é mais relevante");
    }

    default void mesmoMetodo(){
        System.out.println("É o mesmo metodo, mermao");
    }
}
