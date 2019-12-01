package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Conta;
import util.DateUtil;

public class ContaModel extends AbstractTableModel {

    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private DateUtil oUtil = new DateUtil();

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
        if (columnIndex == 0) {
            return oConta.getId();
        } else if (columnIndex == 1) {
            return oConta.getEntidade().getNome();
        } else if (columnIndex == 2) {
            return oUtil.dateToString(oConta.getDataCriacao());
        } else {
            return oConta.getValorTotal();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        } else if (column == 1) {
            return "Entidade";
        } else if (column == 2) {
            return "Dt. Criação";
        } else {
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
