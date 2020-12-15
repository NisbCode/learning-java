package Estudando.javacore.ZZD_concorrencia.test;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * CONCORRENCIA
 * Uma forma de se trabalhar com threads, porém no
 * alto nível. É usada a API java.util.concurrent pra isso
 */

class Contador {
    private int count;
    /**
     * VARIÁVEIS ATÔMICAS
     * 1.2- Para evitar isso, usamos a classe AtomicInteger,
     * que é criada de uma forma ThreadSafe chamada CAS
     * (Compare and Swap) que funciona assim:
     * A CPU do computador cria uma variável temporária
     * após atomicInteger ser usado dentro de um método (isso acontece
     * toda vez que uma variável é usada dentro de método), contudo,
     * antes dela retornar esse valor à variável atomicInteger,
     * ela compara pra ver se ele é diferente de como estava anteriormente,
     * se sim,
     * ele troca o valor antigo pelo novo
     */
    private AtomicInteger atomicInteger = new AtomicInteger();
    public void increment(){
        count++;
        // E aqui, fazer a chamada do método de incremento
        // dentro do AtomicInteger
        atomicInteger.getAndIncrement();
    }

    public int getCount(){
        return count;
    }

    // e criamos um getter para o atomicInteger pegar
    // o valor inteiro que ele tá representando
    public int getAtomicInteger(){
        return atomicInteger.intValue();
    }
}

class IncrementadorThread extends Thread {
    private Contador contador;

    public IncrementadorThread(Contador contador){
        this.contador = contador;
    }

    public void run(){
        /**
         * 1.1- O resultado esperado daqui é 20000, pois os dois itObjetos
         * percorrerão o método run e incrementarão a variável contadorObjeto,
         * contudo, pela aleatoriadade das threads nem isso acontece
         * É possivel sincronizar o método increment, contudo, isso
         * gasta processamento
         */
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + Thread.currentThread().getName() + " atuando no momento");
            contador.increment();

        }
    }
}

public class ConcorrenciaTest{
    public static void main(String[] args) throws InterruptedException {
        Contador contadorObjeto = new Contador();
        IncrementadorThread itObjeto1 = new IncrementadorThread(contadorObjeto);
        IncrementadorThread itObjeto2 = new IncrementadorThread(contadorObjeto);
        itObjeto1.start();
        itObjeto2.start();
        itObjeto1.join();
        itObjeto2.join();
        System.out.println(contadorObjeto.getCount());
        /**
         * 1.3- Agora adicionamos o AtomicInteger logo após o objeto
         */
        System.out.println(contadorObjeto.getAtomicInteger());
    }
}
