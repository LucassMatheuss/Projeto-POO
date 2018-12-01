package fatec.poo.control;

import fatec.poo.model.AVista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoAVista {
    private Connection connection;

    public DaoAVista(Connection connection) {
        this.connection = connection;
    }

    public void inserir(AVista avista) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO POO_APRAZO (codPagamento, valor, agencia, "
                    + "nCheque, preData) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, avista.getCodigoPagamento());
            ps.setDouble(2, avista.getValor());
            ps.setInt(3, avista.getAgencia());
            ps.setInt(4, avista.getNcheque());
            ps.setString(5, avista.getPreData());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(AVista avista) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE POO_AVISTA SET valor = ?, agencia = ?, nCheque = ?, "
                    + "preData = ? WHERE codPagamento = ?");
            ps.setDouble(1, avista.getValor());
            ps.setInt(2, avista.getAgencia());
            ps.setInt(3, avista.getNcheque());
            ps.setString(4, avista.getPreData());
            ps.setInt(5, avista.getCodigoPagamento());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public AVista consultar(int codigoPagamento) {
        PreparedStatement ps = null;
        AVista avista = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM POO_AVISTA WHERE codPagamento = ?");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                avista = new AVista(codigoPagamento);
                avista.setValor(rs.getDouble("valor"));
                avista.setAgencia(rs.getInt("agencia"));
                avista.setNcheque(rs.getInt("nCheque"));
                avista.setPreData(rs.getString("preData"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return avista;
    }
    
    public int getProxCod(){
        PreparedStatement ps = null;
        int cod = 1;
        try {
            ps = connection.prepareStatement("SELECT TOP 1 codPagamento FROM POO_AVISTA ORDER BY codPagamento DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cod += rs.getInt("codPagamento");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cod;
    }
}
