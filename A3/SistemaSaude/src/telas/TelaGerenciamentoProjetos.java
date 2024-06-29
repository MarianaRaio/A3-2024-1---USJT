/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.sql.Connection;
import conexaoBD.Projetos;
import java.util.List;
import javax.swing.JOptionPane;
import modelDAO.DAOfactory;
import modelDAO.ProjetosDAO;
import modelDAO.SubProjetoDAO;

/**
 *
 * @author Mariana Raio
 */
public class TelaGerenciamentoProjetos extends javax.swing.JFrame {

    ProjetosDAO projetos = DAOfactory.criarProjeto();
    SubProjetoDAO subprojeto = DAOfactory.criarSubProjeto();
    int id_projeto;
    int id_descricao;
    String permissao;
    String descricao_proj;
    

    /**
     * Creates new form TelaGerenciamentoProjetos
     */
    public TelaGerenciamentoProjetos(String permissao) {
        this.permissao = permissao;
        initComponents();
        preencherComboBox();

    }

    public TelaGerenciamentoProjetos(int id_projeto, int id_descricao, String permissao, String descricao_proj) {
        this.id_projeto = id_projeto;
        this.id_descricao = id_descricao;
        this.permissao = permissao;
        this.descricao_proj = descricao_proj;
        initComponents();
        preencherComboBox();
        atualizacaoComboBox();
    }
    public void atualizacaoComboBox() {
        
        String nome = projetos.listarNomeAtualiacao(id_projeto);
        comboBoxProjetos.setSelectedItem(nome);
        String nomeSubProjeto = subprojeto.listarNomeAtualiacao(id_descricao);
        ComboBoxSubProjeto.setSelectedItem(nomeSubProjeto);
        txtDescricao.setText(descricao_proj);
    }
    

    public TelaGerenciamentoProjetos() {
        initComponents();
    }

    public void preencherCampos(String item) {
        Projetos projeto = projetos.consultarPorNome(item);
        if (projeto != null) {
            txtId.setText(projeto.getId().toString());
            txtNome.setText(projeto.getNome());

        } else {
            txtId.setText("");
            txtNome.setText("");
            JOptionPane.showMessageDialog(this, "Projeto não encontrado!");
        }
    }

    public void preencherComboBox() {
        List<String> listaProjetos = projetos.listarNome();
        comboBoxProjetos.removeAllItems();
        comboBoxProjetos.addItem("Selecione");
        for (String projeto : listaProjetos) {
            comboBoxProjetos.addItem(projeto);
        }
        List<String> listaSubProjetos = subprojeto.listarDescricao();
        ComboBoxSubProjeto.removeAllItems();
        ComboBoxSubProjeto.addItem("Selecione");
        for (String subprojeto : listaSubProjetos) {
            ComboBoxSubProjeto.addItem(subprojeto);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comboBoxProjetos = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnMostrarProjetos = new javax.swing.JButton();
        ComboBoxSubProjeto = new javax.swing.JComboBox<>();
        btnAtualizar = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projetos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("PROJETOS (ODS)");

        comboBoxProjetos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "1 - Erradicação da Pobreza ", "2 - Fome Zero e Agricultura Sustentável", "3 - Saúde e Bem-Estar", "4 - Educação de Qualidade", "5 - Igualdade de Gênero", "6 - Água Potável e Saneamento", "7 - Energia Limpa e Acessível", "8 - Trabalho Decente e Crescimento Econômico", "9 - Indústria, Inovação e Infraestrutura", "10 - Redução das Desigualdades", "11 - Cidades e Comunidades Sustentáveis", "12 - Consumo e Produção Responsáveis", "13 - Ação Contra A Mudança Global Do Clima", "14 - Vida na Água", "15 - Vida Terrestre ", "16 - Paz, Justiça e Instituições Eficazes ", "17 - Parcerias e Meios de Implementação " }));
        comboBoxProjetos.setToolTipText("Selecione um projeto");
        comboBoxProjetos.setBorder(javax.swing.BorderFactory.createTitledBorder("Projeto: "));
        comboBoxProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProjetosActionPerformed(evt);
            }
        });

        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder("id:"));

        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome:"));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnMostrarProjetos.setText("MOSTRAR PROJETOS");
        btnMostrarProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProjetosActionPerformed(evt);
            }
        });

        ComboBoxSubProjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxSubProjeto.setToolTipText("Selecione um SubProjeto");
        ComboBoxSubProjeto.setBorder(javax.swing.BorderFactory.createTitledBorder("SubProjeto:"));

        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do projeto:"));
        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxProjetos, 0, 428, Short.MAX_VALUE)
                    .addComponent(ComboBoxSubProjeto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDescricao)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(comboBoxProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxSubProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarProjetos)
                    .addComponent(btnAtualizar))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProjetosActionPerformed
        ListagemProjeto listagem = new ListagemProjeto(permissao);
        listagem.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMostrarProjetosActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int id_projetos = Integer.parseInt(txtId.getText());
        int id_subprojetos = subprojeto.buscarId(ComboBoxSubProjeto.getSelectedItem().toString());
        
        double avaliacao = 0;
        if (permissao.equals("user")){
            avaliacao = Double.parseDouble(JOptionPane.showInputDialog("Dê uma avaliação para o projeto de 0 a 5!"));
        }
        
           
        String descricao_proj = txtDescricao.getText();
        projetos.inserir(id_subprojetos, id_projetos, avaliacao, descricao_proj);

        JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void comboBoxProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProjetosActionPerformed
        Object selectedItem = comboBoxProjetos.getSelectedItem();
        if (selectedItem != null && !selectedItem.toString().equals("Selecione")) {
            String item = selectedItem.toString();
            preencherCampos(item);
        } else {
            txtId.setText("");
            txtNome.setText("");

        }

    }//GEN-LAST:event_comboBoxProjetosActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int id_projeto_new = Integer.parseInt(txtId.getText());
        int id_subprojeto_new = subprojeto.buscarId(ComboBoxSubProjeto.getSelectedItem().toString());
        String descricao_proj = txtDescricao.getText();
        double avaliacao = Double.parseDouble(JOptionPane.showInputDialog("Dê uma avaliação para o projeto de 0 a 5!"));
        
        projetos.atualizarInfo(id_projeto, id_descricao, id_projeto_new, id_subprojeto_new, avaliacao, descricao_proj);
        
        ListagemProjeto lista = new ListagemProjeto(permissao);
        lista.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        TelaGerenciamentoProjetos tela = new TelaGerenciamentoProjetos(permissao);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciamentoProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciamentoProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciamentoProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciamentoProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciamentoProjetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxSubProjeto;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMostrarProjetos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxProjetos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}