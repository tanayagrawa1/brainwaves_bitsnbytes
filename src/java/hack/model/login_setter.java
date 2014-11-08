/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.model;

import hack.db.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tanay
 */
public class login_setter {
    
    public String login(String a,String b) throws SQLException
    {
        Connection conn = ConnectDB.connect();
        
        PreparedStatement ps = conn.prepareStatement("Select * from login where cust_id =? and pwd= ?");
        ps.setString(1,a);
        ps.setString(2, b);
        ResultSet rs= ps.executeQuery();
        if(rs.next())
        {
            return rs.getString(2);
        }
        return "-1";
               
    }
    
    
    
}
