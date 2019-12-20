package dao;

import config.ConfigFile;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

    public static Connection getConnection() {
        try {            
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            return DriverManager.getConnection(
                    "jdbc:firebirdsql:" + ConfigFile.leDadosArquivo() + "?charSet=utf-8&roleName=yourRole",
                    "sysdba",
                    "masterkey");                        
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("ERRO" + erro.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de conexão. "
                    + "\nPossiveis Causas:"
                    + "\n" + "1. Seu computador nao conseguiu acessar o servidor"
                    + "\n" + "2. O Serviço de Banco de dados esta parado"
                    + "\n"
                    + "\n" + erro.toString(),
                    "Conexão", 3);
            return null;
        }
    }
}