package fatec.poo.model;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class APrazo {
    
    private double Valor;
    private String DtVencimento;
    private double TaxaJuros;
    private int QtdeMensalidade;

    
    //Sets
    
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setDtVencimento(String DtVencimento) {
        this.DtVencimento = DtVencimento;
    }

    public void setTaxaJuros(double TaxaJuros) { //Recebe em Porcentagem portanto divide por 100
        this.TaxaJuros = (TaxaJuros/100);
    }

    public void setQtdeMensalidade(int QtdeMensalidade) {
        this.QtdeMensalidade = QtdeMensalidade;
    }

    
    
    //GETS
    
    public double getValor() {
        return Valor;
    }

    public String getDtVencimento() {
        return DtVencimento;
    }

    public double getTaxaJuros() {
        return TaxaJuros;
    }

    public int getQtdeMensalidade() {
        return QtdeMensalidade;
    }
}
