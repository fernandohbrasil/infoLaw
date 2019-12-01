package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Entidade;

public class EntidadeDao {

    private Connection conexao;
    private PreparedStatement stmt;

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
    }

    public boolean update(Entidade oEntidade) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update entidade set "
                    + "nome = ?,"
                    + "telefone = ?,"
                    + "email = ?,"
                    + "municipioId = ?,"
                    + "cep = ?,"
                    + "bairro = ?,"
                    + "rua = ?,"
                    + "numero = ?,"
                    + "cpf = ?,"
                    + "rg = ?,"
                    + "cnpj = ?,"
                    + "ie = ?"
                    + "where "
                    + "id = ?");

            stmt.setString(1, oEntidade.getNome());
            stmt.setString(2, oEntidade.getTelefone());
            stmt.setString(3, oEntidade.getEmail());
            stmt.setInt(4, oEntidade.getMunicipio().getId());
            stmt.setString(5, oEntidade.getCep());
            stmt.setString(6, oEntidade.getBairro());
            stmt.setString(7, oEntidade.getRua());
            stmt.setString(8, oEntidade.getNumero());
            stmt.setString(9, oEntidade.getCpf());
            stmt.setString(10, oEntidade.getRg());
            stmt.setString(11, oEntidade.getCnpj());
            stmt.setString(12, oEntidade.getIe());
            stmt.setInt(13, oEntidade.getId());
            stmt.execute();

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

    public boolean delete(Entidade oEntidade) {
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
    }

    public int getNextId() {
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
    }

    public List<Entidade> buscarTodos() {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement(
                    "select id, nome, telefone, email, municipioId, cep, bairro, rua, numero, cpf, rg, cnpj, ie "
                    + "from entidade "
                    + "order by nome ");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Entidade> entidades = new ArrayList<Entidade>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                oEnt.setId(rs.getInt("id"));
                oEnt.setNome(rs.getString("nome"));
                oEnt.setTelefone(rs.getString("telefone"));
                oEnt.setEmail(rs.getString("email"));
                oEnt.setMunicipio(new MunicipioDao().findById(rs.getInt("municipioId")));
                oEnt.setCep(rs.getString("cep"));
                oEnt.setBairro(rs.getString("bairro"));
                oEnt.setRua(rs.getString("rua"));
                oEnt.setNumero(rs.getString("numero"));                
                oEnt.setCpf(rs.getString("cpf"));
                oEnt.setRg(rs.getString("rg"));
                oEnt.setCnpj(rs.getString("cnpj"));
                oEnt.setIe(rs.getString("ie"));                
                entidades.add(oEnt);
            }
            return entidades;
        } catch (Exception e) {
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