package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FormMenuPrincipal;

public class PrincipalController {

    private FormMenuPrincipal frmPrincipal;
    private MunicipioController municipioCtrl;
    private EntidadeController entidadeCtrl;
    private ContaController contaCtrl;
    private BaixaController baixaCtrl;
    private CancelaContasController cancelaContasCtrl;
    private DivideValoresController divideValoresCtrl;

    public PrincipalController() {
        frmPrincipal = new FormMenuPrincipal();
        municipioCtrl = new MunicipioController();
        entidadeCtrl = new EntidadeController();
        contaCtrl = new ContaController();
        baixaCtrl = new BaixaController();
        cancelaContasCtrl = new CancelaContasController();
        divideValoresCtrl = new DivideValoresController();

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        frmPrincipal.miCadMunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                municipioCtrl.cadastrarMunicipio();
            }
        });

        frmPrincipal.miCadEntidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadeCtrl.cadastrarEntidade();
            }
        });

        frmPrincipal.miCadLancamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contaCtrl.lancarConta();
            }
        });

        frmPrincipal.miBaixaLancamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baixaCtrl.baixaContas();
            }
        });

        frmPrincipal.miCancelaContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelaContasCtrl.cancelaContas();
            }
        });

        frmPrincipal.miDivideContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                divideValoresCtrl.divideContas();
            }
        });
    }

    public void executar() {
        frmPrincipal.setVisible(true);
    }
}
