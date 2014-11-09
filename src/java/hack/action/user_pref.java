/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.action;

import hack.model.UserPreference;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tanay
 */
public class user_pref extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           int ary[] = new int[6];
           String arry[] = new String[6];
           String a;
           ary[0] =Integer.parseInt(request.getParameter("movie"));
           ary[1] =Integer.parseInt(request.getParameter("dine"));
           ary[2] =Integer.parseInt(request.getParameter("eg"));
           ary[3] =Integer.parseInt(request.getParameter("ca"));
           ary[4] =Integer.parseInt(request.getParameter("air"));
           ary[5] =Integer.parseInt(request.getParameter("bd"));
           
           arry[0]="movies";
           arry[1]="food";
           arry[2]="electronics";
           arry[3]="clothing";
           arry[4]="travel";
           arry[5]="stationery";
           
           int i,j,c;
           for(i=0;i<5;i++)
           {
               for(j=i+1;j<6;j++)
               {
                   if(ary[i]<ary[j])
                   {
                       c=ary[i];
                       ary[i]=ary[j];
                       ary[j]=c;
                       a=arry[i];
                       arry[i]=arry[j];
                       arry[j]=a;
                       
                   }
               }
           }
           HttpSession session= request.getSession();
           
           UserPreference up= new UserPreference();
           int k=up.updatePref(session.getAttribute("cust").toString(), arry, ary);
           if(k==0)
           {
               System.out.println("Kya bey LOUDU");
           }
           
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(user_pref.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(user_pref.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
