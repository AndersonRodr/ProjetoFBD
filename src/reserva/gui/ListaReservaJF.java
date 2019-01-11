/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserva.gui;

import cliente.service.Servico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import locacao.dominio.Locacao;
import locacao.gui.ListaLocacaoJF;
import locacao.service.LocacaoService;
import reserva.dominio.Reserva;
import reserva.service.ReservaService;

/**
 *
 * @author Anderson
 */
public class ListaReservaJF extends javax.swing.JFrame {
    private Servico service = new Servico();
    private ReservaService resService = new ReservaService();   
    private ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();

    /**
     * Creates new form ListaReserva
     */
    public ListaReservaJF() throws SQLException {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultTableModel tabelinha = (DefaultTableModel) tabelaReserva.getModel();
        tabelaReserva.setRowSorter(new TableRowSorter(tabelinha));
        tabelaReserva.getColumnModel().getColumn(5).setMinWidth(0);
        tabelaReserva.getColumnModel().getColumn(5).setMaxWidth(0);
        preencherTabelaPFisica();
        
        
//        DefaultTableModel tabelinha2 = (DefaultTableModel) tabelaReservaPJuridica.getModel();
//        tabelaReservaPJuridica.setRowSorter(new TableRowSorter(tabelinha));
        tabelaReservaPJuridica.getColumnModel().getColumn(5).setMinWidth(0);
        tabelaReservaPJuridica.getColumnModel().getColumn(5).setMaxWidth(0);
        preencherTabelaPJuridica();    

        
    }
    
    private void preencherTabelaPFisica() throws SQLException{ 
        listaReservas = resService.getListaReservas();
        ArrayList<Reserva> listaPFisica = resService.getPFisica(listaReservas);                      
        DefaultTableModel tabelinha = (DefaultTableModel) tabelaReserva.getModel(); 
        tabelinha.setNumRows(0); 
        if (listaPFisica != null ){   
                for (Reserva r: listaPFisica){                   
                    tabelinha.addRow(new Object[] { 
                        r.getCpfCnpj(),
                        r.getIdFilialOrigem(),
                        r.getIdFilialDevolucao(),                  
                        formatarDataSaida(r.getDataRetirada()),
                        formatarDataSaida(r.getDataDevolucao()),
                        r.getIdReserva()
                });                
            }        
        }
    }
    
    private void preencherTabelaPJuridica() throws SQLException{ 
        listaReservas = resService.getListaReservas();        
        ArrayList<Reserva> listaPJuridica = resService.getPJuridica(listaReservas);
                       
        DefaultTableModel tabelinha2 = (DefaultTableModel) tabelaReservaPJuridica.getModel(); 
        tabelinha2.setNumRows(0); 
        if (listaPJuridica != null ){   
                for (Reserva r: listaPJuridica){                   
                    tabelinha2.addRow(new Object[] { 
                        r.getCpfCnpj(),
                        r.getIdFilialOrigem(),
                        r.getIdFilialDevolucao(),                  
                        formatarDataSaida(r.getDataRetirada()),
                        formatarDataSaida(r.getDataDevolucao()),
                        r.getIdReserva()
                });                
            }        
        }
    }    
        
    private String formatarDataSaida(String data){
        return service.formatarDataSaida(data);
    }

    private String formatarDataEntrada(String data){
        return service.formatarDataEntrada(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReserva = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaReservaPJuridica = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tabelaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Filial de Retirada", "Filial de Devolução", "Data de Retirada", "Data de Devolução", "idReserva"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaReserva);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Excluir Reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pessoa Juridica");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Pessoa Física");

        tabelaReservaPJuridica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "Filial Retirada", "Filial de Devolucao", "Data Retirada", "Data Devolução", "idReserva"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaReservaPJuridica);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Excluir Reserva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tabelaReserva.getSelectedRow() != -1){
            DefaultTableModel tabelinha = (DefaultTableModel) tabelaReserva.getModel();
            Reserva reserva = new Reserva();
            int i = tabelaReserva.getSelectedRow();
            reserva.setIdReserva((Integer) tabelaReserva.getValueAt(i, 5));
            try {
                if (resService.removerReserva(reserva.getIdReserva())) {
                    JOptionPane.showMessageDialog(null, "Reserva Excluída");
                    tabelinha.removeRow(tabelaReserva.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListaReservaJF.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabelaReservaPJuridica.getSelectedRow() != -1){
            DefaultTableModel tabelinha = (DefaultTableModel) tabelaReservaPJuridica.getModel();
            Reserva reserva = new Reserva();
            int i = tabelaReservaPJuridica.getSelectedRow();
            reserva.setIdReserva((Integer) tabelaReservaPJuridica.getValueAt(i, 5));
            try {
                if (resService.removerReserva(reserva.getIdReserva())) {
                    JOptionPane.showMessageDialog(null, "Reserva Excluída");
                    tabelinha.removeRow(tabelaReservaPJuridica.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListaReservaJF.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaReservaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaReservaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaReservaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaReservaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListaReservaJF().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaReservaJF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabelaReserva;
    private javax.swing.JTable tabelaReservaPJuridica;
    // End of variables declaration//GEN-END:variables
}
