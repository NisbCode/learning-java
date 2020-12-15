package Estudando.javacore.ZZD_concorrencia.test;


/**
 * CLASSES COM COMPORTAMENTO DIFERENTE DA
 * CopyOnWrite:
 * ConcurrentHashMap: que possui métodos suportados apenas pelo
 * java 8 (tipo o putIfAbstent(), que ao invés de pegar o valor
 * da chave, pega a propria chave)
 * ConcurrentLinkedDeque,
 * ConcurrentLinkedQueue,
 * ConcurrentSkipListMap,
 * ConcurrentSkipListSet
 * Nesse caso o iterator é weekly consistent(fracamente consistente),
 * ou seja, é possivel ver no meio da iteração elementos serem
 * inseridos e removidos, conforme as atitudes das threads
 */

public class ConcorrenciaDeColecoesTest {
    public static void main(String[] args) {

    }
}
