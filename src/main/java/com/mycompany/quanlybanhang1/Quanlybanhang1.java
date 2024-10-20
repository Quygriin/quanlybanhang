/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package com.mycompany.quanlybanhang1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Quanlybanhang1 {

    public static void main(String[] args) throws ClassNotFoundException {
        String url="jdbc:sqlserver://localhost:1433;databaseName=BANHANG;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
     
        try  {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection  con= DriverManager.getConnection(url);
                 Statement stmt= con.createStatement();
             String sql="select * from hoadon";
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("mahd"));
            }
                    }
        catch (SQLException e) {
            System.out.println(" sai lỗi"+e.getMessage());
        }
        
    }
}
