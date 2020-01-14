/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.VotoJpaController;
import controlador.VotoNuloJpaController;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import persistencia.Factory;

/**
 *
 * @author Diego Cale Pillco
 */
public class Estadistica {

    private final DefaultCategoryDataset data;
    private ChartPanel contenedor;
    private JFreeChart grafica;
    private final VotoJpaController vc;
    private final VotoNuloJpaController vnc;
    private final Factory f;
    private int votol1;
    private int votol2;
    private int votoNulo;

    public Estadistica() {
        f = new Factory();
        data = new DefaultCategoryDataset();
        vc = new VotoJpaController(f.getEntityManagerFactory());
        vnc = new VotoNuloJpaController(f.getEntityManagerFactory());
    }

    public void obtenerVotos() {
        votol1 = 0;
        votol2 = 0;
        List<Voto> listaVoto = vc.findVotoEntities();
        listaVoto.forEach((voto) -> {
            if (voto.getIdLista().getIdLista() == 1) {
                votol1++;
            } else if (voto.getIdLista().getIdLista() == 2) {
                votol2++;
            }
        });
    }

    public void graficar(boolean modal) {
        final String lista1 = "Lista 1";
        final String lista2 = "Lista 2";
        data.addValue(votol1, lista1, "Votación");
        data.addValue(votol2, lista2, "Votación");
        grafica = ChartFactory.createBarChart3D("Resultados Electorales", "Participantes", "Votos", data, PlotOrientation.VERTICAL, true, true, false);
        contenedor = new ChartPanel(grafica);
        if(modal){
         contenedor.setSize(709, 331);
        }else{
        contenedor.setSize(500, 270);
        }
        

    }

    public void obtenerVotosNulos() {
        votoNulo = 0;
        votoNulo = vnc.getVotoNuloCount();
    }
    
    public int obtenerTotalVotos() {
      int  voto = vc.getVotoCount();
      int  votoN = vnc.getVotoNuloCount();
        return voto+votoN;
    }

    
    public void fijarPanel(JPanel panellBotones) {
        panellBotones.add(contenedor);
    }

    public int getVotol1() {
        return votol1;
    }

    public int getVotol2() {
        return votol2;
    }

    public int getVotoNulo() {
        return votoNulo;
    }

}
