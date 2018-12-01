package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Pessoa;
import fatec.poo.model.Aluno;
import fatec.poo.model.Instrutor;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoPessoa {
    private Connection connection;
    
    public DaoPessoa (Connection connection){
        this.connection = connection;
    }
    
    public void inserir (Pessoa pessoa){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO poo_Pessoa (cpf, nome, dataNasc, endereco, numero, bairro, cidade, estado, " +
                    "cep, telefone, celular, sexo, estadoCivil, rg, email) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getDataNasc());
            ps.setString(4, pessoa.getEndereco());
            ps.setInt(5, pessoa.getNumero());
            ps.setString(6, pessoa.getBairro());
            ps.setString(7, pessoa.getCidade());
            ps.setString(8, pessoa.getEstado());
            ps.setString(9, pessoa.getCep());
            ps.setString(10, pessoa.getTelefone());
            ps.setString(11, pessoa.getCelular());
            ps.setString(12, pessoa.getSexo());
            ps.setString(13, pessoa.getEstadoCivil());
            ps.setString(14, pessoa.getRg());
            ps.setString(15, pessoa.getEmail());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Pessoa pessoa){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE poo_Pessoa SET nome = ?, dataNasc = ?, endereco = ?, numero = ?, bairro = ?, " +
                    "cidade = ?, estado = ?, cep = ?, telefone = ?, celular = ?, sexo = ?, estadoCivil = ?, rg = ?, " +
                    "email = ? WHERE cpf = ?"); 
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getDataNasc());
            ps.setString(3, pessoa.getEndereco());
            ps.setInt(4, pessoa.getNumero());
            ps.setString(5, pessoa.getBairro());
            ps.setString(6, pessoa.getCidade());
            ps.setString(7, pessoa.getEstado());
            ps.setString(8, pessoa.getCep());
            ps.setString(9, pessoa.getTelefone());
            ps.setString(10, pessoa.getCelular());
            ps.setString(11, pessoa.getSexo());
            ps.setString(12, pessoa.getEstadoCivil());
            ps.setString(13, pessoa.getRg());
            ps.setString(14, pessoa.getEmail());
            ps.setString(15, pessoa.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Pessoa consultar (String cpf, String tipo){
        Pessoa pessoa = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM poo_Pessoa WHERE cpf = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                if ("aluno".equals(tipo))
                    pessoa = new Aluno(rs.getString("nome"), cpf);
                else
                    pessoa = new Instrutor(rs.getString("nome"), cpf);
                pessoa.setDataNasc(rs.getString("dataNasc"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setNumero(rs.getInt("numero"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setEstadoCivil(rs.getString("estadoCivil"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) { 
             System.out.println(ex.toString());
        }
        return pessoa;
    }
    
    public void excluir(Pessoa pessoa){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM poo_Pessoa WHERE cpf = ?");
            ps.setString(1, pessoa.getCpf());
            ps.execute();
        } catch (SQLException ex) { 
             System.out.println(ex.toString());
        }
    }
}
