package view;


public class FormCadastroEntidade extends javax.swing.JFrame {

    public FormCadastroEntidade(java.awt.Frame parent, boolean modal) {        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgbTipoPessoa = new javax.swing.ButtonGroup();
        pnPrincipal = new javax.swing.JPanel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRua = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtBairro = new javax.swing.JTextField();
        edtRua = new javax.swing.JTextField();
        edtEmail = new javax.swing.JTextField();
        edtFone = new javax.swing.JTextField();
        edtCpf = new javax.swing.JFormattedTextField();
        edtCnpj = new javax.swing.JFormattedTextField();
        cbMunicipio = new javax.swing.JComboBox<>();
        cbUF = new javax.swing.JComboBox<>();
        lblRaca = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        edtCep = new javax.swing.JTextField();
        edtIe = new javax.swing.JTextField();
        lblIe = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        edtRg = new javax.swing.JTextField();
        cbValidaCpf = new javax.swing.JCheckBox();
        lblTitulo = new javax.swing.JLabel();
        btnGrava = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        pnTipoPessoa = new javax.swing.JPanel();
        rgFisica = new javax.swing.JRadioButton();
        rgJuridica = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(590, 400));
        setPreferredSize(new java.awt.Dimension(590, 400));
        setSize(new java.awt.Dimension(590, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnPrincipal.setPreferredSize(new java.awt.Dimension(430, 317));
        pnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCidade.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCidade.setText("Cidade");
        pnPrincipal.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        lblEstado.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblEstado.setText("Estado");
        pnPrincipal.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, -1));

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblEmail.setText("Email");
        pnPrincipal.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, -1, -1));

        lblRua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRua.setText("Rua");
        pnPrincipal.add(lblRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, -1));

        lblNome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNome.setText("Nome");
        pnPrincipal.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, -1));

        lblCnpj.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCnpj.setText("CNPJ");
        pnPrincipal.add(lblCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, -1));

        lblCpf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCpf.setText("CPF");
        pnPrincipal.add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblCodigo.setText("Código");
        pnPrincipal.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, -1));

        lblBairro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblBairro.setText("Bairro");
        pnPrincipal.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, -1, -1));

        lblNumero.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNumero.setText("Numero");
        pnPrincipal.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 240, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblTelefone.setText("Telefone");
        pnPrincipal.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        edtCodigo.setEditable(false);
        pnPrincipal.add(edtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, -1));
        pnPrincipal.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 330, -1));
        pnPrincipal.add(edtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 330, -1));
        pnPrincipal.add(edtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 330, -1));
        pnPrincipal.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 330, -1));
        pnPrincipal.add(edtFone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 330, -1));

        try {
            edtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCpf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnPrincipal.add(edtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 120, -1));

        try {
            edtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCnpj.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnPrincipal.add(edtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, -1));

        pnPrincipal.add(cbMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 200, -1));

        cbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUF.setSelectedIndex(23);
        pnPrincipal.add(cbUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        lblRaca.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRaca.setText("CEP");
        pnPrincipal.add(lblRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));
        pnPrincipal.add(edtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 100, -1));
        pnPrincipal.add(edtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 120, -1));
        pnPrincipal.add(edtIe, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 120, -1));

        lblIe.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblIe.setText("IE");
        pnPrincipal.add(lblIe, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        lblRg.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRg.setText("RG");
        pnPrincipal.add(lblRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));
        pnPrincipal.add(edtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 120, -1));

        cbValidaCpf.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        cbValidaCpf.setSelected(true);
        cbValidaCpf.setText("Valida CPF/CNPJ");
        cbValidaCpf.setToolTipText("");
        pnPrincipal.add(cbValidaCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Cliente");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 550, -1));

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
        getContentPane().add(btnGrava, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

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
        getContentPane().add(btnCancela, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

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
        getContentPane().add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

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
        getContentPane().add(btnExclui, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        btnFecha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fechar.png"))); // NOI18N
        btnFecha.setText("Sair");
        btnFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFecha.setHideActionText(true);
        btnFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFecha.setIconTextGap(10);
        btnFecha.setMaximumSize(new java.awt.Dimension(50, 30));
        btnFecha.setMinimumSize(new java.awt.Dimension(50, 30));
        btnFecha.setPreferredSize(new java.awt.Dimension(105, 30));
        getContentPane().add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        pnTipoPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tipo de Pessoa"));
        pnTipoPessoa.setPreferredSize(new java.awt.Dimension(105, 70));
        pnTipoPessoa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rgbTipoPessoa.add(rgFisica);
        rgFisica.setSelected(true);
        rgFisica.setText("Física");
        pnTipoPessoa.add(rgFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        rgbTipoPessoa.add(rgJuridica);
        rgJuridica.setText("Jurídica");
        pnTipoPessoa.add(rgJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        getContentPane().add(pnTipoPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancela;
    public javax.swing.JButton btnConsulta;
    public javax.swing.JButton btnExclui;
    public javax.swing.JButton btnFecha;
    public javax.swing.JButton btnGrava;
    public javax.swing.JComboBox<String> cbMunicipio;
    public javax.swing.JComboBox<String> cbUF;
    public javax.swing.JCheckBox cbValidaCpf;
    public javax.swing.JTextField edtBairro;
    public javax.swing.JTextField edtCep;
    public javax.swing.JFormattedTextField edtCnpj;
    public javax.swing.JTextField edtCodigo;
    public javax.swing.JFormattedTextField edtCpf;
    public javax.swing.JTextField edtEmail;
    public javax.swing.JTextField edtFone;
    public javax.swing.JTextField edtIe;
    public javax.swing.JTextField edtNome;
    public javax.swing.JTextField edtNumero;
    public javax.swing.JTextField edtRg;
    public javax.swing.JTextField edtRua;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    public javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCodigo;
    public javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblIe;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRaca;
    public javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnTipoPessoa;
    public javax.swing.JRadioButton rgFisica;
    public javax.swing.JRadioButton rgJuridica;
    public javax.swing.ButtonGroup rgbTipoPessoa;
    // End of variables declaration//GEN-END:variables
}
