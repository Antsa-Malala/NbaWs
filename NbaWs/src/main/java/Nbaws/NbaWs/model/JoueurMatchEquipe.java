package Nbaws.NbaWs.model;

public class JoueurMatchEquipe {
    int id;
    int idmatch;
    Equipe equipe1;
    Equipe equipe2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
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

    public JoueurMatchEquipe(int id, int idmatch, Equipe equipe1, Equipe equipe2) {
        this.setId(id);
        this.setIdmatch(idmatch);
        this.setEquipe1(equipe1);
        this.setEquipe2(equipe2);
    }
    
    
}

