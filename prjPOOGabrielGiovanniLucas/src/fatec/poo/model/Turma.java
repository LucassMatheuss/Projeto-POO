package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Turma {

    private String siglaTurma, nome, dataInicio,
            dataTermino, periodo, observacoes;
    private int qtdeVagas;
    private Instrutor instrutor;
    private ArrayList<Matricula> matriculas;
    private Curso curso;

    public Turma(String siglaTurma, String nome) {
        this.siglaTurma = siglaTurma;
        this.nome = nome;
        matriculas = new ArrayList<Matricula>();
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getQtdeVagas() {
        return qtdeVagas;
    }

    public void setQtdeVagas(int qtdeVagas) {
        this.qtdeVagas = qtdeVagas;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public void addMatricula(Matricula m) {
        matriculas.add(m);
        m.setTurma(this);
    }

    public void emitirListaFrequencia() {
        return;
    }

    //Setar o Curso
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }
}
