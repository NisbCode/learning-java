package Estudando.javacore.N_polimorfismo.classes.A_outro_exemplo;

public class DatabaseDAOImpl implements GenericDAO {
    @Override
    public void save() {
        System.out.println("Salvando dados no banco de dados");
    }
}
