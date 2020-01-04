package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDao {

    private Connection conexao;
    private PreparedStatement stmt;

    public boolean autentica(String username, int senha) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select * from usuario where username = ? and senha = ?");
            stmt.setString(1, username);
            stmt.setInt(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = Usuario.getInstance();
                usuario.setAdministrador(rs.getInt("administrador") == 1);
                usuario.setId(rs.getInt("id"));
                usuario.setSenha(rs.getInt("senha"));
                usuario.setUsername(rs.getString("username"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean update(String username, int senha) {
        try {            
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update usuario set "
                    + "senha = ?,"
                    + "username = ?"                    
                    + "where "
                    + "id = ?");

            stmt.setInt(1, senha);
            stmt.setString(2, username);
            stmt.setInt(3, Usuario.getInstance().getId());
            stmt.execute();

            autentica(username, senha);            
            return true;
        } catch (SQLException e) {
            System.out.println(stmt.toString());
            System.out.println(e);
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    /*
    public boolean insert(Entidade oEntidade) throws SQLException {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement(
                    "insert into entidade (id,nome, telefone, email, municipioId, cep, bairro, rua, numero, cpf, rg, cnpj, ie)"
                    + " values "
                    + "  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, oEntidade.getId());
            stmt.setString(2, oEntidade.getNome());
            stmt.setString(3, oEntidade.getTelefone());
            stmt.setString(4, oEntidade.getEmail());
            stmt.setInt(5, oEntidade.getMunicipio().getId());
            stmt.setString(6, oEntidade.getCep());
            stmt.setString(7, oEntidade.getBairro());
            stmt.setString(8, oEntidade.getRua());
            stmt.setString(9, oEntidade.getNumero());
            stmt.setString(10, oEntidade.getCpf());
            stmt.setString(11, oEntidade.getRg());
            stmt.setString(12, oEntidade.getCnpj());
            stmt.setString(13, oEntidade.getIe());
            stmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }*/

 /*public boolean delete(Entidade oEntidade) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("delete from entidade where id = ?");
            stmt.setInt(1, oEntidade.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }*/

 /*public int getNextId() {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select coalesce(max(id), 0) + 1 as codigo from entidade");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("codigo");

        } catch (Exception e) {
            return 0;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }*/
}
