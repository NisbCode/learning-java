package br.com.abc.javacore.ZZBjdbc;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/***
 * USO DO RowSet
 * É uma espécie de derivado da classe RowSet, no qual é
 * mais fácil de se trabalhar
 * Há dois tipos: o que faz as mudanças no banco com
 * atualização remota e o salva os dados em memória para
 * edição para depois atualizá-los
 * Contudo, não suporta o uso de update, delete e insert
 */

public class ConexaoFactoryRowSet {
    public static Connection getConexao (){
        String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String password = "jeonjeonggukisagodF@ck";


        try {
            Connection conexao = DriverManager.getConnection(url, usuario, password);
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // A classe Connection pede pra fechar com return
        return null;
    }

    public static JdbcRowSet getRowSetConnection (){                    // relaxAutoComit: para usar o acceptChanges() no
                                                                        // CachedRowSet
        String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC&relaxAutoCommit=true";
        String usuario = "root";
        String password = "jeonjeonggukisagodF@ck";

        try {
            // Para criar um objeto JdbcRowSet
            JdbcRowSet jdbcRowSet =  RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(usuario);
            jdbcRowSet.setPassword(password);

            return jdbcRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // A classe Connection pede pra fechar com return
        return null;
    }

    public static CachedRowSet getRowSetConnectionCached (){
        String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String password = "jeonjeonggukisagodF@ck";

        try {
            // Para criar um objeto JdbcRowSet
            CachedRowSet cashedRowSet =  RowSetProvider.newFactory().createCachedRowSet();
            cashedRowSet.setUrl(url);
            cashedRowSet.setUsername(usuario);
            cashedRowSet.setPassword(password);

            return cashedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // A classe Connection pede pra fechar com return
        return null;
    }


    // Método para encerrar a conexão e lidar com os tratamentos
    // (adaptado ao modo RowSet)
    public static void close(RowSet jrs){

        try {
            // Se usar chave no if aqui, vai dar erro, cuidado
            if (jrs != null)
                jrs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
