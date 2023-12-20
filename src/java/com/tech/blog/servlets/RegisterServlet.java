/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.bolg.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author coolr
 */

@MultipartConfig
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //Fetch all data from form
            
            String check = request.getParameter("check");
            if (check ==null)
            {
                out.println("Terms and Conditions Not Accepted");
            }else
            {
                //fetch remaining data;
                String name=request.getParameter("user_name");
                String email=request.getParameter("user_email");
                String password=request.getParameter("user_password");
                String gender=request.getParameter("gender");
                String about=request.getParameter("about");
                //Create user object and set all data to that object
                
                
                // Server-side validation
                if (validateInput(name, email, password, gender, about)) {
                    User user = new User(name, email, password, gender, about);
                    UserDao dao = new UserDao(ConnectionProvider.getConnection());

                    if (dao.saveUser(user)) {
                        out.println("done");
                    } else {
                        out.println("error");
                    }
                } else {
                    out.println("Something wentWrong, Please fill all the details!");
                }
            }
        }
    }
    
    
     // Server-side validation method
    private boolean validateInput(String name, String email, String password, String gender, String about) {
        // Validate each field 
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty() || gender == null || gender.trim().isEmpty()
                || about == null || about.trim().isEmpty()) {
            return false; // Validation failed if any field is empty
        }

        
        
       
        // Validate email format
    if (!isValidEmail(email)) {
        return false;
    }

    // Validate password strength
    if (!isValidPassword(password)) {
        return false;
    }
        
        
        

        return true; // If all validations pass
        
   }
    
    // Function to validate email format
private boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    return email.matches(emailRegex);
}

// Function to validate password strength
private boolean isValidPassword(String password) {
    // Password should be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit
    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
    return password.matches(passwordRegex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
