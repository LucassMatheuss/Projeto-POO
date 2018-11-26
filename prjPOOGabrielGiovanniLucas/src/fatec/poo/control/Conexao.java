package fatec.poo.control;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Conexao {
    private String connectionString, driver, usuario, senha;
    private Connection connection = null;

    public Conexao(String usuario, String senha) {   
        this.usuario = usuario;
        this.senha = senha;   
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
   
    public Connection conectar() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(connectionString, usuario, senha);               
                System.out.println("Conexão estabelecida");
            } catch (Exception ex) {
                System.out.println("Falha na conexao:\n" + ex.toString() + 
                                    ex.getMessage());
            }
        }
        return connection;
    }
   
    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());    
            }
        }   
    }
}