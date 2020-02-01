package view;

import javax.swing.text.MaskFormatter;


public class FormLancaConta extends javax.swing.JFrame {

    public FormLancaConta(java.awt.Frame parent, boolean modal) {        
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbTipoPessoa = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        edtCliente = new javax.swing.JTextField();
        edtQtdParc = new javax.swing.JTextField();
        cbCliente = new javax.swing.JComboBox<>();
        lblTelefone1 = new javax.swing.JLabel();
        edtData = new javax.swing.JTextField();
        lblTelefone2 = new javax.swing.JLabel();
        edtTotal = new javax.swing.JTextField();
        btnGeraParc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txParcelas = new javax.swing.JTextPane();
        btnConsulta = new javax.swing.JButton();
        cbVista = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txObs = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        btnGrava = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        pnTipoConta = new javax.swing.JPanel();
        rgReceber = new javax.swing.JRadioButton();
        rgPagar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(775, 655));
        setPreferredSize(new java.awt.Dimension(775, 655));
        setSize(new java.awt.Dimension(775, 655));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblNome.setText("Cliente");
        pnPrincipal.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblCodigo.setText("Código");
        pnPrincipal.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone.setText("Nº");
        pnPrincipal.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 90, -1, -1));

        edtCodigo.setEditable(false);
        pnPrincipal.add(edtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, -1));
        pnPrincipal.add(edtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 39, 25));
        pnPrincipal.add(edtQtdParc, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 90, 22, 25));

        pnPrincipal.add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 440, -1));

        lblTelefone1.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone1.setText("Data");
        pnPrincipal.add(lblTelefone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 90, -1, -1));
        pnPrincipal.add(edtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 90, 77, 25));

        lblTelefone2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone2.setText("Vl. Total");
        pnPrincipal.add(lblTelefone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        edtTotal.setToolTipText("Ex: 50,20");
        pnPrincipal.add(edtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 70, -1));

        btnGeraParc.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnGeraParc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnGeraParc.setText("Gera Parcelas");
        btnGeraParc.setAlignmentY(0.7F);
        btnGeraParc.setBorder(null);
        btnGeraParc.setHideActionText(true);
        btnGeraParc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGeraParc.setIconTextGap(10);
        btnGeraParc.setMaximumSize(new java.awt.Dimension(80, 30));
        btnGeraParc.setMinimumSize(new java.awt.Dimension(80, 30));
        btnGeraParc.setPreferredSize(new java.awt.Dimension(105, 30));
        pnPrincipal.add(btnGeraParc, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 90, 133, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N

        txParcelas.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txParcelas.setDisabledTextColor(new java.awt.Color(7, 2, 2));
        txParcelas.setEnabled(false);
        txParcelas.setSelectionColor(new java.awt.Color(2, 121, 241));
        jScrollPane1.setViewportView(txParcelas);

        pnPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 265, 580, 280));

        btnConsulta.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pesquisar.png"))); // NOI18N
        btnConsulta.setAlignmentX(1.0F);
        btnConsulta.setAlignmentY(1.0F);
        btnConsulta.setBorder(null);
        btnConsulta.setHideActionText(true);
        btnConsulta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsulta.setIconTextGap(10);
        btnConsulta.setMaximumSize(new java.awt.Dimension(50, 30));
        btnConsulta.setMinimumSize(new java.awt.Dimension(50, 30));
        btnConsulta.setPreferredSize(new java.awt.Dimension(105, 30));
        pnPrincipal.add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 60, 27, 27));

        cbVista.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        cbVista.setText("A Vista");
        pnPrincipal.add(cbVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        txObs.setColumns(20);
        txObs.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txObs.setRows(5);
        txObs.setText("Observação:");
        txObs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(txObs);

        pnPrincipal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 580, 125));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 610, 560));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Lançamentos");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 720, -1));

        btnGrava.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnGrava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnGrava.setText("Gravar");
        btnGrava.setAlignmentY(0.7F);
        btnGrava.setBorder(null);
        btnGrava.setHideActionText(true);
        btnGrava.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGrava.setIconTextGap(10);
        btnGrava.setMaximumSize(new java.awt.Dimension(80, 30));
        btnGrava.setMinimumSize(new java.awt.Dimension(80, 30));
        btnGrava.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnGrava, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 40, 105, 30));

        btnCancela.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        btnCancela.setText("Cancelar");
        btnCancela.setBorder(null);
        btnCancela.setHideActionText(true);
        btnCancela.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCancela.setIconTextGap(10);
        btnCancela.setMaximumSize(new java.awt.Dimension(50, 30));
        btnCancela.setMinimumSize(new java.awt.Dimension(50, 30));
        btnCancela.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 68, 105, 30));

        btnFecha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFecha.setText("Sair");
        btnFecha.setBorder(null);
        btnFecha.setHideActionText(true);
        btnFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFecha.setIconTextGap(10);
        btnFecha.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFecha.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFecha.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 96, 105, 30));

        pnTipoConta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipo de Conta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N
        pnTipoConta.setPreferredSize(new java.awt.Dimension(105, 70));
        pnTipoConta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbTipoPessoa.add(rgReceber);
        rgReceber.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgReceber.setSelected(true);
        rgReceber.setText("Receber");
        pnTipoConta.add(rgReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        rgbTipoPessoa.add(rgPagar);
        rgPagar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgPagar.setText("Pagar");
        pnTipoConta.add(rgPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        getContentPane().add(pnTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 534, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancela;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnGeraParc;
    public javax.swing.JButton btnGrava;
    public javax.swing.JComboBox<String> cbCliente;
    public javax.swing.JCheckBox cbVista;
    public javax.swing.JTextField edtCliente;
    public javax.swing.JTextField edtCodigo;
    public javax.swing.JTextField edtData;
    public javax.swing.JTextField edtQtdParc;
    public javax.swing.JTextField edtTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblTelefone2;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnTipoConta;
    public javax.swing.JRadioButton rgPagar;
    public javax.swing.JRadioButton rgReceber;
    public javax.swing.ButtonGroup rgbTipoPessoa;
    public javax.swing.JTextArea txObs;
    public javax.swing.JTextPane txParcelas;
    // End of variables declaration//GEN-END:variables
}
