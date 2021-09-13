package br.com.abc.javacore.Zgenerics.teste;

import br.com.abc.javacore.Zgenerics.classe.Carro;

import java.util.ArrayList;
import java.util.List;

/***
 * APRENDENDO A LIDAR COM GENERICS
 */

public class ClasseGenericaTeste {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));
            // Agora é só colocar o tipo entre maior e menor
        ObjetoAlugavel<Carro> carroAlugavel = new ObjetoAlugavel<>(carrosDisponiveis);
        Carro carro = carroAlugavel.alugaObjetosDisponivel();
        System.out.println("Usando o carro por um mês");
        carroAlugavel.devolverObjeto(carro);

    }
    // Para que não precisemos criar várias classes com,
    // mesmo código, definimos um tipo T entre chaves para entrar
    // algum dado necessário
    // Nas Collections é E, fora delas é T, de Type

    static class ObjetoAlugavel<T> {
        private List<T> objetosDisponiveis = new ArrayList<>();

        public ObjetoAlugavel(List<T> objetosDisponiveis) {
            this.objetosDisponiveis = objetosDisponiveis;
        }


        public T alugaObjetosDisponivel() {
            T t = objetosDisponiveis.remove(0);
            System.out.println("Alugando objeto " + t);
            System.out.println("Objetos disponíveis: " + objetosDisponiveis);
            return t;
        }

        public void devolverObjeto(T t) {
            System.out.println("Devolvendo objeto " + t);
            objetosDisponiveis.add(t);
            System.out.println("Objetos disponíveis: " + objetosDisponiveis);
        }
    }

    // Também é possível criar 2 Types numa generic
    // (não testado, apenas anotação)
    class DoisAtributos<T, X>{
        T um;
        X dois;

        public DoisAtributos(T um, X dois) {
            this.um = um;
            this.dois = dois;
        }

        public T getUm() {
            return um;
        }

        public void setUm(T um) {
            this.um = um;
        }

        public X getDois() {
            return dois;
        }

        public void setDois(X dois) {
            this.dois = dois;
        }
    }
}
