package com.tech.blog.dao;

import com.tech.bolg.entities.Event;
import com.tech.blog.helper.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
    private final Connection con;

    public EventDao() {
        this.con = ConnectionProvider.getConnection();
    }

    public EventDao(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean addEvent(Event event) {
        boolean f = false;
        try {
            String query = "INSERT INTO events (name, date, location, description) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, event.getName());
                pstmt.setTimestamp(2, new Timestamp(event.getDate().getTime()));
                pstmt.setString(3, event.getLocation());
                pstmt.setString(4, event.getDescription());

                pstmt.executeUpdate();
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Event> getUpcomingEvents() {
        List<Event> events = new ArrayList<>();
        try {
            String query = "SELECT * FROM events WHERE date > NOW() ORDER BY date";
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    int eventId = rs.getInt("eventId");
                    String name = rs.getString("name");
                    Timestamp date = rs.getTimestamp("date");
                    String location = rs.getString("location");
                    String description = rs.getString("description");

                    Event event = new Event(name, date, location, description);
                    event.setEventId(eventId);
                    events.add(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Add other methods as needed (e.g., updateEvent, deleteEvent)
}
