package controller;

import dao.EntidadeDao;
import dao.MunicipioDao;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Entidade;
import model.Municipio;
import view.FormCadastroEntidade;
import view.consulta.FormConsultaEntidade;
import view.model.EntidadeModel;

public class EntidadeController {

    private final FormCadastroEntidade frmCadEntidade;
    private final EntidadeDao dao;
    private final MunicipioDao munDao;
    private final EntidadeModel entidadeModel;
    private final FormConsultaEntidade frmConsEntidade;

    public EntidadeController() {
        frmCadEntidade = new FormCadastroEntidade(null, true);
        frmConsEntidade = new FormConsultaEntidade(frmCadEntidade, true);

        dao = new EntidadeDao();
        munDao = new MunicipioDao();
        entidadeModel = new EntidadeModel();

        inicializarComponente();
    }

    private void inicializarComponente() {
        frmCadEntidade.btnGrava.addActionListener((ActionEvent e) -> {
            try {
                gravar();
            } catch (SQLException ex) {
                Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        frmCadEntidade.btnCancela.addActionListener((ActionEvent e) -> {
            cancelar();
        });

        frmCadEntidade.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmCadEntidade.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                fechar();
            }
        });

        frmCadEntidade.btnConsulta.addActionListener((ActionEvent e) -> {
            consultar();
        });

        // Vincular o Table Model com a jTable
        frmConsEntidade.tbEntidade.setModel(entidadeModel);

        frmConsEntidade.tbEntidade.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    editarEntidade();
                }
            }
        });

        frmCadEntidade.btnExclui.addActionListener((ActionEvent e) -> {
            excluir();
        });

        frmCadEntidade.cbUF.addActionListener((ActionEvent e) -> {
            selecionaUf((String) frmCadEntidade.cbUF.getSelectedItem());
        });

        frmCadEntidade.rgJuridica.addActionListener((ActionEvent e) -> {
            tipoPessoa(false);
        });

        frmCadEntidade.rgFisica.addActionListener((ActionEvent e) -> {
            tipoPessoa(true);
        });

        frmConsEntidade.btnFecha.addActionListener((ActionEvent e) -> {
            fecharConsulta();
        });

    }

    private void fecharConsulta() {
        frmConsEntidade.setVisible(false);

        frmCadEntidade.setVisible(true);
    }

    private void excluir() {
        if (dao.delete(buscarDadosForm()) == false) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Entidade");
        } else {
            limparCampos();
            frmCadEntidade.edtNome.grabFocus();
        }
    }

    public void consultar() {
        carregarEntidades();
        frmCadEntidade.setVisible(false);

        // Mostrando a tela 
        frmConsEntidade.setVisible(true);
    }

    private void carregarEntidades() {
        entidadeModel.limpar();

        // Usar o DAO para buscar os objetos e adicionar no Table Model
        List<Entidade> todos = dao.buscarTodos();
        todos.forEach((oEntidade) -> {
            entidadeModel.addEntidade(oEntidade);
        });
    }

    public void cadastrarEntidade() {
        //Inicializando Campos vazios
        limparCampos();

        //Mostrando a tela 
        mostraFormCad(true);
    }

    private void gravar() throws SQLException {
        if (frmCadEntidade.edtCodigo.getText().isEmpty()) {
            //Se código vazio, objeto novo
            if (dao.insert(buscarDadosForm()) == false) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Entidade");
            } else {
                limparCampos();
                //Seto o foco no campo Nome
                frmCadEntidade.edtNome.grabFocus();
            }
        } else {
            //Se código diferente de vazio objeto existente
            if (dao.update(buscarDadosForm()) == false) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Entidade");
            } else {
                limparCampos();
                //Seto o foco no  campo Nome
                frmCadEntidade.edtNome.grabFocus();
            }
        }
    }

    private Entidade buscarDadosForm() {
        String nome = frmCadEntidade.edtNome.getText();
        String telefone = frmCadEntidade.edtFone.getText();
        String email = frmCadEntidade.edtEmail.getText();
        Municipio oMunicipio = munDao.findByName((String) frmCadEntidade.cbMunicipio.getSelectedItem());
        String cep = frmCadEntidade.edtCep.getText();
        String bairro = frmCadEntidade.edtBairro.getText();
        String rua = frmCadEntidade.edtRua.getText();
        String numero = frmCadEntidade.edtNumero.getText();
        String cpf = frmCadEntidade.edtCpf.getText();
        String rg = frmCadEntidade.edtRg.getText();
        String cnpj = frmCadEntidade.edtCnpj.getText();
        String ie = frmCadEntidade.edtIe.getText();
        int codigo;

        if (frmCadEntidade.edtCodigo.getText().isEmpty()) {
            codigo = dao.getNextId();
        } else {
            codigo = Integer.parseInt(frmCadEntidade.edtCodigo.getText());
        }
        return new Entidade(codigo, nome, telefone, email, oMunicipio, cep, bairro, rua, numero, cpf, rg, cnpj, ie);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        frmCadEntidade.edtCodigo.setText(null);
        frmCadEntidade.edtNome.setText(null);
        frmCadEntidade.edtFone.setText(null);
        frmCadEntidade.edtEmail.setText(null);
        frmCadEntidade.cbUF.setSelectedIndex(23);
        selecionaUf("SC");

        frmCadEntidade.edtCep.setText("88400-000");
        frmCadEntidade.edtBairro.setText(null);
        frmCadEntidade.edtRua.setText(null);
        frmCadEntidade.edtNumero.setText(null);
        frmCadEntidade.edtCpf.setText(null);
        frmCadEntidade.edtRg.setText(null);
        frmCadEntidade.edtCnpj.setText(null);
        frmCadEntidade.edtIe.setText(null);
    }

    private void selecionaUf(String uf) {
        frmCadEntidade.cbMunicipio.removeAllItems();
        ArrayList<Municipio> municipios = (ArrayList<Municipio>) munDao.findByUf(uf);

        municipios.forEach((oMunicipio) -> {
            frmCadEntidade.cbMunicipio.addItem(oMunicipio.getNome());
        });
    }

    private void tipoPessoa(Boolean pessoaFisica) {
        frmCadEntidade.edtCpf.setVisible(pessoaFisica);
        frmCadEntidade.lblCpf.setVisible(pessoaFisica);
        frmCadEntidade.lblRg.setVisible(pessoaFisica);
        frmCadEntidade.edtRg.setVisible(pessoaFisica);
        frmCadEntidade.rgFisica.setSelected(pessoaFisica);

        frmCadEntidade.rgJuridica.setSelected(!pessoaFisica);
        frmCadEntidade.edtCnpj.setVisible(!pessoaFisica);
        frmCadEntidade.lblCnpj.setVisible(!pessoaFisica);
        frmCadEntidade.edtIe.setVisible(!pessoaFisica);
        frmCadEntidade.lblIe.setVisible(!pessoaFisica);

        if (pessoaFisica) {
            frmCadEntidade.edtCnpj.setText(null);
        } else {
            frmCadEntidade.edtCpf.setText(null);
        }
    }

    private void mostraFormCad(boolean pessoaFisica) {
        //Verificação do Tipo de Pessoa
        tipoPessoa(pessoaFisica);

        // abrir o formulário de cadastro
        frmCadEntidade.setVisible(true);
    }

    private void cancelar() {
        limparCampos();
    }

    private void fechar() {
        frmCadEntidade.setVisible(false);
    }

    private void editarEntidade() {
        // recuperar a posição do objeto selecionado
        int posicao = frmConsEntidade.tbEntidade.getSelectedRow();

        // buscar o objeto 
        Entidade entidade = entidadeModel.getEntidade(posicao);

        // preencher os campos do form com os dados do objeto
        frmCadEntidade.edtCodigo.setText(Integer.toString(entidade.getId()));
        frmCadEntidade.edtNome.setText(entidade.getNome());
        frmCadEntidade.edtFone.setText(entidade.getTelefone());
        frmCadEntidade.edtEmail.setText(entidade.getEmail());
        frmCadEntidade.cbUF.setSelectedIndex(getIndexUf(entidade.getMunicipio().getUf()));
        frmCadEntidade.cbMunicipio.setSelectedItem(entidade.getMunicipio().getNome());
        frmCadEntidade.edtCep.setText(entidade.getCep());
        frmCadEntidade.edtBairro.setText(entidade.getBairro());
        frmCadEntidade.edtRua.setText(entidade.getRua());
        frmCadEntidade.edtNumero.setText(entidade.getNumero());
        frmCadEntidade.edtCpf.setText(entidade.getCpf());
        frmCadEntidade.edtRg.setText(entidade.getRg());
        frmCadEntidade.edtCnpj.setText(entidade.getCnpj());
        frmCadEntidade.edtIe.setText(entidade.getIe());

        // fechar o formulário de consulta
        frmConsEntidade.setVisible(false);
        // abrir o formulário de cadastro
        frmCadEntidade.setVisible(true);

        // chamar o carrega objeto, para atualizar
        // o model e atualizar a jTable
        carregarEntidades();

    }

    private String getUF(int index) {
        switch (index) {
            case 0:
                return "AC";
            case 1:
                return "AL";
            case 2:
                return "AP";
            case 3:
                return "AM";
            case 4:
                return "BA";
            case 5:
                return "CE";
            case 6:
                return "DF";
            case 7:
                return "ES";
            case 8:
                return "GO";
            case 9:
                return "MA";
            case 10:
                return "MT";
            case 11:
                return "MS";
            case 12:
                return "MG";
            case 13:
                return "PA";
            case 14:
                return "PB";
            case 15:
                return "PR";
            case 16:
                return "PE";
            case 17:
                return "PI";
            case 18:
                return "RJ";
            case 19:
                return "RN";
            case 20:
                return "RS";
            case 21:
                return "RO";
            case 22:
                return "RR";
            case 23:
                return "SC";
            case 24:
                return "SP";
            case 25:
                return "SE";
            case 26:
                return "TO";
            default:
                return "NA";
        }
    }

    private int getIndexUf(String uf) {
        switch (uf) {
            case "AC":
                return 0;
            case "AL":
                return 1;
            case "AP":
                return 2;
            case "AM":
                return 3;
            case "BA":
                return 4;
            case "CE":
                return 5;
            case "DF":
                return 6;
            case "ES":
                return 7;
            case "GO":
                return 8;
            case "MA":
                return 9;
            case "MT":
                return 10;
            case "MS":
                return 11;
            case "MG":
                return 12;
            case "PA":
                return 13;
            case "PB":
                return 14;
            case "PR":
                return 15;
            case "PE":
                return 16;
            case "PI":
                return 17;
            case "RJ":
                return 18;
            case "RN":
                return 19;
            case "RS":
                return 20;
            case "RO":
                return 21;
            case "RR":
                return 22;
            case "SC":
                return 23;
            case "SP":
                return 24;
            case "SE":
                return 25;
            case "TO":
                return 26;
            default:
                return 0;
        }
    }
}
