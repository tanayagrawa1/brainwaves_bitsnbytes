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
import java.sql.Statement;

/**
 *
 * @author tanay
 */
public class update_cost {
    
    public int update (String s,int val) throws SQLException
    {
        
        
        Connection conn = ConnectDB.connect();
        String statement="update user_preference set wt_"+val+"= 3*wt_"+val+" where user_id='"+s+"'";
        System.out.println(statement);
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(statement);
        
        PreparedStatement ps = conn.prepareStatement("select * from user_preference where user_id=?");
        ps.setString(1,s);
        rs = ps.executeQuery();
        String tmp=null;
        int temp;
        if(rs.next())
        {
            int a[] = new int[3];
            String str[]=new String[3];
           /* a1=rs.getString(2);
            b1=rs.getString(3);
            c1=rs.getString(4);
            a = rs.getInt(5);
            b = rs.getInt(6);
            c = rs.getInt(7);
            
           /* if(a>b)
            {
                if(a>c)
                {
                    if(b>c)
                    {
                       return 1; 
                    }
                    else
                    {
                        temp =c;
                        c=b;
                        b=temp;
                        
                        tmp=c1;
                        c1=b1;
                        b1=tmp;
                    }
                
                }
                
                else
                {
                    temp=c;
                    c=a;
                    a=temp;
                    temp=a;
                    a=b;
                    b=temp;
                    
                    tmp = c1;
                    c1=a1;
                    a1=tmp;
                    
                    tmp=a1;
                    a1=b1;
                    b1=tmp;
                    
                }
            }
            
            else
            {
               if(b>c)
               {
                   
               }
            
            }*/
            
        }
        
        
        
        if(rs.next())
            return 1;
        
        
        
        return 0;
    }
    
    
    
}
