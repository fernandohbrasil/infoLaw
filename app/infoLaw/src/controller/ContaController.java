package controller;

import util.DateUtil;
import dao.ContaDao;
import dao.EntidadeDao;
import java.awt.event.ActionEvent;
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
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import model.Conta;
import model.Entidade;
import model.SubConta;
import util.CurrencyUtil;
import view.FormLancaConta;
import view.consulta.FormConsultaEntidade;
import view.model.EntidadeModel;

public class ContaController {

    private final FormLancaConta frmLancaConta;
    private final ContaDao dao;

    private Conta conta;
    ArrayList<SubConta> parcelas;

    private Entidade entidade;
    private final EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private final FormConsultaEntidade frmConsEntidade;
    private final EntidadeModel entidadeModel;

    public ContaController() {
        frmLancaConta = new FormLancaConta(null, true);
        frmConsEntidade = new FormConsultaEntidade(frmLancaConta, true);

        conta = new Conta();
        parcelas = new ArrayList<>();

        dao = new ContaDao();
        entidade = new Entidade();
        entidadeModel = new EntidadeModel();
        entDao = new EntidadeDao();

        inicializarComponente();
    }

    private void inicializarComponente() {
        frmLancaConta.cbCliente.addPopupMenuListener(new PopupMenuListener() {
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

        frmLancaConta.btnConsulta.addActionListener((ActionEvent e) -> {
            consultar();
        });

        frmLancaConta.btnGeraParc.addActionListener((ActionEvent e) -> {
            mostraParcelas();
        });

        frmLancaConta.btnGrava.addActionListener((ActionEvent e) -> {
            try {
                gravar();
            } catch (SQLException ex) {
                Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        frmLancaConta.btnCancela.addActionListener((ActionEvent e) -> {
            limparCampos();
        });

        frmLancaConta.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmConsEntidade.btnFecha.addActionListener((ActionEvent e) -> {
            fecharConsulta();
        });
    }

    private void fecharConsulta() {
        frmConsEntidade.setVisible(false);

        frmLancaConta.setVisible(true);
    }

    private void fechar() {
        frmLancaConta.setVisible(false);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        frmLancaConta.edtCodigo.setText(null);
        frmLancaConta.edtCliente.setText(null);
        frmLancaConta.cbCliente.setSelectedIndex(-1);
        frmLancaConta.rgReceber.setSelected(true);
        frmLancaConta.cbVista.setSelected(false);
        frmLancaConta.edtData.setText(DateUtil.fullDateNow());
        frmLancaConta.edtQtdParc.setText("1");
        frmLancaConta.edtTotal.setText("0,00");
        frmLancaConta.txParcelas.setText(null);
        frmLancaConta.txObs.setText("Observação:");
    }

    private void carregaEntidades() {
        frmLancaConta.cbCliente.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        entidades.forEach((entidade) -> {
            frmLancaConta.cbCliente.addItem(entidade.getNome());
        });
    }

    private void selecionaCliente() {
        if (frmLancaConta.cbCliente.getSelectedIndex() > -1) {
            frmLancaConta.edtCliente.setText(String.valueOf(this.entidades.get(frmLancaConta.cbCliente.getSelectedIndex()).getId()));
        }
    }

    public void lancarConta() {
        carregaEntidades();
        limparCampos();

        //Mostrando a tela 
        frmLancaConta.setVisible(true);
    }

    private void selecionaClienteId() {
        // recuperar a posição do objeto selecionado
        int posicao = frmConsEntidade.tbEntidade.getSelectedRow();

        // buscar o objeto 
        entidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmLancaConta.edtCliente.setText(Integer.toString(entidade.getId()));
        frmLancaConta.cbCliente.setSelectedItem(entidade.getNome());

        // fechar o formulário de consulta
        frmConsEntidade.setVisible(false);
        // abrir o formulário de cadastro
        frmLancaConta.setVisible(true);

        // chamar o carrega objeto, para atualizar
        // o model e atualizar a jTable
        carregarEntidades();
    }

    public void consultar() {
        carregarEntidades();
        frmLancaConta.setVisible(false);

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

    private void mostraParcelas() {
        if (validaCampos()) {
            gerarParcelas();

            String parcelasInfo;

            parcelasInfo = "Conta: " + this.conta.getId() + "\n"
                    + "Cliente: " + this.conta.getEntidade().getNome() + "\n"
                    + "Data Lançamento: " + DateUtil.dateToString(this.conta.getDataCriacao()) + "\n"
                    + "Valor Total: " + this.conta.getValorTotalFormatado() + "\n\n";

            for (int i = 0; i < this.parcelas.size(); i++) {
                parcelasInfo = parcelasInfo
                        + "    Parcela: " + this.parcelas.get(i).getSequencia() + "\n"
                        + "    Data de Vencimento: " + DateUtil.dateToString(this.parcelas.get(i).getDataVencimento()) + "\n"
                        + "    Data de Pagamento: " + DateUtil.dateToString(this.parcelas.get(i).getDataPagamento()) + "\n"
                        + "    Valor Parcela: " + this.parcelas.get(i).getValorParcelaFormatado() + "\n"
                        + "    Valor Pago: " + this.parcelas.get(i).getValorPagoFormatado() + "\n\n";
            }
            frmLancaConta.txParcelas.setText(parcelasInfo);
        }
    }

    private void gravar() throws SQLException {
        if ((!frmLancaConta.txParcelas.getText().isEmpty()) && (this.parcelas.size() > 0)) {
            this.conta.setObs(frmLancaConta.txObs.getText());

            if (dao.insert(conta, parcelas)) {
                JOptionPane.showMessageDialog(frmLancaConta, "Parcelas Gravadas com Sucesso");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(frmLancaConta, "Houve um erro ao gravar a informação no banco de dados! \n"
                        + "Consulte a parcela gerada, caso não a localize! Repita o procedimento de gravação.");
            }
        } else {
            JOptionPane.showMessageDialog(frmLancaConta, "ERRO ao gravar! Necessário Gerar as Parcelas");
        }
    }

    private int getStatus() {
        if (frmLancaConta.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }

    private void gerarParcelas() {
        this.conta = new Conta();
        this.parcelas = new ArrayList<>();

        int qtdParcelas = Integer.parseInt(frmLancaConta.edtQtdParc.getText());

        this.conta.setId(Integer.parseInt(String.valueOf(dao.getNextId())));
        this.conta.setEntidade(this.entidades.get(frmLancaConta.cbCliente.getSelectedIndex()));
        this.conta.setValorTotal(CurrencyUtil.getValorFromEdit(frmLancaConta.edtTotal.getText()));
        this.conta.setDataCriacao(Date.from(Instant.now()));
        this.conta.setStatus(getStatus());

        if (frmLancaConta.cbVista.isSelected()) {
            SubConta subConta = new SubConta();
            subConta.setConta(conta);
            subConta.setSequencia(1);
            subConta.setDataPagamento(DateUtil.stringToDate(frmLancaConta.edtData.getText()));
            subConta.setDataVencimento(DateUtil.stringToDate(frmLancaConta.edtData.getText()));
            subConta.setValorPago(conta.getValorTotal());
            subConta.setValorParcela(conta.getValorTotal());
            subConta.setSituacao(1);
            this.parcelas.add(subConta);
        } else {
            for (int i = 0; i < qtdParcelas; i++) {
                SubConta oSubConta = new SubConta();

                oSubConta.setConta(conta);
                oSubConta.setSequencia(i + 1);
                oSubConta.setValorParcela(conta.getValorTotal() / qtdParcelas);
                oSubConta.setDataVencimento(DateUtil.addMonth(DateUtil.stringToDate(frmLancaConta.edtData.getText()), i));

                this.parcelas.add(oSubConta);
            }

            if (DateUtil.fullDateNow().equals(frmLancaConta.edtData.getText())) {
                int respota = JOptionPane.showConfirmDialog(frmLancaConta, "A Data de vencimento da primeira parcela é "
                        + "igual a data atual!\n"
                        + "Deseja gerar a primeira parcela paga?");

                if (respota == 0) {
                    this.parcelas.get(0).setSituacao(1);
                    this.parcelas.get(0).setDataPagamento(Date.from(Instant.now()));
                    this.parcelas.get(0).setValorPago(conta.getValorTotal() / qtdParcelas);
                }
            }
        }
    }

    private boolean validaCampos() {
        return validaCliente() && validaTotal() && validaParcelas() && validaData();
    }

    private boolean validaTotal() {
        if (CurrencyUtil.getValorFromEdit(frmLancaConta.edtTotal.getText()) > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frmLancaConta, "Valor Total inválido! Possíveis causas:"
                    + "\n * Número menor ou igual a zero"
                    + "\n * Formatação decimal incorreta");
            frmLancaConta.edtTotal.grabFocus();
            return false;
        }
    }

    private boolean validaParcelas() {
        try {
            return Integer.valueOf(frmLancaConta.edtQtdParc.getText()) > 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frmLancaConta, "Quantidade de parcelas inválida! Possíveis causas:"
                    + "\n * Número menor ou igual a zero"
                    + "\n * Formatação decimal incorreta");
            frmLancaConta.edtQtdParc.grabFocus();
            return false;
        }
    }

    private boolean validaData() {
        try {
            return DateUtil.validaData(frmLancaConta.edtData.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmLancaConta, "Data de Vencimento inválida! Possíveis causas:"
                    + "\n * Campo Vazio"
                    + "\n * Formatação incorreta, seguir o padrão DD/MM/AAAA"
                    + "\n \n"
                    + "Essa data é utilizada como base para a primeira parcela, \n"
                    + "as demais serão lançadas num interválo de 30 dias");
            frmLancaConta.edtData.grabFocus();
            return false;
        }
    }

    private boolean validaCliente() {
        try {
            return frmLancaConta.cbCliente.getSelectedItem() != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmLancaConta, "Cliente não selecionado!"
                    + "\n * Necessário que apareça o nome do cliente na tela!");
            frmLancaConta.cbCliente.grabFocus();
            return false;
        }
    }
}
