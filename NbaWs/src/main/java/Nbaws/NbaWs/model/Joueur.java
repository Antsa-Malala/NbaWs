package Nbaws.NbaWs.model;

import java.sql.Date;

public class Joueur {
    
    int idJoueur;
    String nomJoueur;
    Date dateNaissance;
    double mesure;
    Equipe equipe;
    String sexe;

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getMesure() {
        return mesure;
    }

    public void setMesure(double mesure) {
        this.mesure = mesure;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Joueur(int idJoueur, String nomJoueur, Date dateNaissance, double mesure, Equipe equipe, String sexe) {
        this.setIdJoueur(idJoueur);
        this.setNomJoueur(nomJoueur);
        this.setDateNaissance(dateNaissance);
        this.setMesure(mesure);
        this.setEquipe(equipe);
        this.setSexe(sexe);
    }
    
}
    

