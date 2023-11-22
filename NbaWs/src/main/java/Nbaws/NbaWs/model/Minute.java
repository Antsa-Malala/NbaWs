package Nbaws.NbaWs.model;

import java.util.List;

public class Minute {
    int id;
    int match;
    List<Fourchette> fourchette;
    int joueur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getJoueur() {
        return joueur;
    }

    public void setJoueur(int id) {
        this.joueur = id;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public List<Fourchette> getFourchette() {
        return fourchette;
    }

    public void setFourchette(List<Fourchette> fourchette) {
        this.fourchette = fourchette;
    }

    public Minute(int id, int match, List<Fourchette> fourchette,int joueur) {
        this.setId(id);
        this.setMatch(match);
        this.setFourchette(fourchette);
        this.setJoueur(joueur);
    }
    
    
}
