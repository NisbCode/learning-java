package Estudando.javacore.ZZB_jdbc.test;


import Estudando.javacore.ZZB_jdbc.classe.Carro;
import Estudando.javacore.ZZB_jdbc.classe.Comprador;
import Estudando.javacore.ZZB_jdbc.database.CarroDAOImpl;
import Estudando.javacore.ZZB_jdbc.interfaces.CarroDAO;


import java.util.List;
import java.util.Scanner;

public class CarroCRUD { //Classe de projeto p a classe de execução
    private static Scanner teclado = new Scanner(System.in);

    private static CarroDAO dao = new CarroDAOImpl();  //Polimorfismo nesse caso vai ajudar no seguinte, sabemos q essa classe
                                                       //serve de "molde" p a TesteCRUD, ao mudar o seu banco de dados, vc teria
                                                       //q mudar td essa classe só p se adequar, ao invés disso, usar polimorfismo
                                                       //nesse caso vai te fazer precisar apenas mudar a quem ele implementa


    public static void executar(int op) {
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.println("Digite o nome");
                procurarPorNome(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
        }
    }

    private static void inserir() {
        Carro c = new Carro();
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());   //Vai ler e setar o nome cm esse
        System.out.println("Placa: ");
        c.setPlaca(teclado.nextLine());
        System.out.println("Selecione um dos compradores abaixo");
        List<Comprador> compradorList = CompradorCRUD.listar();
        c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));  //Setar o comprador da lista com o digitado no teclado
        dao.save(c);
    }

    private static void atualizar() {
        System.out.println("Selecione um dos carros abaixo");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = teclado.nextLine();
        System.out.println("Nova placa ou enter para manter a mesma");
        String placa = teclado.nextLine();
        if (!nome.isEmpty()) {
            c.setNome(nome);
        }
        if (!placa.isEmpty()) {
            c.setPlaca(placa);
        }
        dao.update(c);
    }

    private static List<Carro> listar() {
        List<Carro> carroList = dao.selectAll();
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "]" + c.getNome() + c.getPlaca() + c.getComprador().getNome());
        }
        return carroList;
    }

    private static void procurarPorNome(String nome) {
        List<Carro> carroList = dao.searchByName(nome);
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "]" + c.getNome() + c.getPlaca() + c.getComprador().getNome());
        }

    }

    public static void deletar() {
        System.out.println("Selecione um dos carros abaixo para deletar");
        List<Carro> carroList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s")) {
            dao.delete(carroList.get(index));
        }
    }
}
