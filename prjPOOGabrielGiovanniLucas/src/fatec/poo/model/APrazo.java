package fatec.poo.model;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class APrazo {

    private int codigoPagamento;
    private double Valor;
    private String DtVencimento;
    private double TaxaJuros;
    private int QtdeMensalidade;

    public APrazo(int codigoPagamento) {
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

    public String getDtVencimento() {
        return DtVencimento;
    }

    public void setDtVencimento(String DtVencimento) {
        this.DtVencimento = DtVencimento;
    }

    public double getTaxaJuros() {
        return TaxaJuros;
    }

    public void setTaxaJuros(double TaxaJuros) {
        this.TaxaJuros = TaxaJuros;
    }

    public int getQtdeMensalidade() {
        return QtdeMensalidade;
    }

    public void setQtdeMensalidade(int QtdeMensalidade) {
        this.QtdeMensalidade = QtdeMensalidade;
    }
}
