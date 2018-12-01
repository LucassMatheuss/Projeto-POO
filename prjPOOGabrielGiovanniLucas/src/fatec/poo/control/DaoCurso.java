package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Curso;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoCurso {
    Connection connection = null;

    public DaoCurso(Connection connection) {
        this.connection = connection;
    }
    
    public void inserir (Curso curso){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO POO_CURSO(sigla, nome, cargaHoraria, "
                    + "valor, dataVigencia, valorHoraInstrutor, programa) VALUES(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getNome());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setDouble(4, curso.getValor());
            ps.setString(5, curso.getDataVigencia());
            ps.setDouble(6, curso.getValorHoraInstrutor());
            ps.setString(7, curso.getPrograma());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar (Curso curso){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE POO_CURSO SET nome = ?, cargaHoraria = ?, valor = ?, "
                    + "dataVigencia = ?, valorHoraInstrutor = ?, programa = ? WHERE sigla = ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.setDouble(3, curso.getValor());
            ps.setString(4, curso.getDataVigencia());
            ps.setDouble(5, curso.getValorHoraInstrutor());
            ps.setString(6, curso.getPrograma());
            ps.setString(7, curso.getSigla());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Curso consultar (String sigla){
        Curso curso = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM POO_CURSO where sigla = ?" );
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                curso = new Curso(sigla, rs.getString("nome"));
                curso.setCargaHoraria(rs.getInt("cargaHoraria"));
                curso.setValor(rs.getDouble("valor"));
                curso.setDataVigencia(rs.getString("dataVigencia"));
                curso.setValorHoraInstrutor(rs.getDouble("valorHoraInstrutor"));
                curso.setPrograma(rs.getString("programa"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return curso;
    }
    
    public void excluir (Curso curso){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM POO_CURSO WHERE sigla = ?");
            ps.setString(1, curso.getSigla());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public ArrayList<Curso> listar () {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM POO_CURSO");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Curso curso = new Curso(rs.getString("sigla"), rs.getString("nome"));
                curso.setCargaHoraria(rs.getInt("cargaHoraria"));
                curso.setValor(rs.getDouble("valor"));
                curso.setDataVigencia(rs.getString("dataVigencia"));
                curso.setValorHoraInstrutor(rs.getDouble("valorHoraInstrutor"));
                curso.setPrograma(rs.getString("programa"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cursos;
    }
}
