package br.com.abc.javacore.ZZCjdbc.conn;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * Created by William Suane on 9/19/2016.
 */
public class ConexaoFactory {
    //java.sql = Connection, Statement, ResultSet
    //DriverManager
    public static Connection getConexao() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
        String user = "root";
        String password = "root";
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
        String user = "root";
        String password = "root";
        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static CachedRowSet getRowSetConnectionCached() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false&relaxAutoCommit=true";
        String user = "root";
        String password = "root";
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(RowSet jrs) {
        try {
            if (jrs != null)
                jrs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stmt) {
        close(connection);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stmt, ResultSet rs) {
        close(connection, stmt);
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}













//Basicamente é dever da empresa MySQL ou demais, fazerem com que o banco de dados funfre
//Porém, p agt conseguir se conectar a ela, eles criaram 3 interfaces, as q vamos trabalhar

/***
 * JDBC: pacote criado para abstrair o desenvolvedor
 * dos problemas do banco de dados, para tal, é necessário
 * aprender sobre as interfaces do pacote java.sql
 * As 3 interfaces principais são:
 *   Connection, que gera a conexão da interface com o banco
 *   de dados
 *   Statemant, para realizar operações que mudam o estado do
 *   banco
 *   ResultSet, similar ao select, trabalha com os resultados
 *   das consultas
 * A conexão vem através da classe DriverManager, que busca o conector
 * específico de um banco e devolve ao desenvolvedor
 */

public class ConexaoFactory {
    public static Connection getConexao() {  //static pq a conexão é a msm n importando as vezes chamadas, e tb pq n usa nenhuma atrib de classe
        // Para obter a conexao, 3 coisas são necessárias:
        // uma url, um usuário e um password

        // Cada banco de dados tem uma url especifica que pode
        // ser encontrada na sua documentação
        // No mysql é jdbc:banco_de_dados://endereço_do_banco(localhost em inglês):porta/nome_do_banco
        // adaptar ao horario brasileiro de verão
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
//        Para usar parâmetros numa URL use "?"

        String usuario = "root";

        // senha no mysql
        String password = "bank";

        // Agora pegar a conexao (dentro de um tratamento de exceções)
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, password);
//            System.out.println(conexao);
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // A classe Connection pede pra fechar com return
        return null;
    }

    public static JdbcRowSet getRowSetConnection() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC";
        String user = " root";
        String password = "bank";
        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CachedRowSet getRowSetConnectionCached() {
        String url = "jdbc:mysql://localhost/agencia?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC&relaxAutoCommit=true"; //&relaxAutoCommit=true
        String user = " root";
        String password = "bank";
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            return cachedRowSet;        //Isso vai ser sempre o retornado acima no public... Se lá é Cached, aq tb
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(RowSet jrs) {
        try {
            if (jrs != null)
                jrs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para encerrar a conexão e lidar com os tratamentos
    public static void close(Connection connection) {

        try {
            // Se usar chave no if aqui, vai dar erro, cuidado
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sobrecarga para lidar com statements também
    public static void close(Connection connection, Statement statement) {
        close(connection);
        try {
            // Se usar chave no if aqui, vai dar erro, cuidado
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sobrecarga para lidar com coisas relacionadas ao resultSet
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection, statement);
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


