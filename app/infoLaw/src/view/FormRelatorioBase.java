package view;

import javax.swing.text.MaskFormatter;


public class FormRelatorioBase extends javax.swing.JFrame {

    public FormRelatorioBase(java.awt.Frame parent, boolean modal) {        
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbTipoConta = new javax.swing.ButtonGroup();
        rgbTipoData = new javax.swing.ButtonGroup();
        rgbStatus = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        pnCliente = new javax.swing.JPanel();
        lblNome1 = new javax.swing.JLabel();
        edtCliente = new javax.swing.JTextField();
        cbxEntidade = new javax.swing.JComboBox<>();
        btnConsCli = new javax.swing.JButton();
        cbEntidade = new javax.swing.JCheckBox();
        pnData = new javax.swing.JPanel();
        lblTelefone3 = new javax.swing.JLabel();
        edtDtIni = new javax.swing.JTextField();
        lblTelefone4 = new javax.swing.JLabel();
        edtDtFin = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rgDtPagamento = new javax.swing.JRadioButton();
        rgDtVencimento = new javax.swing.JRadioButton();
        rgDtEmissao = new javax.swing.JRadioButton();
        pnTipoConta = new javax.swing.JPanel();
        rgReceber = new javax.swing.JRadioButton();
        rgPagar = new javax.swing.JRadioButton();
        pnStatus = new javax.swing.JPanel();
        rgAberto = new javax.swing.JRadioButton();
        rgPago = new javax.swing.JRadioButton();
        rgCancelado = new javax.swing.JRadioButton();
        lblTitle = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(730, 340));
        setSize(new java.awt.Dimension(730, 340));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setMinimumSize(new java.awt.Dimension(800, 800));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome1.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblNome1.setText("Entidade");
        pnCliente.add(lblNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        pnCliente.add(edtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 39, 25));

        pnCliente.add(cbxEntidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 510, -1));

        btnConsCli.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnConsCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pesquisar.png"))); // NOI18N
        btnConsCli.setAlignmentX(1.0F);
        btnConsCli.setAlignmentY(1.0F);
        btnConsCli.setBorder(null);
        btnConsCli.setHideActionText(true);
        btnConsCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsCli.setIconTextGap(10);
        btnConsCli.setMaximumSize(new java.awt.Dimension(50, 30));
        btnConsCli.setMinimumSize(new java.awt.Dimension(50, 30));
        btnConsCli.setPreferredSize(new java.awt.Dimension(105, 30));
        pnCliente.add(btnConsCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 27, 27));

        cbEntidade.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        cbEntidade.setText("P. Entidade");
        pnCliente.add(cbEntidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        pnPrincipal.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 670, 80));

        pnData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefone3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone3.setText("Data Inicial");
        pnData.add(lblTelefone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 15, -1, -1));
        pnData.add(edtDtIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 77, 25));

        lblTelefone4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone4.setText("Data Final");
        pnData.add(lblTelefone4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 15, -1, -1));
        pnData.add(edtDtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 10, 77, 25));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbTipoData.add(rgDtPagamento);
        rgDtPagamento.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        rgDtPagamento.setText("Pagamento");
        jPanel1.add(rgDtPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1, -1, -1));

        rgbTipoData.add(rgDtVencimento);
        rgDtVencimento.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        rgDtVencimento.setSelected(true);
        rgDtVencimento.setText("Vencimento");
        jPanel1.add(rgDtVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        rgbTipoData.add(rgDtEmissao);
        rgDtEmissao.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        rgDtEmissao.setText("Emissão");
        jPanel1.add(rgDtEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 1, -1, -1));

        pnData.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 310, 27));

        pnPrincipal.add(pnData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 670, 50));

        pnTipoConta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipo de Conta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N
        pnTipoConta.setPreferredSize(new java.awt.Dimension(105, 70));
        pnTipoConta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbTipoConta.add(rgReceber);
        rgReceber.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgReceber.setSelected(true);
        rgReceber.setText("Receber");
        pnTipoConta.add(rgReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        rgbTipoConta.add(rgPagar);
        rgPagar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgPagar.setText("Pagar");
        pnTipoConta.add(rgPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, -1, -1));

        pnPrincipal.add(pnTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 165, 170, 45));

        pnStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N
        pnStatus.setPreferredSize(new java.awt.Dimension(105, 70));
        pnStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbStatus.add(rgAberto);
        rgAberto.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgAberto.setSelected(true);
        rgAberto.setText("Em Aberto");
        pnStatus.add(rgAberto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        rgbStatus.add(rgPago);
        rgPago.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgPago.setText("Pago");
        pnStatus.add(rgPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 15, -1, -1));

        rgbStatus.add(rgCancelado);
        rgCancelado.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgCancelado.setText("Cancelado");
        rgCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgCanceladoActionPerformed(evt);
            }
        });
        pnStatus.add(rgCancelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 15, -1, -1));

        pnPrincipal.add(pnStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 165, 270, 45));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 690, 220));

        lblTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Emissão de Relatórios Financeiros");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 690, -1));

        btnFechar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFechar.setText("Sair");
        btnFechar.setBorder(null);
        btnFechar.setHideActionText(true);
        btnFechar.setIconTextGap(10);
        btnFechar.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFechar.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFechar.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 110, 30));

        btnImprimir.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setAlignmentY(0.7F);
        btnImprimir.setBorder(null);
        btnImprimir.setHideActionText(true);
        btnImprimir.setIconTextGap(10);
        btnImprimir.setMaximumSize(new java.awt.Dimension(80, 30));
        btnImprimir.setMinimumSize(new java.awt.Dimension(80, 30));
        btnImprimir.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 110, 30));
        btnImprimir.getAccessibleContext().setAccessibleName("Imprimir");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rgCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgCanceladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgCanceladoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConsCli;
    public javax.swing.JButton btnFechar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JCheckBox cbEntidade;
    public javax.swing.JComboBox<String> cbxEntidade;
    public javax.swing.JTextField edtCliente;
    public javax.swing.JTextField edtDtFin;
    public javax.swing.JTextField edtDtIni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblTelefone3;
    private javax.swing.JLabel lblTelefone4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnData;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnStatus;
    private javax.swing.JPanel pnTipoConta;
    public javax.swing.JRadioButton rgAberto;
    public javax.swing.JRadioButton rgCancelado;
    public javax.swing.JRadioButton rgDtEmissao;
    public javax.swing.JRadioButton rgDtPagamento;
    public javax.swing.JRadioButton rgDtVencimento;
    public javax.swing.JRadioButton rgPagar;
    public javax.swing.JRadioButton rgPago;
    public javax.swing.JRadioButton rgReceber;
    private javax.swing.ButtonGroup rgbStatus;
    public javax.swing.ButtonGroup rgbTipoConta;
    private javax.swing.ButtonGroup rgbTipoData;
    // End of variables declaration//GEN-END:variables
}
