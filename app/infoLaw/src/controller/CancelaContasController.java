package controller;

import dao.ContaDao;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Conta;
import model.SubConta;
import view.FormCancelaConta;
import view.model.ContaModel;
import view.model.ParcelaContaModel;

public class CancelaContasController {

    private final FormCancelaConta frmCancelaConta;
    private final ContaDao dao;

    private ArrayList<SubConta> parcelas;

    private final ContaModel contaModel;
    private final ParcelaContaModel subContaModel;

    public CancelaContasController() {
        frmCancelaConta = new FormCancelaConta(null, true);

        contaModel = new ContaModel();
        subContaModel = new ParcelaContaModel();

        dao = new ContaDao();
        inicializarComponente();
    }

    private void inicializarComponente() {
        frmCancelaConta.btnCancelaContas.addActionListener((ActionEvent e) -> {
        });

        frmCancelaConta.btnCancelaParc.addActionListener((ActionEvent e) -> {
        });

        frmCancelaConta.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmCancelaConta.tbContas.setModel(contaModel);
        frmCancelaConta.tbParcelas.setModel(subContaModel);

        frmCancelaConta.btnFiltrar.addActionListener((ActionEvent e) -> {
            filtrarContas();
        });

        frmCancelaConta.tbContas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    filtrarParcelas();
                }
            }
        });

        frmCancelaConta.btnCancelaContas.addActionListener((ActionEvent e) -> {
            cancelaConta();
        });

        frmCancelaConta.btnCancelaParc.addActionListener((ActionEvent e) -> {
            cancelaParcela();
        });
    }

    private void fechar() {
        frmCancelaConta.setVisible(false);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        subContaModel.limpar();
        subContaModel.fireTableDataChanged();

        contaModel.limpar();
        contaModel.fireTableDataChanged();

        frmCancelaConta.rgReceber.setSelected(true);
    }

    public void cancelaContas() {
        //Mostrando a tela 
        limparCampos();
        frmCancelaConta.setVisible(true);
    }

    private void filtrarContas() {
        List<Conta> todos;

        todos = dao.buscaContas(getPagaRecebe());

        contaModel.limpar();
        todos.forEach((oConta) -> {
            contaModel.addConta(oConta);
        });
        contaModel.fireTableDataChanged();
    }

    private void filtrarParcelas() {
        List<SubConta> todos;

        todos = dao.buscaParcelas(contaModel.getConta(frmCancelaConta.tbContas.getSelectedRow()).getId());

        subContaModel.limpar();
        todos.forEach((oSubConta) -> {
            subContaModel.addSubConta(oSubConta);
        });
        subContaModel.fireTableDataChanged();
    }

    private int getPagaRecebe() {
        if (frmCancelaConta.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }

    private void cancelaConta() {
        int contaId;

        contaId = contaModel.getConta(frmCancelaConta.tbContas.getSelectedRow()).getId();

        if (contaId > 0) {
            int respota = JOptionPane.showConfirmDialog(frmCancelaConta, "Você está prestes a cancelar TODAS as parcelas desta conta! \n"
                    + "Confirma o procedimento?");
            if (respota == 0) {
                dao.cancelaConta(contaId);
                filtrarParcelas();

            }
        }
    }

    private void cancelaParcela() {
        int contaId;
        int sequencia;

        contaId = contaModel.getConta(frmCancelaConta.tbContas.getSelectedRow()).getId();
        sequencia = subContaModel.getSubConta(frmCancelaConta.tbParcelas.getSelectedRow()).getSequencia();

        if ((contaId > 0) && (sequencia > 0)) {
            int respota = JOptionPane.showConfirmDialog(frmCancelaConta,
                    "Você está prestes cancelar a parcela selcionada! \n"
                    + "Confirma o procedimento?");
            if (respota == 0) {
                dao.cancelaParcela(contaId, sequencia);
                filtrarParcelas();
            }
        }
    }
}
