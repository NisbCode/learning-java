package Estudando.javacore.ZZIdefault.classes;


import Estudando.javacore.ZZIdefault.interfacess.D;
import Estudando.javacore.ZZIdefault.interfacess.A;
import Estudando.javacore.ZZIdefault.interfacess.B;
import Estudando.javacore.ZZIdefault.interfacess.E;

/**
 * Quando você implementa duas interfaces que contenham o
 * mesmo método, há três regras pra lidar com a situação:
 */

public class C implements A, B {
    public static void main(String[] args) {
        /**
         * 1- O método que for declarado em uma classe sempre vai ter
         * prioridade sobre métodos de interfaces
         */
        //Para ver o fato acontecendo implemente a interface A e extends a classe D apenas
        new C().oi();

        /**
         * 2- Num método que tenha mesma assinatura em duas interfaces,
         * e ambas as interfaces estejam sendo implementadas, é o método
         * mais específico que será chamado
         */
        //Para ver acontecendo implemente a interface A e B

        /**
         * 3- Se for o mesmo método, sem diferença, o desenvolvedor deverá
         * dizer qual dos métodos ele vai querer, para isso deve ser criada
         * uma nova classe para sobrescrever, invocando o método da classe
         * desejada
         */
        //Para ver acontecendo implemente as interfaces A e E

    }

    @Override
    public void oi() {
//        E.super.oi();    //Implemente a E p usar esse
    }
}
