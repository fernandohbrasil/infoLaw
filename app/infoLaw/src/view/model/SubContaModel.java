package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.SubConta;
import util.DateUtil;

public class SubContaModel extends AbstractTableModel {

    private final ArrayList<SubConta> subContas = new ArrayList<>();
    private final DateUtil util = new DateUtil();

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
        switch (columnIndex) {
            case 0:
                return oSubConta.getConta().getId();
            case 1:
                return oSubConta.getSequencia();
            case 2:
                return oSubConta.getConta().getEntidade().getNome();
            case 3:
                return oSubConta.getValorParcelaFormatado();
            case 4:
                return util.dateToString(oSubConta.getDataVencimento());
            case 5:
                return util.dateToString(oSubConta.getConta().getDataCriacao());
            default:
                return util.dateToString(oSubConta.getDataPagamento());
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nº Conta";
            case 1:
                return "Nº Parcela";
            case 2:
                return "Entidade";
            case 3:
                return "Valor";
            case 4:
                return "Dt. Vencimento";
            case 5:
                return "Dt. Criação";
            default:
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
