/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeveloppeurDaoImpl;

/**
 *
 * @author kor
 */
import developpeur.Developpeur;
import dbConnection.DBConnection;
import developpeurDao.DeveloppeurDao;
import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.Scanner;


public class DeveloppeurDaoImpl implements DeveloppeurDao {

    public DeveloppeurDaoImpl() {

    }

    // Créer la table
    public static void CreateDevData() {
        Connection cn = DBConnection.getConnection();
        Statement st = null;
        if (cn == null) {
            return;
        }
        // Créer la table
        try {
            st = cn.createStatement();
            String createTableSQL = "CREATE TABLE DevData ("
                    + "Developpeurs VARCHAR(32), "
                    + "Jour CHAR(11), "
                    + "NbScripts INTEGER)";
            st.executeUpdate(createTableSQL);
            System.out.println("Table DevData créée !");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        } finally {
            try {
                //Etape 5 : Libérer les ressources de la mémoire
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }

    //  méta-données
    public static void metaDonnées() {
        Statement st = null;
        Connection cn = DBConnection.getConnection();
        ResultSet rs = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez votre requête SQL :");
            String userQuery = scanner.nextLine();
            System.out.println("________________________________");
            st = cn.createStatement();
            boolean isResultSet = st.execute(userQuery);
            if (isResultSet) {
                // La requête produit un ResultSet
                rs = st.getResultSet();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                // Afficher le nombre de colonnes
                System.out.println("Nombre de colonnes : " + columnCount);
                // Afficher les méta-données pour chaque colonne
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Colonne " + i + ": "
                            + metaData.getColumnName(i)
                            + ", Type: " + metaData.getColumnTypeName(i));
                }
                // Afficher le contenu de la table ligne par ligne
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }
            } else {
                // La requête n'a pas produit de ResultSet, on affiche le nombre de lignes affectées
                int lignesAffectées = st.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + lignesAffectées);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erreur SQL");
            }
        }
    }

    // Total de scripts réalisés par un développeur donné
    @Override
    public void totalScriptsParDeveloppeur(String nom) {

        Statement st = null;
        Connection cn = DBConnection.getConnection();
        ResultSet rs = null;
        String sql = "SELECT SUM(NbScripts) AS TotalScripts FROM DevData WHERE Developpeurs = '" + nom + "'";

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Total de scripts réalisés par " + nom + ": " + rs.getInt("TotalScripts"));
            } else {
                System.out.println("Aucun résultat trouvé pour le développeur: " + nom);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erreur SQL");
            }
        }
    }

    //  Calculer et afficher le nombre total de scripts réalisés en une semaine
    @Override
    public void totalScriptsSemaine() {

        Statement st = null;
        Connection cn = DBConnection.getConnection();
        ResultSet rs = null;
        String sql = "SELECT SUM(NbScripts) AS TotalScripts FROM DevData";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Total de scripts réalisés en une semaine: "
                        + rs.getInt("TotalScripts"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erreur SQL");
            }
        }
    }
//  Afficher la liste des développeurs triée par le nombre de scripts

    @Override
    public void DeveloppeursParNBScript() {
        Statement st = null;
        Connection cn = DBConnection.getConnection();
        ResultSet rsMax = null;
        try {
            String totalScriptsSQL = "SELECT Developpeurs, SUM(NbScripts) AS TotalScripts "
                    + "FROM DevData GROUP BY Developpeurs ORDER BY TotalScripts DESC";
            st = cn.createStatement();
            ResultSet rsTotal = st.executeQuery(totalScriptsSQL);
            while (rsTotal.next()) {
                System.out.println("Développeur: " + rsTotal.getString("Developpeurs")
                        + ", TotalScripts: " + rsTotal.getInt("TotalScripts"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
        } finally {
            try {
                if (rsMax != null) {
                    rsMax.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erreur SQL");
            }
        }
    }

    // Maximum de scripts réalisés en une journée
    @Override
    public void DeveloppeursMaxScript() {
        Statement st = null;
        Connection cn = DBConnection.getConnection();
        ResultSet rsMax = null;
        try {
            String maxScriptsSQL = "SELECT Developpeurs, jour, MAX(NbScripts) "
                    + "FROM devdata "
                    + "GROUP BY jour";
            st = cn.createStatement();
            rsMax = st.executeQuery(maxScriptsSQL);

            while (rsMax.next()) {
                System.out.println("Développeur: "
                        + rsMax.getString("Developpeurs")
                        + ", Jour: " + rsMax.getString("Jour")
                        + ", MaxScripts: " + rsMax.getInt("MAX(NbScripts)"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL: " + ex.getMessage());
        } finally {
            try {
                if (rsMax != null) {
                    rsMax.close(); // Fermer ResultSet
                }
                if (st != null) {
                    st.close(); // Fermer Statement
                }
                if (cn != null) {
                    cn.close(); // Fermer Connection
                }
            } catch (SQLException ex) {
                System.out.println("Error SQL");
            }
        }
    }

    // Insérer des données du developpeur
    @Override
    public void save(Developpeur developpeur) {
        Statement st = null;
        Connection cn = DBConnection.getConnection();
        if (cn == null) {
            return;
        }
        if (developpeur.getId() > 0) {

        } else {
            try {
                st = cn.createStatement();
                String req = "insert into devdata values('"
                        + developpeur.getNomDeveloppeur()
                        + "','" + developpeur.getJour() + "','"
                        + developpeur.getNbScript() + "')";
                st.executeUpdate(req);
            } catch (SQLException ex) {
                System.out.println("Erreur SQL");
            } finally {
                try {
                    //Etape 5 : Libérer les ressources de la mémoire
                    if (st != null) {
                        st.close();
                    }
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Impossible de libérer les ressources");
                }
            }
        }
    }

   

}
