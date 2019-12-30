package controller;

import dao.LoginDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.FormLogin;

public class LoginController {
    private final FormLogin frmLogin;    
    private final LoginDao dao;    

    public LoginController() {
        frmLogin = new FormLogin();
        
        dao = new LoginDao();
        inicializarComponente();
    }

    private void inicializarComponente() {
        frmLogin.btnAcessar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                        PrincipalController principalControle = new PrincipalController();        
                        principalControle.executar();
                
            //    try {
//                    gravar();
//                } catch (SQLException ex) {
//                    Logger.getLogger(MunicipioController.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });


        frmLogin.btnCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        frmLogin.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                cancelar();
            }
        });
        
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
}