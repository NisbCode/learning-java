package br.com.abc.javacore.ZZEconcorrencia.conditions;

/**
 * CLASSE Condition
 * uma forma alto nivel de se utilizar wait, notify e
 * notifyAll
 * As classes do ListaMembros foram copiadas
 * para a demonstração
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
    private final Queue<String> emails = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionLock = lock.newCondition();
    private boolean aberta = true;

    public int getEmailPendentes() {
        // Os métodos wait, notify e notifyAll só
        // funcionam em métodos sincronizados
        synchronized (emails) {
            return this.emails.size();
        }
    }


    public boolean isAberta() {
        return aberta;
    }

    public String obterEmailMembro() {
        String email = null;
        // método wait exige try-catch
        try {
            lock.lock();
            while (this.emails.size() == 0) {
                if (!aberta) return null;
                System.out.println("Lista vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo wait");
                conditionLock.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void adicionarEmailMembro(String email) {
        lock.lock();
        try {
            this.emails.add(email);
            System.out.println("Email adicionado a lista");
            System.out.println("Notificando as Threads que estão em epera");
            this.emails.notifyAll();
        } finally {
            lock.unlock();
        }

    }

    public void fecharLista() {
        System.out.println("Notificando as threads e fechando a lista");
        aberta = false;
        try {
            this.emails.notifyAll();
        } finally {
            lock.unlock();
        }
    }

}