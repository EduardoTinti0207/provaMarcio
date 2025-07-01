package dao;

import java.sql.*;
import connection.ConnectionFactory;
import model.Projeto;

public class ProjetoDAO {

    public boolean adicionarProjeto(Projeto projeto) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement check = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
            check.setInt(1, projeto.getIdFuncionario());
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Erro: Funcionário não encontrado para vínculo com projeto.");
                return false;
            }

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO projeto (nome, descricao, id_funcionario) VALUES (?, ?, ?)");
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getIdFuncionario());
            stmt.executeUpdate();

            System.out.println("Projeto cadastrado com sucesso.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}