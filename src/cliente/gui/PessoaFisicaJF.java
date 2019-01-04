/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.gui;

import cliente.dao.ClientePessoaDAO;
import cliente.dominio.Cliente;
import cliente.dominio.Motorista;
import cliente.dominio.PessoaFisica;
import cliente.service.Servico;
import cliente.service.ServicoClienteCPF;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Anderson
 */
public class PessoaFisicaJF extends javax.swing.JFrame {
//    private boolean frameCadPFisicaOpen = false;
    private String cpf;
    private Servico service = new Servico();
    private Cliente cliente = new Cliente();
    private PessoaFisica pessoa = new PessoaFisica();
    private Motorista motorista = new Motorista();
    private ArrayList<Motorista> listaMotoristas = new ArrayList<Motorista>();
    private String sexo;
    private boolean buscou;
    
    public PessoaFisicaJF() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultTableModel tabelinha = (DefaultTableModel) tabelaMotoristasPFisica.getModel();
        tabelaMotoristasPFisica.setRowSorter(new TableRowSorter(tabelinha));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEditPFisica = new javax.swing.JButton();
        buscaNomePFisica = new javax.swing.JTextField();
        buscaEndePFisica = new javax.swing.JTextField();
        btnApagarPFisica = new javax.swing.JButton();
        buscaCpfPFisica = new javax.swing.JFormattedTextField();
        buscaNascPFisica = new javax.swing.JFormattedTextField();
        buscaSexoMPFisica = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        buscaSexoFPFisica = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscarCPF = new javax.swing.JFormattedTextField();
        btnBuscarCpf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMotoristasPFisica = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        excluirMotorista = new javax.swing.JButton();
        nomeMoto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cnhMoto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rgMoto = new javax.swing.JTextField();
        btnCadMotoristaPFisica = new javax.swing.JButton();
        vencimentoMoto = new javax.swing.JFormattedTextField();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Endereço:");

