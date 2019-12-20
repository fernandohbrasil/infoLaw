package controller;

import java.awt.event.ActionEvent;
import view.FormMenuPrincipal;

public class PrincipalController {
    private final FormMenuPrincipal frmPrincipal;
    private final MunicipioController municipioCtrl;
    private final EntidadeController entidadeCtrl;
    private final ContaController contaCtrl;
    private final BaixaController baixaCtrl;
    private final RelatorioBaseController relatorioBaseCtrl;
    private final CancelaContasController cancelaContasCtrl;
    private final DivideValoresController divideValoresCtrl;

    public PrincipalController() {
        frmPrincipal = new FormMenuPrincipal();
        municipioCtrl = new MunicipioController();
        entidadeCtrl = new EntidadeController();
        contaCtrl = new ContaController();
        baixaCtrl = new BaixaController();
        relatorioBaseCtrl = new RelatorioBaseController();
        cancelaContasCtrl = new CancelaContasController();
        divideValoresCtrl = new DivideValoresController();

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        frmPrincipal.miCadMunicipio.addActionListener((ActionEvent e) -> {
            municipioCtrl.cadastrarMunicipio();
        });

        frmPrincipal.miCadEntidade.addActionListener((ActionEvent e) -> {
            entidadeCtrl.cadastrarEntidade();
        });

        frmPrincipal.miCadLancamento.addActionListener((ActionEvent e) -> {
            contaCtrl.lancarConta();
        });

        frmPrincipal.miBaixaLancamento.addActionListener((ActionEvent e) -> {
            baixaCtrl.baixaContas();
        });
        
        frmPrincipal.miRelFinancas.addActionListener((ActionEvent e) -> {
            relatorioBaseCtrl.init();
        });

        frmPrincipal.miCancelaContas.addActionListener((ActionEvent e) -> {
            cancelaContasCtrl.cancelaContas();
        });

        frmPrincipal.miDivideContas.addActionListener((ActionEvent e) -> {
            divideValoresCtrl.divideContas();
        });
    }

    public void executar() {
        frmPrincipal.setVisible(true);
    }
}
