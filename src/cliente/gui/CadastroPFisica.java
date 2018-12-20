/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.gui;

import cliente.dominio.Cliente;
import javax.swing.JOptionPane;
import cliente.service.CPF;
import cliente.service.Servico;

/**
 *
 * @author Anderson
 */
public class CadastroPFisica extends javax.swing.JFrame {
    private Servico service = new Servico();
    
    
    public CadastroPFisica() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        enderecoCadPFisica = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        senhaCadPFisica = new javax.swing.JPasswordField();
        btnCadPFisica = new javax.swing.JButton();
        nascCadPFisica = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cpfCadPFisica = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        checkPFisicaM = new javax.swing.JRadioButton();
        checkPFisicaF = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        nomeCadPFisica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anderson\\Desktop\\cadPFisica.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Endereço:");

        enderecoCadPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoCadPFisicaActionPerformed(evt);
            }
        });

        jLabel7.setText("Senha:");

        btnCadPFisica.setBackground(new java.awt.Color(153, 153, 255));
        btnCadPFisica.setText("CADASTRAR");
        btnCadPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPFisicaActionPerformed(evt);
            }
        });

        try {
            nascCadPFisica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nascCadPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nascCadPFisicaActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Nascimento:");

        try {
            cpfCadPFisica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfCadPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfCadPFisicaActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF:");

        checkPFisicaM.setBackground(new java.awt.Color(255, 255, 255));
        checkPFisicaM.setText("M");
        checkPFisicaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPFisicaMActionPerformed(evt);
            }
        });

        checkPFisicaF.setBackground(new java.awt.Color(255, 255, 255));
        checkPFisicaF.setText("F");

        jLabel4.setText("Sexo:");

        nomeCadPFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeCadPFisicaMouseClicked(evt);
            }
        });
        nomeCadPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCadPFisicaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("CADASTRO DE PESSOA FÍSICA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(nomeCadPFisica)
                            .addComponent(nascCadPFisica)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cpfCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(checkPFisicaM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkPFisicaF))
                                    .addComponent(jLabel4)))
                            .addComponent(enderecoCadPFisica)
                            .addComponent(jLabel7)
                            .addComponent(senhaCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(nomeCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPFisicaM)
                    .addComponent(checkPFisicaF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(nascCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCadPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCadPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCadPFisicaActionPerformed

    private void nascCadPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nascCadPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nascCadPFisicaActionPerformed

    private void checkPFisicaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPFisicaMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPFisicaMActionPerformed

    private void enderecoCadPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoCadPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoCadPFisicaActionPerformed

    private void nomeCadPFisicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeCadPFisicaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nomeCadPFisicaMouseClicked

    private void btnCadPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPFisicaActionPerformed
        if(validaCampos()){

            
            Cliente cliente = new Cliente();
            cliente.setNome(nomeCadPFisica.getText());
            cliente.setEndereco(enderecoCadPFisica.getText());
            if (service.buscarCPF(cpfCadPFisica.getText())){
                JOptionPane.showMessageDialog(null, "CPF já cadastrado");
            }
            else{
                if (service.cadCliente(cliente)){
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro.");
                }
            }
        }
    }//GEN-LAST:event_btnCadPFisicaActionPerformed

    private boolean validaCampos(){
        String strCpf = cpfCadPFisica.getText();
        CPF cpf = new CPF(strCpf, true);
        
        if (service.isEmpty(String.valueOf(nomeCadPFisica.getText()))){
            JOptionPane.showMessageDialog(null, "Nome inválido");
            return false;
        }
        else if (!cpf.isCPF()){
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return false;
        }
        else if (checkPFisicaM.isSelected() && checkPFisicaF.isSelected()){
            JOptionPane.showMessageDialog(null, "Escolha apenas um sexo");
            return false;
        }
        else if (!checkPFisicaM.isSelected() && !checkPFisicaF.isSelected()){
            JOptionPane.showMessageDialog(null, "Escolha um sexo");
            return false;
        }
        else if (!service.validarIdade(nascCadPFisica.getText())){
            JOptionPane.showMessageDialog(null, "Precisa ser maior de idade");
            return false;
        }
        else if (service.isEmpty(String.valueOf(enderecoCadPFisica.getText()))){
            JOptionPane.showMessageDialog(null, "Endereço inválido");
            return false;
        }
        else if(service.isEmpty(String.valueOf(senhaCadPFisica.getText()))){
            JOptionPane.showMessageDialog(null, "Senha inválida");
            return false;
        }
        else{
            return true;
        }
    }
    
    private void limparCampos(){
        nomeCadPFisica.setText("");
        cpfCadPFisica.setText("   .   .   -  ");
        checkPFisicaM.disable();
        checkPFisicaF.disable();
        nascCadPFisica.setText("  /  /    ");
        enderecoCadPFisica.setText("");
        senhaCadPFisica.setText("");
    }
    
    private void cpfCadPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfCadPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfCadPFisicaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPFisica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPFisica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPFisica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPFisica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPFisica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadPFisica;
    private javax.swing.JRadioButton checkPFisicaF;
    private javax.swing.JRadioButton checkPFisicaM;
    private javax.swing.JFormattedTextField cpfCadPFisica;
    private javax.swing.JTextField enderecoCadPFisica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField nascCadPFisica;
    private javax.swing.JTextField nomeCadPFisica;
    private javax.swing.JPasswordField senhaCadPFisica;
    // End of variables declaration//GEN-END:variables
}
