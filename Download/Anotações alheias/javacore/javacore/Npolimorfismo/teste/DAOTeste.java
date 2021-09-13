package br.com.abc.javacore.Npolimorfismo.teste;

import br.com.abc.javacore.Npolimorfismo.classes.DatabaseDAOImpl;
import br.com.abc.javacore.Npolimorfismo.classes.GenericDAO;

public class DAOTeste {
    public static void main(String[] args) {
        //mais vantajoso criar uma variavel do tipo
        // da implementação

        //Note: TIPOINTERFACE arquivoDAO = new TIPODECLASSEQUEAIMPLEMENTA
        GenericDAO arquivoDAO = new DatabaseDAOImpl();
        arquivoDAO.save();
    }
}
