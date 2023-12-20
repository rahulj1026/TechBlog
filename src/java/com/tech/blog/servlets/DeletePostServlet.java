package com.tech.blog.servlets;

import com.tech.blog.dao.PostDao;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.bolg.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete-post")
public class DeletePostServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parse request parameters
        int postId = Integer.parseInt(request.getParameter("postId"));

        // Get the current user from the session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        // Perform the delete operation in your database
        // Use appropriate methods from your DAO classes
        PostDao postDao = new PostDao(ConnectionProvider.getConnection());
        boolean success = postDao.deletePost(postId, user.getId());

        // Redirect back to the page where the post was deleted
        if (success) {
            response.sendRedirect("load_post.jsp");
        } else {
            // Handle the case where deletion was not successful
            response.sendRedirect("error_page.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Delete Post Servlet";
    }
}
