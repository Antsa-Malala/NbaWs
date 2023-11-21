package Nbaws.NbaWs.model;
import java.sql.DriverManager;
import java.sql.Connection;

public class Connexion {
    public static Connection getConnect() throws Exception{
        try{  
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nba", "nba", "nba");
            return connect;    
        }
        catch(Exception e){
            throw e;
        }
    }
}  
