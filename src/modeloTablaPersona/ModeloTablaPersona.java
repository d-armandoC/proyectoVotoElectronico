/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTablaPersona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Diego C
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private Persona personaSeleccionada = null;
    private List<Persona> filasPersonas = null;
    private String[] titulos = null;
    private int rowIndex;

    public ModeloTablaPersona() {
        this.titulos = new String[]{"Nombre", "Apellido", "Fecha Nacimiento", "Cedula", "Celular", "Correo", "Genero", "Check"};
        this.filasPersonas = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Pedido Enviado");
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getFilasPersonas() {
        return filasPersonas;
    }

    public void setFilasPersonas(List<Persona> filasPersonas) {
        this.filasPersonas = filasPersonas;
    }

    @Override
    public int getRowCount() {
        return filasPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        personaSeleccionada = filasPersonas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return personaSeleccionada.getNombre();
            case 1:
                return personaSeleccionada.getApellido();
            case 2:
                return personaSeleccionada.getFechaNacimiento();
            case 3:
                return personaSeleccionada.getCedula();
            case 4:
                return personaSeleccionada.getCelular();
            case 5:
                return personaSeleccionada.getCorreo();
            case 6:
                return formatGenero(1);
            case 7:
                return personaSeleccionada.getEstado();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        personaSeleccionada = filasPersonas.get(row);
        personaSeleccionada.setEstado(new Boolean((boolean) value));
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 7) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Date.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return Boolean.class;
            default:
                return Object.class;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return titulos[columnIndex];
    }

    public void update(Persona object) {
        setPersonaSeleccionada(null);
        filasPersonas.add(rowIndex, object);
        fireTableDataChanged();
    }

    public void addRow(Persona object) {
        filasPersonas.add(filasPersonas.size(), object);
        fireTableDataChanged();
    }

    public void deleteRow(Persona p) {
        filasPersonas.remove(p);
        fireTableDataChanged();
    }

    public String formatGenero(int n) {
        switch (n) {
            case 0:
                return "S/N";
            case 1:
                return "Lacteos";
            case 2:
                return "Abarrotes";
            default:
                return "";
        }
    }

}
