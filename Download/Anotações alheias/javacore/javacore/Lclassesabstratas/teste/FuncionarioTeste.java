package br.com.abc.javacore.Lclassesabstratas.teste;

import br.com.abc.javacore.Lclassesabstratas.classes.Funcionario;
import br.com.abc.javacore.Lclassesabstratas.classes.Gerente;
import br.com.abc.javacore.Lclassesabstratas.classes.Vendedor;

public class FuncionarioTeste {
    public static void main(String[] args) {
        //note o erro que da ao tentar instanciar
        // a classe funcionario
//        (para fins didaticos, mantenha o erro e comente
//        o código ao executar)
//        Funcionario f = new Funcionario("Marcos","958489-9",2500);
        Gerente g = new Gerente("Anna", "659595-8", 5000);
        Vendedor v = new Vendedor("Camila", "54654-9", 1500, 500);
        g.calculaSalario();
        System.out.println(g);

        v.calculaSalario();
        System.out.println(v);

    }

}
