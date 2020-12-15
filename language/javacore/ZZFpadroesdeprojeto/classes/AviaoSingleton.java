package Estudando.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * PADRÃO SINGLETON
 * Usado quando o desenvolvedor tem parâmetros em que os
 * argumentos não podem se repetir
 * PORÉEEEEM
 * essa forma de se fazer o padrão não é recomendada, pois não tem proteção
 * contra construtores criados no método de teste
 * É muito mais indicado utilizar o exemplo em AviaoSingletonEnum
 */

public class AviaoSingleton {
    /**
     * EAGER INITIALIZATION: Inicializar diretamente no atributo
     * Transformar o objeto a ser criado num objeto imutável
     * e alocá-lo na memória
     */

//    private static final AviaoSingleton INSTANCE = new AviaoSingleton();

    private Set<String> assentosDisponiveis;

    /**
     * LAZY INITIALIZATION: criando um novo objeto apenas se for necessário
     */

    private static AviaoSingleton INSTANCE; //Usado apenas na forma LAZY

    //Caso vc faça da forma EAGER, esse get tem apenas q retornar a INSTANCE
    public static AviaoSingleton getINSTANCE() {       //Get p o atributo INSTANCE
        // "Se não tiver nada dentro dessa variável INSTANCE..."
        if (INSTANCE == null){
            // "... então obtenha o lock dessa classe, pra apenas
            // uma thread trabalhar nela..."
            synchronized (AviaoSingleton.class){
                // "... e checa de novo: se for mesmo nulo..."
                if (INSTANCE == null){
                    // "... Então coloca um objeto AviaoSingleton dentro dela"
                    INSTANCE = new AviaoSingleton();
                }
            }

        }
        return INSTANCE; //eager só teria essa parte
    }

    private AviaoSingleton(){
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean escolherAssento(String assento){
        return assentosDisponiveis.remove(assento);
    }
}
