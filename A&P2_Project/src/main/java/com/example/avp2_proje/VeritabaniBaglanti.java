package com.example.avp2_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeritabaniBaglanti {

    public static Connection veritabaniBaslat() throws SQLException, ClassNotFoundException {
        String dbDriver="com.mysql.cj.jdbc.Driver";
        String dbURl="jdbc:mysql://localhost:3306/";

        String dbName="avp2_proje";
        String dbUsername="root";
        String dbPassword="";

        Class.forName(dbDriver);
        Connection con= DriverManager.getConnection(dbURl + dbName,dbUsername,dbPassword);
        return con;

    }




}
