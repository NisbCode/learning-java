package Estudando.javacore.ZZB_jdbc.database;


import Estudando.javacore.ZZB_jdbc.classe.Comprador;
import Estudando.javacore.ZZB_jdbc.ConexaoFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***
 * CLASSE CompradorDBOLD otimizada e trabalhada no try-with-resources com PreparedStatement
 */

public class CompradorDAO {
    // Adaptando todos os métodos para o PreparedStatement
    public static void save(Comprador comprador) {
        String sql = "INSERT INTO agencia.comprador (cpf, nome) VALUES ( ?, ? );";
        // usar o TryWithResources para fechar automaticamente
        // a conexão
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM agencia.comprador WHERE id = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, comprador.getId());
            ps.executeUpdate();
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE agencia.comprador SET cpf = ?, nome = ? WHERE id = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comprador.getCpf());
            ps.setString(2, comprador.getNome());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comprador> selectAll() {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador";
        List<Comprador> compradorList = new ArrayList<>();
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery(sql)) {
            while (resultSet.next()) {
                // "... pegue ou o id (columnIndex, que sempre começa em 1) desejado ou o nome (columnLabel) da coluna desejada,
                // depende do que o desenvolvedor vai inserir"
                compradorList.add(new Comprador(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf")));

            }
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Comprador> searchByName(String nome) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE ?;";
        List<Comprador> compradorList = new ArrayList<>();
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }
            ConexaoFactory.close(conn, ps, rs);  //O try-with-resources vai tentar fechar, se já tiver ele vai só ignorar
            return compradorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Comprador searchById(Integer id) {
        String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE id LIKE ?;";
        Comprador comprador = null;
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comprador = (new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }
            ConexaoFactory.close(conn, ps, rs);
            return comprador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
