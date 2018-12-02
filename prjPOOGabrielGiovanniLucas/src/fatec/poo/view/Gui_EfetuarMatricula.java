package fatec.poo.view;

import fatec.poo.control.Conexao;
import fatec.poo.control.DaoAPrazo;
import fatec.poo.control.DaoAVista;
import fatec.poo.control.DaoAluno;
import fatec.poo.control.DaoCurso;
import fatec.poo.control.DaoInstrutor;
import fatec.poo.control.DaoMatricula;
import fatec.poo.control.DaoTurma;
import fatec.poo.model.APrazo;
import fatec.poo.model.AVista;
import fatec.poo.model.Aluno;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Matricula;
import fatec.poo.model.Pessoa;
import fatec.poo.model.Turma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Pillan, Giovanni Garcia, Lucas Matheus
 */
public class Gui_EfetuarMatricula extends javax.swing.JFrame {

    /**
     * Creates new form Gui_EfetuarMatricula
     */
    public Gui_EfetuarMatricula() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jftxtDataMatricula = new javax.swing.JFormattedTextField();
        jftxtCPF = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        cmbCurso = new javax.swing.JComboBox<>();
        cmbTurma = new javax.swing.JComboBox<>();
        pnlPagamento = new javax.swing.JPanel();
        rbAvista = new javax.swing.JRadioButton();
        rbAprazo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        txtCheque = new javax.swing.JTextField();
        ftxtDataPagamento = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMensalidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTaxaJuros = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ftxtDataVencimento = new javax.swing.JFormattedTextField();
        btnConsultar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Efetuar Matricula");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Data da Matricula");

        jLabel2.setText("Curso");

        jLabel3.setText("Turma");

        jLabel4.setText("CPF Aluno");

        jLabel5.setText("Valor");

        jLabel6.setText("Nome");

        try {
            jftxtDataMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jftxtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftxtCPF.setEnabled(false);

        txtValor.setEditable(false);
        txtValor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtValor.setEnabled(false);

        txtNome.setEditable(false);
        txtNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNome.setEnabled(false);

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        pnlPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        buttonGroup1.add(rbAvista);
        rbAvista.setText("A Vista");
        rbAvista.setEnabled(false);
        rbAvista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAvistaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAprazo);
        rbAprazo.setText("A Prazo");
        rbAprazo.setEnabled(false);
        rbAprazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAprazoActionPerformed(evt);
            }
        });

        jLabel7.setText("Agencia");

        jLabel8.setText("No. Cheque");

        jLabel9.setText("Data Pagamento");

        txtAgencia.setEnabled(false);

        txtCheque.setEnabled(false);

        try {
            ftxtDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataPagamento.setEnabled(false);

        jLabel10.setText("Qtde. Mensalidades");

        txtMensalidade.setEnabled(false);

        jLabel11.setText("Tx. Juros(%)");

        txtTaxaJuros.setEnabled(false);

        jLabel12.setText("Data 1o. Vencimento");

        try {
            ftxtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataVencimento.setEnabled(false);

        javax.swing.GroupLayout pnlPagamentoLayout = new javax.swing.GroupLayout(pnlPagamento);
        pnlPagamento.setLayout(pnlPagamentoLayout);
        pnlPagamentoLayout.setHorizontalGroup(
            pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAvista)
                    .addComponent(rbAprazo))
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPagamentoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaxaJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ftxtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPagamentoLayout.setVerticalGroup(
            pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAvista)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbAprazo)
                        .addComponent(txtMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtTaxaJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(ftxtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.setEnabled(false);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(149, Short.MAX_VALUE)
                        .addComponent(btnConsultar)
                        .addGap(30, 30, 30)
                        .addComponent(btnInserir)
                        .addGap(27, 27, 27)
                        .addComponent(btnAlterar)
                        .addGap(28, 28, 28)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(27, 27, 27)
                                        .addComponent(jftxtDataMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jftxtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(46, 46, 46))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnConsultar, btnExcluir, btnInserir, btnSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jftxtDataMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jftxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(pnlPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void rbAvistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAvistaActionPerformed
        txtAgencia.setEnabled(true);
        txtCheque.setEnabled(true);
        ftxtDataPagamento.setEnabled(true);
        txtMensalidade.setEnabled(false);
        txtTaxaJuros.setEnabled(false);
        ftxtDataVencimento.setEnabled(false);
    }//GEN-LAST:event_rbAvistaActionPerformed

    private void rbAprazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAprazoActionPerformed
        txtAgencia.setEnabled(false);
        txtCheque.setEnabled(false);
        ftxtDataPagamento.setEnabled(false);
        txtMensalidade.setEnabled(true);
        txtTaxaJuros.setEnabled(true);
        ftxtDataVencimento.setEnabled(true);
    }//GEN-LAST:event_rbAprazoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String cpf = jftxtCPF.getText().replace(".", "").replace("-", "");
        cpf = cpf.replaceAll("\\D", "");
        if (!Pessoa.validarCPF(cpf)) {
            try {
                throw new Exception("CPF é inválido!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else { //é válido
            aluno = null;
            matricula = null;
            matricula = daoMatricula.consultar(jftxtCPF.getText().replace(".", "").replace("-", ""));
            if (matricula == null) {
                aluno = daoAluno.consultar(jftxtCPF.getText().replace(".", "").replace("-", ""));
                txtNome.setText(aluno.getNome());
            }else{
                jftxtDataMatricula.setText(matricula.getData());
                //arrayCursos.indexOf(matricula)
                //txtValor.setText(matricula.get);
                //cmbTurma.setText(matricula.getTurma());
                
            }

        }

        if (aluno == null) {
            btnConsultar.setEnabled(false);
            btnInserir.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }

        txtNome.setEnabled(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        ArrayList<String> arrayTurma = daoTurma.listar((String) cmbCurso.getSelectedItem()); // Lista a Turma baseada no Curso Escolhido
        cmbTurma.removeAllItems();
        for (int i = 0; i < arrayTurma.size(); i++) {
            cmbTurma.addItem(arrayTurma.get(i));
        }
        turma = daoTurma.consultar((String) cmbTurma.getSelectedItem());

        jftxtCPF.setEnabled(true);
        rbAvista.setEnabled(true);
        rbAprazo.setEnabled(true);
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conexao = new Conexao("LucasM", "familiacorrea");
        //conexao = new Conexao("BD1711015", "BD1711015");
        //conexao = new Conexao("ZickkyG", "Gigio2025");
        conexao.setDriver("oracle.jdbc.driver.OracleDriver");
        //conexao.setConnectionString("jdbc:oracle:thin:@apolo:1521:xe");
        conexao.setConnectionString("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        daoCurso = new DaoCurso(conexao.conectar());
        daoTurma = new DaoTurma(conexao.conectar());
        daoAVista = new DaoAVista(conexao.conectar());
        daoAPrazo = new DaoAPrazo(conexao.conectar());
        daoAluno = new DaoAluno(conexao.conectar());

        arrayCursos = daoCurso.listar();
        for (int i = 0; i < arrayCursos.size(); i++) {
            cmbCurso.addItem(arrayCursos.get(i).getSigla());
        }

        txtValor.setText(Double.toString(arrayCursos.get(cmbCurso.getSelectedIndex()).getValor()));

        ArrayList<String> arrayTurma = daoTurma.listar((String) cmbCurso.getSelectedItem());
        for (int i = 0; i < arrayTurma.size(); i++) {
            cmbTurma.addItem(arrayTurma.get(i));
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Alteração?") == 0) {
            //daoMatricula.excluir(matricula);
            //daoAVista.excluir(Avista);
            //daoAPrazo.excluir(Aprazo);   

            jftxtDataMatricula.setText("");
            txtValor.setText("");
            jftxtCPF.setText("");
            txtNome.setText("");
            txtAgencia.setText("");
            txtCheque.setText("");
            ftxtDataPagamento.setText("");
            txtMensalidade.setText("");
            txtTaxaJuros.setText("");
            ftxtDataVencimento.setText("");

            jftxtDataMatricula.setEnabled(true);
            cmbCurso.setEnabled(true);
            cmbTurma.setEnabled(true);
            jftxtCPF.setEnabled(false);
            txtNome.setEnabled(false);
            txtAgencia.setEnabled(false);
            txtCheque.setEnabled(false);
            ftxtDataPagamento.setEnabled(false);
            txtMensalidade.setEnabled(false);
            txtTaxaJuros.setEnabled(false);
            ftxtDataVencimento.setEnabled(false);

            btnConsultar.setEnabled(true);
            btnInserir.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Alteração?") == 0) {

            matricula.setData(jftxtDataMatricula.getText());
            Avista.setValor(Double.valueOf(txtValor.getText()));
            Avista.setAgencia(Integer.valueOf(txtAgencia.getText()));
            Avista.setNcheque(Integer.valueOf(txtCheque.getText()));
            Avista.setPreData(ftxtDataPagamento.getText());
            Aprazo.setDtVencimento(ftxtDataVencimento.getText());
            Aprazo.setQtdeMensalidade(Integer.valueOf(txtMensalidade.getText()));
            Aprazo.setTaxaJuros(Double.valueOf(txtTaxaJuros.getText()));
            Aprazo.setValor(Double.valueOf(txtValor.getText()));

            jftxtDataMatricula.setText("");
            txtValor.setText("");
            jftxtCPF.setText("");
            txtNome.setText("");
            txtAgencia.setText("");
            txtCheque.setText("");
            ftxtDataPagamento.setText("");
            txtMensalidade.setText("");
            txtTaxaJuros.setText("");
            ftxtDataVencimento.setText("");

            jftxtDataMatricula.setEnabled(true);
            cmbCurso.setEnabled(true);
            cmbTurma.setEnabled(true);
            jftxtCPF.setEnabled(false);
            txtNome.setEnabled(false);
            txtAgencia.setEnabled(false);
            txtCheque.setEnabled(false);
            ftxtDataPagamento.setEnabled(false);
            txtMensalidade.setEnabled(false);
            txtTaxaJuros.setEnabled(false);
            ftxtDataVencimento.setEnabled(false);

            btnConsultar.setEnabled(true);
            btnInserir.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);

            daoMatricula.alterar(matricula);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Avista = new AVista(daoAVista.getProxCod());
        Aprazo = new APrazo(daoAPrazo.getProxCod());
        matricula = new Matricula(jftxtDataMatricula.getText());

        matricula.setData(jftxtDataMatricula.getText());
        Avista.setValor(Double.valueOf(txtValor.getText()));
        Avista.setAgencia(Integer.valueOf(txtAgencia.getText()));
        Avista.setNcheque(Integer.valueOf(txtCheque.getText()));
        Avista.setPreData(ftxtDataPagamento.getText());
        Aprazo.setDtVencimento(ftxtDataVencimento.getText());
        Aprazo.setQtdeMensalidade(Integer.valueOf(txtMensalidade.getText()));
        Aprazo.setTaxaJuros(Double.valueOf(txtTaxaJuros.getText()));
        Aprazo.setValor(Double.valueOf(txtValor.getText()));

        daoMatricula.inserir(matricula);
        daoAPrazo.inserir(Aprazo);
        daoAVista.inserir(Avista);

        jftxtDataMatricula.setText("");
        txtValor.setText("");
        jftxtCPF.setText("");
        txtNome.setText("");
        txtAgencia.setText("");
        txtCheque.setText("");
        ftxtDataPagamento.setText("");
        txtMensalidade.setText("");
        txtTaxaJuros.setText("");
        ftxtDataVencimento.setText("");

        btnInserir.setEnabled(false);

        jftxtDataMatricula.setEnabled(true);
        cmbCurso.setEnabled(true);
        cmbTurma.setEnabled(true);
        jftxtCPF.setEnabled(false);
        txtNome.setEnabled(false);
        txtAgencia.setEnabled(false);
        txtCheque.setEnabled(false);
        ftxtDataPagamento.setEnabled(false);
        txtMensalidade.setEnabled(false);
        txtTaxaJuros.setEnabled(false);
        ftxtDataVencimento.setEnabled(false);

        btnConsultar.setEnabled(true);


    }//GEN-LAST:event_btnInserirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_EfetuarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_EfetuarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_EfetuarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_EfetuarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_EfetuarMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbTurma;
    private javax.swing.JFormattedTextField ftxtDataPagamento;
    private javax.swing.JFormattedTextField ftxtDataVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField jftxtCPF;
    private javax.swing.JFormattedTextField jftxtDataMatricula;
    private javax.swing.JPanel pnlPagamento;
    private javax.swing.JRadioButton rbAprazo;
    private javax.swing.JRadioButton rbAvista;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtMensalidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTaxaJuros;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
private Conexao conexao = null;
    private DaoCurso daoCurso = null;
    private DaoInstrutor daoInstrutor = null;
    private DaoTurma daoTurma = null;
    private AVista Avista = null;
    private APrazo Aprazo = null;
    private Aluno aluno = null;
    private Matricula matricula = null;
    private DaoMatricula daoMatricula = null;
    private DaoAluno daoAluno = null;
    private DaoAVista daoAVista = null;
    private DaoAPrazo daoAPrazo = null;
    private Curso curso = null;
    private Turma turma = null;
    private ArrayList<Curso> arrayCursos;
}
