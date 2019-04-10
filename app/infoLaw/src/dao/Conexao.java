package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

    static Connection conexao;

    public static Connection getConexao() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/infoLaw/db/infoLaw.db";
            //String url = "jdbc:sqlite:/home/fernando/Documentos/Programação/Projetos/Java/infoLaw/db/infoLaw.db";
            conexao = DriverManager.getConnection(url);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !" + "\n" + erro.getMessage(), "Conexão", 3);
        }
        return conexao;
    }
}
