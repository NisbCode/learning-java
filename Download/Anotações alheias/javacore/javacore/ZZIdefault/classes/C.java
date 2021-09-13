package br.com.abc.javacore.ZZIdefault.classes;

import br.com.abc.javacore.ZZIdefault.interfacess.D;
import br.com.abc.javacore.ZZIdefault.interfacess.InterfaceA;
import br.com.abc.javacore.ZZIdefault.interfacess.InterfaceB;
import br.com.abc.javacore.ZZIdefault.interfacess.InterfaceE;

/**
 * Quando você implementa duas interfaces que contenham o
 * mesmo método, há três regras pra lidar com a situação:
 */

public class C extends D implements InterfaceA, InterfaceB, InterfaceE {
    public static void main(String[] args) {
        /**
         * 1- O método que for declarado em uma classe sempre vai ter
         * prioridade sobre métodos de interfaces
         */
        // Esse mesmo método está também nas interfaces A e B
        new C().relevanciaClasseOuInterface();


        /**
         * 2- Num método que tenha mesma assinatura em duas interfaces,
         * e ambas as interfaces estejam sendo implementadas, é o método
         * mais específico que será chamado
         */
        // note que o oi de B contém mais detalhes que o oi de A, pelo extends
        new C().oi();


        /**
         * 3- Se for o mesmo método, sem diferença, o desenvolvedor deverá
         * dizer qual dos métodos ele vai querer, para isso deve ser criada
         * uma nova classe para sobrescrever, invocando o método da classe
         * desejada
         */
        new C().mesmoMetodo();


    }

    @Override
    public void mesmoMetodo() {
        InterfaceE.super.mesmoMetodo();
    }
}
