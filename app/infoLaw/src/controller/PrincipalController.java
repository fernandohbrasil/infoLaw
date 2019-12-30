package controller;

import java.awt.event.ActionEvent;
import view.FormMenuPrincipal;

public class PrincipalController {
    private final FormMenuPrincipal frmPrincipal;

    public PrincipalController() {
        frmPrincipal = new FormMenuPrincipal();
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        frmPrincipal.miCadMunicipio.addActionListener((ActionEvent e) -> {
            new MunicipioController().cadastrarMunicipio();
        });

        frmPrincipal.miCadEntidade.addActionListener((ActionEvent e) -> {
            new EntidadeController().cadastrarEntidade();
        });

        frmPrincipal.miCadLancamento.addActionListener((ActionEvent e) -> {
            new ContaController().lancarConta();
        });

        frmPrincipal.miBaixaLancamento.addActionListener((ActionEvent e) -> {
            new BaixaController().baixaContas();
        });
        
        frmPrincipal.miRelFinancas.addActionListener((ActionEvent e) -> {
            new RelatorioBaseController().init();
        });

        frmPrincipal.miCancelaContas.addActionListener((ActionEvent e) -> {
            new CancelaContasController().cancelaContas();
        });

        frmPrincipal.miDivideContas.addActionListener((ActionEvent e) -> {
            new DivideValoresController().divideContas();
        });
        
        frmPrincipal.miUsuario.addActionListener(((ActionEvent e) -> {
            new UsuarioController().cadastrarUsuario();
        }));
    }

    public void executar() {
        frmPrincipal.setVisible(true);
    }
}