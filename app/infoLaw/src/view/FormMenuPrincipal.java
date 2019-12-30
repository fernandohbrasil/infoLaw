
package view;

public class FormMenuPrincipal extends javax.swing.JFrame {

    public FormMenuPrincipal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mbMenuPrincipal = new javax.swing.JMenuBar();
        mCadastros = new javax.swing.JMenu();
        miCadEntidade = new javax.swing.JMenuItem();
        miCadMunicipio = new javax.swing.JMenuItem();
        mConsultas = new javax.swing.JMenu();
        miCadLancamento = new javax.swing.JMenuItem();
        miBaixaLancamento = new javax.swing.JMenuItem();
        miCancelaContas = new javax.swing.JMenuItem();
        miDivideContas = new javax.swing.JMenuItem();
        mRelatorios = new javax.swing.JMenu();
        miRelFinancas = new javax.swing.JMenuItem();
        mUsuario = new javax.swing.JMenu();
        miUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(800, 600));

        mCadastros.setText("Cadastros");

        miCadEntidade.setText("Entidade");
        mCadastros.add(miCadEntidade);

        miCadMunicipio.setText("Município");
        mCadastros.add(miCadMunicipio);

        mbMenuPrincipal.add(mCadastros);

        mConsultas.setText("Financeiro");

        miCadLancamento.setText("Cad. Lançamentos");
        mConsultas.add(miCadLancamento);

        miBaixaLancamento.setText("Baixa de Lançamentos");
        mConsultas.add(miBaixaLancamento);

        miCancelaContas.setText("Cancela Contas");
        mConsultas.add(miCancelaContas);

        miDivideContas.setText("Divide Valores");
        mConsultas.add(miDivideContas);

        mbMenuPrincipal.add(mConsultas);

        mRelatorios.setText("Relatorios");

        miRelFinancas.setText("Relatório de Finanças");
        mRelatorios.add(miRelFinancas);

        mbMenuPrincipal.add(mRelatorios);

        mUsuario.setText("Usuário");

        miUsuario.setText("Cadastro de Usuário");
        miUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuarioActionPerformed(evt);
            }
        });
        mUsuario.add(miUsuario);

        mbMenuPrincipal.add(mUsuario);

        setJMenuBar(mbMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miUsuarioActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mCadastros;
    private javax.swing.JMenu mConsultas;
    public javax.swing.JMenu mRelatorios;
    private javax.swing.JMenu mUsuario;
    private javax.swing.JMenuBar mbMenuPrincipal;
    public javax.swing.JMenuItem miBaixaLancamento;
    public javax.swing.JMenuItem miCadEntidade;
    public javax.swing.JMenuItem miCadLancamento;
    public javax.swing.JMenuItem miCadMunicipio;
    public javax.swing.JMenuItem miCancelaContas;
    public javax.swing.JMenuItem miDivideContas;
    public javax.swing.JMenuItem miRelFinancas;
    public javax.swing.JMenuItem miUsuario;
    // End of variables declaration//GEN-END:variables
}
