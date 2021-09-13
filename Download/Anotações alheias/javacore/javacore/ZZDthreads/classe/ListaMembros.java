package br.com.abc.javacore.ZZDthreads.classe;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {
    private final Queue<String> emails = new LinkedList<>();
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
            synchronized (this.emails) {
                while (this.emails.size() == 0) {
                    if (!aberta) return null;
                    System.out.println("Lista vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo wait");
                    this.emails.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void adicionarEmailMembro(String email) {
        synchronized (this.emails) {
            this.emails.add(email);
            System.out.println("Email adicionado a lista");
            System.out.println("Notificando as Threads que estão em epera");
            this.emails.notifyAll();
        }
    }

    public void fecharLista() {
        System.out.println("Notificando as threads e fechando a lista");
        aberta = false;
        synchronized (this.emails) {
            this.emails.notifyAll();
        }
    }

}