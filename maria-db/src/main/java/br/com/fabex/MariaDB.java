package br.com.fabex;

import org.mariadb.jdbc.util.Version;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MariaDB {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
    static final String USER = "admin";
    static final String PASS = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            InputStream resourceAsStream = Version.class.getClassLoader().getResourceAsStream("mariadb.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            System.out.println("Version: " + properties.getProperty("version"));

            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            stmt = conn.createStatement();

            String sql = "SELECT * FROM usuario where id = -1";

            System.out.println("Exist: " + stmt.executeQuery(sql).next());
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ignored) {
            }
        }
    }
}
