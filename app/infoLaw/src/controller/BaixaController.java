package controller;

import util.DateUtil;
import dao.ContaDao;
import dao.EntidadeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import model.Entidade;
import model.SubConta;
import view.FormBaixaConta;
import view.consulta.FormConsultaEntidade;
import view.model.SubContaModel;
import view.model.EntidadeModel;

public class BaixaController {

    private FormBaixaConta frmBaixaConta;
    private ContaDao dao;

    ArrayList<SubConta> parcelas;

    private Entidade oEntidade;
    private EntidadeModel entidadeModel;
    private EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private FormConsultaEntidade frmConsEntidade;
    private SubContaModel contaModel;

    private DateUtil oUtil;

    public BaixaController() {
        frmBaixaConta = new FormBaixaConta(frmBaixaConta, true);
        frmConsEntidade = new FormConsultaEntidade(frmBaixaConta, true);

        contaModel = new SubContaModel();

        dao = new ContaDao();
        oEntidade = new Entidade();
        entidadeModel = new EntidadeModel();
        entDao = new EntidadeDao();

        oUtil = new DateUtil();

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
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selecionaClienteId();
                }
            }
        });

        frmBaixaConta.btnConsCli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarEntidade();
            }
        });

        frmBaixaConta.btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baixarParcela();
            }
        });

        frmBaixaConta.btnFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        frmConsEntidade.btnFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharConsulta();
            }
        });

        frmBaixaConta.tbLancamentos.setModel(contaModel);

        frmBaixaConta.btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrar();
            }
        });

        frmBaixaConta.tbLancamentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                buscarObs();
            }
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
        frmBaixaConta.lblResultado.setText("Total Demonstrado: 0.0 ");
        frmBaixaConta.lblQtdParc.setText("Quantidade de Parcelas: 0 ");

        frmBaixaConta.txObs.setText("Observação: ");
        frmBaixaConta.cbData.setSelected(true);
        frmBaixaConta.cbEntidade.setSelected(false);
        frmBaixaConta.rgReceber.setSelected(true);
        frmBaixaConta.rgDtVenc.setSelected(true);
        frmBaixaConta.cbxEntidade.setSelectedIndex(-1);
        frmBaixaConta.edtCliente.setText(null);
        frmBaixaConta.edtDtIni.setText(oUtil.getFormt().format(Date.from(Instant.now())));
        frmBaixaConta.edtDtFin.setText(oUtil.getFormt().format(Date.from(Instant.now())));
        //frmBaixaConta.edtDtFin.setText(oUtil.lastDayOfMonth() + "/" + oUtil.monthNow() + "/" + oUtil.yearNow());

        contaModel.limpar();
        contaModel.fireTableDataChanged();
    }

    private void carregaEntidades() {
        frmBaixaConta.cbxEntidade.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        for (Entidade entidades : entidades) {
            frmBaixaConta.cbxEntidade.addItem(entidades.getNome());
        }
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
        oEntidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmBaixaConta.edtCliente.setText(Integer.toString(oEntidade.getId()));
        frmBaixaConta.cbxEntidade.setSelectedItem(oEntidade.getNome());

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

    private void buscarObs() {
        if (frmBaixaConta.tbLancamentos.getSelectedRow() >= 0) {
            frmBaixaConta.txObs.setText(dao.getObsConta(contaModel.getSubConta(frmBaixaConta.tbLancamentos.getSelectedRow()).getConta().getId()));
        }

    }

    private void filtrar() {
        List<SubConta> todos = null;
        if (frmBaixaConta.cbData.isSelected() && (!frmBaixaConta.cbEntidade.isSelected())) {
            //por data sem cliente
            if (validaData()) {
                Date ini = oUtil.stringToDate(frmBaixaConta.edtDtIni.getText());
                Date fin = oUtil.stringToDate(frmBaixaConta.edtDtFin.getText());

                if (frmBaixaConta.rgDtVenc.isSelected()) {
                    //vencimento                    
                    todos = dao.buscaDataVencimento(ini, fin, getStatus());
                } else {
                    //pagamento                    
                    todos = dao.buscaDataPagamento(ini, fin, getStatus());
                }
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Data Inicial ou Final inválida!");
            }

        } else if (frmBaixaConta.cbData.isSelected() && (frmBaixaConta.cbEntidade.isSelected())) {
            //por data com cliente
            if (validaData()) {
                Date ini = oUtil.stringToDate(frmBaixaConta.edtDtIni.getText());
                Date fin = oUtil.stringToDate(frmBaixaConta.edtDtFin.getText());
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

            frmBaixaConta.lblResultado.setText("Total Demonstrado: " + total);
            frmBaixaConta.lblQtdParc.setText("Quantidade de Parcelas: " + todos.size());
        }

        contaModel.fireTableDataChanged();
    }

    private boolean validaCliente() {
        try {
            return frmBaixaConta.cbxEntidade.getSelectedItem() != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaData() {
        boolean validou = false;

        validou = oUtil.validaData(frmBaixaConta.edtDtIni.getText());
        return validou == oUtil.validaData(frmBaixaConta.edtDtFin.getText());
    }

    private void baixarParcela() {
        int posicao = frmBaixaConta.tbLancamentos.getSelectedRow();

        SubConta oSubConta = contaModel.getSubConta(posicao);

        if (oSubConta.getValorPago() <= 0) {
            if (dao.baixarConta(oSubConta)) {
                JOptionPane.showMessageDialog(frmBaixaConta, "Parcela paga com sucesso!");
                filtrar();
            } else {
                JOptionPane.showMessageDialog(frmBaixaConta, "Erro ao pagar parcela!");
            }
        } else {
            JOptionPane.showMessageDialog(frmBaixaConta, "Essa Parcela já está paga");
        }
    }

    private int getStatus() {
        if (frmBaixaConta.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }
}