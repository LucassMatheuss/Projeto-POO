package fatec.poo.model;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class AVista {
    
    private double Valor;
    private int Agencia;
    private int Ncheque;
    private String PreData;
    
    
    //SETS

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setAgencia(int Agencia) {
        this.Agencia = Agencia;
    }

    public void setNcheque(int Ncheque) {
        this.Ncheque = Ncheque;
    }

    public void setPreData(String PreData) {
        this.PreData = PreData;
    }

    
    //GETS
    
    
    public double getValor() {
        return Valor;
    }

    public int getAgencia() {
        return Agencia;
    }

    public int getNcheque() {
        return Ncheque;
    }

    public String getPreData() {
        return PreData;
    }
    
    
    
    
}
