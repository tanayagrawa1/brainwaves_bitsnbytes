/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.model;

import hack.db.ConnectDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tanay
 */
public class find_deals {
    
    
    public deal_bean[] find(String s) throws SQLException, IOException
    {
        Connection conn = ConnectDB.connect();
        PreparedStatement ps = conn.prepareStatement("Select * from user_preference where user_id=?");
        ps.setString(1, s);
        ResultSet rs = ps.executeQuery();
        String s1,s2,s3 ;
        s1=s2=s3=null;
        int i=0;
        deal_bean[] dc= new deal_bean[3];
        if(rs.next())
        {
            s1=rs.getString(3);
            s2=rs.getString(4);
            s3=rs.getString(5);
        }
        
        Date d = new Date();
        int z = d.getHours();
        int k;
        if(z>=8&&z<12)
            k=1;
        else if(z>=12 && z<17)
            k=2;
        else if(z>=17 && z<22)
            k=3;
        else
            k=4;
        
       get_Deals gd = new get_Deals();
       ps = conn.prepareStatement("select * from auctions where timeslot=? and category=?");
       ps.setString(1, k+"");
       ps.setString(2, s1);
       rs = ps.executeQuery();
       if(rs.next())
       {
           dc[i]= new deal_bean();
        dc[i++]=   gd.get_img(rs.getString(4), rs.getString(2));
       }
        
       
       ps = conn.prepareStatement("select * from auctions where timeslot=? and category=?");
       ps.setString(1, k+"");
       ps.setString(2, s2);
       rs = ps.executeQuery();
       if(rs.next())
       {
           dc[i]= new deal_bean();
        dc[i++]=   gd.get_img(rs.getString(4), rs.getString(2));
       }
    
        ps = conn.prepareStatement("select * from auctions where timeslot=? and category=?");
       ps.setString(1, k+"");
       ps.setString(2, s3);
       rs = ps.executeQuery();
       if(rs.next())
       {
           dc[i]= new deal_bean();
        dc[i++]=   gd.get_img(rs.getString(4), rs.getString(2));
       }
    
       return dc;
    }
}
    
    
    

