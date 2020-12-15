package Estudando.javacore.N_polimorfismo.test.A_test_deste_outro_exemplo;

import Estudando.javacore.N_polimorfismo.classes.A_outro_exemplo.ArquivoDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        ArquivoDAOImpl arquivoDAO = new ArquivoDAOImpl();
        arquivoDAO.save();
//      Isso serve meio q como um array só q expandível
        List<String> lista = new ArrayList<>();
        lista.add("Nome1");
        lista.add("Nome2");
        lista.add("Nome3");
        lista.add("Nome4");
        lista.add("Nome5");
        lista.add("Nome6");
        for(String nome : lista){
            System.out.println(nome);
        }
    }
}
