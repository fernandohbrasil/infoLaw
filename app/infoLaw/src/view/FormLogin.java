package view;

public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        edtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
        btnAcessar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edtUsuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlLogin.add(edtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 41, 131, -1));

        lblUsuario.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblUsuario.setText("Usuário");
        pnlLogin.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 46, -1, -1));

        lblSenha.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        lblSenha.setText("Senha");
        pnlLogin.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 89, -1, -1));

        edtSenha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pnlLogin.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 84, 131, -1));

        btnAcessar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnAcessar.setText("Acessar");
        pnlLogin.add(btnAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 136, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        pnlLogin.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 136, -1, -1));

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 190));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Info Law");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 250, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAcessar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JPasswordField edtSenha;
    public javax.swing.JTextField edtUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    // End of variables declaration//GEN-END:variables
}
