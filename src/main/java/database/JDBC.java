/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class JDBC {
    public static Connection getConnection() throws ClassNotFoundException {
        Connection con=null;
 String url="jdbc:sqlserver://localhost:1433;databaseName=quanlybanhang;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
     
        try  {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              con= DriverManager.getConnection(url);
                 
                    }
        catch (SQLException e) {
            System.out.println(" sai lỗi"+e.getMessage());
        }
		return con;
	}
    public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
