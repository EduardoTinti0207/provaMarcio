package app;

import dao.FuncionarioDAO;
import dao.ProjetoDAO;
import model.Funcionario;
import model.Projeto;

public class Main {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        Funcionario f = new Funcionario();
        f.setId(1); // Pessoa já cadastrada
        f.setMatricula("F001");
        f.setDepartamento("TI");
        funcionarioDAO.adicionarFuncionario(f);

        Projeto p = new Projeto();
        p.setNome("Sistema Interno");
        p.setDescricao("Desenvolvimento de sistema de gestão.");
        p.setIdFuncionario(1);
        projetoDAO.adicionarProjeto(p);
    }
}