package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.db.CompradorDBOLD;

import java.util.List;

/**
 * Created by William Suane on 9/19/2016.
 */
public class TesteConexao {
    public static void main(String[] args) {
//        deletar();
//        atualizar();
//        List<Comprador> listaComprador = selecionarTudo();
//        List<Comprador> listaComprador2 = buscarPorNome("oao");
//        System.out.println(listaComprador);
//        System.out.println(listaComprador2);
//        CompradorDB.selectMetaData();
//        CompradorDB.checkDriverStatus();
//        CompradorDB.testTypeScroll();
//        CompradorDB.updateNomesToLowerCase();
//        System.out.println(CompradorDB.searchByNamePreparedStatement("oao"));
//        CompradorDB.updatePreparedStatement(new Comprador(1,"011.011.011-01", "Prepared Statement da Silva"));
//        System.out.println(CompradorDB.searchByNameCallableStatement("%oao%"));
//        System.out.println(CompradorDB.searchByNameRowSet("oao"));
//        CompradorDB.updateRowSet(new Comprador(1,"011.011.011-01", "Prepared Statement da Silva"));
        CompradorDBOLD.updateRowSetCached(new Comprador(1,"011.011.011-01", "Prepared Statement da Silva"));

    }


    public static void inserir() {
        Comprador comprador = new Comprador("111.111.111-22", "Priscila");
        CompradorDBOLD.save(comprador);
    }

    public static void deletar() {
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDBOLD.delete(comprador);
    }

    public static void atualizar() {
        Comprador comprador = new Comprador(1, "MARIA", "000.000.000-11");
        CompradorDBOLD.update(comprador);
    }

    public static List<Comprador> selecionarTudo() {
        return CompradorDBOLD.selectAll();
    }

    public static List<Comprador> buscarPorNome(String nome) {
        return CompradorDBOLD.searchByName(nome);
    }
}








public class TesteConexao {
    public static void main(String[] args) {
////      Para inserir:
//        inserir();


////      Para deletar:
//        deletar();


////      Para atualizar:
//        atualizar();


//        // Para mostrar a conexão:
//        ConexaoFactory mostrarConexao = new ConexaoFactory();
//        mostrarConexao.getConexao();


////        Connection conexaoTeste = ConexaoFactory. getConexao();
////
////        // LEMBRETE: de primeira ele não vai encontrar o drive
////        // externo dentro da lib, deve-se configurar isso nas opções do intellij


////         SELECT * FROM no java (Para mostrar a lista)
//        List<Comprador> listaComprador = selecionarTudo();
//        System.out.println(listaComprador);
//

//         //LIKE no java
//        List<Comprador> buscandoPedacoNome = procurarPeloNome("ma");
//        System.out.println(buscandoPedacoNome);


//        // Exibir os metadados, como nome ou numero de colunas
//        CompradorDBOLD.selectMetaData();
//

//        // Checar o suporte de sentido de leitura dos dados
//        CompradorDBOLD.checkDriverStatus();
//

//         //Testar os sentidos de leitura
//        CompradorDBOLD.testTypeScroll();


//        // Teste de update com o ResultSet
//        CompradorDBOLD.updateNomesToLowerCase();


//        // searchByName com menos gastos nos dados
//        System.out.println(CompradorDBOLD.searchByNamePreparedStatement("oao"));


//        // SearchByName usando uma procedure
//        System.out.println(CompradorDBOLD.searchByNameCallableStatement("ari"));

        // SearchByName versão RowSet
        System.out.println(CompradorDBOLD.searchByNameRowSet("oao"));

//
//        // SA MERDA TA DANDO ERRO PQ A JDK ATUALIZOU, IGNORA POR ORA
////        CompradorDBOLD.updateRowSet(new Comprador(1, "111.111.111-11", "William"));

//         //Merma merda do anterior, mas esse funciona e ainda fecha
//         //a conexão sozin <3
//        CompradorDBOLD.updateRowSetCached(new Comprador(1, "111.111.111-11", "William"));

//
//        // Transação
////        CompradorDBOLD.saveTransaction();
//
    }
    // Escolha um método para executar no main e divirta-se :)


    public static void inserir(){
        Comprador inserirCompradorPriscila = new Comprador("111.111.111-12", "Priscila ");
        CompradorDBOLD compradorDB = new CompradorDBOLD();
        compradorDB.save(inserirCompradorPriscila); //vai retornar o numero de linhas alteradas
    }

    public static void deletar(){
        Comprador comprador = new Comprador();
        comprador.setId(2);
        CompradorDBOLD.delete(comprador);
    }

    public static void atualizar(){
        Comprador comprador = new Comprador(1, "000.000.000-11", "MARIA");
        CompradorDBOLD.update(comprador);
    }

    public static List<Comprador> selecionarTudo(){
        return CompradorDBOLD.selectAll();
    }

    public static List<Comprador> procurarPeloNome(String nome){
        return CompradorDBOLD.searchByName(nome);
    }
}


