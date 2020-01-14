/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Cale Pillco
 */
public class Factory {
    
    private EntityManagerFactory emf;
    
 public  EntityManagerFactory getEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("VotoElectronicoITSLPU");
        return emf;
    }


}
