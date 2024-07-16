<%@page import="com.tech.bolg.entities.User"%>
<%@page import="com.tech.blog.dao.LikeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.bolg.entities.Post"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>

<div class="row">


<% 
    
    User uuu=(User)session.getAttribute("currentUser");
    Thread.sleep(500);
    PostDao d=new PostDao(ConnectionProvider.getConnection());
    
    int cid=Integer.parseInt(request.getParameter("cid"));
    List<Post> post=null;
    if(cid==0){
    
    post=d.getAllPosts();
    }else{
        
        post=d.getPostbyCatId(cid);
        
    }
    
    if(post.size()==0){
        out.println("<h3 class='display-3 text-center'>Unfortunately No Content Yet in this Category...</h3>");
        return;
    }
    for(Post p:post)
    {
        %>
        
        <div class="col-md-6 mt-2">
            <div class="card">
                <img class="card-img-top" src="blog_pics/<%=p.getpPic() %>" alt="Card image cap">
                <div class="card-body">
                    <b><%=p.getpTitle() %> </b>
                    <p><%= p.getpContent() %></p>
                  
                </div>
                    
                    <div class="card-footer primary-background text-center">
                        
                        <%
                            LikeDao ld=new LikeDao(ConnectionProvider.getConnection());
                        %>
                        
                       <a href="#!" onclick="doLike(<%= p.getPid()%>,<%= uuu.getId()%>,this)" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i> <span class="like-counter"><%= ld.countLikeOnPost(p.getPid()) %></span></a> 
                        <a href="show_blog_page.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light btn-sm">Read More...</a>                        
                                              
                        <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i> <span>20</span></a>                        
                    </div>        
                
                
            </div>
            
            
            
            
        </div>
        
        
        
      <%
    }



%>

</div>