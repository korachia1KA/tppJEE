/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoJdbc;

import DeveloppeurDaoImpl.DeveloppeurDaoImpl;
import developpeurDao.DeveloppeurDao;
import developpeur.Developpeur;
import java.util.ArrayList;



public class ExoJDBC {

    public static void main(String[] args) {
     // DeveloppeurDaoImpl.CreateDevData();
        DeveloppeurDao developpeurDao = new DeveloppeurDaoImpl();
      /*   ArrayList<Developpeur> developpeurs = new ArrayList<Developpeur>();
        developpeurs.add(new Developpeur( "ALAMI", "Lundi", 1));
        developpeurs.add(new Developpeur( "WAFI", "Lundi", 2));
        developpeurs.add(new Developpeur( "SLAMI", "Mardi", 9));*/
        // developpeurDao.totalScriptsParDeveloppeur("WAFI");
        DeveloppeurDaoImpl.metaDonnées();
    }
   

}
