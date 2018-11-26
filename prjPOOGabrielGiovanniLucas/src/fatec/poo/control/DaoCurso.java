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
            ps = connection.prepareStatement("INSERT INTO poo_Curso(sigla, nome, cargaHoraria, "
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
            ps = connection.prepareStatement("UPDATE poo_Curso SET nome = ?, cargaHoraria = ?, valor = ?, "
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
            ps = connection.prepareStatement("SELECT * FROM poo_Curso where sigla = ?" );
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
    
    public ArrayList<String> listar () {
        ArrayList<String> cursos = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT sigla FROM poo_Curso");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cursos.add(rs.getString("sigla"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cursos;
    }
    
    public void excluir (Curso curso){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM poo_Curso WHERE sigla = ?");
            ps.setString(1, curso.getSigla());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
