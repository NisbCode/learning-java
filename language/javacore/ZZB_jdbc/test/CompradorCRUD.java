package Estudando.javacore.ZZB_jdbc.test;


import Estudando.javacore.ZZB_jdbc.classe.Comprador;
import Estudando.javacore.ZZB_jdbc.database.CompradorDAO;


import java.util.List;
import java.util.Scanner;

public class CompradorCRUD {
    private static Scanner teclado = new Scanner(System.in);

    public static void executar(int op) {   //São pra fazer os casos do teste funcionar
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
        Comprador c = new Comprador();
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("CPF: ");
        c.setCpf(teclado.nextLine());
        CompradorDAO.save(c);
    }

    private static void atualizar() {
        System.out.println("Selecione um dos compradores abaixo");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = teclado.nextLine();
        System.out.println("Novo cpf ou enter para manter o mesmo");
        String cpf = teclado.nextLine();
        if (!nome.isEmpty()) {  //Se o nome não for vazio
            c.setNome(nome);
        }
        if (!cpf.isEmpty()) {
            c.setCpf(cpf);
        }
        CompradorDAO.update(c);
    }

    protected static List<Comprador> listar() {   //Possibilite de retornar a lista
        List<Comprador> compradorList = CompradorDAO.selectAll();//Lista da class Comprador recebe o método selectAll da class CompradorDao
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
//                              Obs: por algum motivo, os nomes estão no cpf
//                              e os cpfs estão no nome, ignore isso por ora
            System.out.println("[" + i + "]" + c.getCpf() + " " + c.getNome());
        }
        return compradorList;  //Retorne a lista pra q agt possa usar ela dps p att
    }

    private static void procurarPorNome(String nome) {
        List<Comprador> compradorList = CompradorDAO.searchByName(nome);
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
//                              Obs: por algum motivo, os nomes estão no cpf
//                              e os cpfs estão no nome, ignore isso por ora
            System.out.println("[" + i + "]" + c.getCpf() + c.getNome());
        }

    }

    public static void deletar(){
        System.out.println("Selecione um dos compradores abaixo para deletar");
        List<Comprador> compradorList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if(op.startsWith("s")){
            CompradorDAO.delete(compradorList.get(index));
        }
    }
}
