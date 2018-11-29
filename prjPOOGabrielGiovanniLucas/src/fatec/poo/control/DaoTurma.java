package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Curso;
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
            ps = connection.prepareStatement("INSERT INTO poo_Turma (siglaTurma, nome, dataInicio, "
                    + "dataTermino, periodo, qtdeVagas, siglaCurso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getNome());
            ps.setString(3, turma.getDataInicio());
            ps.setString(4, turma.getDataTermino());
            ps.setString(5, turma.getPeriodo());
            ps.setInt(6, turma.getQtdeVagas());
            ps.setString(7, turma.getCurso().getSigla());
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
    
    public Turma consultar (String siglaTurma){
        Turma turma = null;
        Curso curso = null;
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
                turma.setObservacoes(rs.getString("observacoes"));
                turma.setQtdeVagas(rs.getInt("qtdeVagas"));
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
    
    //PARTE NOVA TRAB 4
    
    public ArrayList<String> listar (Curso curso) {
        ArrayList<String> Turmas = new ArrayList<>();
        PreparedStatement ps = null;
        try {//Verificar se funciona essa Query para listar o nome da turma relacionada ao curso)
            ps = connection.prepareStatement("SELECT Sigla FROM poo_Turma WHERE siglaCurso = ? ");
            ps.setString(1, curso.getSigla());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Turmas.add(rs.getString("Sigla"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Turmas;
    }
    
    
    
}
