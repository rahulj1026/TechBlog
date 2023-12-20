/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import java.sql.*;

public class LikeDao {
    
    Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }
    
    public boolean insertLike(int pid,int uid){
        boolean f=false;
        try{
            String q="insert into likes (pid,uid)values(?,?)";
            PreparedStatement ps=this.con.prepareStatement(q);
            //Values set........
            
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            
            ps.executeUpdate();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
         return f;
    }
    
   
    public int countLikeOnPost(int pid){
        
        int count=0;
        String q="select count(*) from likes where pid=?";
        
        try {
            PreparedStatement p=this.con.prepareStatement(q);
            p.setInt(1, pid);
            ResultSet set=p.executeQuery();
            if(set.next())
            {
                count=set.getInt("count(*)");
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return count;
        
    }
    
    
    public boolean isLikedByUser(int pid, int uid){
        boolean f=false;
        try{
            PreparedStatement p=this.con.prepareStatement("select * from likes where pid=? and uid=?");
            p.setInt(1, pid);
            p.setInt(2, uid);
            
            ResultSet set=p.executeQuery();
            if(set.next()){
                
                f=true;
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return f;
    }
    
    
    public boolean deleteLike(int pid, int uid){
        
        boolean f=false;
        try {
            PreparedStatement p=this.con.prepareStatement("delete from likes where pid=? and uid=?");
            p.setInt(1, pid);
            p.setInt(2, uid);
            
            p.executeUpdate();
            f=true;
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return f;
    }
}
