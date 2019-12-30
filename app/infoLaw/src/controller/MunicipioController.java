package controller;

import dao.MunicipioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Municipio;
import view.FormCadastroMunicipio;
import view.consulta.FormConsultaMunicipio;
import view.model.MunicipioModel;

public class MunicipioController {

    private final FormCadastroMunicipio frmCadMunipio;    
    private final MunicipioDao dao;
    private final MunicipioModel municipioModel;
    private final FormConsultaMunicipio frmConsMunicipio;

    MunicipioController() {
        frmCadMunipio = new FormCadastroMunicipio(null, true);
        frmConsMunicipio = new FormConsultaMunicipio(frmCadMunipio, true);
        dao = new MunicipioDao();        
        municipioModel = new MunicipioModel();
        inicializarComponente();
    }

    private void inicializarComponente() {
        frmCadMunipio.btnGrava.addActionListener((ActionEvent e) -> {
            try {
                gravarMunicipio();
            } catch (SQLException ex) {
                Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        frmCadMunipio.btnCancela.addActionListener((ActionEvent e) -> {
            cancelar();
        });

        frmCadMunipio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                fechar();
            }
        });

        frmCadMunipio.btnConsulta.addActionListener((ActionEvent e) -> {
            consultarMunicipio();
        });
        
        frmConsMunicipio.tbEntidade.setModel(municipioModel);
        frmConsMunicipio.tbEntidade.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    editarMunicipio();
                }
            }
        });

        frmCadMunipio.btnExclui.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });

    }

    private void excluir() {
        if (dao.delete(buscarDadosForm()) == false) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Município");
        } else {
            limparCampos();
            frmCadMunipio.edtNome.grabFocus();
        }
    }

    public void consultarMunicipio() {
        // Carregar todos os objetos para o Table Model
        carregarMunicipios();

        //Como a Consulta e o Cadastro são telas modais devemos garantir que 
        //quando uma tiver aparecendo a outra não esta
        frmCadMunipio.setVisible(false);

        // Mostrando a tela 
        frmConsMunicipio.setVisible(true);
    }

    private void carregarMunicipios() {
        municipioModel.limpar();
        
        List<Municipio> todos = dao.buscarTodos();
        todos.forEach((oMunicipio) -> {
            municipioModel.addMunicipio(oMunicipio);
        });
    }

    public void cadastrarMunicipio() {
        limparCampos();       
        frmCadMunipio.setVisible(true);
    }

    private void gravarMunicipio() throws SQLException {
        if (frmCadMunipio.edtCodigo.getText().isEmpty()) {
            //Se código vazio, objeto novo
            if (dao.insert(buscarDadosForm()) == false) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Município");
            } else {
                limparCampos();
                //Seto o foco no campo Nome
                frmCadMunipio.edtNome.grabFocus();
            }
        } else {
            //Se código diferente de vazio objeto existente
            if (dao.update(buscarDadosForm()) == false) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Município");
            } else {
                limparCampos();
                //Seto o foco no  campo Nome
                frmCadMunipio.edtNome.grabFocus();
            }
        }
    }

    //Como os métodos precisam buscar os dados do Form
    //Foi criado uma função para este processo 
    private Municipio buscarDadosForm() {
        //Setos as informações do form em variáveis
        String nome = frmCadMunipio.edtNome.getText();
        String cep = frmCadMunipio.edtCEP.getText();
        String uf = getUF(frmCadMunipio.cbUF.getSelectedIndex());
        int codigo;

        //Se Código vazio, significa que é objeto novo, então, busco Id
        //Se Código diferente de vazio, então, é um objeto existente
        if (frmCadMunipio.edtCodigo.getText().isEmpty()) {
            codigo = dao.getNextId();
        } else {
            codigo = Integer.parseInt(frmCadMunipio.edtCodigo.getText());
        }
        //Seto os dados do objeto por meio do construtor    
        return new Municipio(codigo, nome, uf, cep);
    }

    private void limparCampos() {
        //Limpando todos os campos da tela
        frmCadMunipio.edtCodigo.setText(null);
        frmCadMunipio.edtNome.setText(null);
        frmCadMunipio.edtCEP.setText("88400-000");
        frmCadMunipio.cbUF.setSelectedIndex(23);
    }

    private void cancelar() {
        limparCampos();
    }

    private void fechar() {
        frmCadMunipio.setVisible(false);
    }

    private void editarMunicipio() {
        // recuperar a posição do objeto selecionado
        int posicao = frmConsMunicipio.tbEntidade.getSelectedRow();

        // buscar o objeto 
        Municipio municipio = municipioModel.getMunicipio(posicao);

        // preencher os campos do form com os dados do objeto
        frmCadMunipio.edtCodigo.setText(Integer.toString(municipio.getId()));
        frmCadMunipio.edtNome.setText(municipio.getNome());
        frmCadMunipio.cbUF.setSelectedIndex(getIndexUf(municipio.getUf()));
        frmCadMunipio.edtCEP.setText(municipio.getCep());

        // fechar o formulário de consulta
        frmConsMunicipio.setVisible(false);
        // abrir o formulário de cadastro
        frmCadMunipio.setVisible(true);

        // chamar o carrega objeto, para atualizar
        // o model e atualizar a jTable
        carregarMunicipios();
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
