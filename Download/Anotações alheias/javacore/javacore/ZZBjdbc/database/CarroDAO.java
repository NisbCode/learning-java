package br.com.abc.javacore.ZZBjdbc.database;

import br.com.abc.javacore.ZZBjdbc.ConexaoFactory;
import br.com.abc.javacore.ZZBjdbc.classes.Carro;
import br.com.abc.javacore.ZZBjdbc.classes.Comprador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    public static void save(Carro carro) {
        String sql = "INSERT INTO agencia.carro (nome, placa, comprador_id) VALUES ( ?, ?, ? );";
        // usar o TryWithResources para fechar automaticamente
        // a conexão
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, carro.getNome());
            ps.setString(2, carro.getPlaca());
            ps.setInt(3, carro.getComprador().getId());
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível excluir o registro");
            return;
        }
        String sql = "DELETE FROM agencia.carro WHERE id = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, carro.getId());
            ps.executeUpdate();
            System.out.println("Registro excluído com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("Não foi possível atualizar o registro");
            return;
        }
        String sql = "UPDATE agencia.comprador SET nome = ?, placa = ?, WHERE id = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, carro.getNome());
            ps.setString(2, carro.getPlaca());
            ps.setInt(3, carro.getId());
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> selectAll() {
        String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro";
        List<Carro> carroList = new ArrayList<>();
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery(sql)) {
            while (resultSet.next()) {
                Comprador c = CompradorDAO.searchById((resultSet.getInt("comprador_id")));
                carroList.add(new Carro(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("placa"), c));

            }
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Carro> searchByName(String nome) {
        String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro WHERE nome LIKE ?;";
        List<Carro> carroList = new ArrayList<>();
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comprador c = CompradorDAO.searchById(rs.getInt("comprador_id"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));
            }
            ConexaoFactory.close(conn, ps, rs);
            return carroList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
