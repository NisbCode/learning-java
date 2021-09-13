package br.com.abc.javacore.ZZDthreads.classe;

public class Entregador implements Runnable {
    private ListaMembros listaMembros;

    public Entregador(ListaMembros listaMembros){
        this.listaMembros = listaMembros;
    }

    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println(nomeThread + " Começando o trabalho de entrega");
        int qtdePendente = listaMembros.getEmailPendentes();
        boolean aberta = listaMembros.isAberta();
        while (aberta || qtdePendente > 0){
            try{
                String email = listaMembros.obterEmailMembro();
                if (email != null) {
                    System.out.println(nomeThread + " Enciando email para " + email);
                    Thread.sleep(2000);
                    System.out.println("Envio para " + email + " concluido com sucesso");
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            aberta = listaMembros.isAberta();
            qtdePendente = listaMembros.getEmailPendentes();
        }
        System.out.println("Atividades finalizadas");

    }
}
