package controller;

import dao.Conexao;
import util.DateUtil;
import dao.EntidadeDao;
import dao.FilialDao;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import model.Entidade;
import model.Filial;
import model.SubConta;
import model.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.FormRelatorioBase;
import view.consulta.FormConsultaEntidade;
import view.model.SubContaModel;
import view.model.EntidadeModel;

public class RelatorioBaseController {

    private FormRelatorioBase frmRelatorioBase;
    private final FilialDao filialDao;

    ArrayList<SubConta> parcelas;

    private Entidade oEntidade;
    private final EntidadeModel entidadeModel;
    private final EntidadeDao entDao;
    private ArrayList<Entidade> entidades;

    private final FormConsultaEntidade frmConsEntidade;
    private final SubContaModel contaModel;

    private final DateUtil oUtil;

    public RelatorioBaseController() {
        frmRelatorioBase = new FormRelatorioBase(frmRelatorioBase, true);
        frmConsEntidade = new FormConsultaEntidade(frmRelatorioBase, true);

        contaModel = new SubContaModel();

        filialDao = new FilialDao();
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
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    selecionaClienteId();
                }
            }
        });

        frmRelatorioBase.btnConsCli.addActionListener((ActionEvent e) -> {
            consultarEntidade();
        });

        frmRelatorioBase.btnFechar.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmRelatorioBase.btnImprimir.addActionListener((ActionEvent e) -> {
            imprimir();
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
        frmRelatorioBase.edtDtIni.setText(oUtil.getDate().format(Date.from(Instant.now())));
        frmRelatorioBase.edtDtFin.setText(oUtil.getDate().format(Date.from(Instant.now())));

        contaModel.limpar();
        contaModel.fireTableDataChanged();
    }

    private void carregaEntidades() {
        frmRelatorioBase.cbxEntidade.removeAllItems();
        entidades = (ArrayList<Entidade>) entDao.buscarTodos();

        entidades.forEach((entidade) -> {
            frmRelatorioBase.cbxEntidade.addItem(entidade.getNome());
        });
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
        boolean validou;

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

    private int getSituacao() {
        if (frmRelatorioBase.rgAberto.isSelected()) {
            return 0;
        } else if (frmRelatorioBase.rgPago.isSelected()) {
            return 1;
        } else {
            return 2;
        }
    }

    private void imprimir() {
        try {
            if (!validaData()) {
                JOptionPane.showMessageDialog(frmRelatorioBase, "Data Inválida");
                return;
            }

            Map<String, Object> parametros = new HashMap<>();
            Connection connexao = Conexao.getConnection();
            Filial filial = filialDao.getFilial();

            parametros.put("where_clause", getWhereClause());
            parametros.put("status", getStatus());
            parametros.put("situacao", getSituacao());
            parametros.put("order_by", getOrderBy());
            parametros.put("all_params", getAllParams());
            parametros.put("versao", filial.getVersao());
            parametros.put("usuario", Usuario.getInstance().getUsername());
            parametros.put("logo", getLogo(filial));

            JasperPrint relatorio = JasperFillManager.fillReport("relatorios/financeiro_base.jasper", parametros, connexao);
            JasperViewer.viewReport(relatorio, false);
        } catch (JRException exception) {
            Logger.getLogger(RelatorioBaseController.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private String getWhereData() {
        String dataIni = frmRelatorioBase.edtDtIni.getText().replace("/", ".");
        String dataFin = frmRelatorioBase.edtDtFin.getText().replace("/", ".");

        if (frmRelatorioBase.rgDtEmissao.isSelected()) {
            return "conta.datacriacao between '"
                    + dataIni
                    + "' and '"
                    + dataFin
                    + "'";
        } else if (frmRelatorioBase.rgDtPagamento.isSelected()) {
            return "subconta.datapagamento between '"
                    + dataIni
                    + "' and '"
                    + dataFin
                    + "'";
        } else {
            return "subconta.datavencimento between '"
                    + dataIni
                    + "' and '"
                    + dataFin
                    + "'";
        }
    }

    private String getWhereStatus() {
        if (frmRelatorioBase.rgPagar.isSelected()) {
            return " and conta.status = 1";
        } else {
            return " and conta.status = 0";
        }
    }

    private String getWhereSituacao() {
        if (frmRelatorioBase.rgAberto.isSelected()) {
            return " and subConta.situacao = 0";
        } else if (frmRelatorioBase.rgPago.isSelected()) {
            return " and subConta.situacao = 1";
        } else {
            return " and subConta.situacao = 2";
        }
    }

    private String getWhereEntidade() {
        if (!frmRelatorioBase.cbEntidade.isSelected() || !validaCliente()) {
            return " ";
        }
        final int entidadeId = Integer.parseInt(frmRelatorioBase.edtCliente.getText());

        return " and entidade.id = " + entidadeId;
    }

    private Object getWhereClause() {
        String whereData = getWhereData();
        String whereStatus = getWhereStatus();
        String whereSituacao = getWhereSituacao();
        String whereEntidade = getWhereEntidade();

        return whereData + whereStatus + whereSituacao + whereEntidade;
    }

    private String getParamData() {
        String result = " Data de ";

        if (frmRelatorioBase.rgDtEmissao.isSelected()) {
            result = result + "Emissão: ";
        } else if (frmRelatorioBase.rgDtPagamento.isSelected()) {
            result = result + "Pagamento: ";
        } else {
            result = result + "Vencimento: ";
        }

        return result + frmRelatorioBase.edtDtIni.getText() + " até " + frmRelatorioBase.edtDtFin.getText() + ";";
    }

    private String getParamStatus() {
        if (frmRelatorioBase.rgPagar.isSelected()) {
            return " Status: A Pagar;";
        } else {
            return " Status: A Receber;";
        }
    }

    private String getParamSituacao() {
        if (frmRelatorioBase.rgAberto.isSelected()) {
            return " Situação: Em Aberto;";
        } else if (frmRelatorioBase.rgPago.isSelected()) {
            return " Situação: Pago;";
        } else {
            return " Situação: Cancelo;";
        }
    }

    private String getParamEntidade() {
        if (!frmRelatorioBase.cbEntidade.isSelected() || !validaCliente()) {
            return "";
        }
        final Entidade entidade = this.entidades.get(frmRelatorioBase.cbxEntidade.getSelectedIndex());
        return " Entidade: " + entidade.getNome();
    }

    private Object getAllParams() {
        String paramData = getParamData();
        String paramStatus = getParamStatus();
        String paramSituacao = getParamSituacao();
        String paramEntidade = getParamEntidade();
        
        return paramData + paramStatus + paramSituacao + paramEntidade;
    }

    private BufferedImage getLogo(Filial filial) {
        try {
            return ImageIO.read(new ByteArrayInputStream(filial.getLogoByte()));
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(frmRelatorioBase, "Erro ao buscar Logo!");
            return null;
        }
    }

    private Object getOrderBy() {
        if (frmRelatorioBase.rgOrdem1.isSelected()) {
            return "  1,2,4,6";
        } else if (frmRelatorioBase.rgOrdem2.isSelected()) {
            return "  6,1,2,4";
        } else {
            return "  5,1,2,4";
        }        
    }
}
