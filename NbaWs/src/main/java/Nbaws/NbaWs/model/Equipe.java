package Nbaws.NbaWs.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Equipe {
    Integer idEquipe;
    String nomEquipe;
    List<Integer> joueur;

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public List<Integer> getJoueur() {
        return joueur;
    }

    public void setJoueur(List<Integer> equipe) {
        this.joueur = equipe;
    }

    public Equipe(int idEquipe, String nomEquipe,List<Integer> joueur) {
        this.setIdEquipe(idEquipe);
        this.setNomEquipe(nomEquipe);
        this.setJoueur(joueur);
    }
    public Equipe(int idEquipe, String nomEquipe) {
        this.setIdEquipe(idEquipe);
        this.setNomEquipe(nomEquipe);
    }

    public static Equipe[] getListEquipe(Connection con) throws Exception
    {
        ArrayList<Equipe> listEquipe=new ArrayList<Equipe>();
        Equipe[] equipe=new Equipe[0];
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = "select * from equipe";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                Equipe e=new Equipe(res.getInt("idequipe"),res.getString("nomequipe"));
                listEquipe.add(e);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        finally{

            if( res != null ){
                res.close();
            }
            if(st != null ){
                st.close();
            }
            if(co==1)
            {
                con.close();
            }
        }
        return listEquipe.toArray(equipe);
    }
    
}
