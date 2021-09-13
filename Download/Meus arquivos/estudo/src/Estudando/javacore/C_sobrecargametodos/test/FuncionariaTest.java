package Estudando.javacore.C_sobrecargametodos.test;

import Estudando.javacore.C_sobrecargametodos.classes.Funcionaria;

public class FuncionariaTest {
    public static void main(String[] args) {
        //Lembrete relacionado aos construtores, como você alterou o nome ali embaixo, irá sobreescrever
        Funcionaria func = new Funcionaria("ângela");
        Funcionaria func2 = new Funcionaria();


//Fazer aquele método que usa os set tornará as seguintes linhas comentadas inuteis
        /*
        func.setNome("Ana Júlia");
        func.setCPF("843.264.028-04");
        func.setSalario(2460);
        */

        //E com isso as transformaremoos nessa linha:
        func.init("Ana Júlia", "843.264.028-04", 2460, "3618399276-22");

        func.imprime();
        func2.imprime();
    }
}
