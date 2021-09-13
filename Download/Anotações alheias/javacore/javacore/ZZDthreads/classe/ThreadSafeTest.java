package br.com.abc.javacore.ZZDthreads.classe;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * CLASSES ThreadSafe
 * Classes que, como a StringBuffer, por exemplo, possuem
 * seus métodos sincronizados pra que duas threads não mudem
 * algum dado ao se confundirem.
 * Existe, mas não é 100% confiável, o que torna necessário
 * o uso do syncronized tambem nos métodos derivados dessa classe
 */

public class ThreadSafeTest {
    public static void main(String[] args) {
        ListaNomes nome = new ListaNomes();
        nome.add("Jeon Jungkook");
        class RemovedorDeNomes extends Thread {
            @Override
            public void run() {
                nome.removerPrimeiro();
            }
        }

        new RemovedorDeNomes().start();
    }
}

class ListaNomes {
    //                              método synchronizedList() que sincroniza todos
    //                              os métodos de uma Collection
//    private List<String> nomes = Collections.synchronizedList(new LinkedList<>());
    //                  Mas a classe usada é essa apenas, por causa da não garantia de classes ThreadSafe
    private List<String> nomes = new LinkedList<>();

    public synchronized void add (String nome){
        nomes.add(nome);
    }

    public synchronized void removerPrimeiro(){
        if (nomes.size() > 0){
            System.out.println(nomes.remove(0));
        }
    }
}

