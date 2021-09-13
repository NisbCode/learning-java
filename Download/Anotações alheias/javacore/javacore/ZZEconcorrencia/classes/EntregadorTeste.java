package br.com.abc.javacore.ZZEconcorrencia.conditions;

import javax.swing.*;
import java.awt.*;

public class EntregadorTeste {
    public static void main(String[] args) {
        ListaMembros listaMembros = new ListaMembros();
        Thread t1 = new Thread(new Entregador(listaMembros), "ThreadEntregador 1");
        Thread t2 = new Thread(new Entregador(listaMembros), "ThreadEntregador 2");
        t1.start();
        t2.start();
        while (true){
            try {
                String email = JOptionPane.showInputDialog("Digite o email do membro");


            if (email == null || email.isEmpty()){
                listaMembros.fecharLista();
                break;
            }
            listaMembros.adicionarEmailMembro(email);
            } catch (HeadlessException e){
                e.printStackTrace();
            }
        }
    }
}
