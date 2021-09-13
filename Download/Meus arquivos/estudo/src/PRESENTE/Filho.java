package PRESENTE;

import java.util.concurrent.TimeUnit;

public class Filho {
    public Mae mae;
    public String estado;

    public Filho(Mae mae) {
        this.mae = mae;
    }

    public void reacao() {
        if (mae.acao == AcoesMae.DAR_CASTIGO) {
            System.out.println(AcoesMae.DAR_CASTIGO.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: ~fica puto");
            sleep();
            System.out.println("Filho: ~fica bem puto");
            sleep();
            System.out.println("Filho: ~fica muito muito puto");
            sleep();
            System.out.println("Filho: ~respira");
            sleep();
            System.out.println("Filho: ~cumpre, pq reclamar piora");
            sleep();
            System.out.println("Filho: ~cresce e percebe que a mãe tava certa");


        } else if (mae.acao == AcoesMae.DAR_AMOR) {
            System.out.println(AcoesMae.DAR_AMOR.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: ~se sente acolhido");
            sleep();
            System.out.println("Filho: ~se sente bem");
            sleep();
            System.out.println("Filho: ~cresce bem");


        } else if (mae.acao == AcoesMae.DEIXA_FAZER_ALGO) {
            System.out.println(AcoesMae.DEIXA_FAZER_ALGO.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("- PULTA MERDA ~corre pra fazer");


        } else if (mae.acao == AcoesMae.NAO_DEIXA_FAZER_ALGO) {
            System.out.println(AcoesMae.NAO_DEIXA_FAZER_ALGO.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("E de novo");
            System.out.println("Filho: ~fica puto");
            sleep();
            System.out.println("Filho: ~fica bem puto");
            sleep();
            System.out.println("Filho: ~fica muito muito puto");
            sleep();
            System.out.println("Filho: ~respira");
            sleep();
            System.out.println("Filho: ~cumpre, pq reclamar piora");
            sleep();
            System.out.println("Filho: ~cresce e percebe que a mãe tava certa");


        } else if (mae.acao == AcoesMae.DEIXA_FILHO_NO_CELULAR_E_DORME) {
            System.out.println(AcoesMae.DEIXA_FILHO_NO_CELULAR_E_DORME.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: ~vê porno");


        } else if (mae.acao == AcoesMae.FILHO_CHEGA_EM_CASA_DE_MADRUGADA) {
            System.out.println(AcoesMae.FILHO_CHEGA_EM_CASA_DE_MADRUGADA.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: - Carai mano ;--;");
        } else if (mae.acao == AcoesMae.DAR_WHOPPER) {
            System.out.println(AcoesMae.DAR_WHOPPER.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: ~felicidade level 100000000000000");
        } else if (mae.acao == AcoesMae.MANDA_COMER_VEGETAIS) {
            System.out.println(AcoesMae.MANDA_COMER_VEGETAIS.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: - Ah nao, vei");
            sleep();
            System.out.println("Filho: - Não, vagem não");
            sleep();
            System.out.println("Filho: - Olha essa coisa");
            sleep();
            System.out.println("Filho: - Parece tentáculo de hentai");
            sleep();
            System.out.println("Filho: - Eu n vou comer isso de jeito nenhum");
            sleep();
            System.out.println("Filho: - Não vou");
            sleep();
            System.out.println("Filho: - Não vou");
            sleep();
            System.out.println("Filho: - Não vou ;-;");
            sleep();
            System.out.println("Filho: ~acaba comendo pq a mãe ta obrigando");
        } else if (mae.acao == AcoesMae.ABRACA) {
            System.out.println(AcoesMae.ABRACA.getDescricao());
            System.out.println(" ");
            sleep();
            System.out.println("Filho: ~se sente protegido e todos os problemas do mundo somem");
        } else if (mae.acao == AcoesMae.NO_DIA_DAS_MAES) {
            System.out.println(AcoesMae.NO_DIA_DAS_MAES.getDescricao());
            sleep();
            System.out.println("Era isso o que estava escrito: ");
            System.out.println(" ");
            sleep();

            momMessage();
        }


    }


    public void momMessage(){
        System.out.println("Mamãe");
        sleep();
        System.out.println("Mamãe...");
        sleep();
        System.out.println("Eu realmente não consigo entender como");
        System.out.println("consegue me chamar assim, depois de tudo");
        sleep();
        System.out.println("Mesmo caindo");
        sleep();
        System.out.println("Mesmo que eu fosse a pior");
        sleep();
        System.out.println("Mesmo que tivesse esperança alguma pra mim");
        sleep();
        System.out.println("Você não para e não pararia de me amar");
        sleep();
        System.out.println("Você me diz que isso é por amor");
        sleep();
        System.out.println("Mas como você faz isso?");
        sleep();
        System.out.println("Tipo, que ser humano ama dessa forma?");
        sleep();
        System.out.println("Eu acho que seu amor chegou num nível divino");
        sleep();
        System.out.println("Além do humano");
        sleep();
        System.out.println("Isso explicaria toda essa força que ele tem");
        sleep();
        System.out.println("Olhar pra esse seu amor me faz ver que eu não sei amar");
        sleep();
        System.out.println("Que eu tô imatura, preciso aprender a fazer isso da forma certa");
        sleep();
        System.out.println("Por mais que eu esteja me sentindo mal, recentemente");
        sleep();
        System.out.println("Cumprir suas ordens vêm me deixado orgulhosa");
        System.out.println("e me fazendo sentir bem");
        sleep();
        System.out.println("Sim, mesmo que me mande comer brócolis");
        sleep();
        System.out.println("Isso fez eu me sentir bem, forte");
        sleep();
        System.out.println("Tudo o que vc é pra mim, eu quero ser");
        sleep();
        System.out.println("Quero rir de cada piada depressiva que contar");
        sleep();
        System.out.println("Quero entender cada expressão artística que me mandar");
        sleep();
        System.out.println("Quero comer cada vegetal que disser (a muito contra gosto, mas ok)");
        sleep();
        System.out.println("Quero abraçar esses seus 'Ta' e também te bater quando me bater");
        System.out.println("pra gente ter 10 minutos de  porrada e ficar de boa");
        sleep();
        System.out.println("Quero que continue a me ensinar a crescer");
        sleep();
        System.out.println("A única coisa que não quero...");
        sleep();
        System.out.println("De jeito nenhum");
        sleep();
        System.out.println("É ir embora");
        sleep();
        System.out.println("Porque me encontrei do seu lado");
        sleep();
        System.out.println("Você depressiva ou não");
        sleep();
        System.out.println("Eu me encontrei aqui");
        sleep();
        System.out.println("Eu te amo");
        sleep();
        System.out.println("Demais, demais mesmo");
        sleep();
        System.out.println("E vou fazer você não ter dúvida disso");
        sleep();
        System.out.println("<333");
        sleep();
        System.out.println("PS: Se Deus quiser, o presente do ano que vem é físico");
        sleep();
        System.out.println("/ Your Little Anpangirl");

    }

    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
