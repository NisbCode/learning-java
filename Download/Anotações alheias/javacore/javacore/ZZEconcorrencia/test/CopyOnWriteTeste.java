package br.com.abc.javacore.ZZEconcorrencia;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteArrayList: é a classe ArrayList em versão
 * "threadsafe", não é totalmente porque tem como mudar
 * alguns atributos da classe, ou seja, ela não é final
 * Não é recomendável usá-lo para ficar alterando valores
 * da lista, apenas para leitura porque ele não substitui.
 * ele apaga a lista toda e cria uma nova com as mudanças
 * exigindo processamento
 */

public class CopyOnWriteTeste implements Runnable{
    public static void main(String[] args) {
        CopyOnWriteTeste ct = new CopyOnWriteTeste();
        Thread t1 = new Thread(ct, "Thread-1");
        Thread t2 = new Thread(ct, "Thread-2");
        Thread removedor = new Thread(new RemovedorMembros(ct.getList()), "Thread-removedor");

        t1.start();
        t2.start();
        removedor.start();

    }

    private List<Integer> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteTeste() {
        for (int i = 0; i <= 9000; i++) {
            list.add(i);
        }
    }

    @Override
    public void run() {
        // O iterator vai exibir a lista do momento em que
        // ele pegou, por isso vai aparecer a lista mesmo
        // depois dela ser removida
        Iterator<Integer> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()){
            System.out.println(Thread.currentThread().getName() + " " + iterator.next());

        }
    }

    public List<Integer> getList(){
        return list;
    }

    private static class RemovedorMembros implements Runnable{
        private List<Integer> list;

        public RemovedorMembros(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + " removeu: " + list.remove(i));
            }
        }
    }
}














