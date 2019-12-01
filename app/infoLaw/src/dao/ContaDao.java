package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Conta;
import model.Entidade;
import model.SubConta;

public class ContaDao {

    private Connection conexao;
    private PreparedStatement stmt;

    public boolean insert(Conta oConta, ArrayList<SubConta> parcelas) throws SQLException {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement(
                    "insert into conta (id, entidadeId, dataCriacao, valorTotal, status, obs) "
                    + " values "
                    + "  (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, oConta.getId());
            stmt.setInt(2, oConta.getEntidade().getId());
            stmt.setDate(3, new java.sql.Date(oConta.getDataCriacao().getTime()));
            stmt.setDouble(4, oConta.getValorTotal());
            stmt.setInt(5, oConta.getStatus());
            stmt.setString(6, oConta.getObs());
            stmt.execute();

            return insertSubConta(parcelas);
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

    private boolean insertSubConta(ArrayList<SubConta> parcelas) throws SQLException {
        try {
            conexao = Conexao.getConnection();

            for (int i = 0; i < parcelas.size(); i++) {
                stmt = conexao.prepareStatement(
                        "insert into subconta (contaID, sequencia, dataVencimento, dataPagamento, valorParcela, valorPago, situacao)"
                        + " values "
                        + "  (?, ?, ?, ?, ?, ?, ?)");

                stmt.setInt(1, parcelas.get(i).getConta().getId());
                stmt.setInt(2, parcelas.get(i).getSequencia());
                stmt.setDate(3, new java.sql.Date(parcelas.get(i).getDataVencimento().getTime()));

                if (parcelas.get(i).getDataPagamento() == null) {
                    stmt.setNull(4, java.sql.Types.DATE);
                } else {
                    stmt.setDate(4, new java.sql.Date(parcelas.get(i).getDataPagamento().getTime()));
                }
                stmt.setDouble(5, parcelas.get(i).getValorParcela());

                if (parcelas.get(i).getDataPagamento() == null) {
                    stmt.setNull(6, java.sql.Types.DOUBLE);
                } else {
                    stmt.setDouble(6, parcelas.get(i).getValorPago());
                }

                stmt.setInt(7, parcelas.get(i).getSituacao());
                stmt.execute();
            }

            return true;
        } catch (SQLException e) {
            stmt = conexao.prepareStatement("delete from subConta where contaID = ?");
            stmt.setInt(1, parcelas.get(0).getConta().getId());
            stmt.execute();

            stmt = conexao.prepareStatement("delete from conta where id = ?");
            stmt.setInt(1, parcelas.get(0).getConta().getId());
            stmt.execute();
            System.err.println("ERRO:" + e.toString());
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
            stmt = conexao.prepareStatement("select coalesce(max(id), 0) + 1 as codigo from conta");
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

    public List<SubConta> buscaDataVencimento(Date dtInicial, Date dtFinal, int pagRec) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select \n"
                    + "  subConta.contaID,\n"
                    + "  subConta.sequencia,\n"
                    + "  entidade.nome,\n"
                    + "  subConta.dataVencimento,\n"
                    + "  subConta.valorParcela,\n"
                    + "  subConta.valorPago,\n"
                    + "  conta.dataCriacao,\n"
                    + "  subConta.dataPagamento \n"
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ?\n"
                    + "  and\n"
                    + "  subConta.dataVencimento BETWEEN ? and ?\n"
                    + "  and\n"
                    + "  subConta.situacao = 0 \n"
                    + "order by \n"
                    + "  1,4");
//                                + "  subConta.dataVencimento");

            stmt.setInt(1, pagRec);
            stmt.setDate(2, new java.sql.Date(dtInicial.getTime()));
            stmt.setDate(3, new java.sql.Date(dtFinal.getTime()));

            ResultSet rs = stmt.executeQuery();

            ArrayList<SubConta> contas = new ArrayList<SubConta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();
                SubConta oSub = new SubConta();

                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setEntidade(oEnt);
                oConta.setId(rs.getInt("contaID"));

                oSub.setSequencia(rs.getInt("sequencia"));
                oSub.setDataPagamento(rs.getDate("dataPagamento"));
                oSub.setDataVencimento(rs.getDate("dataVencimento"));
                oSub.setValorParcela(rs.getDouble("valorParcela"));
                oSub.setValorPago(rs.getDouble("valorPago"));
                oSub.setConta(oConta);

                contas.add(oSub);
            }
            return contas;
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

    public List<SubConta> buscaDataVencimentoCliente(Date dtInicial, Date dtFinal, int pagRec, int entidadeId) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select \n"
                    + "  subConta.ContaId,\n"
                    + "  subConta.sequencia,\n"
                    + "  entidade.nome,\n"
                    + "  subConta.dataVencimento,\n"
                    + "  subConta.valorParcela,\n"
                    + "  subConta.valorPago,\n"
                    + "  conta.dataCriacao,\n"
                    + "  subConta.dataPagamento \n"
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ?\n"
                    + "  and\n"
                    + "  subConta.dataVencimento BETWEEN ? and ?\n"
                    + "  and\n"
                    + "  entidadeID = ?\n"
                    + "  and\n"
                    + "  subConta.situacao = 0 \n"
                    + "order by \n"
                    + "  1,4 ");
            //+"  subConta.dataVencimento"            );

            stmt.setInt(1, pagRec);
            stmt.setDate(2, new java.sql.Date(dtInicial.getTime()));
            stmt.setDate(3, new java.sql.Date(dtFinal.getTime()));
            stmt.setInt(4, entidadeId);

            ResultSet rs = stmt.executeQuery();

            ArrayList<SubConta> contas = new ArrayList<SubConta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();
                SubConta oSub = new SubConta();

                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setEntidade(oEnt);
                oConta.setId(rs.getInt("ContaId"));

                oSub.setSequencia(rs.getInt("sequencia"));
                oSub.setDataPagamento(rs.getDate("dataPagamento"));
                oSub.setDataVencimento(rs.getDate("dataVencimento"));
                oSub.setValorParcela(rs.getDouble("valorParcela"));
                oSub.setValorPago(rs.getDouble("valorPago"));
                oSub.setConta(oConta);

                contas.add(oSub);
            }
            return contas;
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

