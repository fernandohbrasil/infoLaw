package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.SubConta;
import util.Util;

public class SubContaModel extends AbstractTableModel {

    private ArrayList<SubConta> subContas = new ArrayList<SubConta>();
    private Util oUtil = new Util();

    @Override
    public int getRowCount() {
        return subContas.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Primeiro, recuperar o objeto a ser mostrado naquela linha
        SubConta oSubConta = subContas.get(rowIndex);

        // Segundo, recuperar o atributo do objeto a ser 
        // mostrado naquela coluna
        if (columnIndex == 0) {
            return oSubConta.getoConta().getId();
        } else if (columnIndex == 1) {
            return oSubConta.getSequencia();
        } else if (columnIndex == 2) {
            return oSubConta.getoConta().getoEntidade().getNome();
        } else if (columnIndex == 3) {
            return oSubConta.getValorParcela();
        } else if (columnIndex == 4) {
            return oUtil.dateToString(oSubConta.getDataVencimento());
        } else if (columnIndex == 5) {
            return oUtil.dateToString(oSubConta.getoConta().getDataCriacao());
        } else {
            return oUtil.dateToString(oSubConta.getDataPagamento());
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nº Conta";
        } else if (column == 1) {
            return "Nº Parcela";
        } else if (column == 2) {
            return "Entidade";
        } else if (column == 3) {
            return "Valor";
        } else if (column == 4) {
            return "Dt. Vencimento";
        } else if (column == 5) {
            return "Dt. Criação";
        } else {
            return "Dt. Pagamento";
        }
    }

    public void addSubConta(SubConta oSubConta) {
        // adicionar na lista
        subContas.add(oSubConta);
    }

    public SubConta getSubConta(int posicao) {
        return subContas.get(posicao);
    }

    public void limpar() {
        subContas.clear();
    }
}
