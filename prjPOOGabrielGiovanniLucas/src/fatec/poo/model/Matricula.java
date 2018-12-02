package fatec.poo.model;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Matricula {

    private String data;
    private int qtdeFaltas, codPagamentoVista, codPagamentoPrazo;
    private double nota;
    private Aluno aluno;
    private Turma turma;

    public Matricula(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }

    public int getQtdeFaltas() {
        return qtdeFaltas;
    }

    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }
    
    public int getCodPagamentoVista() {
        return codPagamentoVista;
    }

    public void setCodPagamentoVista(int codPagamentoVista) {
        this.codPagamentoVista = codPagamentoVista;
    }

    public int getCodPagamentoPrazo() {
        return codPagamentoPrazo;
    }

    public void setCodPagamentoPrazo(int codPagamentoPrazo) {
        this.codPagamentoPrazo = codPagamentoPrazo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void emitirCarne() {
        return;
    }
}
