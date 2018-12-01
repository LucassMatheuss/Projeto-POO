package fatec.poo.control;

import fatec.poo.model.APrazo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class DaoAPrazo {

    private Connection connection;

    public DaoAPrazo(Connection connection) {
        this.connection = connection;
    }

    public void inserir(APrazo aprazo) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO POO_APRAZO (codPagamento, valor, dtVencimento, "
                    + "taxaJuros, QtdeMensalidade) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, aprazo.getCodigoPagamento());
            ps.setDouble(2, aprazo.getValor());
            ps.setString(3, aprazo.getDtVencimento());
            ps.setDouble(4, aprazo.getTaxaJuros());
            ps.setInt(5, aprazo.getQtdeMensalidade());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(APrazo aprazo) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE POO_APRAZO SET valor = ?, dataVencimento = ?, "
                    + "taxaJuros = ?, qtdeMensalidade = ? WHERE codPagamento = ?");
            ps.setDouble(1, aprazo.getValor());
            ps.setString(2, aprazo.getDtVencimento());
            ps.setDouble(3, aprazo.getTaxaJuros());
            ps.setInt(4, aprazo.getQtdeMensalidade());
            ps.setInt(5, aprazo.getCodigoPagamento());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public APrazo consultar(int codigoPagamento) {
        PreparedStatement ps = null;
        APrazo aprazo = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM POO_APRAZO WHERE codPagamento = ?");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aprazo = new APrazo(codigoPagamento);
                aprazo.setValor(rs.getDouble("valor"));
                aprazo.setDtVencimento(rs.getString("dtVencimento"));
                aprazo.setTaxaJuros(rs.getDouble("taxaJuros"));
                aprazo.setQtdeMensalidade(rs.getInt("qtdeMensalidade"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return aprazo;
    }
    
    public int getProxCod(){
        PreparedStatement ps = null;
        int cod = 1;
        try {
            ps = connection.prepareStatement("SELECT TOP 1 codPagamento FROM POO_APRAZO ORDER BY codPagamento DESC");
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
