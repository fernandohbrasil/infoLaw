package controller;

import util.Util;
import dao.ContaDao;
import dao.EntidadeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import view.FormLancaConta;
import view.consulta.FormConsultaEntidade;
import view.model.EntidadeModel;

public class ContaController {

    private FormLancaConta frmLancaConta;
    private ContaDao dao;

    Conta oConta;
    ArrayList<SubConta> parcelas;

    private Entidade oEntidade;
    private EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private FormConsultaEntidade frmConsEntidade;
    private EntidadeModel entidadeModel;

    private Util oUtil;

    public ContaController() {
        frmLancaConta = new FormLancaConta(null, true);
        frmConsEntidade = new FormConsultaEntidade(frmLancaConta, true);

        oConta = new Conta();
        parcelas = new ArrayList<>();

        dao = new ContaDao();
        oEntidade = new Entidade();
        entidadeModel = new EntidadeModel();
        entDao = new EntidadeDao();

        oUtil = new Util();

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
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selecionaClienteId();
                }
            }
        });

        frmLancaConta.btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultar();
            }
        });

        frmLancaConta.btnGeraParc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraParcelas();
            }
        });

        frmLancaConta.btnGrava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gravar();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        frmLancaConta.btnCancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        frmLancaConta.btnFecha.addActionListener(new ActionListener() {
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
        frmLancaConta.edtData.setText(oUtil.getFormt().format(Date.from(Instant.now())));
        frmLancaConta.edtQtdParc.setText("1");
        frmLancaConta.edtTotal.setText("0.00");
        frmLancaConta.txParcelas.setText(null);
        frmLancaConta.txObs.setText("Observação:");
    }

    private void carregaEntidades() {
        frmLancaConta.cbCliente.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        for (Entidade oEntidade : entidades) {
            frmLancaConta.cbCliente.addItem(oEntidade.getNome());
        }
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
        oEntidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmLancaConta.edtCliente.setText(Integer.toString(oEntidade.getId()));
        frmLancaConta.cbCliente.setSelectedItem(oEntidade.getNome());

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
        for (Entidade oEntidade : todos) {
            entidadeModel.addEntidade(oEntidade);
        }
    }

    private void mostraParcelas() {
        gerarParcelas();

        String parcelas = "";

        parcelas = "Conta: " + this.oConta.getId() + "\n"
                + "Cliente: " + this.oConta.getoEntidade().getNome() + "\n"
                + "Data Lançamento: " + oUtil.dateToString(this.oConta.getDataCriacao()) + "\n"
                + "Valor Total: " + this.oConta.getValorTotal() + "\n\n";

        for (int i = 0; i < this.parcelas.size(); i++) {
            parcelas = parcelas
                    + "    Parcela: " + this.parcelas.get(i).getSequencia() + "\n"
                    + "    Data de Vencimento: " + oUtil.dateToString(this.parcelas.get(i).getDataVencimento()) + "\n"
                    + "    Data de Pagamento: " + oUtil.dateToString(this.parcelas.get(i).getDataPagamento()) + "\n"
                    + "    Valor Parcela: " + this.parcelas.get(i).getValorParcela() + "\n"
                    + "    Valor Pago: " + this.parcelas.get(i).getValorPago() + "\n\n";
        }
        frmLancaConta.txParcelas.setText(parcelas);
    }

    private void gravar() throws SQLException {
        if ((!frmLancaConta.txParcelas.getText().isEmpty()) && (this.parcelas.size() > 0)) {
            this.oConta.setObs(frmLancaConta.txObs.getText());
            
            if (dao.insert(oConta, parcelas)) {
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
        this.oConta = new Conta();
        this.parcelas = new ArrayList<>();

        int qtdParcelas = Integer.parseInt(frmLancaConta.edtQtdParc.getText());

        this.oConta.setId(Integer.parseInt(String.valueOf(dao.getNextId())));
        this.oConta.setoEntidade(this.entidades.get(frmLancaConta.cbCliente.getSelectedIndex()));
        this.oConta.setValorTotal(Double.parseDouble(frmLancaConta.edtTotal.getText()));
        this.oConta.setDataCriacao(Date.from(Instant.now()));
        this.oConta.setStatus(getStatus());        

        if (validaCampos()) {
            if (frmLancaConta.cbVista.isSelected()) {
                SubConta oSubConta = new SubConta();
                oSubConta.setoConta(oConta);
                oSubConta.setSequencia(1);
                oSubConta.setDataPagamento(oUtil.stringToDate(frmLancaConta.edtData.getText()));
                oSubConta.setDataVencimento(oUtil.stringToDate(frmLancaConta.edtData.getText()));
                oSubConta.setValorPago(oConta.getValorTotal());
                oSubConta.setValorParcela(oConta.getValorTotal());
                oSubConta.setSituacao(1);
                this.parcelas.add(oSubConta);
            } else {
                for (int i = 0; i < qtdParcelas; i++) {
                    SubConta oSubConta = new SubConta();

                    oSubConta.setoConta(oConta);
                    oSubConta.setSequencia(i + 1);
                    oSubConta.setValorParcela(oConta.getValorTotal() / qtdParcelas);
                    oSubConta.setDataVencimento(oUtil.addMonth(oUtil.stringToDate(frmLancaConta.edtData.getText()), i));

                    this.parcelas.add(oSubConta);
                }

                if (oUtil.dateToString(Date.from(Instant.now())).equals(frmLancaConta.edtData.getText())) {
                    int respota = JOptionPane.showConfirmDialog(frmLancaConta, "A Data de vencimento da primeira parcela é "
                            + "igual a data atual!\n"
                            + "Deseja gerar a primeira parcela paga?");

                    if (respota == 0) {
                        this.parcelas.get(0).setSituacao(1);
                        this.parcelas.get(0).setDataPagamento(Date.from(Instant.now()));
                        this.parcelas.get(0).setValorPago(oConta.getValorTotal() / qtdParcelas);
                    }
                }
            }
        }
    }

    private boolean validaCampos() {
        boolean validou = false;
        if (validaCliente()) {
            if (validaTotal()) {
                if (validaParcelas()) {
                    if (validaData()) {
                        validou = true;
                    } else {
                        JOptionPane.showMessageDialog(frmLancaConta, "Data de Vencimento inválida! Possíveis causas:"
                                + "\n * Campo Vazio"
                                + "\n * Formatação incorreta, seguir o padrão DD/MM/AAAA"
                                + "\n \n"
                                + "Essa data é utilizada como base para a primeira parcela, \n"
                                + "as demais serão lançadas num interválo de 30 dias");
                        frmLancaConta.edtData.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(frmLancaConta, "Quantidade de parcelas inválida! Possíveis causas:"
                            + "\n * Número menor ou igual a zero"
                            + "\n * Formatação decimal incorreta");
                    frmLancaConta.edtQtdParc.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(frmLancaConta, "Valor Total inválido! Possíveis causas:"
                        + "\n * Número menor ou igual a zero"
                        + "\n * Formatação decimal incorreta");
                frmLancaConta.edtTotal.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(frmLancaConta, "Cliente não selecionado!"
                    + "\n * Necessário que apareça o nome do cliente na tela!");
            frmLancaConta.cbCliente.grabFocus();
        }
        return validou;
    }

    private boolean validaTotal() {
        try {
            return Double.valueOf(frmLancaConta.edtTotal.getText()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaParcelas() {
        try {
            return Integer.valueOf(frmLancaConta.edtQtdParc.getText()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaData() {
        try {
            return oUtil.validaData(frmLancaConta.edtData.getText());
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaCliente() {
        try {
            return frmLancaConta.cbCliente.getSelectedItem() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
