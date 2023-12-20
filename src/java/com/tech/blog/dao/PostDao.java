package com.tech.blog.dao;

import com.tech.blog.helper.ConnectionProvider;
import com.tech.bolg.entities.Category;
import com.tech.bolg.entities.Post;
import java.sql.*;
import java.util.*;
public class PostDao {
    Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Category> getAllCategories(){
        ArrayList<Category> list= new ArrayList<Category>();
        
            try{
                
                String q="select * from categories";
                Statement st=this.con.createStatement();
                
                ResultSet set=st.executeQuery(q);
                while(set.next()){
                    int cid =set.getInt("cid");
                    String name=set.getString("name");
                    String description=set.getString("description");
                    
                    Category c=new Category(cid,name,description);
                    list.add(c);
                    
                    
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            return list;
        
    }
    
    public boolean savePost(Post p){
        boolean f=false;
        
        try{
            
            String q="insert into post(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, p.getpTitle());
            ps.setString(2, p.getpContent());
            ps.setString(3, p.getpCode());
            
            ps.setString(4, p.getpPic());
            ps.setInt(5, p.getCatId());
            ps.setInt(6, p.getUserId());
            ps.executeUpdate();
            
            f=true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return f;
    }
    
    
    // Get All the Posts
    
    public List<Post> getAllPosts()
    {
        List<Post> list=new ArrayList<>();
        //Fetch all the posts
        try{
            
            PreparedStatement p=con.prepareStatement("select * from post order by pid desc");
            
            ResultSet set=p.executeQuery();
            
            while(set.next())
            {
                
                int pid=set.getInt("pid");
                String pTitle=set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                
                int catId=set.getInt("catId");
                int userId=set.getInt("userId");
                
                Post post = new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);
                
                list.add(post);
                
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<Post> getPostbyCatId(int catId)
    {
        
        List<Post> list=new ArrayList<>();
        //Fetch all the posts by ID only
        try{
            
            PreparedStatement p=con.prepareStatement("select * from post where catId=?");
            
            p.setInt(1,catId);
            
            ResultSet set=p.executeQuery();
            
            while(set.next())
            {
                
                int pid=set.getInt("pid");
                String pTitle=set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                
                
                int userId=set.getInt("userId");
                
                Post post = new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);
                
                list.add(post);
                
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return list;
        
    }
    
    public Post getPostByPostId(int postId)
    {
        Post post=null;
        String q;
        q = "select * from post where pid=?";
        try{
            PreparedStatement ps= this.con.prepareStatement(q);
        
            ps.setInt(1, postId);
            
            ResultSet set=ps.executeQuery();
            if(set.next()){
              
                int pid=set.getInt("pid");
                String pTitle=set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                int cid=set.getInt("catId");
                
                int userId=set.getInt("userId");
                
                post = new Post(pid, pTitle, pContent, pCode, pPic, date, cid, userId);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return post;
        
    }
    
    
   public boolean deletePost(int postId, int userId) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionProvider.getConnection();

            // Verify that the post belongs to the user before deleting
            if (!isPostBelongsToUser(postId, userId, con)) {
                return false; // Post does not belong to the user
            }

            // Delete the post
            String query = "DELETE FROM post WHERE pid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, postId);

            // Execute the delete operation
            int rowsAffected = ps.executeUpdate();

            // Check if the deletion was successful (at least one row affected)
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately (logging, etc.)
            return false;
        } finally {
            // Close the resources in the reverse order of their creation
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
            }
        }
    }

    // Helper method to check if the post belongs to the user
    private boolean isPostBelongsToUser(int postId, int userId, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            String query = "SELECT COUNT(*) from post WHERE pid = ? AND uid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, postId);
            ps.setInt(2, userId);

            // Execute the query to count matching rows
            return ps.executeQuery().next();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
    
    
}

    
