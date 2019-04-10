package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Entidade;

public class EntidadeModel extends AbstractTableModel {

    private ArrayList<Entidade> entidades = new ArrayList<Entidade>();

    @Override
    public int getRowCount() {
        return entidades.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Primeiro, recuperar o objeto a ser mostrado naquela linha
        Entidade oEntidade = entidades.get(rowIndex);

        // Segundo, recuperar o atributo do objeto a ser 
        // mostrado naquela coluna
        if (columnIndex == 0) {
            return oEntidade.getId();
        } else if (columnIndex == 1) {
            return oEntidade.getNome();
        } else if (columnIndex == 2) {
            return oEntidade.getTelefone();
        } else {
            return oEntidade.getEmail();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        } else if (column == 1) {
            return "Nome";
        } else if (column == 2) {
            return "Telefone";
        } else {
            return "Email";
        }
    }

    public void addEntidade(Entidade oEntidade) {
        // adicionar na lista
        entidades.add(oEntidade);
        // notificar a Jtable que o objeto foi adicionado
        fireTableDataChanged();
    }

    public Entidade getEntidade(int posicao) {
        return entidades.get(posicao);
    }

    public void limpar() {
        entidades.clear();
    }
}
