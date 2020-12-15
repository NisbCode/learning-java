package Estudando.javacore.O_exception.c_checkedexception.classes;

public class Leitor1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Fechando Leitor1");
    }
}
