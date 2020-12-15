package Estudando.javacore.Z_generics.test;

import java.util.ArrayList;
import java.util.List;

/***
 * MÉTODOS ABSTRATOS
 */
public class MetodoGenericoTest {
    public static void main(String[] args) {
        // Olhar la embaixo primeiro
        criarArrayVoid(new Cachorro());
        List<Cachorro> doguinhos = criarArrayList(new Cachorro());

    }

    // <T> = objeto envolvido
    public static <T> void criarArrayVoid(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }

    // Caso queiramos especificar o tipo de retorno
    // do fazAlgumaCoisa
    public static <T> List<T> criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
        return lista;
    }

    // E ainda é possível limitar
    public static <T extends Animal> List<T> criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
        return lista;
    }
}
