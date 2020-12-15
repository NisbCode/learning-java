package Estudando.javacore.N_polimorfismo.classes.A_outro_exemplo;

public class ArquivoDAOImpl implements GenericDAO {
    @Override
    public void save() {
        System.out.println("Salvando dados nos arquivos");
    }
}
