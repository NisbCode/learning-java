package br.com.abc.javacore.Minterfaces.classes;

            //2- Convenção: o nome de uma interface deve
            // ser um adjetivo (não é regra, é recomendação),
            // se não der pra fazer, faça tipo ITributo
public interface Tributavel {
    //4- todos os atributos de interface são constantes
                                //Lembrete: variavel
                                // constante logo deve na
                                // declaração ser inicializada
    public static final double IMPOSTO = 0.2;

    //3- declaração do public abstract no método
    // não necessário, mas existente
    void cacularImposto();
}
