package dao;

import java.sql.*;
import connection.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDAO {

    public boolean adicionarFuncionario(Funcionario funcionario) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement check = conn.prepareStatement("SELECT * FROM pessoa WHERE id = ?");
            check.setInt(1, funcionario.getId());
            ResultSet rs = check.executeQuery();
            if (!rs.next()) {
                System.out.println("Erro: Pessoa com ID " + funcionario.getId() + " não encontrada.");
                return false;
            }

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO funcionario (id, matricula, departamento) VALUES (?, ?, ?)");
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getMatricula());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.executeUpdate();

            System.out.println("Funcionário cadastrado com sucesso.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}