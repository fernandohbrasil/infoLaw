package controller;

import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormUsuario;

public class UsuarioController {

    private final FormUsuario frmUsuario;
    private final UsuarioDao dao;

    public UsuarioController() {
        frmUsuario = new FormUsuario(null, true);
        dao = new UsuarioDao();

        inicializarComponente();
    }

    private void inicializarComponente() {
        frmUsuario.btnGrava.addActionListener((ActionEvent e) -> {
            gravar();
        });

        frmUsuario.btnReload.addActionListener((ActionEvent e) -> {
            inicializa();
        });
        
        frmUsuario.btnCancela.addActionListener((ActionEvent e) -> {
            cancelar();
        });

        frmUsuario.btnFecha.addActionListener((ActionEvent e) -> {
            fechar();
        });

        frmUsuario.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                fechar();
            }
        });
    }

    public void cadastrarUsuario() {
        inicializa();
        frmUsuario.setVisible(true);
    }

    private void gravar() {
        String username = frmUsuario.edtUsername.getText();
        int senha = Integer.parseInt(frmUsuario.edtSenha.getText());

        if (foiAlterado(username, senha)) {
            if (dao.update(username, senha) == false) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Usuario!");
            } else {
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Valor foi alterado!");
        }
    }

    private void limparCampos() {
        frmUsuario.edtCodigo.setText(null);
        frmUsuario.edtUsername.setText(null);
        frmUsuario.edtSenha.setText(null);
    }

    private void cancelar() {
        limparCampos();
    }

    private void fechar() {
        frmUsuario.setVisible(false);
    }

    private void inicializa() {
        frmUsuario.edtCodigo.setText(String.valueOf(Usuario.getInstance().getId()));
        frmUsuario.edtUsername.setText(Usuario.getInstance().getUsername());
        frmUsuario.edtSenha.setText(String.valueOf(Usuario.getInstance().getSenha()));
    }

    private boolean foiAlterado(String username, int senha) { 
        return usernameAlterado(username) || senhaAlterada(senha);
    }

    private boolean usernameAlterado(String username) {
        return !username.equals(Usuario.getInstance().getUsername());
    }

    private boolean senhaAlterada(int senha) {
        return senha != Usuario.getInstance().getSenha();                
    }
}