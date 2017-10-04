package sql;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import pronostics.Equipe;
import pronostics.Match;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1fryouf
 */
public class SQLConnection {

    private final String dbURL = "jdbc:derby://localhost:1527/sample;create=true;user=app;password=app";
    private String tableName;
    
    private Connection conn = null;
    private Statement stmt = null;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    
    public void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException except){
            
            except.printStackTrace();
        }
    }
    
    public boolean insertTeam(String nom, String president, String entraineur, String pays, String championat, String stade, String icon ){
        
        try{
            
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO " + tableName + " VALUES ('" + nom + "','" + entraineur + "','" + president + "','" + pays + "','" + championat + "','" + stade + "','" + icon + "')");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }

    public boolean insertMatch(String id, String equipeDom, String equipeExt, String stade, String date, String competition, int butDom, int butExt){
        
        try{
            
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO " + tableName + " VALUES ('" + equipeDom + 
                    "','" + equipeExt + 
                    "','" + stade + 
                    "','" + date + 
                    "','" + competition + 
                    "','" + id + 
                    "'," + butDom + 
                    "," + butExt + 
                    ")");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }
    
    public boolean editTeam(String nom, String president, String entraineur, String pays, String championat, String stade, String icon ){
        
        try{
            
            stmt = conn.createStatement();
            stmt.execute("UPDATE " + tableName + " "
                    + " SET nom='" + nom 
                    + "', entraineur='" + entraineur 
                    + "', president='" + president 
                    + "', pays='" + pays 
                    + "', championat='" + championat 
                    + "', stade='" + stade 
                    + "', icon='" + icon + "'"
                    + " WHERE nom='" + nom + "'");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }
    
    public boolean editMatch(String id, String equipeDom, String equipeExt, String stade, String date, String competition, int butDom, int butExt ){
        
        try{
            
            stmt = conn.createStatement();
            stmt.execute("UPDATE " + tableName + " "
                    + " SET id='" + id 
                    + "', equipe_domicile='" + equipeDom 
                    + "', equipe_exterieur='" + equipeExt 
                    + "', stade='" + stade 
                    + "', date='" + date
                    + "', competition='" + competition
                    + "', but_domicile=" + butDom
                    + ", but_exterieur=" + butExt
                    + " WHERE id='" + id + "'");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteTeam(String nom){
       
        try{
            
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM " + tableName + " WHERE nom ='" + nom + "'");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteMatch(String id ){
       
        try{
            
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM " + tableName + " WHERE id ='" + id + "'");
            stmt.close();

            return true;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Equipe> selectTeams(String teamName){
        
        try{
            stmt = conn.createStatement();
            ArrayList<Equipe> listTeam;
            
            String query = "SELECT * FROM " + tableName + " WHERE nom ='" +teamName+ "' ORDER BY nom";
            
            if("".equals(teamName)){
                query = "SELECT * FROM " + tableName + " ORDER BY nom";
            }
            
            try (ResultSet results = stmt.executeQuery(query)) {

                listTeam = new ArrayList<>();
                while(results.next()){
                    Equipe e = new Equipe(results.getString(1), results.getString(2) , results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7));
                    listTeam.add(e);
                }
            }
            stmt.close();
            
            return listTeam;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<Equipe> selectTeamsByComp(String compName){
        
        try{
            stmt = conn.createStatement();
            ArrayList<Equipe> listTeam;
            
            String query = "SELECT * FROM " + tableName + " WHERE championat ='" +compName+ "' ORDER BY nom";
            
            if(null != compName)switch (compName) {
                case "":
                    query = "SELECT * FROM " + tableName + " WHERE championat NOT IN (SELECT DISTINCT championat FROM APP.EQUIPES WHERE championat !='') ORDER BY nom";
                    break;
                case "Toutes":
                    query = "SELECT * FROM " + tableName + " ORDER BY nom";
                    break;
            }
            
            System.out.println(query);
            try (ResultSet results = stmt.executeQuery(query)) {

                listTeam = new ArrayList<>();
                while(results.next()){
                    Equipe e = new Equipe(results.getString(1), results.getString(2) , results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7));
                    listTeam.add(e);
                }
            }
            stmt.close();
            
            return listTeam;
        }catch (SQLException sqlExcept){

            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<String> selectTeamsByMatchs(String compName){
        
        try{
            stmt = conn.createStatement();
            ArrayList<String> listTeam;
            
            String query1 = "select equipe_domicile from APP.MATCHES where competition IN ('SP1','SP2') and date > '2016-01-01'";
            String query2 = "select equipe_exterieur from APP.MATCHES where competition IN ('SP1','SP2') and date > '2016-01-01'";
            
            System.out.println(query1);
            try (ResultSet results = stmt.executeQuery(query1)) {

                listTeam = new ArrayList<>();
                while(results.next()){
                    String e = results.getString(1);
                    listTeam.add(e);
                }
            }
            try (ResultSet results = stmt.executeQuery(query2)) {

                listTeam = new ArrayList<>();
                while(results.next()){
                    String e = results.getString(1);
                    listTeam.add(e);
                }
            }
            stmt.close();
            Set<String> hs = new HashSet<>();
            hs.addAll(listTeam);
            listTeam.clear();
            listTeam.addAll(hs);
            return listTeam;
        }catch (SQLException sqlExcept){

            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<Match> selectMatchs(String id){
        
        try{
            stmt = conn.createStatement();
            ArrayList<Match> listMatch;
            
            String query = "SELECT * FROM " + tableName + " WHERE id ='" + id +  "'";
            
            if("".equals(id)){
                query = "SELECT * FROM " + tableName + " ORDER BY date DESC";
            }
            
            try (ResultSet results = stmt.executeQuery(query)) {

                listMatch = new ArrayList<>();
                while(results.next()){
                    Match m = new Match(results.getString(1), results.getString(2) , results.getString(3), new Date(new SimpleDateFormat("yyyy-MM-dd").parse(results.getString(4)).getTime()), results.getString(5), results.getInt(7), results.getInt(8) );
                    listMatch.add(m);
                }
                stmt.close();
                return listMatch;
            } catch (ParseException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
            
            
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<Match> selectMatchsByComp(String compName){
        
        try{
            stmt = conn.createStatement();
            ArrayList<Match> listMatch;
            
            String query = "SELECT * FROM " + tableName + " WHERE competition ='" + compName +  "' AND date > '2017-08-01' ORDER BY date ASC, equipe_domicile, equipe_exterieur DESC";
            
            if("".equals(compName)){
                query = "SELECT * FROM " + tableName + " WHERE competition NOT IN (SELECT DISTINCT championat FROM APP.EQUIPES WHERE championat !='') ORDER BY date DESC, equipe_domicile, equipe_exterieur";
            }
            
            try (ResultSet results = stmt.executeQuery(query)) {

                listMatch = new ArrayList<>();
                while(results.next()){
                    Match m = new Match(results.getString(1), results.getString(2) , results.getString(3), new Date(new SimpleDateFormat("yyyy-MM-dd").parse(results.getString(4)).getTime()), results.getString(5), results.getInt(7), results.getInt(8) );
                    listMatch.add(m);
                }
                stmt.close();
                return listMatch;
            } catch (ParseException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
            
            
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<String> selectCompetitions(String compName){
        
        try{
            stmt = conn.createStatement();
            ArrayList<String> comps;
            
            String query = "SELECT DISTINCT championat FROM " + tableName + " WHERE championat ='" +compName+ "' ORDER BY championat ASC";
            
            if("Toutes".equals(compName)){
                query = "SELECT DISTINCT championat FROM " + tableName + " ORDER BY championat ASC";
            }
            
            try (ResultSet results = stmt.executeQuery(query)) {

                comps = new ArrayList<>();
                while(results.next()){
                   
                    comps.add(results.getString(1));
                }
            }
            stmt.close();
            
            return comps;
        }catch (SQLException sqlExcept){
            sqlExcept.printStackTrace();
            return null;
        }
        
    }
    
    public int execute(String query){
        
        int nbVictoires = -1;
        try {
                stmt = conn.createStatement();
                
                
                try (ResultSet results = stmt.executeQuery(query)) {
                    
                    while(results.next()){
                        nbVictoires = results.getInt(1);
                        
                    }
                    
                    stmt.close();
                    return nbVictoires;
                }catch(Exception e){
                    e.printStackTrace();
                    return nbVictoires;
                }
                
            }catch(SQLException ex){
                
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                return nbVictoires;
            }
    }
    
    private void shutdown(){
        try{
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept){
            
        }

    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
}
