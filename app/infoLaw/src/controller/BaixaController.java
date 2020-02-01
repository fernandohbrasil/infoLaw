package controller;

import dao.ContaDao;
import dao.EntidadeDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import model.Conta;
import model.Entidade;
import model.SubConta;
import util.CurrencyUtil;
import util.DateUtil;
import view.FormBaixaConta;
import view.consulta.FormConsultaEntidade;
import view.model.SubContaModel;
import view.model.EntidadeModel;

public class BaixaController {

    private FormBaixaConta frmBaixaConta;
    private final ContaDao dao;

    ArrayList<SubConta> parcelas;

    private final EntidadeModel entidadeModel;
    private final EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private final FormConsultaEntidade frmConsEntidade;
    private final SubContaModel contaModel;

    public BaixaController() {
        frmBaixaConta = new FormBaixaConta(frmBaixaConta, true);
        frmConsEntidade = new FormConsultaEntidade(frmBaixaConta, true);

        contaModel = new SubContaModel();

        dao = new ContaDao();
        entidadeModel = new EntidadeModel();
        entDao = new EntidadeDao();

        inicializarComponente();
    }

    private void inicializarComponente() {
        frmBaixaConta.cbxEntidade.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                //
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                selecionaCliente();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                //
            }
        });

        // Vincular o Table Model com a jTable
        frmConsEntidade.tbEntidade.setModel(entidadeModel);
        frmConsEntidade.tbEntidade.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selecionaClienteId();
                }
            }
        });

        frmBaixaConta.btnConsCli.addActionListener((ActionEvent e) -> {
            consultarEntidade();
        });

        frmBaixaConta.btnPagar.addActionListener((ActionEvent e) -> {
            baixarParcela();
        });

        frmBaixaConta.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmConsEntidade.btnFecha.addActionListener((ActionEvent e) -> {
            fecharConsulta();
        });

        frmBaixaConta.tbLancamentos.setModel(contaModel);

        frmBaixaConta.btnFiltrar.addActionListener((ActionEvent e) -> {
            filtrar();
        });

        frmBaixaConta.tbLancamentos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            atualizaInformacoesContaSelecionada();
        });

        frmBaixaConta.edtDtIni.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                frmBaixaConta.edtDtIni.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        frmBaixaConta.edtDtFin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                frmBaixaConta.edtDtFin.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        frmBaixaConta.edtNovaData.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                frmBaixaConta.edtNovaData.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        frmBaixaConta.edtValorParcial.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                frmBaixaConta.edtValorParcial.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        frmBaixaConta.btnPagParcial.addActionListener((ActionEvent e) -> {
            pagaParcial();
        });
    }

    private void fecharConsulta() {
        frmConsEntidade.setVisible(false);

        frmBaixaConta.setVisible(true);
    }

    private void fechar() {
        frmBaixaConta.setVisible(false);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        frmBaixaConta.lblResultado.setText("Total Demonstrado: R$ 0,00 ");
        frmBaixaConta.lblQtdParc.setText("Quantidade de Parcelas: 0 ");

        frmBaixaConta.txObs.setText("Observação: ");
        frmBaixaConta.cbData.setSelected(true);
        frmBaixaConta.cbEntidade.setSelected(false);
        frmBaixaConta.rgReceber.setSelected(true);
        frmBaixaConta.rgDtVenc.setSelected(true);
        frmBaixaConta.cbxEntidade.setSelectedIndex(-1);
        frmBaixaConta.edtCliente.setText(null);
        frmBaixaConta.edtDtIni.setText(DateUtil.fullDateNow());
        frmBaixaConta.edtDtFin.setText(DateUtil.fullDateNow());

        frmBaixaConta.edtValorParcial.setText("0,00");
        frmBaixaConta.edtNovaData.setText(DateUtil.dateToString(DateUtil.addMonth(Date.from(Instant.now()), 1)));

        contaModel.limpar();
        contaModel.fireTableDataChanged();
    }

    private void carregaEntidades() {
        frmBaixaConta.cbxEntidade.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        entidades.forEach((entidades) -> {
            frmBaixaConta.cbxEntidade.addItem(entidades.getNome());
        });
    }

    private void selecionaCliente() {
        if (frmBaixaConta.cbxEntidade.getSelectedIndex() > -1) {
            frmBaixaConta.edtCliente.setText(String.valueOf(this.entidades.get(frmBaixaConta.cbxEntidade.getSelectedIndex()).getId()));
        }
    }

    public void baixaContas() {
        carregaEntidades();
        limparCampos();

        //Mostrando a tela 
        frmBaixaConta.setVisible(true);
    }

    private void selecionaClienteId() {
        // recuperar a posição do objeto selecionado
        int posicao = frmConsEntidade.tbEntidade.getSelectedRow();

        // buscar o objeto 
        Entidade entidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmBaixaConta.edtCliente.setText(Integer.toString(entidade.getId()));
        frmBaixaConta.cbxEntidade.setSelectedItem(entidade.getNome());

        // fechar o formulário de consulta
        frmConsEntidade.setVisible(false);
        // abrir o formulário de cadastro
        frmBaixaConta.setVisible(true);

        // chamar o carrega objeto, para atualizar
        // o model e atualizar a jTable
        carregarEntidades();
    }

    public void consultarEntidade() {
        carregarEntidades();
        frmBaixaConta.setVisible(false);

        // Mostrando a tela 
        frmConsEntidade.setVisible(true);
    }

    private void carregarEntidades() {
        entidadeModel.limpar();

        // Usar o DAO para buscar os objetos e adicionar no Table Model
        List<Entidade> todos = entDao.buscarTodos();
        todos.forEach((entidade) -> {
            entidadeModel.addEntidade(entidade);
        });
    }

    private void atualizaInformacoesContaSelecionada() {
        if (frmBaixaConta.tbLancamentos.getSelectedRow() >= 0) {
            SubConta subConta = contaModel.getSubConta(frmBaixaConta.tbLancamentos.getSelectedRow());
            frmBaixaConta.txObs.setText(subConta.getConta().getObs());
            frmBaixaConta.edtValorParcial.setText(CurrencyUtil.getFormatCurrency(subConta.getValorParcela()));
        }
    }

    private List<SubConta> porData() {
        if (validaData()) {
            Date ini = DateUtil.stringToDate(frmBaixaConta.edtDtIni.getText());
            Date fin = DateUtil.stringToDate(frmBaixaConta.edtDtFin.getText());

            if (frmBaixaConta.rgDtVenc.isSelected()) {
                //vencimento                    
                return dao.buscaDataVencimento(ini, fin, getStatus());
            } else {
                //pagamento                    
                return dao.buscaDataPagamento(ini, fin, getStatus());
            }
        } else {
            JOptionPane.showMessageDialog(frmBaixaConta, "Data Inicial ou Final inválida!");
            return null;
        }
    }

    private void filtrar() {
        List<SubConta> todos = null;
        if (frmBaixaConta.cbData.isSelected() && (!frmBaixaConta.cbEntidade.isSelected())) {
            todos = porData();
        } else if (frmBaixaConta.cbData.isSelected() && (frmBaixaConta.cbEntidade.isSelected())) {
            //por data com cliente
            if (validaData()) {
                Date ini = DateUtil.stringToDate(frmBaixaConta.edtDtIni.getText());
                Date fin = DateUtil.stringToDate(frmBaixaConta.edtDtFin.getText());
                int entidadeId = Integer.parseInt(frmBaixaConta.edtCliente.getText());

                if (frmBaixaConta.rgDtVenc.isSelected()) {
                    //vencimento                    
                    todos = dao.buscaDataVencimentoCliente(ini, fin, getStatus(), entidadeId);
                } else {
                    //pagamento
                    todos = dao.buscaDataPagamentoCliente(ini, fin, getStatus(), entidadeId);
                }
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Data Inicial ou Final inválida!");
            }

        } else if (!frmBaixaConta.cbData.isSelected() && (frmBaixaConta.cbEntidade.isSelected())) {
            //Apenas Cliente
            if (validaCliente()) {
                int entidadeId = Integer.parseInt(frmBaixaConta.edtCliente.getText());

                todos = dao.buscaCliente(getStatus(), entidadeId);
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Cliente não selecionado!"
                        + "\n * Necessário que apareça o nome do cliente na tela!");
                frmBaixaConta.cbxEntidade.grabFocus();
            }
        }

        double total = 0.00;
        contaModel.limpar();
        if (todos != null) {
            for (SubConta subconta : todos) {
                total = total + subconta.getValorParcela();
                contaModel.addSubConta(subconta);
            }
            frmBaixaConta.lblResultado.setText("Total Demonstrado: R$ " + CurrencyUtil.getFormatCurrency(total));
            frmBaixaConta.lblQtdParc.setText("Quantidade de Parcelas: " + todos.size());
        }
        contaModel.fireTableDataChanged();

        if (frmBaixaConta.tbLancamentos.getRowCount() > 0) {
            frmBaixaConta.tbLancamentos.setRowSelectionInterval(0, 0);
        }
    }

    private boolean validaCliente() {
        try {
            return frmBaixaConta.cbxEntidade.getSelectedItem() != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaData() {
        boolean validou;

        validou = DateUtil.validaData(frmBaixaConta.edtDtIni.getText());
        return validou == DateUtil.validaData(frmBaixaConta.edtDtFin.getText());
    }

    private void baixarParcela() {
        if (temParcelas()) {
            int posicao = frmBaixaConta.tbLancamentos.getSelectedRow();
            SubConta subConta = contaModel.getSubConta(posicao);

            if (subConta.getValorPago() <= 0) {
                if (dao.baixarSubConta(subConta)) {
                    JOptionPane.showMessageDialog(frmBaixaConta, "Parcela paga com sucesso!");
                    filtrar();
                } else {
                    JOptionPane.showMessageDialog(frmBaixaConta, "Erro ao pagar parcela!");
                }
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Essa Parcela já está paga");
            }
        } else {
            JOptionPane.showMessageDialog(frmBaixaConta, "Selecione uma parcela!");
        }
    }

    private int getStatus() {
        if (frmBaixaConta.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }

    private void pagaParcial() {
        SubConta subConta = getOldSubConta();
        if (validaCamposParcial(subConta)) {
            if (JOptionPane.showConfirmDialog(frmBaixaConta, ""
                    + "Deseja fazer o pagamento Parcial da Parcela selecionada?\n"
                    + "\n"
                    + "Será gerado uma nova parcela com o valor da\n"
                    + "diferença com a Data de Vencimento selecionada!") == 0) {

                if (geraNovaConta(subConta)) {
                    baixarParcela();
                }
            }
        }
    }

    private boolean geraNovaConta(SubConta oldSubConta) {
        try {
            Conta conta = new Conta();
            SubConta subConta = new SubConta();
            ArrayList<SubConta> parcelas = new ArrayList<>();

            conta.setId(Integer.parseInt(String.valueOf(dao.getNextId())));

            Entidade entidade = new Entidade();
            entidade.setId(oldSubConta.getConta().getEntidade().getId());
            conta.setEntidade(entidade);

            conta.setValorTotal(Double.sum(oldSubConta.getValorParcela(), -CurrencyUtil.getValorFromEdit(frmBaixaConta.edtValorParcial.getText())));
            conta.setDataCriacao(Date.from(Instant.now()));
            conta.setStatus(oldSubConta.getConta().getStatus());
            conta.setObs("Parcela Gerada atraves do Pagamento parcial da parcela: \n"
                    + "Conta: " + oldSubConta.getConta().getId() + "\n"
                    + "Parcela: " + oldSubConta.getSequencia() + "\n"
                    + "Data Vencimento Original: " + DateUtil.dateToString(oldSubConta.getDataVencimento()) + "\n"
                    + "Valor da Parcela Original: " + oldSubConta.getValorParcela() + "\n"
                    + "\n"
                    + ((oldSubConta.getConta().getObs() == null || oldSubConta.getConta().getObs().isEmpty()) ? ""
                    : "Observacao Original: " + oldSubConta.getConta().getObs()));

            subConta.setConta(conta);
            subConta.setSequencia(1);
            subConta.setDataVencimento(DateUtil.stringToDate(frmBaixaConta.edtNovaData.getText()));
            subConta.setValorParcela(conta.getValorTotal());
            subConta.setSituacao(0);
            parcelas.add(subConta);

            try {
                if (dao.insert(conta, parcelas)) {
                    JOptionPane.showMessageDialog(frmBaixaConta, "Nova Conta Gerada com Sucesso");
                    return true;
                }
            } catch (SQLException ex) {
                return erroPagamentoParcial(ex.getMessage());
            }
        } catch (Exception e) {
            return erroPagamentoParcial(e.getMessage());
        }
        return erroPagamentoParcial(null);
    }

    private SubConta getOldSubConta() {
        int posicao = frmBaixaConta.tbLancamentos.getSelectedRow();
        return contaModel.getSubConta(posicao);
    }

    private boolean validaCamposParcial(SubConta subConta) {
        return temParcelas() && validaValor(subConta) && validaNovaData();
    }

    private boolean temParcelas() {
        return frmBaixaConta.tbLancamentos.getRowCount() > 0;
    }

    private boolean validaValor(SubConta subConta) {
        if (CurrencyUtil.getValorFromEdit(frmBaixaConta.edtValorParcial.getText()) > 0) {
            if (subConta.getValorParcela() > CurrencyUtil.getValorFromEdit(frmBaixaConta.edtValorParcial.getText())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Valor Pago Parcialmente precisa ser menor que o Valor da Parcela!");
                frmBaixaConta.edtValorParcial.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(frmBaixaConta, "Valor Total inválido! Possíveis causas:"
                    + "\n * Número menor ou igual a zero"
                    + "\n * Formatação decimal incorreta");
            frmBaixaConta.edtValorParcial.grabFocus();
            return false;
        }
    }

    private boolean validaNovaData() {
        return DateUtil.validaData(frmBaixaConta.edtNovaData.getText());
    }

    private boolean erroPagamentoParcial(String erro) {
        JOptionPane.showMessageDialog(frmBaixaConta, "Houve um erro ao gravar a informação no banco de dados! \n"
                + "Consulte a parcela gerada, caso não a localize! Repita o procedimento de gravação."
                + "\n\n"
                + erro);
        return false;
    }
}
