package Estudando.javacore.ZZB_jdbc.interfaces;


import Estudando.javacore.ZZB_jdbc.classe.Carro;

import java.util.List;

public interface CarroDAO {

    void save(Carro carro);


    void delete(Carro carro);

    void update(Carro carro);

    List<Carro> selectAll();

    List<Carro> searchByName(String nome);
}
