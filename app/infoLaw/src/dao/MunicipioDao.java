package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Municipio;

public class MunicipioDao {

    private Connection conexao;
    private PreparedStatement stmt;

    public boolean insert(Municipio oMunicipio) throws SQLException {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("insert into municipio (id, nome, uf, cep) values (?, ?, ?, ?)");

            stmt.setInt(1, oMunicipio.getId());
            stmt.setString(2, oMunicipio.getNome());
            stmt.setString(3, oMunicipio.getUf());
            stmt.setString(4, oMunicipio.getCep());
            stmt.execute();

            return true;
        } catch (Exception e) {
            System.err.println("ERRO  " + e.toString());
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean update(Municipio oMunicipio) {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("update municipio set nome = ?, uf = ?, cep = ? where id = ?");

            stmt.setString(1, oMunicipio.getNome());
            stmt.setString(2, oMunicipio.getUf());
            stmt.setString(3, oMunicipio.getCep());
            stmt.setInt(4, oMunicipio.getId());
            stmt.execute();

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean delete(Municipio oMunicipio) {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement(
                    "delete from municipio where id = ?");
            stmt.setInt(1, oMunicipio.getId());
            stmt.execute();
            return true;
        } catch (Exception e) {
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
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("select coalesce(max(id), 0) + 1 as codigo from municipio");
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

    public Municipio findById(int id) {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("select id, nome, uf, cep from municipio  where id = ? ");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Municipio oMun = new Municipio();
            oMun.setId(rs.getInt("id"));
            oMun.setNome(rs.getString("nome"));
            oMun.setUf(rs.getString("uf"));
            oMun.setCep(rs.getString("cep"));

            return oMun;

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

    public Municipio findByName(String nome) {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("select id, nome, uf, cep from municipio  where nome = ? ");
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Municipio oMun = new Municipio();
            oMun.setId(rs.getInt("id"));
            oMun.setNome(rs.getString("nome"));
            oMun.setUf(rs.getString("uf"));
            oMun.setCep(rs.getString("cep"));

            return oMun;

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

    public List<Municipio> findByUf(String uf) {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("select id, nome, uf, cep from municipio  where uf = ? order by id ");
            stmt.setString(1, uf);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Municipio> municipios = new ArrayList<Municipio>();

            while (rs.next()) {
                Municipio oMun = new Municipio();
                oMun.setId(rs.getInt("id"));
                oMun.setNome(rs.getString("nome"));
                oMun.setUf(rs.getString("uf"));
                oMun.setCep(rs.getString("cep"));

                municipios.add(oMun);
            }

            return municipios;

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

    public List<Municipio> buscarTodos() {
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement(
                    "select id, nome, uf, cep "
                    + "from municipio "
                    + "order by id ");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Municipio> municipios = new ArrayList<Municipio>();

            while (rs.next()) {
                Municipio oMun = new Municipio();
                oMun.setId(rs.getInt("id"));
                oMun.setNome(rs.getString("nome"));
                oMun.setUf(rs.getString("uf"));
                oMun.setCep(rs.getString("cep"));

                municipios.add(oMun);
            }
            return municipios;
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
