package Nbaws.NbaWs.model;

public class Minute {
    int id;
    int match;
    Fourchette[] fourchette;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public Fourchette[] getFourchette() {
        return fourchette;
    }

    public void setFourchette(Fourchette[] fourchette) {
        this.fourchette = fourchette;
    }

    public Minute(int id, int match, Fourchette[] fourchette) {
        this.setId(id);
        this.setMatch(match);
        this.setFourchette(fourchette);
    }
    
    
}
