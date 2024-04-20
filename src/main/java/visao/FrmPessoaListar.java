package visao;

import dao.pessoa.PessoaDAO;
import dao.pessoa.PessoaDAOMySQL;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author osmarbraz
 */
public class FrmPessoaListar extends javax.swing.JFrame {

    /**
     * Creates new form FrmPessoaListar
     */
    public FrmPessoaListar() {
        initComponents();
        preencherTabela();
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
        JBTFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Listar Pessoas");

        JBTFechar.setText("Fechar");
        JBTFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBTFechar)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(JBTFechar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_JBTFecharActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPessoaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPessoaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPessoaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPessoaListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPessoaListar().setVisible(true);
            }
        });
    }

    public void preencherTabela() {
        PessoaDAO pessoadao = new PessoaDAOMySQL();
        List<Pessoa> pessoas = pessoadao.consultarTudo();
        String[] nomeColunas = {"id", "nome", "idade", "data nascimento", "cidade", "estado civil"};
        DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
        aModel.setColumnIdentifiers(nomeColunas);
        Object[] objects = new Object[nomeColunas.length];
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = (Pessoa) pessoas.get(i);
            objects[0] = pessoa.getPessoaId();
            objects[1] = pessoa.getNome();
            objects[2] = pessoa.getIdade();
            objects[3] = pessoa.getDataNascimento();
            objects[4] = pessoa.getCidade();
            objects[5] = pessoa.getEstadoCivil();
            aModel.addRow(objects);
        }
        jTable1.setModel(aModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
