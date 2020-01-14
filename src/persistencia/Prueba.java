/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import controlador.DesignacionJpaController;
import modelo.Designacion;
import modelo.Persona;



/**
 *
 * @author Diego Cale Pillco
 */
public class Prueba {
    
    public static void main(String[] args) {
    Persona p= new Persona();
    Factory f= new Factory();
    DesignacionJpaController dc= new DesignacionJpaController(f.getEntityManagerFactory());
    
    
    
    
    
    
    }
}
