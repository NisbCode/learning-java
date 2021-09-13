package Estudando.javacore.ZZC_threads.classe;


import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {
    private final Queue<String> emails = new LinkedList<>();
    private boolean aberta = true;

    public int getEmailPendentes() {
        // Os métodos wait, notify e notifyAll só
        // funcionam em métodos sincronizados
        synchronized (emails) {   //Como eu não quero que todas as Threads mexam nessa instância, eu a sincronizo
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
                while (this.emails.size() == 0) {   //Seu tamanho inicial é 0 pois não obtemos nenhum email
                    if (!aberta) return null;       //E ele está aberto
                    System.out.println("Lista vazia. Colocando a thread " + Thread.currentThread().getName() + " em modo wait");
                    this.emails.wait();  //A Thread q estiver executando esse método irá esperar até q algo interrompa isso, nesse caso um email chegar
                }
                email = this.emails.poll(); //Fará com que o primeiro da Queue seja apagado assim q o email seja respondido pela Thread
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email;  //pq agt vai usar dps
    }

    public void adicionarEmailMembro(String email) {   ///Ao ser adicionado um email, esse método será ativado
        synchronized (this.emails) {
            this.emails.add(email);
            System.out.println("Email adicionado a lista");
            System.out.println("Notificando as Threads que estão em espera");
            this.emails.notifyAll();  //Notifiquei a todas as Threads em espera p voltar ao trabalho
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