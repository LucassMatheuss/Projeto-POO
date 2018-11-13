package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Aluno;
import fatec.poo.model.Pessoa;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoAluno {
    private Connection connection;
    private DaoPessoa dp;
    
    public DaoAluno (Connection connection){
        this.connection = connection;
        dp = new DaoPessoa(connection);
    }
    
    public void inserir (Aluno aluno){
        PreparedStatement ps = null;
        try {
            dp.inserir((Pessoa)aluno);
            ps = connection.prepareStatement("INSERT INTO poo_Aluno (cpf, escolaridade) " +
                    "VALUES(?, ?)");
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getEscolaridade());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Aluno aluno){
        PreparedStatement ps = null;
        try {
            dp.alterar(aluno);
            ps = connection.prepareStatement("UPDATE poo_Aluno SET escolaridade = ? WHERE cpf = ?"); 
            ps.setString(1, aluno.getEscolaridade());
            ps.setString(2, aluno.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Aluno consultar (String cpf){
        Aluno aluno = null;
        PreparedStatement ps = null;
        try {
            aluno = (Aluno)dp.consultar(cpf, "aluno");
            ps = connection.prepareStatement("SELECT * FROM poo_Aluno WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                aluno.setEscolaridade(rs.getString("escolaridade"));
                //aluno.setMatricula(DaoMatricula.Carregar(aluno));
            }
        } catch (SQLException ex) { 
             System.out.println(ex.toString());
        }
        return aluno;
    }
    
    public void excluir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            //Desnecessário caso o a chave primária da tabela Pessoa esteja configurada como cascade em caso de exclusão.
            //Inicio
            ps = connection.prepareStatement("DELETE FROM poo_Aluno WHERE cpf = ?");
            ps.setString(1, aluno.getCpf());
            ps.execute();
            //Fim
            dp.excluir(aluno);
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
}