    public List<SubConta> buscaDataPagamento(Date dtInicial, Date dtFinal, int pagRec) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select "
                    + "  subConta.ContaId,\n"
                    + "  subConta.sequencia,\n"
                    + "  entidade.nome,\n"
                    + "  subConta.dataVencimento,\n"
                    + "  subConta.valorParcela,\n"
                    + "  subConta.valorPago,\n"
                    + "  conta.dataCriacao,\n"
                    + "  subConta.dataPagamento \n"
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ?\n"
                    + "  and\n"
                    + "  subConta.dataPagamento BETWEEN ? and ?\n"
                    + "  and\n"
                    + "  subConta.situacao = 1 \n"
                    + "order by \n"
                    + "  subConta.dataPagamento");

            stmt.setInt(1, pagRec);
            stmt.setDate(2, new java.sql.Date(dtInicial.getTime()));
            stmt.setDate(3, new java.sql.Date(dtFinal.getTime()));

            ResultSet rs = stmt.executeQuery();

            ArrayList<SubConta> contas = new ArrayList<SubConta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();
                SubConta oSub = new SubConta();

                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setEntidade(oEnt);
                oConta.setId(rs.getInt("ContaId"));

                oSub.setSequencia(rs.getInt("sequencia"));
                oSub.setDataPagamento(rs.getDate("dataPagamento"));
                oSub.setDataVencimento(rs.getDate("dataVencimento"));
                oSub.setValorParcela(rs.getDouble("valorParcela"));
                oSub.setValorPago(rs.getDouble("valorPago"));
                oSub.setConta(oConta);

                contas.add(oSub);
            }
            return contas;
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

    public List<SubConta> buscaDataPagamentoCliente(Date dtInicial, Date dtFinal, int pagRec, int entidadeId) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select "
                    + "  subConta.ContaId,\n"
                    + "  subConta.sequencia,\n"
                    + "  entidade.nome,\n"
                    + "  subConta.dataVencimento,\n"
                    + "  subConta.valorParcela,\n"
                    + "  subConta.valorPago,\n"
                    + "  conta.dataCriacao,\n"
                    + "  subConta.dataPagamento \n"
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ?\n"
                    + "  and\n"
                    + "  subConta.dataPagamento BETWEEN ? and ?\n"
                    + "  and\n"
                    + "  entidadeID = ?\n"
                    + "  and\n"
                    + "  subConta.situacao = 1 \n"
                    + "order by \n"
                    + "  subConta.dataPagamento");

            stmt.setInt(1, pagRec);
            stmt.setDate(2, new java.sql.Date(dtInicial.getTime()));
            stmt.setDate(3, new java.sql.Date(dtFinal.getTime()));
            stmt.setInt(4, entidadeId);

            ResultSet rs = stmt.executeQuery();

            ArrayList<SubConta> contas = new ArrayList<SubConta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();
                SubConta oSub = new SubConta();

                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setEntidade(oEnt);
                oConta.setId(rs.getInt("ContaId"));

                oSub.setSequencia(rs.getInt("sequencia"));
                oSub.setDataPagamento(rs.getDate("dataPagamento"));
                oSub.setDataVencimento(rs.getDate("dataVencimento"));
                oSub.setValorParcela(rs.getDouble("valorParcela"));
                oSub.setValorPago(rs.getDouble("valorPago"));
                oSub.setConta(oConta);

                contas.add(oSub);
            }
            return contas;
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

    public List<SubConta> buscaCliente(int pagRec, int entidadeId) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select \n"
                    + "  subConta.ContaId,\n"
                    + "  subConta.sequencia,\n"
                    + "  entidade.nome,\n"
                    + "  subConta.dataVencimento,\n"
                    + "  subConta.valorParcela,\n"
                    + "  subConta.valorPago,\n"
                    + "  conta.dataCriacao,\n"
                    + "  subConta.dataPagamento \n"
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ?\n"
                    + "  and\n"
                    + "  entidadeID = ? \n"
                    + "  and \n"
                    + "  subConta.situacao = 0 \n"
                    + "order by \n"
                    + "  subConta.dataVencimento");

            stmt.setInt(1, pagRec);
            stmt.setInt(2, entidadeId);

            ResultSet rs = stmt.executeQuery();

            ArrayList<SubConta> contas = new ArrayList<SubConta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();
                SubConta oSub = new SubConta();

                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setEntidade(oEnt);
                oConta.setId(rs.getInt("ContaId"));

                oSub.setSequencia(rs.getInt("sequencia"));
                oSub.setDataPagamento(rs.getDate("dataPagamento"));
                oSub.setDataVencimento(rs.getDate("dataVencimento"));
                oSub.setValorParcela(rs.getDouble("valorParcela"));
                oSub.setValorPago(rs.getDouble("valorPago"));
                oSub.setConta(oConta);

                contas.add(oSub);
            }
            return contas;
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

    public boolean baixarConta(SubConta oSubConta) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update \n"
                    + "    subConta \n"
                    + "set \n"
                    + "    valorPago = valorParcela, \n"
                    + "    situacao = 1, \n"
                    + "    dataPagamento = ? \n"
                    + "where \n"
                    + "    contaID = ? \n"
                    + "    and \n"
                    + "    sequencia = ?");
            stmt.setDate(1, new java.sql.Date(Date.from(Instant.now()).getTime()));
            stmt.setInt(2, oSubConta.getConta().getId());
            stmt.setInt(3, oSubConta.getSequencia());
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

    public List<Conta> buscaContas(int pagRec) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement(""
                    + "Select \n"
                    + "    conta.id,\n"
                    + "    entidade.nome,\n"
                    + "    conta.dataCriacao,\n"
                    + "    conta.valorTotal\n"
                    + "from\n"
                    + "    conta, entidade\n"
                    + "where     \n"
                    + "    conta.entidadeID = entidade.id\n"
                    + "    and\n"
                    + "    conta.status = ?\n"
                    + "order by\n"
                    + "    2");

            stmt.setInt(1, pagRec);

            ResultSet rs = stmt.executeQuery();
            ArrayList<Conta> contas = new ArrayList<Conta>();

            while (rs.next()) {
                Entidade oEnt = new Entidade();
                Conta oConta = new Conta();

                oConta.setId(rs.getInt("Id"));
                oEnt.setNome(rs.getString("nome"));
                oConta.setDataCriacao(rs.getDate("dataCriacao"));
                oConta.setValorTotal(rs.getDouble("valorTotal"));
                oConta.setEntidade(oEnt);
                contas.add(oConta);
            }
            return contas;
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

    public List<SubConta> buscaParcelas(int contaId) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement(""
                    + "Select \n"
                    + "    subConta.sequencia, \n"
                    + "    subConta.dataVencimento, \n"
                    + "    subConta.dataPagamento, \n"
                    + "    subConta.valorParcela, \n"
                    + "    subConta.situacao \n"
                    + "from \n"
                    + "    subConta \n"
                    + "where \n"
                    + "    subConta.ContaId = ?\n"
                    + "order by \n"
                    + "    1");

            stmt.setInt(1, contaId);

            ResultSet rs = stmt.executeQuery();
            ArrayList<SubConta> parcelas = new ArrayList<SubConta>();

            while (rs.next()) {
                SubConta parcela = new SubConta();

                parcela.setSequencia((rs.getInt("sequencia")));
                parcela.setDataVencimento((rs.getDate("dataVencimento")));
                parcela.setDataPagamento((rs.getDate("dataPagamento")));
                parcela.setValorParcela((rs.getDouble("valorParcela")));
                parcela.setSituacao((rs.getInt("situacao")));

                parcelas.add(parcela);
            }
            return parcelas;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean cancelaConta(int contaId) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update \n"
                    + "    subConta \n"
                    + "set \n"
                    + "    situacao = 2 \n"
                    + "where \n"
                    + "    contaID = ? \n");

            stmt.setInt(1, contaId);
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

    public boolean cancelaParcela(int contaId, int sequencia) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update \n"
                    + "    subConta \n"
                    + "set \n"
                    + "  situacao = 2 \n"
                    + "where \n"
                    + "  contaID = ? \n"
                    + "  and \n"
                    + "  sequencia = ?");

            stmt.setInt(1, contaId);
            stmt.setInt(2, sequencia);
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

    public String getObsConta(int id) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select obs from conta where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("obs");
        } catch (Exception e) {
            return "";
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public List<SubConta> buscaParcelasNaoDividas(int pagRec) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("select \n"
                    + "  subConta.*,\n"
                    + "  conta.dataCriacao, \n"
                    + "  entidade.nome \n"                    
                    + "from \n"
                    + "  subconta, conta, entidade\n"
                    + "where \n"
                    + "  subConta.contaID = conta.id\n"
                    + "  and \n"
                    + "  conta.entidadeID = entidade.id\n"
                    + "  and \n"
                    + "  conta.status = ? \n"
                    + "  and \n"
                    + "  subConta.repassado = 0 \n"
                    + "  and \n"
                    + "  subConta.situacao = 1 \n"
                    + "order by \n"
                    + "  subConta.dataPagamento desc");

            stmt.setInt(1, pagRec);

            ResultSet rs = stmt.executeQuery();
            ArrayList<SubConta> parcelas = new ArrayList<SubConta>();

            while (rs.next()) {
                SubConta parcela = new SubConta();
                Conta oConta = new Conta();
                Entidade oEntidade = new Entidade();
                
                oEntidade.setNome((rs.getString("nome")));

                oConta.setId(rs.getInt("ContaId"));
                oConta.setDataCriacao((rs.getDate("dataCriacao")));
                oConta.setEntidade(oEntidade);
                
                parcela.setConta(oConta);
                parcela.setSequencia((rs.getInt("sequencia")));
                parcela.setDataVencimento((rs.getDate("dataVencimento")));
                parcela.setDataPagamento((rs.getDate("dataPagamento")));
                parcela.setValorParcela((rs.getDouble("valorParcela")));
                parcela.setSituacao((rs.getInt("situacao")));

                parcelas.add(parcela);
            }
            return parcelas;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {

            }
        }
    }

    public boolean divideParcela(int contaId, int sequencia) {
        try {
            conexao = Conexao.getConnection();
            stmt = conexao.prepareStatement("update \n"
                    + "    subConta \n"
                    + "set \n"
                    + "  repassado = 1 \n"
                    + "where \n"
                    + "  contaID = ? \n"
                    + "  and \n"
                    + "  sequencia = ?");

            stmt.setInt(1, contaId);
            stmt.setInt(2, sequencia);
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
}
