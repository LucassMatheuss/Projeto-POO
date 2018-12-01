package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Turma;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoTurma {
    private Connection connection;
    
    public DaoTurma (Connection connection){
        this.connection = connection;
    }
    
    public void inserir (Turma turma){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO poo_Turma (siglaTurma, cpfInstrutor, siglaCurso, nome, "
                    + "dataInicio, dataTermino, periodo, qtdeVagas, observacoes) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, null);
            ps.setString(3, turma.getCurso().getSigla());
            ps.setString(4, turma.getNome());
            ps.setString(5, turma.getDataInicio());
            ps.setString(6, turma.getDataTermino());
            ps.setString(7, turma.getPeriodo());
            ps.setInt(8, turma.getQtdeVagas());
            ps.setString(9, null);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Turma turma){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE poo_Turma SET nome = ?, dataInicio = ?, "
                    + "dataTermino = ?, periodo = ?, qtdeVagas = ? WHERE siglaTurma = ?");
            ps.setString(1, turma.getNome());
            ps.setString(2, turma.getDataInicio());
            ps.setString(3, turma.getDataTermino());
            ps.setString(4, turma.getPeriodo());
            ps.setInt(5, turma.getQtdeVagas());
            ps.setString(6, turma.getSiglaTurma());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alocarInstrutor (String cpf , Turma turma){
    PreparedStatement ps = null;
    try {         
            ps = connection.prepareStatement("UPDATE poo_Turma SET cpfInstrutor = ? WHERE siglaTurma = ?");
            ps.setString(1, cpf);
            ps.setString(2, turma.getSiglaTurma()); 
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void desalocarInstrutor (String cpf , Turma turma){
    PreparedStatement ps = null;
    try {        
            ps = connection.prepareStatement("UPDATE poo_Turma SET cpfInstrutor = ? WHERE siglaTurma = ?");
            ps.setString(1, null);
            ps.setString(2, turma.getSiglaTurma()); 
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Turma consultar (String siglaTurma){
        Turma turma = null;
        Curso curso = null;
        Instrutor instrutor = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM poo_Turma WHERE siglaTurma = ?");
            ps.setString(1, siglaTurma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                turma = new Turma(siglaTurma, rs.getString("nome"));
                turma.setDataInicio(rs.getString("dataInicio"));
                turma.setDataTermino(rs.getString("dataTermino"));
                turma.setPeriodo(rs.getString("periodo"));
                turma.setQtdeVagas(rs.getInt("qtdeVagas"));
                turma.setObservacoes(rs.getString("observacoes"));
                instrutor = new DaoInstrutor(connection).consultar(rs.getString("cpfInstrutor"));
                turma.setInstrutor(instrutor);
                curso = new DaoCurso(connection).consultar(rs.getString("siglaCurso")); 
                curso.addTurmas(turma);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return turma;
    }
    
    public void excluir (Turma turma){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM poo_Turma WHERE siglaTurma = ?");
            ps.setString(1, turma.getSiglaTurma());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public ArrayList<String> listar (String curso) {
        ArrayList<String> Turmas = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT SiglaTurma FROM poo_Turma WHERE siglaCurso = ? ");
            ps.setString(1, curso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Turmas.add(rs.getString("SiglaTurma"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Turmas;
    }
}