        btnEditPFisica.setText("Editar Cliente");
        btnEditPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPFisicaActionPerformed(evt);
            }
        });

        btnApagarPFisica.setBackground(new java.awt.Color(255, 51, 51));
        btnApagarPFisica.setForeground(new java.awt.Color(255, 255, 255));
        btnApagarPFisica.setText("Excluir Cliente");
        btnApagarPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarPFisicaActionPerformed(evt);
            }
        });

        try {
            buscaCpfPFisica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            buscaNascPFisica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buscaSexoMPFisica.setBackground(new java.awt.Color(204, 204, 255));
        buscaSexoMPFisica.setText("M");
        buscaSexoMPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaSexoMPFisicaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Sexo:");

        buscaSexoFPFisica.setBackground(new java.awt.Color(204, 204, 255));
        buscaSexoFPFisica.setText("F");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnApagarPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buscaSexoMPFisica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscaSexoFPFisica)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscaNomePFisica)
                            .addComponent(buscaEndePFisica)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(buscaNascPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscaCpfPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscaNomePFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaNascPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaCpfPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(buscaEndePFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaSexoMPFisica)
                    .addComponent(buscaSexoFPFisica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditPFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApagarPFisica)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setText("Cadastrar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar CPF");

        try {
            buscarCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        buscarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCPFActionPerformed(evt);
            }
        });

        btnBuscarCpf.setText("Buscar");
        btnBuscarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnBuscarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        tabelaMotoristasPFisica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CNH", "Vencimento", "RG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMotoristasPFisica);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Motoristas");

        jLabel7.setText("Nome:");

        excluirMotorista.setText("Excluir Motorista");
        excluirMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirMotoristaActionPerformed(evt);
            }
        });

        jLabel8.setText("CNH:");

        cnhMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnhMotoActionPerformed(evt);
            }
        });

        jLabel9.setText("Vencimento:");

        jLabel10.setText("RG:");

        btnCadMotoristaPFisica.setText("Cadastrar Motorista");
        btnCadMotoristaPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadMotoristaPFisicaActionPerformed(evt);
            }
        });

        try {
            vencimentoMoto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(excluirMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(nomeMoto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cnhMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(vencimentoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnCadMotoristaPFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirMotorista)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(rgMoto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cnhMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vencimentoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(26, 26, 26))
                            .addComponent(nomeMoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnCadMotoristaPFisica)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCPFActionPerformed
        
    }//GEN-LAST:event_buscarCPFActionPerformed

    private void btnBuscarCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCpfActionPerformed
        if (validarCpf()){
            cpf = buscarCPF.getText();
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            cliente = service.buscarPessoaFisica(cpf);

            if (cliente != null){
                buscaNomePFisica.setText(cliente.getNome());
                buscaNascPFisica.setText(formatarDataSaida(cliente.getPFisica().getDataNascimento()));
                buscaCpfPFisica.setText(formatarCpfEntrada(cliente.getPFisica().getCpf()));
                buscaEndePFisica.setText(cliente.getEndereco());
                setarSexoBusca(cliente.getPFisica());
                buscou = true;
                preencherTabela();
            }
            else{
                limparCamposPessoa();
            }
        }
    }//GEN-LAST:event_btnBuscarCpfActionPerformed

    private void setarSexoBusca(PessoaFisica pFisica){
        if (pFisica.getSexo().equals("M")){
            buscaSexoMPFisica.setSelected(true);
        }
        else {
            buscaSexoFPFisica.setSelected(true);
        }
    }
    
    private boolean validarCpf(){       
        String strCpf = buscarCPF.getText();
        ServicoClienteCPF cpf = new ServicoClienteCPF(strCpf, true);        
        if (!cpf.isCPF()){
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return false;
        }
        return true;
    }
    
    private String formatarDataSaida(String nasc){
        return service.formatarDataSaida(nasc);
    }
    
    private String formatarCpfSaida(String cpf){
        return service.formatarCpfSaida(cpf);
    }
    
    private String formatarCpfEntrada(String cpf){
        return service.formatarCpfEntrada(cpf);
    }
    
    private void limparCamposPessoa(){
        buscaNomePFisica.setText("");
        buscaNascPFisica.setText(null);
        buscaCpfPFisica.setText(null);
        buscaEndePFisica.setText("");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroPFisica telaCadPFisica = new  CadastroPFisica();
//        if (!frameCadPFisicaOpen){
            telaCadPFisica.setVisible(true);  
//            frameCadPFisicaOpen = true;
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnApagarPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarPFisicaActionPerformed
        if (!service.isEmpty(buscaNomePFisica.getText())){
            if (service.deletarClientePFisica(cliente)){
                cliente = null;
                JOptionPane.showMessageDialog(null, "Cliente excluído");
                limparCamposPessoa();
                preencherTabela();
            }
            else{
                JOptionPane.showMessageDialog(null, "O cliente não existe na base de dados");
            }
        }
    }//GEN-LAST:event_btnApagarPFisicaActionPerformed

    private void cnhMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnhMotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnhMotoActionPerformed

    private void btnCadMotoristaPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadMotoristaPFisicaActionPerformed
        if (!service.isEmpty(buscaNomePFisica.getText())){
            if (verificarCampos()){ 
                motorista.setCnh(parseInt(cnhMoto.getText())); 
                motorista.setIdCliente(cliente.getId()); 
                motorista.setNome(nomeMoto.getText()); 
                motorista.setRg(parseInt(rgMoto.getText())); 
                motorista.setDataVencimento(formatarDataEntrada(vencimentoMoto.getText())); 
                if (service.inserirMotorista(motorista)){ 
                    limparCamposMoto(); 
                    JOptionPane.showMessageDialog(null, "Motorista cadastrado");                     
                    preencherTabela();
                }
            } 
        }
        else{ 
            JOptionPane.showMessageDialog(null, "Busque um cliente por favor"); 
        }
    }//GEN-LAST:event_btnCadMotoristaPFisicaActionPerformed

    private void btnEditPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPFisicaActionPerformed
        if (buscou){                   
            if (validarCampos()){
                cliente.setNome(buscaNomePFisica.getText());
                cliente.setEndereco(buscaEndePFisica.getText());           

    //            PessoaFisica pessoa = new PessoaFisica();
                pessoa.setDataNascimento(formatarDataEntrada(buscaNascPFisica.getText()));
                pessoa.setCpf(formatarCpfEntrada(buscaCpfPFisica.getText()));
                pessoa.setSexo(sexo);
                try {
                    if (service.alterarClientePFisica(cliente, pessoa)){
                        JOptionPane.showMessageDialog(null, "Cliente Editado!");
                        buscou = false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Erro ao realizar alteração.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado" + ex);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Busque um cliente");
        }
    }//GEN-LAST:event_btnEditPFisicaActionPerformed

    private void buscaSexoMPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaSexoMPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaSexoMPFisicaActionPerformed

    private void excluirMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excluirMotoristaActionPerformed

    private boolean verificarCampos(){
        if (service.isEmpty(nomeMoto.getText())){
            return false;
        }
        else if (service.isEmpty(rgMoto.getText())){
            return false;
        }
        else if (service.isEmpty(cnhMoto.getText())){
            return false;
        }
        else{
            return true;
        }
    }
    
    private String formatarDataEntrada (String nasc){ 
        return service.formatarDataEntrada(nasc); 
    }
    
    private void preencherTabela(){ 
        DefaultTableModel tabelinha = (DefaultTableModel) tabelaMotoristasPFisica.getModel(); 
        tabelinha.setNumRows(0); 
        if (cliente != null){ 
            listaMotoristas = service.getListaMotoristas(cliente.getId());  
            if (listaMotoristas.size() > 0 ){   
                for (Motorista m: listaMotoristas){ 
                    tabelinha.addRow(new Object[] { 
                       m.getNome(), 
                       m.getCnh(), 
                       formatarDataSaida(m.getDataVencimento()), 
                       m.getRg() 
                    }); 
                } 
            } 
        } 
    } 
     
    private void limparCamposMoto(){ 
        cnhMoto.setText(""); 
        nomeMoto.setText(""); 
        rgMoto.setText("");
        vencimentoMoto.setText(null);
        
    } 
        
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
            java.util.logging.Logger.getLogger(PessoaFisicaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaFisicaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PessoaFisicaJF().setVisible(true);
            }
        });
    }
    
    
    private boolean validarCampos(){
        String strCpf = buscaCpfPFisica.getText();
        ServicoClienteCPF cpf = new ServicoClienteCPF(strCpf, true);
        
        if (service.isEmpty(String.valueOf(buscaNomePFisica.getText()))){
            JOptionPane.showMessageDialog(null, "Nome inválido");
            return false;
        }
        else if (!cpf.isCPF()){
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return false;
        }
        else if (!service.validarIdade(buscaNascPFisica.getText())){
            JOptionPane.showMessageDialog(null, "Precisa ser maior de idade");
            return false;
        }
        
        else if (buscaSexoMPFisica.isSelected() && buscaSexoFPFisica.isSelected()){
            JOptionPane.showMessageDialog(null, "Escolha apenas um sexo");
            return false;
        }
        else if (!buscaSexoMPFisica.isSelected() && !buscaSexoFPFisica.isSelected()){
            JOptionPane.showMessageDialog(null, "Escolha um sexo");
            return false;
        }
        
        else if (service.isEmpty(String.valueOf(buscaEndePFisica.getText()))){
            JOptionPane.showMessageDialog(null, "Endereço inválido");
            return false;
        }
        else{
            if (buscaSexoMPFisica.isSelected()){
                sexo = "M";
            }
            else if (buscaSexoFPFisica.isSelected()){
                sexo = "F";
            }
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagarPFisica;
    private javax.swing.JButton btnBuscarCpf;
    private javax.swing.JButton btnCadMotoristaPFisica;
    private javax.swing.JButton btnEditPFisica;
    private javax.swing.JFormattedTextField buscaCpfPFisica;
    private javax.swing.JTextField buscaEndePFisica;
    private javax.swing.JFormattedTextField buscaNascPFisica;
    private javax.swing.JTextField buscaNomePFisica;
    private javax.swing.JRadioButton buscaSexoFPFisica;
    private javax.swing.JRadioButton buscaSexoMPFisica;
    private javax.swing.JFormattedTextField buscarCPF;
    private javax.swing.JTextField cnhMoto;
    private javax.swing.JButton excluirMotorista;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeMoto;
    private javax.swing.JTextField rgMoto;
    private javax.swing.JTable tabelaMotoristasPFisica;
    private javax.swing.JFormattedTextField vencimentoMoto;
    // End of variables declaration//GEN-END:variables

}
