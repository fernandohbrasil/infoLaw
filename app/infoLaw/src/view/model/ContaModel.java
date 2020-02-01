package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Conta;
import util.DateUtil;

public class ContaModel extends AbstractTableModel {

    private final ArrayList<Conta> contas = new ArrayList<>();

    @Override
    public int getRowCount() {
        return contas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Primeiro, recuperar o objeto a ser mostrado naquela linha
        Conta oConta = contas.get(rowIndex);

        // Segundo, recuperar o atributo do objeto a ser 
        // mostrado naquela coluna
        switch (columnIndex) {
            case 0:
                return oConta.getId();
            case 1:
                return oConta.getEntidade().getNome();
            case 2:
                return DateUtil.dateToString(oConta.getDataCriacao());
            default:
                return oConta.getValorTotalFormatado();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Entidade";
            case 2:
                return "Dt. Criação";
            default:
                return "Valor Total";
        }
    }

    public void addConta(Conta oConta) {
        // adicionar na lista
        contas.add(oConta);
    }

    public Conta getConta(int posicao) {
        return contas.get(posicao);
    }

    public void limpar() {
        contas.clear();
    }
}
