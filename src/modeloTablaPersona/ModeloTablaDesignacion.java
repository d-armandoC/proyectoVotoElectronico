package modeloTablaPersona;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Designacion;

/**
 *
 * @author Anshy Torres
 */
public class ModeloTablaDesignacion extends AbstractTableModel{
    private Designacion designacion = null;
    private List<Designacion> filasDesignacion = null;
    private String[] titulos = null;
    private int rowIndex;

    public ModeloTablaDesignacion(List<Designacion> list) {
        this.titulos = new String[]{"Nombre", "Descripcion"};
        this.filasDesignacion = new ArrayList<>();
        setFilasDesignacion(list);
    }
    
    public ModeloTablaDesignacion() {
        this.titulos = new String[]{"Nombre", "Descripcion"};
        this.filasDesignacion = new ArrayList<>();
    }
    
    public Designacion getDesignacion() {
        return designacion;
    }

    public void setDesignacion(Designacion designacion) {
        this.designacion = designacion;
    }

    public List<Designacion> getFilasDesignacion() {
        return filasDesignacion;
    }

    public void setFilasDesignacion(List<Designacion> filasDesignacion) {
        this.filasDesignacion = filasDesignacion;
    }

    @Override
    public int getRowCount() {
        return filasDesignacion.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        designacion = filasDesignacion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return designacion.getNombre();
            case 1:
                return designacion.getDescripcion();
            default:
                return null;
        }
    }
    
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            default:
                return Object.class;
        }
    }
        
    @Override
    public String getColumnName(int columnIndex) {
        return titulos[columnIndex];
    }   
    
    public void update(Designacion object) {
        setDesignacion(null);
        filasDesignacion.add(rowIndex, object);
        fireTableDataChanged();
    }

    public void addRow(Designacion object) {
        filasDesignacion.add(filasDesignacion.size(), object);
        fireTableDataChanged();
    }

    public void deleteRow(Designacion p) {
        filasDesignacion.remove(p);
        fireTableDataChanged();
    }
    
}
