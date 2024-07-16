<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.sql.*" %>
<%-- 
    Document   : index
    Created on : Nov 23, 2023, 4:43:25 PM
    Author     : coolr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--css -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css"/>
       
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background {
            clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 84%, 70% 100%, 30% 89%, 0 95%, 0 0);
         }
        </style>
        
    </head>
    <body>
         
        
        <!--NavBar -->
        <%@include file="normal_navbar.jsp" %>
        
        
        <!--//Banner -->
        
        <div class="container-fluid p-0 m-0">
            <div class="jumbotron primary-background text-white banner-background" >
                <div class="container">
                <h3 class="display-3"> Welcome To  Tech Blog </h3>
                
                <p>Programming languages are the backbone of software development, enabling humans to communicate with computers and instruct them to perform specific tasks. They serve as the foundation for creating a wide array of applications, ranging from simple scripts to complex, feature-rich software.

Diverse Landscape
The programming world is diverse, with a multitude of languages catering to different needs and preferences. Each language has its unique syntax, strengths, and areas of application. Whether you're interested in web development, data science, artificial intelligence, or embedded systems, there's a programming language tailored to meet your requirements.
                
                </p>
                
               <a href="start_page.jsp " target="_blank"><button class="btn btn-outline-light btn-lg"><span class="fa fa fa-user-plus"></span> Start! It's Free</button></a>
                <a href="Login_page.jsp" class="btn btn-outline-light btn-lg "><span class="fa fa-user-circle-o fa-spin"></span> Login</a>
                
                </div>
            </div>
            
            
            
        </div>


        <!<!-- CARDS -->
        <div class="container">
            <div class="row" mb-2>
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">Java Programming</h5>
                          <p class="card-text">Java is a widely-used programming language for coding web applications. It has been a popular choice among developers for over two decades, with millions of Java applications in use today. Java is a multi-platform, object-oriented, and network-centric language that can be used as a platform in itself. It is a fast, secure, reliable programming language for coding everything from mobile apps and enterprise software to big data applications and server-side technologies.</p>
                          <a href="https://www.youtube.com/watch?v=A74TOX803D0" target="_blank" class="btn primary-background text-white">Read More</a>
                        </div>
                      </div>
               
                    </div>
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">Data Structure And Algorithms</h5>
                          <p class="card-text">A data structure is defined as a particular way of storing and organizing data in our devices to use the data efficiently and effectively. The main idea behind using data structures is to minimize the time and space complexities. An efficient data structure takes minimum memory space and requires minimum time to execute the data.</p>
                          <a href="https://www.geeksforgeeks.org/learn-data-structures-and-algorithms-dsa-tutorial/" class="btn primary-background text-white" target="_blank">Read More</a>
                        </div>
                      </div>
               
                    </div>
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">Rust Programming Language</h5>
                          <p class="card-text">Rust is a multi-paradigm, general-purpose programming language that emphasizes performance, type safety, and concurrency. It enforces memory safety, meaning that all references point to valid memory, without requiring the use of automated memory management techniques such as garbage collection. To simultaneously enforce memory safety and prevent data races, its "borrow checker" tracks the object lifetime of all references in a program during compilation. Rust was influenced by ideas from functional programming, including immutability, higher-order functions, and algebraic data types. It is popular for systems programming.</p>
                          <a href="https://www.rust-lang.org/" target="_blank" class="btn primary-background text-white">Read More</a>
                        </div>
                      </div>
               
                    </div>
                  </div>
                 <div class="row">
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">SQL</h5>
                          <p class="card-text">Structured query language (SQL) is a programming language for storing and processing information in a relational database. A relational database stores information in tabular form, with rows and columns representing different data attributes and the various relationships between the data values.</p>
                          <a href="https://www.w3schools.com/sql/" target="_blank" class="btn primary-background text-white">Read More</a>
                        </div>
                      </div>
               
                    </div>
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">Kotlin Programming</h5>
                          <p class="card-text">Kotlin is a modern statically typed programming language used by over 60% of professional Android developers that helps boost productivity, developer satisfaction, and code safety.</p>
                          <a href="https://kotlinlang.org/" target="_blank" class="btn primary-background text-white">Read More</a>
                        </div>
                      </div>
               
                    </div>
                <div class="col-md-4">
                    <div class="card" >
                       
                        <div class="card-body">
                          <h5 class="card-title">RoadMaps</h5>
                          <p class="card-text">Here are some Developer Roadmaps which would help you choose the best career.</p>
                          <a href="https://roadmap.sh/" target="_blank" class="btn primary-background text-white">Read More</a>
                        </div>
                      </div>
               
                    </div>
                  </div>
            </div>
        </div>
            
        <!--JavaScripts -->
       
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
      
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>
       
    </body>
</html>
