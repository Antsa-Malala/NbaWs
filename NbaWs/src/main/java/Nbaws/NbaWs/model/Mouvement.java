package Nbaws.NbaWs.model;

public class Mouvement {
    int id;
    int joueur;
    int match;
    int[] ppm;
    String[] rpm;
    String[] pdpm;
    String[] lf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJoueur() {
        return joueur;
    }

    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int[] getPpm() {
        return ppm;
    }

    public void setPpm(int[] ppm) {
        this.ppm = ppm;
    }

    public String[] getRpm() {
        return rpm;
    }

    public void setRpm(String[] rpm) {
        this.rpm = rpm;
    }

    public String[] getPdpm() {
        return pdpm;
    }

    public void setPdpm(String[] pdpm) {
        this.pdpm = pdpm;
    }

    public String[] getLf() {
        return lf;
    }

    public void setLf(String[] lf) {
        this.lf = lf;
    }

    public Mouvement(int id, int joueur, int match, int[] ppm, String[] rpm, String[] pdpm, String[] lf) {
        this.setId(id);
        this.setJoueur(joueur);
        this.setMatch(match);
        this.setPpm(ppm);
        this.setRpm(rpm);
        this.setPdpm(pdpm);
        this.setLf(lf);
    }


}
