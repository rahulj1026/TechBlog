/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import com.tech.bolg.entities.Comment;
/**
 *
 * @author coolr
 */

import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

public class CommentDao {

    private Connection con;

    //create constructor and pass connection for manage DB
    public CommentDao(Connection con) {
        this.con = con;
    }

    //method for save comment on post
    public boolean saveCommentOnPost(Comment c) {
        boolean f = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into comments(pstid,urid,comnt) values(?,?,?)");
            ps.setInt(1, c.getPid());
            ps.setInt(2, c.getUid());
            ps.setString(3, c.getComment());
            ps.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    //method for fetch comment on post
    public List<Comment> getAllCommentByPid(int id) {
        List<Comment> list = new ArrayList<Comment>();
        //code for fetch all comment
        try {
            PreparedStatement ps = this.con.prepareStatement("select * from comments where pstid=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //fetch data from Resultset and asssign to new variable 
                int pid = rs.getInt("pstid");
                int cmid = rs.getInt("cmid");
                int uid = rs.getInt("urid");
                String cmt = rs.getString("comnt");
                Timestamp cmdate=rs.getTimestamp("cmdate");
                
                //all data fetched from DB now assign to Post Object to use this data
                Comment comment=new Comment(cmid, pid, uid, cmt, cmdate) {
                    
                };
                list.add(comment);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
