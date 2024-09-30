/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kor
 */
public class DBConnection {

    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost/scriptdev";
    private static Connection cn = null;
    
     public static Connection getConnection() {
        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        }
        return cn;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static Connection getCn() {
        return cn;
    }

    public static void setUser(String user) {
        DBConnection.user = user;
    }

    public static void setPassword(String password) {
        DBConnection.password = password;
    }

    public static void setUrl(String url) {
        DBConnection.url = url;
    }

    public static void setCn(Connection cn) {
        DBConnection.cn = cn;
    }
 

   
}


