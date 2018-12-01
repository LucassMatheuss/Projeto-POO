package fatec.poo.model;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class AVista {

    private int codigoPagamento;
    private double Valor;
    private int Agencia;
    private int Ncheque;
    private String PreData;

    public AVista(int codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public int getCodigoPagamento() {
        return codigoPagamento;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public int getAgencia() {
        return Agencia;
    }

    public void setAgencia(int Agencia) {
        this.Agencia = Agencia;
    }

    public int getNcheque() {
        return Ncheque;
    }

    public void setNcheque(int Ncheque) {
        this.Ncheque = Ncheque;
    }

    public String getPreData() {
        return PreData;
    }

    public void setPreData(String PreData) {
        this.PreData = PreData;
    }

}
