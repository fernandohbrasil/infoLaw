package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Filial;

public class FilialDao {

    private Connection conexao;
    private PreparedStatement stmt;

    public Filial getFilial() {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select * from filial");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            Blob blob = rs.getBlob("logo");            
            return new Filial(rs.getString("versao"), blob.getBytes(1, (int) blob.length()));            
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }         
}