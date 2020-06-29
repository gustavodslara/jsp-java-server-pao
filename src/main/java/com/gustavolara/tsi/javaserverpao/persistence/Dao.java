package com.gustavolara.tsi.javaserverpao.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class Dao {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:32769/javaserverpao?autoReconnect=true&useSSL=false", "root", "password");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }

    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
        }
    }
}
