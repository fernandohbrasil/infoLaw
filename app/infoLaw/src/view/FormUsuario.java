package view;


public class FormUsuario extends javax.swing.JFrame {

    public FormUsuario(java.awt.Frame parent, boolean modal) {        
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
        edtUsername = new javax.swing.JTextField();
        edtSenha = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnGrava = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(575, 210));
        setPreferredSize(new java.awt.Dimension(575, 210));
        setSize(new java.awt.Dimension(575, 210));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNome.setText("Usuário");
        pnPrincipal.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCodigo.setText("Código");
        pnPrincipal.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblTelefone.setText("Senha");
        pnPrincipal.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        edtCodigo.setEditable(false);
        pnPrincipal.add(edtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, -1));
        pnPrincipal.add(edtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 330, -1));
        pnPrincipal.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 330, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, -1, 125));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Usuário");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 550, -1));

        btnGrava.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnGrava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnGrava.setText("Gravar");
        btnGrava.setAlignmentY(0.7F);
        btnGrava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGrava.setHideActionText(true);
        btnGrava.setIconTextGap(10);
        btnGrava.setMaximumSize(new java.awt.Dimension(80, 30));
        btnGrava.setMinimumSize(new java.awt.Dimension(80, 30));
        btnGrava.setPreferredSize(new java.awt.Dimension(105, 32));
        getContentPane().add(btnGrava, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 42, -1, -1));

        btnCancela.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        btnCancela.setText("Cancelar");
        btnCancela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancela.setHideActionText(true);
        btnCancela.setIconTextGap(10);
        btnCancela.setMaximumSize(new java.awt.Dimension(50, 30));
        btnCancela.setMinimumSize(new java.awt.Dimension(50, 30));
        btnCancela.setPreferredSize(new java.awt.Dimension(105, 32));
        getContentPane().add(btnCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 104, -1, -1));

        btnFecha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFecha.setText("Sair");
        btnFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFecha.setHideActionText(true);
        btnFecha.setIconTextGap(10);
        btnFecha.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFecha.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFecha.setPreferredSize(new java.awt.Dimension(105, 32));
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 135, -1, -1));

        btnReload.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reload.png"))); // NOI18N
        btnReload.setText("Carrega");
        btnReload.setAlignmentY(0.7F);
        btnReload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReload.setHideActionText(true);
        btnReload.setIconTextGap(10);
        btnReload.setMaximumSize(new java.awt.Dimension(80, 30));
        btnReload.setMinimumSize(new java.awt.Dimension(80, 30));
        btnReload.setPreferredSize(new java.awt.Dimension(105, 32));
        getContentPane().add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 73, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancela;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnGrava;
    public javax.swing.JButton btnReload;
    public javax.swing.JTextField edtCodigo;
    public javax.swing.JTextField edtSenha;
    public javax.swing.JTextField edtUsername;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnPrincipal;
    public javax.swing.ButtonGroup rgbTipoPessoa;
    // End of variables declaration//GEN-END:variables
}
