package br.com.abc.javacore.ZZBjdbc;

import java.sql.*;

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
    public static Connection getConexao (){
        // Para obter a conexao, 3 coisas são necessárias:
        // uma url, um usuário e um password

        // Cada banco de dados tem uma url especifica que pode
        // ser encontrada na sua documentação
        // No mysql é jdbc:banco_de_dados://endereço_do_banco:porta/nome_do_banco
                                                        // adaptar ao horario brasileiro de verão
        String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        // senha no mysql
        String password = "jeonjeonggukisagodF@ck";

        // Agora pegar a conexao (dentro de um tratamento de exceções)
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, password);
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // A classe Connection pede pra fechar com return
        return null;
    }

    // Método para encerrar a conexão e lidar com os tratamentos
    public static void close(Connection connection){

        try {
            // Se usar chave no if aqui, vai dar erro, cuidado
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    // Sobrecarga para lidar com statements também
    public static void close (Connection connection, Statement statement){
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
    public static void close (Connection connection, Statement statement, ResultSet resultSet){
        close(connection, statement);
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
