/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
/**
 *
 * @author tanay
 */
public class ConnectDB {
    
    
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/socgen_hack";


static final String USER = "root";
static final String PASS = "root";

public static Connection connect() {
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
// System.out.println("Hello");
//Establishing a connection.

conn = DriverManager.getConnection(DB_URL,USER,PASS);
//System.out.println(conn);
//System.out.println("Hello1");
return conn;

}catch(SQLException se){
//Handle errors for JDBC
se.printStackTrace();
}catch(Exception e){
//Handle errors for Class.forName
e.printStackTrace();
}
return conn;
}
    
    
}
