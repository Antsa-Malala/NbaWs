package Nbaws.NbaWs.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;

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
    public void insertTir(Connection con,int idjoueur,int idmatch,int point) throws Exception{
        PreparedStatement st = null;
        int co=0;
        try{
            if(con==null)
            {
                con = Connexion.getConnect();
                co=1;
            }
            String requete = "insert into mouvement values (default,?,?,1,?)";
            st = con.prepareStatement(requete);
            st.setInt(1,idjoueur);
            st.setInt(2,idmatch);
            st.setDouble(3, point);
            st.execute();
            }
        catch(Exception ex){
            throw ex;
        }
        finally{
            if(st != null ){
                st.close();
            }
            if( co==1 ){
                con.close();
            }
        }  
    }

    public int getNbMatch(Connection con) throws Exception
    {
        return this.getEquipe().getNbMatch(con);
    }

    public int getNbMatchJoue(Connection con) throws Exception
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
            String requete = " select count(distinct(idmatch)) as nb from joueurmatch where idjoueur="+this.getIdJoueur();
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

    public int getPoint(Connection con) throws Exception
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
            String requete = " select sum(points) from mouvement where idjoueur="+this.getIdJoueur();
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

    public double getPpm(Connection con) throws Exception
    {
        double nbpoint=Integer.valueOf(this.getPoint(con)).doubleValue();
        double nbmatch=Integer.valueOf(this.getNbMatchJoue(con)).doubleValue();
        double ppm=nbpoint/nbmatch;
        return ppm;
    }
    public double getRpm(Connection con) throws Exception
    {
        double nbrebond=Integer.valueOf(this.getRebond(con)).doubleValue();
        double nbmatch=Integer.valueOf(this.getNbMatchJoue(con)).doubleValue();
        double rpm=nbrebond/nbmatch;
        return rpm;
    }
    public double getPdpm(Connection con) throws Exception
    {
        double nbpassedecisive=Integer.valueOf(this.getPasseDecisive(con)).doubleValue();
        double nbmatch=Integer.valueOf(this.getNbMatchJoue(con)).doubleValue();
        double pdpm=nbpassedecisive/nbmatch;
        return pdpm;
    }
    public double getmpm(Connection con) throws Exception
    {
        LocalTime time=this.getMinute(con).toLocalTime();
        int nbmatch=this.getNbMatchJoue(con);
        LocalTime originalTime = LocalTime.parse("00:48:00");
        long totalSeconds = originalTime.toSecondOfDay() * nbmatch;
        LocalTime min=LocalTime.ofSecondOfDay(totalSeconds);
        double prc=Joueur.calculatePercentage(time, min);
        return prc;
    }

    public double getfg(Connection con) throws Exception
    {
        double nbtir=Integer.valueOf(this.getTir(con)).doubleValue();
        double nbtirMaty=Integer.valueOf(this.getTirMaty(con)).doubleValue();
        double fg=nbtirMaty/nbtir;
        return fg;
    }
    public double getlf(Connection con) throws Exception
    {
        double nblf=Integer.valueOf(this.getlance(con)).doubleValue();
        double nblfMaty=Integer.valueOf(this.getlfMaty(con)).doubleValue();
        double lf=nblfMaty/nblf;
        return lf;
    }
    public double geteff(Connection con) throws Exception
    {
        double nbppm=this.getPpm(con);
        double nbpdpm=this.getPdpm(con);
        double rpm=this.getRpm(con);
        int nbmatch=getNbMatchJoue(con);
        double eff=(nbppm+nbpdpm+rpm)/nbmatch;
        return eff;
    }

    private static double calculatePercentage(LocalTime currentTime, LocalTime totalTime) {
        long currentSeconds = currentTime.toSecondOfDay();
        long totalSeconds = totalTime.toSecondOfDay();

        if (totalSeconds == 0) {
            return 0;
        }

        double percentage = (double) currentSeconds / totalSeconds * 100;
        return percentage;
    }

    public int getRebond(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=2 and idjoueur="+this.getIdJoueur();
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

    public int getPasseDecisive(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=3 and idjoueur="+this.getIdJoueur();
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

    public Time getMinute(Connection con) throws Exception
    {
        Time nb=new Time(0);
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = " select sum(temps) as min from mpm where idjoueur="+this.getIdJoueur();
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
                nb=res.getTime("min");
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

    public int getTir(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=1 and idjoueur="+this.getIdJoueur();
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

    public int getTirMaty(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=1 and points!=0 and idjoueur="+this.getIdJoueur();
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

    public int getlance(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=4 and idjoueur="+this.getIdJoueur();
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

    public int getlfMaty(Connection con) throws Exception
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
            String requete = "select count(*) as nb from mouvement where idactions=4 and points!=0 and idjoueur="+this.getIdJoueur();
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

    public static Joueur getById(Connection con,int idequipe) throws Exception
    {
        Joueur j=null;
        Statement st = null;
        ResultSet res = null;
        int co=0;
        try{
            if(con==null)
            {
                con=Connexion.getConnect();
                co=1;
            }
            String requete = "select * from joueur where idequipe="+idequipe;
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next())
            {
               j=new Joueur(res.getInt("idjoueur"), res.getString("nomJoueur"), res.getDate("datenaissance"),res.getDouble("mesure"), new Equipe(res.getInt("idequipe")).getById(con),res.getString("sexe"));
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
        return j;
    }
}
    

