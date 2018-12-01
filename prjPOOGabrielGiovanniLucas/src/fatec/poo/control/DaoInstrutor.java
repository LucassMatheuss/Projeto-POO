package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Pessoa;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoInstrutor {
    private Connection connection;
    private DaoPessoa dp;
    
    public DaoInstrutor (Connection connection){
        this.connection = connection;
        dp = new DaoPessoa(connection);
    }
    
    public void inserir (Instrutor Instrutor){
        PreparedStatement ps = null;
        try {
            dp.inserir((Pessoa)Instrutor);
            ps = connection.prepareStatement("INSERT INTO POO_INSTRUTOR (cpfInstrutor, formacao, areaAtuacao) " +
                    "VALUES(?, ?, ?)");
            ps.setString(1, Instrutor.getCpf());
            ps.setString(2, Instrutor.getFormacao());
            ps.setString(3, Instrutor.getAreaAtuacao());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Instrutor Instrutor){
        PreparedStatement ps = null;
        try {
            dp.alterar(Instrutor);
            ps = connection.prepareStatement("UPDATE POO_INSTRUTOR SET formacao = ?, areaAtuacao = ? WHERE cpfInstrutor = ?"); 
            ps.setString(1, Instrutor.getFormacao());
            ps.setString(2, Instrutor.getAreaAtuacao());
            ps.setString(3, Instrutor.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Instrutor consultar (String cpf){
        Instrutor Instrutor = null;
        PreparedStatement ps = null;
        try {
            Instrutor = (Instrutor)dp.consultar(cpf, "Instrutor");
            ps = connection.prepareStatement("SELECT * FROM POO_INSTRUTOR WHERE cpfInstrutor = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Instrutor.setFormacao(rs.getString("formacao"));
                Instrutor.setAreaAtuacao(rs.getString("areaAtuacao"));
            }
        } catch (SQLException ex) { 
             System.out.println(ex.toString());
        }
        return Instrutor;
    }
    
    public void excluir(Instrutor Instrutor) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM POO_INSTRUTOR WHERE cpfInstrutor = ?");
            ps.setString(1, Instrutor.getCpf());
            ps.execute();
            dp.excluir(Instrutor);
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
    }
    
    public ArrayList<Instrutor> listar () {
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT nome, POO_INSTRUTOR.cpfInstrutor FROM POO_PESSOA, "
                    + "POO_INSTRUTOR WHERE POO_PESSOA.cpf = POO_INSTRUTOR.cpfInstrutor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                instrutores.add(new Instrutor (rs.getString("nome"),rs.getString("cpfInstrutor")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return instrutores;
    }
}
