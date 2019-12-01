package dao;

import config.ConfigFile;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

    static String databasePath = "192.168.1.13/3050:C:/Banco/database.fdb";

    public static Connection getConnection() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            return DriverManager.getConnection(
                    "jdbc:firebirdsql:" + ConfigFile.leDadosArquivo() + "?charSet=utf-8&roleName=yourRole",
                    "sysdba",
                    "masterkey");
        } catch (Exception erro) {
            System.out.println("ERRO" + erro.getCause().getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de conexão. "
                    + "\nPossiveis Causas:"
                    + "\n" + "1. Seu computador nao conseguiu acessar o servidor"                                        
                    + "\n" + "2. O Serviço de Banco de dados esta parado"
                    + "\n"
                    + "\n" + erro.getCause().toString(),
                    "Conexão", 3);
            return null;
        }
    }
}