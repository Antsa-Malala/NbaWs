package Nbaws.NbaWs.model;

import java.sql.Date;

public class Match {
    int idMatch;
    String lieu;
    Date dateDebut;
    Equipe equipe1;
    Equipe equipe2;

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Match(int idMatch, String lieu, Date dateDebut, Equipe equipe1, Equipe equipe2) {
        this.setIdMatch(idMatch);
        this.setLieu(lieu);
        this.setDateDebut(dateDebut);
        this.setEquipe1(equipe1);
        this.setEquipe2(equipe2);
    }
    
    
}

