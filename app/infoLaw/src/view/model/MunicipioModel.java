package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Municipio;

public class MunicipioModel extends AbstractTableModel {

    private ArrayList<Municipio> municipios = new ArrayList<Municipio>();

    @Override
    public int getRowCount() {
        return municipios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Primeiro, recuperar o objeto a ser mostrado naquela linha
        Municipio oMunicipio = municipios.get(rowIndex);

        // Segundo, recuperar o atributo do objeto a ser 
        // mostrado naquela coluna
        if (columnIndex == 0) {
            return oMunicipio.getId();
        } else if (columnIndex == 1) {
            return oMunicipio.getNome();
        } else if (columnIndex == 2) {
            return oMunicipio.getUf();
        } else {
            return oMunicipio.getCep();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        } else if (column == 1) {
            return "Nome";
        } else if (column == 2) {
            return "Estado";
        } else {
            return "CEP";
        }
    }

    public void addMunicipio(Municipio oMunicipio) {
        // adicionar na lista
        municipios.add(oMunicipio);
        // notificar a Jtable que o objeto foi adicionado
        fireTableDataChanged();
    }

    public Municipio getMunicipio(int posicao) {
        return municipios.get(posicao);
    }

    public void limpar() {
        municipios.clear();
    }
}
