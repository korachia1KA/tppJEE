/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpeur;

/**
 *
 * @author kor
 */
public class Developpeur {

    private int id;
    private String nomDeveloppeur;
    private String jour;
    private int nbScript;

    public Developpeur() {
    }

    public Developpeur(String nomDeveloppeur, String jour, int nbScript) {
        this.nomDeveloppeur = nomDeveloppeur;
        this.jour = jour;
        this.nbScript = nbScript;
    }

    public int getId() {
        return id;
    }

    public String getNomDeveloppeur() {
        return nomDeveloppeur;
    }

    public String getJour() {
        return jour;
    }

    public int getNbScript() {
        return nbScript;
    }

    public void setNomDeveloppeur(String nomDeveloppeur) {
        this.nomDeveloppeur = nomDeveloppeur;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbScript(int nbScript) {
        this.nbScript = nbScript;
    }

    @Override
    public String toString() {
        return "Developpeur{" + "id=" + id + ", nomDeveloppeur=" + nomDeveloppeur + ", jour=" + jour + ", nbScript=" + nbScript + '}';
    }

}
