package br.com.abc.javacore.Oexception.checkedexceptions.classes;

public class Leitor2 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Fechando Leitor2");
    }
}
