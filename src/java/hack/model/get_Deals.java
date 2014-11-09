/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.model;

import hack.db.ConnectDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tanay
 */
public class get_Deals {
     int i;
    public deal_bean get_img(String a,String b) throws SQLException, FileNotFoundException, IOException
    {
        
        Connection conn = ConnectDB.connect();
        deal_bean db=new deal_bean();
        PreparedStatement ps = conn.prepareStatement("Select * from deals where vendor_id=? and time_slot=?");
        ps.setString(1,a);
        ps.setString(2, b);
        System.out.println("XYZ"+a+" "+b);
        OutputStream f=null;
        
        ResultSet rs= ps.executeQuery();
        if(rs.next())
        {
            db.setVendor_id(rs.getString(2));
            db.setLink(rs.getString(5));
            db.setTime_slot(rs.getString(3));
             InputStream in = rs.getBinaryStream(4);
             f = new FileOutputStream(new File("/home/tanay/NetBeansProjects/socgen_hackathon/web/img/Deal"+ ++i +".jpg"));
             db.setImg_path("/home/tanay/NetBeansProjects/socgen_hackathon/web/img/Deal"+ i +".jpg");
                
             int c = 0;
             while ((c = in.read()) > -1)
             f.write(c);
             
        }
        f.close();
        return db;
               
    }
    
    
}
