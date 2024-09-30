/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpeurDao;

import developpeur.Developpeur;



/**
 *
 * @author kor
 */
public interface DeveloppeurDao {
    
    public void totalScriptsSemaine();
    
    public void totalScriptsParDeveloppeur(String nom);
    
    public void DeveloppeursParNBScript();
    
    public void DeveloppeursMaxScript();
    
    public void save(Developpeur developpeur);
    
}