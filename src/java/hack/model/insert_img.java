/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.model;

import hack.db.ConnectDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tanay
 */
public class insert_img {
    
    
    public int insert() throws SQLException, FileNotFoundException, IOException
    {
        Connection conn = ConnectDB.connect();
        PreparedStatement ps = conn.prepareStatement("insert into deals values (?, ?,?, ?,?)");
   
        File f = new File("/home/tanay/img_2.jpeg");
        FileInputStream fis = new FileInputStream(f);
        ps.setInt(1, 2);
        ps.setString(2, "v01");
        ps.setString(3, "2");
        ps.setBinaryStream(4, fis, f.length());
        
        ps.setString(5, "wwww.google.com");
        System.out.println(ps.executeUpdate());
        
        fis.close();
        
        return 1;
    
    }
    
}
