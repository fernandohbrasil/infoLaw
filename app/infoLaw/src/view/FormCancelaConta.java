package view;

import javax.swing.text.MaskFormatter;


public class FormCancelaConta extends javax.swing.JFrame {

    public FormCancelaConta(java.awt.Frame parent, boolean modal) {        
        initComponents();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbPAgRec = new javax.swing.ButtonGroup();
        rgbSituacao = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbContas = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbParcelas = new javax.swing.JTable();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnTipoConta = new javax.swing.JPanel();
        rgReceber = new javax.swing.JRadioButton();
        rgPagar = new javax.swing.JRadioButton();
        btnFecha = new javax.swing.JButton();
        btnCancelaParc = new javax.swing.JButton();
        btnCancelaContas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 560));
        setPreferredSize(new java.awt.Dimension(890, 560));
        setSize(new java.awt.Dimension(890, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setMinimumSize(new java.awt.Dimension(800, 800));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N

        tbContas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbContas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tbContas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbContas);

        pnPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 810, 140));

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
        pnPrincipal.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 190, -1, -1));

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

        pnPrincipal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 810, 150));

        lblTitulo1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Parcelas");
        pnPrincipal.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 840, -1));

        lblTitulo2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Contas");
        pnPrincipal.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 840, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 840, 430));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cancelamento de Contas");
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

        getContentPane().add(pnTipoConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 475, 170, 45));

        btnFecha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFecha.setText("Sair");
        btnFecha.setBorder(null);
        btnFecha.setHideActionText(true);
        btnFecha.setIconTextGap(10);
        btnFecha.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFecha.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFecha.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 480, 120, 35));

        btnCancelaParc.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnCancelaParc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnCancelaParc.setText("Cancela Parcela");
        btnCancelaParc.setAlignmentY(0.7F);
        btnCancelaParc.setBorder(null);
        btnCancelaParc.setHideActionText(true);
        btnCancelaParc.setIconTextGap(10);
        btnCancelaParc.setMaximumSize(new java.awt.Dimension(80, 30));
        btnCancelaParc.setMinimumSize(new java.awt.Dimension(80, 30));
        btnCancelaParc.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnCancelaParc, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 480, 165, 35));

        btnCancelaContas.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnCancelaContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnCancelaContas.setText("Cancela Conta");
        btnCancelaContas.setAlignmentY(0.7F);
        btnCancelaContas.setBorder(null);
        btnCancelaContas.setHideActionText(true);
        btnCancelaContas.setIconTextGap(10);
        btnCancelaContas.setMaximumSize(new java.awt.Dimension(80, 30));
        btnCancelaContas.setMinimumSize(new java.awt.Dimension(80, 30));
        btnCancelaContas.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnCancelaContas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 165, 35));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelaContas;
    public javax.swing.JButton btnCancelaParc;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnFiltrar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnTipoConta;
    public javax.swing.JRadioButton rgPagar;
    public javax.swing.JRadioButton rgReceber;
    public javax.swing.ButtonGroup rgbPAgRec;
    private javax.swing.ButtonGroup rgbSituacao;
    public javax.swing.JTable tbContas;
    public javax.swing.JTable tbParcelas;
    // End of variables declaration//GEN-END:variables
}
