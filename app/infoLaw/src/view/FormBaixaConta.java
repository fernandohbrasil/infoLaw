package view;

import javax.swing.text.MaskFormatter;


public class FormBaixaConta extends javax.swing.JFrame {

    public FormBaixaConta(java.awt.Frame parent, boolean modal) {        
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbTipoPessoa = new javax.swing.ButtonGroup();
        rgbTipoData = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLancamentos = new javax.swing.JTable();
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
        cbData = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        rgDtPag = new javax.swing.JRadioButton();
        rgDtVenc = new javax.swing.JRadioButton();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txObs = new javax.swing.JTextArea();
        lblQtdParc = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnFecha = new javax.swing.JButton();
        pnTipoConta = new javax.swing.JPanel();
        rgReceber = new javax.swing.JRadioButton();
        rgPagar = new javax.swing.JRadioButton();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(745, 442));
        setPreferredSize(new java.awt.Dimension(850, 635));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setMinimumSize(new java.awt.Dimension(800, 800));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblResultado.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblResultado.setText("Total Demonstrado:");
        pnPrincipal.add(lblResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 560, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N

        tbLancamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbLancamentos.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tbLancamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbLancamentos);

        pnPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 670, 140));

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

        pnPrincipal.add(pnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 670, 80));

        pnData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefone3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone3.setText("Data Inicial");
        pnData.add(lblTelefone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));
        pnData.add(edtDtIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 77, 25));

        lblTelefone4.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblTelefone4.setText("Data Final");
        pnData.add(lblTelefone4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));
        pnData.add(edtDtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 77, 25));

        cbData.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        cbData.setSelected(true);
        cbData.setText("P. Data");
        pnData.add(cbData, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbTipoData.add(rgDtPag);
        rgDtPag.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        rgDtPag.setText("Pagamento");
        jPanel1.add(rgDtPag, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1, -1, -1));

        rgbTipoData.add(rgDtVenc);
        rgDtVenc.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        rgDtVenc.setSelected(true);
        rgDtVenc.setText("Vencimento");
        jPanel1.add(rgDtVenc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        pnData.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 39, 215, 27));

        pnPrincipal.add(pnData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 670, 70));

        btnFiltrar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setAlignmentY(0.7F);
        btnFiltrar.setBorder(null);
        btnFiltrar.setHideActionText(true);
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setIconTextGap(10);
        btnFiltrar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnFiltrar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnFiltrar.setPreferredSize(new java.awt.Dimension(105, 30));
        pnPrincipal.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        txObs.setEditable(false);
        txObs.setColumns(20);
        txObs.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        txObs.setRows(5);
        txObs.setText("Observação:");
        txObs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txObs);

        pnPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 670, 130));

        lblQtdParc.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblQtdParc.setText("Quantidade de Parcelas:");
        pnPrincipal.add(lblQtdParc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 560, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 690, 550));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Baixa de Lançamentos");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 720, -1));

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
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 105, 30));

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

        getContentPane().add(pnTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 524, -1, -1));

        btnPagar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setAlignmentY(0.7F);
        btnPagar.setBorder(null);
        btnPagar.setHideActionText(true);
        btnPagar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnPagar.setIconTextGap(10);
        btnPagar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnPagar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnPagar.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 43, 105, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConsCli;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnPagar;
    public javax.swing.JCheckBox cbData;
    public javax.swing.JCheckBox cbEntidade;
    public javax.swing.JComboBox<String> cbxEntidade;
    public javax.swing.JTextField edtCliente;
    public javax.swing.JTextField edtDtFin;
    public javax.swing.JTextField edtDtIni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome1;
    public javax.swing.JLabel lblQtdParc;
    public javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTelefone3;
    private javax.swing.JLabel lblTelefone4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnData;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnTipoConta;
    public javax.swing.JRadioButton rgDtPag;
    public javax.swing.JRadioButton rgDtVenc;
    public javax.swing.JRadioButton rgPagar;
    public javax.swing.JRadioButton rgReceber;
    private javax.swing.ButtonGroup rgbTipoData;
    public javax.swing.ButtonGroup rgbTipoPessoa;
    public javax.swing.JTable tbLancamentos;
    public javax.swing.JTextArea txObs;
    // End of variables declaration//GEN-END:variables
}
