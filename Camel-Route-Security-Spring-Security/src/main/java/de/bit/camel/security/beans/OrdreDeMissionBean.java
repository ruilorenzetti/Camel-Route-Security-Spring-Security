package de.bit.camel.security.beans;


import org.apache.log4j.Logger;



/**
 * 
 * @author Rami TORKHANI
 */
public class OrdreDeMissionBean {
    private static Logger logger = Logger.getLogger(OrdreDeMissionBean.class);

  
    public String getOrdreDeMissionPropreteData() {
    	  logger.info("GETOrdreDeMissionPropreteData: 1, 10001, 'Frederic Dupont','Service Eclairage','14.10.2016','changement lampe','VALID'");

      	return "ORDRE DE MISSION DATA";
    }
    
    public static String GetOrdreMissionEtatCivil() {
        logger.info("ORDRE DE MISSION ETAT CIVILE  ");

    	return "Ordre de mission Créer";
  
    }
}
