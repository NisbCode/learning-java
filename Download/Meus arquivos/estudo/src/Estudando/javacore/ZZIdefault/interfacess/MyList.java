package Estudando.javacore.ZZIdefault.interfacess;

/**
 * NOVAS REGRAS PARA INTERFACES
 */

public interface MyList {
    /**
     * 1- Agora são permitidos métodos estáticos dentro de interfaces.
     * Era por não ser permitido antes que classes utilitárias, como a
     * Collections tinha sido criada. Isso mostra que a cara de muitos
     * códigos vão mudar.
     */

    static void sort(){
        // Só lembrando que métodos estáticos precisam obrigatóriamente ter corpos,
        // mas o desenvolvedor pode sobrescrevê-los
        System.out.println("dentro do sort");
    }


    void add();

    /**
     * 2- Para que novos métodos possam ser adicionados a interface
     * sem que os códigos que já a utilizam quebrem, por serem obrigados
     * a adicionar também esse método e nem sempre ser possível fazer essa adição,
     * foi criada a palavra reservada default, que transforma o método em concreto
     * e torna opcional a adição desse método aos códigos
     */
    // Assim como métodos estáticos, métodos concretos também precisam ter corpo
    default void remove(){
        System.out.println("dentro do remove");
    }

}
