package Nbaws.NbaWs.model;

import java.sql.Timestamp;


public class Fourchette {
    Timestamp entree;
    Timestamp sortie;

    public Timestamp getEntree() {
        return entree;
    }

    public void setEntree(Timestamp entree) {
        this.entree = entree;
    }

    public Timestamp getSortie() {
        return sortie;
    }

    public void setSortie(Timestamp sortie) {
        this.sortie = sortie;
    }

    public Fourchette(Timestamp entree, Timestamp sortie) {
        this.setEntree(entree);
        this.setSortie(sortie);
    }
    
    
}

