package fatec.poo.model;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Curso {
    private String Sigla;
    private String Nome;
    private int CargaHoraria;
    private double Valor;
    private String DataVigencia;
    private double ValorHoraInstrutor;
    private String Programa;
    private ArrayList<Turma> Turmas;

    //Construtor
    
    public Curso(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
        Turmas = new ArrayList<Turma>();
    }

    
    //SETS
    
    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setDataVigencia(String DataVigencia) {
        this.DataVigencia = DataVigencia;
    }

    public void setValorHoraInstrutor(double ValorHoraInstrutor) {
        this.ValorHoraInstrutor = ValorHoraInstrutor;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }

    
    //GETS
    
    public String getSigla() {
        return Sigla;
    }

    public String getNome() {
        return Nome;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public double getValor() {
        return Valor;
    }

    public String getDataVigencia() {
        return DataVigencia;
    }

    public double getValorHoraInstrutor() {
        return ValorHoraInstrutor;
    }

    public String getPrograma() {
        return Programa;
    }
    
    //ADD para turmas
    
    public void addTurmas(Turma t){
        Turmas.add(t);
        t.setCurso(this);
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
}
