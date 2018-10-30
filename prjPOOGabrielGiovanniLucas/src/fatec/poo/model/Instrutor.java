package fatec.poo.model;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Instrutor extends Pessoa{
    private String formacao, areaAtuacao;
    private ArrayList<Turma>turmas;

    public Instrutor(String nome, String cpf) {
        super(nome, cpf);
        turmas = new ArrayList<Turma>(); 
    }
    
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
    public void addTurma(Turma t){
        turmas.add(t);
        t.setInstrutor(this);
    }
}
