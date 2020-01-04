package controller;

import dao.ContaDao;
import dao.EntidadeDao;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
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
            buscarObs();
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

    private void buscarObs() {
        if (frmBaixaConta.tbLancamentos.getSelectedRow() >= 0) {
            frmBaixaConta.txObs.setText(dao.getObsConta(contaModel.getSubConta(frmBaixaConta.tbLancamentos.getSelectedRow()).getConta().getId()));
        }
    }
        
    private List<SubConta> porData(){        
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
        int posicao = frmBaixaConta.tbLancamentos.getSelectedRow();

        SubConta oSubConta = contaModel.getSubConta(posicao);

        if (oSubConta.getValorPago() <= 0) {
            if (dao.baixarSubConta(oSubConta)) {
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