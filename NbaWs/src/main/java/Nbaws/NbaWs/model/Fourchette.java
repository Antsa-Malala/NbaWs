package Nbaws.NbaWs.model;

import org.bson.BsonTimestamp;


public class Fourchette {
    BsonTimestamp entree;
    BsonTimestamp sortie;

    public BsonTimestamp getEntree() {
        return entree;
    }

    public void setEntree(BsonTimestamp entree) {
        this.entree = entree;
    }

    public BsonTimestamp getSortie() {
        return sortie;
    }

    public void setSortie(BsonTimestamp sortie) {
        this.sortie = sortie;
    }

    public Fourchette(BsonTimestamp entree, BsonTimestamp sortie) {
        this.setEntree(entree);
        this.setSortie(sortie);
    }
    
    
}

