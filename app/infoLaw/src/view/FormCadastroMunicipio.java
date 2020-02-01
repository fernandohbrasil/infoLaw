package view;

public class FormCadastroMunicipio extends javax.swing.JFrame {

    public FormCadastroMunicipio(java.awt.Frame parent, boolean modal) {        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        pnPrincipal = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblRaca = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtCEP = new javax.swing.JTextField();
        cbUF = new javax.swing.JComboBox<>();
        btnGrava = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 220));
        setPreferredSize(new java.awt.Dimension(600, 220));
        setSize(new java.awt.Dimension(600, 220));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTitulo.setText("Cadastro de Município");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 210, -1));

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(435, 170));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCodigo.setText("Codigo");
        pnPrincipal.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblNome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNome.setText("Nome");
        pnPrincipal.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblEspecie.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblEspecie.setText("UF");
        pnPrincipal.add(lblEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lblRaca.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRaca.setText("CEP");
        pnPrincipal.add(lblRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        edtCodigo.setEditable(false);
        edtCodigo.setPreferredSize(new java.awt.Dimension(80, 20));
        pnPrincipal.add(edtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 60, -1));

        edtNome.setPreferredSize(new java.awt.Dimension(80, 20));
        pnPrincipal.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 340, -1));

        edtCEP.setText("88400-000");
        edtCEP.setPreferredSize(new java.awt.Dimension(80, 20));
        pnPrincipal.add(edtCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 90, -1));

        cbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre - AC", "Alagoas - AL", "Amapá - AP", "Amazonas - AM", "Bahia  - BA", "Ceará - CE", "Distrito Federal  - DF", "Espírito Santo - ES", "Goiás - GO", "Maranhão - MA", "Mato Grosso - MT", "Mato Grosso do Sul - MS", "Minas Gerais - MG", "Pará - PA", "Paraíba - PB", "Paraná - PR", "Pernambuco - PE", "Piauí - PI", "Rio de Janeiro - RJ", "Rio Grande do Norte - RN", "Rio Grande do Sul - RS", "Rondônia - RO", "Roraima - RR", "Santa Catarina - SC", "São Paulo - SP", "Sergipe - SE", "Tocantins - TO" }));
        cbUF.setSelectedIndex(23);
        pnPrincipal.add(cbUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, -1, 120));

        btnGrava.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnGrava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/confirmar.png"))); // NOI18N
        btnGrava.setText("Gravar");
        btnGrava.setAlignmentY(0.7F);
        btnGrava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGrava.setHideActionText(true);
        btnGrava.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGrava.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGrava.setIconTextGap(10);
        btnGrava.setMaximumSize(new java.awt.Dimension(80, 30));
        btnGrava.setMinimumSize(new java.awt.Dimension(80, 30));
        btnGrava.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnGrava, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        btnCancela.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        btnCancela.setText("Cancelar");
        btnCancela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancela.setHideActionText(true);
        btnCancela.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCancela.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancela.setIconTextGap(10);
        btnCancela.setMaximumSize(new java.awt.Dimension(50, 30));
        btnCancela.setMinimumSize(new java.awt.Dimension(50, 30));
        btnCancela.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        btnConsulta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pesquisar.png"))); // NOI18N
        btnConsulta.setText("Consultar");
        btnConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnConsulta.setHideActionText(true);
        btnConsulta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnConsulta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsulta.setIconTextGap(10);
        btnConsulta.setMaximumSize(new java.awt.Dimension(50, 30));
        btnConsulta.setMinimumSize(new java.awt.Dimension(50, 30));
        btnConsulta.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        btnExclui.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        btnExclui.setText("Excluir");
        btnExclui.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnExclui.setHideActionText(true);
        btnExclui.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnExclui.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExclui.setIconTextGap(10);
        btnExclui.setMaximumSize(new java.awt.Dimension(50, 30));
        btnExclui.setMinimumSize(new java.awt.Dimension(50, 30));
        btnExclui.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnExclui, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancela;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnExclui;
    public javax.swing.JButton btnGrava;
    public javax.swing.JComboBox<String> cbUF;
    public javax.swing.JTextField edtCEP;
    public javax.swing.JTextField edtCodigo;
    public javax.swing.JTextField edtNome;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnPrincipal;
    // End of variables declaration//GEN-END:variables
}
