package com.tech.blog.servlets;

import com.tech.blog.dao.EventDao;
import com.tech.bolg.entities.Event;
import com.tech.blog.helper.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/events")
public class EventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventDao eventDao = new EventDao(ConnectionProvider.getConnection());
        List<Event> upcomingEvents = eventDao.getUpcomingEvents();

        request.setAttribute("upcomingEvents", upcomingEvents);
        request.getRequestDispatcher("events.jsp").forward(request, response);
    }
}
