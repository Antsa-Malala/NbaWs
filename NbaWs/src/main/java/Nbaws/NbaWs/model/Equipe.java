package Nbaws.NbaWs.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Equipe {
    Integer idEquipe;
    String nomEquipe;

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


    public Equipe(int idEquipe, String nomEquipe) {
        this.setIdEquipe(idEquipe);
        this.setNomEquipe(nomEquipe);
    }

    public Equipe(int idEquipe) {
        this.setIdEquipe(idEquipe);
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

    public Equipe getById(Connection con) throws Exception
    {
        Equipe equipe=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = "select * from equipe where idequipe="+String.valueOf(this.getIdEquipe());
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                equipe=new Equipe(res.getInt("idequipe"),res.getString("nomequipe"));
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
        return equipe;
    }
    
    public int getNbMatch(Connection con) throws Exception
    {
        int nb=0;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = "select count(*) as nb from match where idequipe1="+this.getIdEquipe()+" or idequipe2="+this.getIdEquipe();
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                nb=res.getInt("nb");
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
        return nb;
    }

    public ArrayList<Joueur> getJoueur(Connection con) throws Exception
    {
        ArrayList<Joueur> jo=new ArrayList<Joueur>();
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = "select idjoueur from joueur where idequipe="+this.getIdEquipe();
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                Joueur j=Joueur.getById(con,res.getInt("idjoueur"));
                jo.add(j);
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
        return jo;
    }
}
