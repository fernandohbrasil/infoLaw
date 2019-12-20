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
import view.FormRelatorioBase;
import view.consulta.FormConsultaEntidade;
import view.model.SubContaModel;
import view.model.EntidadeModel;

public class RelatorioBaseController {

    private FormRelatorioBase frmRelatorioBase;
    private ContaDao dao;

    ArrayList<SubConta> parcelas;

    private Entidade oEntidade;
    private EntidadeModel entidadeModel;
    private EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private FormConsultaEntidade frmConsEntidade;
    private SubContaModel contaModel;

    private DateUtil oUtil;

    public RelatorioBaseController() {
        frmRelatorioBase = new FormRelatorioBase(frmRelatorioBase, true);
        frmConsEntidade = new FormConsultaEntidade(frmRelatorioBase, true);

        contaModel = new SubContaModel();

        dao = new ContaDao();
        oEntidade = new Entidade();
        entidadeModel = new EntidadeModel();
        entDao = new EntidadeDao();

        oUtil = new DateUtil();

        inicializarComponente();
    }

    private void inicializarComponente() {
        frmRelatorioBase.cbxEntidade.addPopupMenuListener(new PopupMenuListener() {
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

        frmRelatorioBase.btnConsCli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarEntidade();
            }
        });

        frmRelatorioBase.btnFechar.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmConsEntidade.btnFecha.addActionListener((ActionEvent e) -> {
            fecharConsulta();
        });       
    }

    private void fecharConsulta() {
        frmConsEntidade.setVisible(false);

        frmRelatorioBase.setVisible(true);
    }

    private void fechar() {
        frmRelatorioBase.setVisible(false);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela                
        frmRelatorioBase.cbEntidade.setSelected(false);
        frmRelatorioBase.rgReceber.setSelected(true);
        frmRelatorioBase.rgDtVencimento.setSelected(true);
        frmRelatorioBase.cbxEntidade.setSelectedIndex(-1);
        frmRelatorioBase.edtCliente.setText(null);
        frmRelatorioBase.edtDtIni.setText(oUtil.getFormt().format(Date.from(Instant.now())));
        frmRelatorioBase.edtDtFin.setText(oUtil.getFormt().format(Date.from(Instant.now())));
        
        contaModel.limpar();
        contaModel.fireTableDataChanged();
    }

    private void carregaEntidades() {
        frmRelatorioBase.cbxEntidade.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        for (Entidade entidades : entidades) {
            frmRelatorioBase.cbxEntidade.addItem(entidades.getNome());
        }
    }

    private void selecionaCliente() {
        if (frmRelatorioBase.cbxEntidade.getSelectedIndex() > -1) {
            frmRelatorioBase.edtCliente.setText(String.valueOf(this.entidades.get(frmRelatorioBase.cbxEntidade.getSelectedIndex()).getId()));
        }
    }

    public void init() {
        carregaEntidades();
        limparCampos();

        //Mostrando a tela 
        frmRelatorioBase.setVisible(true);
    }

    private void selecionaClienteId() {
        // recuperar a posição do objeto selecionado
        int posicao = frmConsEntidade.tbEntidade.getSelectedRow();

        // buscar o objeto 
        oEntidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmRelatorioBase.edtCliente.setText(Integer.toString(oEntidade.getId()));
        frmRelatorioBase.cbxEntidade.setSelectedItem(oEntidade.getNome());

        // fechar o formulário de consulta
        frmConsEntidade.setVisible(false);
        // abrir o formulário de cadastro
        frmRelatorioBase.setVisible(true);

        // chamar o carrega objeto, para atualizar
        // o model e atualizar a jTable
        carregarEntidades();
    }

    public void consultarEntidade() {
        carregarEntidades();
        frmRelatorioBase.setVisible(false);

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

    private boolean validaCliente() {
        try {
            return frmRelatorioBase.cbxEntidade.getSelectedItem() != null;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validaData() {
        boolean validou = false;

        validou = oUtil.validaData(frmRelatorioBase.edtDtIni.getText());
        return validou == oUtil.validaData(frmRelatorioBase.edtDtFin.getText());
    }

    private int getStatus() {
        if (frmRelatorioBase.rgReceber.isSelected()) {
            return 0;
        } else {
            return 1;
        }
    }
}