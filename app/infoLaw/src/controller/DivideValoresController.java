package controller;

import dao.ContaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.SubConta;
import util.CurrencyUtil;
import view.FormDivideValores;
import view.model.SubContaModel;

public class DivideValoresController {

    private FormDivideValores frmDivideValores;
    private final ContaDao dao;

    private ArrayList<SubConta> parcelas;
    private final SubContaModel subContaModel;

    public DivideValoresController() {
        frmDivideValores = new FormDivideValores(frmDivideValores, true);
        subContaModel = new SubContaModel();
        dao = new ContaDao();

        inicializarComponente();
    }

    private void inicializarComponente() {

        frmDivideValores.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmDivideValores.tbParcelas.setModel(subContaModel);

        frmDivideValores.btnDivide.addActionListener((ActionEvent e) -> {
            divideValores();
        });

        frmDivideValores.btnFiltrar.addActionListener((ActionEvent e) -> {
            filtrarParcelas();
        });
    }

    private void fechar() {
        frmDivideValores.setVisible(false);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        subContaModel.limpar();
        subContaModel.fireTableDataChanged();

        frmDivideValores.rgReceber.setSelected(true);
    }

    public void divideContas() {
        //Mostrando a tela 
        limparCampos();
        filtrarParcelas();
        frmDivideValores.setVisible(true);
    }

    private void filtrarParcelas() {
        List<SubConta> todos;
        double total = 0;
        todos = dao.buscaParcelasNaoDividas(getPagaRecebe());

        subContaModel.limpar();
        for (SubConta subConta : todos) {
            subContaModel.addSubConta(subConta);
            total = total + subConta.getValorParcela();
        }

        frmDivideValores.lblTotal.setText("Total: R$ " + CurrencyUtil.getFormatCurrency(total));
        subContaModel.fireTableDataChanged();
    }

    private int getPagaRecebe() {
        if (frmDivideValores.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }

    private void divideValores() {
        int contaId;
        int sequencia;

        contaId = subContaModel.getSubConta(frmDivideValores.tbParcelas.getSelectedRow()).getConta().getId();
        sequencia = subContaModel.getSubConta(frmDivideValores.tbParcelas.getSelectedRow()).getSequencia();

        if ((contaId > 0) && (sequencia > 0)) {
            int respota = JOptionPane.showConfirmDialog(frmDivideValores, "Você está prestes a realizar a divisão desse valor Recebido! \n"
                    + "Confirma o procedimento?");
            if (respota == 0) {
                dao.divideParcela(contaId, sequencia);
                filtrarParcelas();
            }
        }
    }
}
