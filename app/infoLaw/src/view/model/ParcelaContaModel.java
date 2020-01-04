package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.SubConta;
import util.DateUtil;

public class ParcelaContaModel extends AbstractTableModel {

    private final ArrayList<SubConta> subContas = new ArrayList<>();
    private final DateUtil util = new DateUtil();

    @Override
    public int getRowCount() {
        return subContas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Primeiro, recuperar o objeto a ser mostrado naquela linha
        SubConta oSubConta = subContas.get(rowIndex);

        // Segundo, recuperar o atributo do objeto a ser 
        // mostrado naquela coluna
        switch (columnIndex) {
            case 0:
                return oSubConta.getSequencia();
            case 1:
                return util.dateToString(oSubConta.getDataVencimento());
            case 2:
                return util.dateToString(oSubConta.getDataPagamento());
            case 3:
                return oSubConta.getValorParcelaFormatado();
            default:
                return oSubConta.getSituacaoS();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nº Parcela";
            case 1:
                return "Dt. Vencimento";
            case 2:
                return "Dt. Pagamento";
            case 3:
                return "Valor Parcela";
            default:
                return "Situação";
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