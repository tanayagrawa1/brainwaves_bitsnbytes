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
public class UserPreference {
    
    public int checkUser(String c) throws SQLException
    {
        Connection conn= ConnectDB.connect();
        PreparedStatement ps= conn.prepareStatement("Select * from user_preference where user_id= ? ");
        ps.setString(1, c);
        ResultSet rs= ps.executeQuery();
        if(rs.next())
        {
            System.out.println("Hello");
            return 1;
        }
        return 0;
        
        

        
    }
    
    public int updatePref(String a,String[] b,int[] c) throws SQLException
    {
        Connection conn= ConnectDB.connect();
        PreparedStatement ps= conn.prepareStatement("insert into user_preference values (?,?,?,?,?,?,?)");
        ps.setString(1,a);
        for(int i=1;i<=3;i++)
        {
            ps.setString(i+1,b[i-1]);
            ps.setInt(i+4, c[i-1]);
        }
        int k=ps.executeUpdate();
        if(k==0)
        {
            return 0;
        }
        return 1;
    }
    
}
