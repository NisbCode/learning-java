package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Comprador;
import br.com.abc.javacore.ZZCjdbc.classes.MyRowSetListener;
import br.com.abc.javacore.ZZCjdbc.conn.ConexaoFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by William Suane on 9/19/2016.
 */
public class CompradorDBOLD {
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "')";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransaction() throws SQLException {
        String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE1', 'TESTE1')";
        String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE2', 'TESTE2')";
        String sql3 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('TESTE3', 'TESTE3')";
        Connection conn = ConexaoFactory.getConexao();
        Savepoint savepoint = null;
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            savepoint = conn.setSavepoint("One");
            stmt.executeUpdate(sql2);
            if (true)
                throw new SQLException();
            stmt.executeUpdate(sql3);
            conn.commit();
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback(savepoint);
            conn.commit();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel excluir o registro");
            return;
        }
        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id`='" + comprador.getId() + "'";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro excluido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf`='" + comprador.getCpf() + "', `nome`='" + comprador.getNome() + "' WHERE `id`='" + comprador.getId() + "'";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf`= ?, `nome`= ? WHERE `id`= ? ";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();
            ConexaoFactory.close(conn, ps);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel atualizar o registro");
            return;
        }
//        String sql = "UPDATE `agencia`.`comprador` SET `cpf`= ?, `nome`= ? WHERE `id`= ? ";
        String sql = "SELECT * FROM comprador where id = ?";
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
        jrs.addRowSetListener(new MyRowSetListener());
        try {
            jrs.setCommand(sql);
//            jrs.setString(1, comprador.getCpf());
//            jrs.setString(2, comprador.getNome());
            jrs.setInt(1, comprador.getId());
            jrs.execute();
            jrs.next();
            jrs.updateString("nome", "WILLIAM");
            jrs.updateRow();
            ConexaoFactory.close(jrs);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateRowSetCached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel atualizar o registro");
            return;
        }
        String sql = "SELECT * FROM comprador where id = ?";
        CachedRowSet crs = ConexaoFactory.getRowSetConnectionCached();
        try {
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();
            crs.next();
            crs.updateString("nome", "WWW");
            crs.updateRow();
            Thread.sleep(8000);
            crs.acceptChanges();
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByName(String nome) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like '%" + nome + "%'";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(conn, stmt, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Comprador> searchByNamePreparedStatement(String nome) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(conn, ps, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> searchByNameRowSet(String nome) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
        jrs.addRowSetListener(new MyRowSetListener());
        List<Comprador> compradorList = new ArrayList<>();
        try { 
            jrs.setCommand(sql);
            jrs.setString(1, "%" + nome + "%");
            jrs.execute();
            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("cpf"), jrs.getString("nome")));
            }
            ConexaoFactory.close(jrs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Comprador> searchByNameCallableStatement(String nome) {
        String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`( ? )";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, "%" + nome + "%");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }
            ConexaoFactory.close(conn, cs, rs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void selectMetaData() {
        String sql = "SELECT * FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            int qtdColunas = rsmd.getColumnCount();
            System.out.println("Quantidades coluna: " + qtdColunas);
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("tabela: " + rsmd.getTableName(i));
                System.out.println("Nome coluna: " + rsmd.getColumnName(i));
                System.out.println("Tamanho coluna " + rsmd.getColumnDisplaySize(i));
            }
            ConexaoFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus() {
        Connection conn = ConexaoFactory.getConexao();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e tambÃ©m suporta CONCUR_UPDATABLE");
                }
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e tambÃ©m suporta CONCUR_UPDATABLE");
                }
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e tambÃ©m suporta CONCUR_UPDATABLE");
                }
            }
            ConexaoFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testTypeScroll() {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.last()) {
                System.out.println("Ultima linha " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
                System.out.println("Numero ultima linha: " + rs.getRow());
            }
            System.out.println("retornou para a primeira linha " + rs.first());
            System.out.println("Primeira linha: " + rs.getRow());
            rs.absolute(4);
            System.out.println("Linha 4 " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            rs.relative(-1);
            System.out.println("Linha 3 " + new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            System.out.println(rs.isLast());
            System.out.println(rs.isFirst());
            rs.afterLast();
            System.out.println("-----------");
            while (rs.previous()) {
                System.out.println(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
            }

            ConexaoFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNomesToLowerCase() {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        Connection conn = ConexaoFactory.getConexao();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.println(dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

            if (rs.next()) {
                rs.updateString("nome", rs.getString("nome").toUpperCase());

//                rs.cancelRowUpdates();
                rs.updateRow();
//                if(rs.rowUpdated()){
//                    System.out.println("Linha atualizada");
//                }

            }
            rs.absolute(2);
            String nome = rs.getString("nome");
            rs.moveToInsertRow();
            rs.updateString("nome", nome.toUpperCase());
            rs.updateString("cpf", "999.999.999-99");
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println(rs.getString("nome") + " row" + rs.getRow());
            rs.absolute(7);
            rs.deleteRow();


            ConexaoFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






package Estudando.javacore.ZZB_jdbc.database;


import Estudando.javacore.ZZB_jdbc.classe.Comprador;
import Estudando.javacore.ZZB_jdbc.ConexaoFactory;
import Estudando.javacore.ZZB_jdbc.classe.MyRowSetListener;



import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ADICIONANDO DADOS A UMA TABELA COM JAVA
 */

public class CompradorDBOLD {
    public static void save(Comprador comprador) {
        // INSERT INTO no java
        String insertInto = "INSERT INTO agencia.comprador (cpf, nome) VALUES ('" + comprador.getNome() + "', '" + comprador.getCpf() + "');";
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            // Dentro da classe Statement temos vários tipos
            // de execute:
            //   executeUpdate: usado para ações que mudam
            //   o estado da tabela (Update, Delete e Alter)
            //   execute: é usado quando o desenvolvedor não
            //   sabe o que vai fazer de primeira
            //   executeQuery: para fazer consulta
            System.out.println(stmt.executeUpdate(insertInto));
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    // Transações: conjuntos de instruções que devem ser feitas
//    // em bloco para funcionar, ou todas funcionam ou nenhuma
//    // funciona
//    public static void saveTransaction() {
//        String insertInto = "INSERT INTO agencia.comprador (cpf, nome) VALUES ('TESTE1', 'TESTE1');";
//        String insertInto2 = "INSERT INTO agencia.comprador (cpf, nome) VALUES ('TESTE2', 'TESTE2');";
//        String insertInto3 = "INSERT INTO agencia.comprador (cpf, nome) VALUES ('TESTE3', 'TESTE3');";
//        // conectar o java com o banco de dados
//        Connection conn = ConexaoFactory.getConexao();
//        // Adicionando savepoint, para o caso de querer salvar
//        // certos dados da transação
//        Savepoint savepoint = null;
//        try {
//            // Desativando o AutoCommit, que faz com que as instruções
//            // sejam executadas linha a linha
//            conn.setAutoCommit(false);
//            Statement stmt = conn.createStatement();
//            // Então, inserir os dados no banco
//            stmt.executeUpdate(insertInto);
//            stmt.executeUpdate(insertInto2);
//            savepoint = conn.setSavepoint("One");
//            // Simulando erro dentro da transação
//            if(true)
//                throw new SQLException();
//            stmt.executeUpdate(insertInto3);
//            // E por ultimo, alterar o estado do banco
//            conn.commit();
//            ConexaoFactory.close(conn, stmt);
//            System.out.println("Registro inserido com sucesso");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Caso dê erro na transação, para mostrar
//            // onde o banco deve voltar, baseado num savepoint
//            try {
//                conn.rollback(savepoint);
//                // agora pra voltar pro momento do savepoint
//                conn.commit();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }

    public static void delete(Comprador comprador) {
        // DELETE no java
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String delete = "DELETE FROM agencia.comprador WHERE id = '" + comprador.getId() + "';";
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(delete));
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        // UPDATE no java
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String update = "UPDATE agencia.comprador SET cpf = '" + comprador.getCpf() + "', nome = '" + comprador.getNome() + "' WHERE id = '" + comprador.getId() + "';";
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(update));
            ConexaoFactory.close(conn, stmt);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePreparedStatement(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("NÃ£o foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE `agencia`.`comprador` SET `cpf`= ?, `nome`= ? WHERE `id`= ? ";
        Connection conn = ConexaoFactory.getConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();
            ConexaoFactory.close(conn, ps);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Fazer um update de dados usando RowSet
    public static void updateRowSet (Comprador comprador) {
        if (comprador == null || comprador.getId() == null ){
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        // primeiro ce da um SELECT
        String sql = "SELECT * FROM comprador WHERE id = ?"; //Já q n dá p vc att, então vc primeiro procura ele
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
        try {
            // Vc dá o comando do sql p o BD
            jrs.setCommand(sql);
            // Substitui o wildcard
            jrs.setInt(1, comprador.getId());
            // Executa o comando pq ele precisa de ter os dados salvos na JdbcResultSet
            jrs.execute();
            // Anda pra primeira posição
            jrs.next();
            // Vc substitui pelo oq quer
            jrs.updateString("nome", "William");
            // agr vc atualiza a linha inteira dentro do MySQL
            jrs.updateRow();
            ConexaoFactory.close(jrs);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // CachedRowSet: fecha a conexão automaticamente
    public static void updateRowSetCached (Comprador comprador) {
        if (comprador == null || comprador.getId() == null ){
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "SELECT * FROM comprador WHERE id = ?";
        CachedRowSet crs = ConexaoFactory.getRowSetConnectionCached();
        try {
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();
            crs.next();
            crs.updateString("nome", "WILLIAM");
            crs.updateRow();
            // ainda tem fazAlgumaCoisa pra aceitar as mudanças
            // ó que lindo
            Thread.sleep(8000);
            crs.acceptChanges();
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException | InterruptedException e){
            e.printStackTrace();
        }
    }


//    Traz uma lista de compradores
    public static List<Comprador> selectAll() {
        // SELECT * FROM no java
        String selectAllFrom = "SELECT id, nome, cpf FROM agencia.comprador";
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            // Introduzindo a classe ResultSet
            ResultSet resultSet = stmt.executeQuery(selectAllFrom);
            // Para pegar os dados: "Enquanto o resultSet tiver algum proximo item..."
            while (resultSet.next()) {
                // "... pegue ou o id (columnIndex, que sempre começa em 1) desejado ou o nome (columnLabel) da coluna desejada,
                // depende do que o desenvolvedor vai inserir"
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));

            }
            ConexaoFactory.close(conn, stmt, resultSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    Procura Compradores
    public static List<Comprador> searchByName(String nome) {
        // LIKE no java, para buscar por pedaços de palavras (especificamente no nome, aqui)
        String selectAllFrom = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE '%" + nome + "%';"; //% é símbolo do MySQL dentro dele vc põe sua busca
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            // Introduzindo a classe ResultSet
            ResultSet resultSet = stmt.executeQuery(selectAllFrom);
            // Para pegar os dados: "Enquanto o resultSet tiver algum proximo item..."
            while (resultSet.next()) {
                // "... pegue ou o id (columnIndex, que sempre começa em 1) desejado ou o nome (columnLabel) da coluna desejada,
                // depende do que o desenvolvedor vai inserir"
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf")));

            }
            ConexaoFactory.close(conn, stmt, resultSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // PreparedStatement: classe filha da classe Statement que melhora a performance da
    // conversão java-sql (Tipo String e StringBuilder)
    public static List<Comprador> searchByNamePreparedStatement(String nome) {
        // A sintaxe no PreparedStatement muda
        // Wildcard: um valor que está em
        // aberto para ser substituído por um dado adicionado posteriormente    Nesse caso tamos falando de "?"
        String selectAllFrom = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {
            // E agora o sql não é mais criado, é preparado
            PreparedStatement ps = conn.prepareStatement(selectAllFrom);
            // Settar a informação que vem no lugar do wildcard (?)
            // baseado no seu tipo (como é nome, uma string nesse caso)
            // Nos parametros, colocar qual wildcard deve ser substituido
            // (1, se só tiver um) e o valor de substituição
            ps.setString(1, "%" + nome + "%");
            // ResultSet sem parametro, nesse caso
            ResultSet resultSet = ps.executeQuery();
            // Para pegar os dados: "Enquanto o resultSet tiver algum proximo item..."
            while (resultSet.next()) {
                // "... pegue ou o id (columnIndex, que sempre começa em 1) desejado ou o nome (columnLabel) da coluna desejada,
                // depende do que o desenvolvedor vai inserir"
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf")));

            }
            ConexaoFactory.close(conn, ps, resultSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // SearchByName com a interface RowSet
    public static List<Comprador> searchByNameRowSet(String nome) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        // Lembrando: aqui não usamos a classe ConexaoFactory,
        // e sim a ConexaoFactoryRowSet (fiz outra pra não poluir demais)
        JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
        jrs.addRowSetListener(new MyRowSetListener());
        List<Comprador> compradorList = new ArrayList<>();
        try {
            // método setCommand(): serve para mandar as instruções
            // para o banco
            jrs.setCommand(sql);
            jrs.setString(1, "%" + nome + "%");
            // método execute(): usado para executar as mudanças feitas
            jrs.execute();
            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("nome"), jrs.getString("cpf")));

            }
            ConexaoFactory.close(jrs);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // CallableStatement: classe filha de Statement, serve para chamar
    // procedures do SQL (coisa que eu n sei exatamente o que
    // é, então melhor perguntar a Rully)
    public static List<Comprador> searchByNameCallableStatement(String nome) {
        String sql = "CALL `agencia`.`SP_GetCompradoresPorNome`( ? );";

        Connection conn = ConexaoFactory.getConexao();
        List<Comprador> compradorList = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall(sql);

            cs.setString(1, "%" + nome + "%");
            // ResultSet sem parametro, nesse caso
            ResultSet resultSet = cs.executeQuery();
            // Para pegar os dados: "Enquanto o resultSet tiver algum proximo item..."
            while (resultSet.next()) {
                // "... pegue ou o id (columnIndex, que sempre começa em 1) desejado ou o nome (columnLabel) da coluna desejada,
                // depende do que o desenvolvedor vai inserir"
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf")));

            }
            ConexaoFactory.close(conn, cs, resultSet);
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Para pegar metadados (Ou seja, quantidade de colunas, nome delas, etc)
    public static void selectMetaData() {
        String sql = "SELECT * FROM agencia.comprador;";
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            // Método para contagem de colunas
            int qtdColunas = rsmd.getColumnCount();
            System.out.println("Quantidade de colunas: " + qtdColunas);
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("tabela: " + rsmd.getTableName(i));
                System.out.println("Nome da coluna: " + rsmd.getColumnName(i));
                System.out.println("Tamanho da coluna: " + rsmd.getColumnDisplaySize(i));
            }

            ConexaoFactory.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Suportes do Drives: método para checar informações do ResultSet quanto ao sentido dos dados
    public static void checkDriverStatus() {
        Connection conn = ConexaoFactory.getConexao();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            // TYPE_FOWARD_ONLY: tipo do ResultSet, com leitura de informações de
            // cima pra baixo (suportado)
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("O ResultSet suporta o status TYPE_FOWARD_ONLY");
                //CONCUR_UPDATABLE: checa se o registro pode ser atualizado automaticamente com o ResultSet aberto (É basicamente um subtipo, pq c forward
                //Pode ser só leitura ou atuatizar c ele aberto, isso td aq é só uma constant da constant TYPE_FORWARD_ONLY
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) ;
                System.out.println("e também suporta o status CONCUR_UPDATABLE");
            }

            // TYPE_SCROLL_INSENSITIVE: a leitura pode ir pra frente, pra tras,
            // começar de um ponto especifico, mas qualquer mudança no banco
            // não afetará esse ResultSet enquanto ele tiver aberto
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("O ResultSet suporta o status TYPE_SCROLL_INSENSITIVE");
                //CONCUR_UPDATABLE: checa se o registro pode ser atualizado automaticamente com o ResultSet aberto
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) ;
                System.out.println("e também suporta o status CONCUR_UPDATABLE");

                // Nesse ambiente de desenvolvimento, apenas esse tipo é suportado
            }

            // TYPE_SCROLL_SENSITIVE: a leitura pode ir pra frente, pra tras,
            // começar de um ponto especifico, e qualquer mudança no banco
            // afetará esse ResultSet enquanto ele tiver aberto e as mudanças serão
            // notadas no objeto
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("O ResultSet suporta o status TYPE_SCROLL_SENSITIVE");
                //CONCUR_UPDATABLE: checa se o registro pode ser atualizado automaticamente com o ResultSet aberto
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) ;
                System.out.println("e também suporta o status CONCUR_UPDATABLE");
            }
            ConexaoFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Agora os métodos que, de fato, mexem com a alteração do sentido
    // da leitura dos dados  (Ele vai mover uma espécime de cursor invisível p a linha q vc mandar e receber o valor daquela linha[Número, nome, etc])
    public static void testTypeScroll() {
        String selectAllFrom = "SELECT id, nome, cpf FROM agencia.comprador";

        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //Isso pq dependendo o driver ele pode suportar outros
            ResultSet resultSet = stmt.executeQuery(selectAllFrom);

            // Para ir com o cursor, a referencia, até a ultima linha da tabela
            if (resultSet.last()) {
                System.out.println("Última linha: " + new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
                System.out.println("Numero ultima linha: " + resultSet.getRow());
            }

            // Para voltar até a primeira linha
            System.out.println("De volta à primeira linha?: " + resultSet.first()); //Ele retorna um boolean
            System.out.println("Numero da linha atual: " + resultSet.getRow());     //P mostrar onde ele tá agr

            // ou, também tem o método absolute(), que vai pra linha que tu quiser
            System.out.println("Linha 4 com o absolute?: " + resultSet.absolute(4));
            System.out.println("Numero da linha atual: " + resultSet.getRow());

            // método relative(): vai pra linha que voce quiser baseado na que você ja está
            System.out.println("O relative mudou a linha: " + resultSet.relative(-1));
            System.out.println("Numero da linha atual: " + resultSet.getRow());

            // Para checar a posição sem mover
            System.out.println("Está na primeira linha: " + resultSet.isFirst());
            System.out.println("Está na última linha: " + resultSet.isLast());

            // Para inverter a ordem da qual a tabela é exibida levando em conta a posição do cursor
            System.out.println("--------------------");
            while (resultSet.previous()) {
                System.out.println(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }

            // Para inverter a ordem da tabela
            System.out.println("--------------------");
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println(new Comprador(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("nome")));
            }

            ConexaoFactory.close(conn, stmt, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Update com uso do ResultSet
    public static void updateNomesToLowerCase() {
        // SELECT * FROM no java
        String selectAllFrom = "SELECT id, nome, cpf FROM agencia.comprador";
        // conectar o java com o banco de dados
        Connection conn = ConexaoFactory.getConexao();
        try {
            // é importante ter o atributo do tipo do ResultSet e se é atualizavel ou n
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery(selectAllFrom);
            while (resultSet.next()) {

                // é aqui que atualiza o valor no banco, os parametros são
                // nome da coluna e o valor pra substituir
                resultSet.updateString("nome", resultSet.getString("nome").toLowerCase());

                // método cancelRowUpdates(): devido aos resultados do
                // updateString() não serem tão confiáveis ao ser chamados
                // 2 vezes ou mais, esse método cancela as alterações feitas
                // com update
                // Não adianta chamar depois do updateRow, porque dai
                // o banco j foi atualizado
                resultSet.cancelRowUpdates();

                // Agora é necessario atualizar no banco
                resultSet.updateRow();
            }
//
//             Agora que ja foi atualizado no banco, para checar
//             se foi atualizado no ResultSet
//             Código escrito aqui para mostrar como é escrito,
//             mas não funciona para o Driver usado aqui
        resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nome"));
            }

            // Agora pra fazer um INSERT com o ResultSet
            resultSet.absolute(2);
            String nome = resultSet.getString("nome");
            // método moveToInsertRow(): move o cursor para a linha que está
            // para ser criada e cria o espaço que vai receber a inserção
            resultSet.moveToInsertRow();
            resultSet.updateString("nome", nome.toUpperCase());
            resultSet.updateString("cpf", "999.999.999-99");
            // insere a linha
            resultSet.insertRow();
            // pra terminar, é necessário voltar o cursor para onde ele começou
            resultSet.moveToCurrentRow();
            System.out.println("row atual: " + resultSet.getRow());
            resultSet.absolute(7);
            resultSet.deleteRow();


            ConexaoFactory.close(conn, stmt, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


