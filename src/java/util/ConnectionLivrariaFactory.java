/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.LivrariaDAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Master
 */
public class ConnectionLivrariaFactory {

    public static Connection getConnection() throws LivrariaDAOException {
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "123456");
        } catch (Exception e) {
            throw new LivrariaDAOException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn, Statement strnt, ResultSet rs) throws LivrariaDAOException {
        close(conn, strnt, rs);
    }

    public static void closeConnection(Connection conn, Statement strnt) throws LivrariaDAOException {
        close(conn, strnt, null);
    }

    public static void closeConnection(Connection conn) throws LivrariaDAOException {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement strnt, ResultSet rs) throws LivrariaDAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (strnt != null) {
                strnt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }

    }

}
