package Estudando.javacore.L_classesabstratas.test;

import Estudando.javacore.L_classesabstratas.classes.Funcionario;
import Estudando.javacore.L_classesabstratas.classes.Gerente;
import Estudando.javacore.L_classesabstratas.classes.Vendedor;

public class FuncionarioTest {
    public static void main(String[] args) {

        Gerente g = new Gerente("Carla", "276863-04", 2000);
        Vendedor v = new Vendedor("Ronald", "475867-08", 1500,5000);
        g.calculaSalario();
        v.calculaSalario();
        System.out.println(g);
        System.out.println("----------------------------------");
        System.out.println(v);
    }
}
