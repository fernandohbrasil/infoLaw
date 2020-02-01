package view;

import javax.swing.text.MaskFormatter;


public class FormDivideValores extends javax.swing.JFrame {

    public FormDivideValores(java.awt.Frame parent, boolean modal) {        
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbPAgRec = new javax.swing.ButtonGroup();
        rgbSituacao = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbParcelas = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnTipoConta = new javax.swing.JPanel();
        rgReceber = new javax.swing.JRadioButton();
        rgPagar = new javax.swing.JRadioButton();
        btnDivide = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(5, 5));
        setPreferredSize(new java.awt.Dimension(880, 430));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setMinimumSize(new java.awt.Dimension(800, 800));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N

        tbParcelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbParcelas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tbParcelas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbParcelas);

        pnPrincipal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 810, 220));

        lblTotal.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("Total: ");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnPrincipal.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 810, -1));

        lblTitulo2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Parcelas");
        pnPrincipal.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 840, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 840, 300));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Divisão de Valores Recebidos");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 840, -1));

        pnTipoConta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipo de Conta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N
        pnTipoConta.setPreferredSize(new java.awt.Dimension(105, 70));
        pnTipoConta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbPAgRec.add(rgReceber);
        rgReceber.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgReceber.setSelected(true);
        rgReceber.setText("Receber");
        pnTipoConta.add(rgReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        rgbPAgRec.add(rgPagar);
        rgPagar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rgPagar.setText("Pagar");
        pnTipoConta.add(rgPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, -1, -1));

        getContentPane().add(pnTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 350, 170, 45));

        btnDivide.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnDivide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnDivide.setText("Dividir Parcela");
        btnDivide.setAlignmentY(0.7F);
        btnDivide.setBorder(null);
        btnDivide.setHideActionText(true);
        btnDivide.setIconTextGap(10);
        btnDivide.setMaximumSize(new java.awt.Dimension(80, 30));
        btnDivide.setMinimumSize(new java.awt.Dimension(80, 30));
        btnDivide.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnDivide, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 355, 140, 35));

        btnFecha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFecha.setText("Sair");
        btnFecha.setBorder(null);
        btnFecha.setHideActionText(true);
        btnFecha.setIconTextGap(10);
        btnFecha.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFecha.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFecha.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 355, 140, 35));

        btnFiltrar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setAlignmentY(0.7F);
        btnFiltrar.setBorder(null);
        btnFiltrar.setHideActionText(true);
        btnFiltrar.setIconTextGap(10);
        btnFiltrar.setMaximumSize(new java.awt.Dimension(80, 30));
        btnFiltrar.setMinimumSize(new java.awt.Dimension(80, 30));
        btnFiltrar.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 355, 140, 35));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDivide;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnFiltrar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnTipoConta;
    public javax.swing.JRadioButton rgPagar;
    public javax.swing.JRadioButton rgReceber;
    public javax.swing.ButtonGroup rgbPAgRec;
    private javax.swing.ButtonGroup rgbSituacao;
    public javax.swing.JTable tbParcelas;
    // End of variables declaration//GEN-END:variables
}
