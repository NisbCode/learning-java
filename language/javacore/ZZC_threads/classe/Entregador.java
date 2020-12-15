package Estudando.javacore.ZZC_threads.classe;


public class Entregador implements Runnable {
    private ListaMembros listaMembros;            //Associação com a outra lista

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
                String email = listaMembros.obterEmailMembro();   //Tentando executar o método da Classe ListaMembros
                if (email != null) {
                    System.out.println(nomeThread + " Enviando email para " + email);
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
