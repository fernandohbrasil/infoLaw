package controller;

import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import view.FormLogin;

public class LoginController {

    private final FormLogin frmLogin;
    private final UsuarioDao dao;

    public LoginController() {
        frmLogin = new FormLogin();

        dao = new UsuarioDao();
        inicializarComponente();
    }

    private void inicializarComponente() {
        frmLogin.btnAcessar.addActionListener((ActionEvent e) -> {
            autenticar();
        });

        frmLogin.btnCancelar.addActionListener((ActionEvent e) -> {
            cancelar();
        });

        frmLogin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                cancelar();
            }
        });

        frmLogin.edtUsuario.addActionListener((ActionEvent e) -> {
            frmLogin.edtSenha.grabFocus();
        });
        
        frmLogin.edtSenha.addActionListener((ActionEvent e) -> {
            autenticar();
        });
    }

    private void autenticar() {
        if (autentica()) {
            frmLogin.setVisible(false);
            PrincipalController principalControle = new PrincipalController();
            principalControle.executar();
        } else {
            JOptionPane.showMessageDialog(frmLogin, "Dados de autenticaçao incorretos!");
        }
    }

    public void executar() {
        limparCampos();

        frmLogin.setVisible(true);
    }

    private void limparCampos() {
        frmLogin.edtUsuario.setText(null);
        frmLogin.edtSenha.setText(null);
    }

    private void cancelar() {
        System.exit(0);
    }

    private boolean autentica() {
        if (frmLogin.edtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frmLogin, "Informe o usuario!");
            return false;
        }

        if (frmLogin.edtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frmLogin, "Informe a senha!");
            return false;
        }
        return dao.autentica(frmLogin.edtUsuario.getText(), Integer.parseInt(frmLogin.edtSenha.getText()));
    }
}
