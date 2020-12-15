package Estudando.javacore.ZZIdefault.interfacess;

public interface B extends A {
    @Override
    default void oi() {
        System.out.println("Dentro do oi de B");
    }
}
