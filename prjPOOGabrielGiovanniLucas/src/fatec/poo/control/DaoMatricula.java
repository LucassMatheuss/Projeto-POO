package fatec.poo.control;

import fatec.poo.model.APrazo;
import fatec.poo.model.Aluno;
import fatec.poo.model.Matricula;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoMatricula {
    private Connection connection;
    
    public DaoMatricula(Connection connection) {
        this.connection = connection;
    }
    
    public void inserir(Matricula matricula){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO POO_MATRICULA (cpfAluno, siglaTurma, codPagamentoVista, "
                    + "codPagamentoPrazo, dataMatricula, qtdeFaltas, nota) VALUES (?, ?, ?, ?, ?, 0, 0)");
            ps.setString(1, matricula.getAluno().getCpf());
            ps.setString(2, matricula.getTurma().getSiglaTurma());
            if (matricula.getCodPagamentoVista() == 0){
                ps.setNull(3, 0);
                ps.setInt(4, matricula.getCodPagamentoPrazo());
            } else{
                ps.setInt(3, matricula.getCodPagamentoVista());
                ps.setNull(4, 0);
            }
            ps.setString(5, matricula.getData());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar (Matricula matricula){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE POO_MATRICULA SET siglaTurma = ?, codPagamentoVista = ?, "
                    + "codPagamentoPrazo = ?, dataMatricula = ?, WHERE cpfAluno = ?");
            ps.setString(1, matricula.getTurma().getSiglaTurma());
            if (matricula.getCodPagamentoVista() == 0){
                ps.setNull(2, 0);
                ps.setInt(3, matricula.getCodPagamentoPrazo());
            } else{
                ps.setInt(2, matricula.getCodPagamentoVista());
                ps.setNull(3, 0);
            }
            ps.setString(4, matricula.getData());
            ps.setString(5, matricula.getAluno().getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Matricula consultar (String cpfAluno){
        PreparedStatement ps = null;
        Matricula matricula = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM POO_MATRICULA WHERE cpfAluno = ?");
            ps.setString(1, cpfAluno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                matricula = new Matricula(rs.getString("dataMatricula"));
                matricula.setAluno(new DaoAluno(connection).consultar(cpfAluno));
                matricula.setTurma(new DaoTurma(connection).consultar(rs.getString("siglaTurma")));
                if (rs.getString("codPagamentoVista") != null && !rs.wasNull())
                    matricula.setCodPagamentoVista(rs.getInt("codPagamentoVista"));
                else 
                    matricula.setCodPagamentoPrazo(rs.getInt("codPagamentoPrazo"));
                matricula.setQtdeFaltas(rs.getInt("qtdeFaltas"));
                matricula.setNota(rs.getDouble("nota"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return matricula;
    }
}
