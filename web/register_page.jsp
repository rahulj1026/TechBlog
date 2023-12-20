<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        
        <!--css -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css"/>
       
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>


        
        <style>
        .banner-background {
            clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 90%, 70% 100%, 26% 92%, 0 100%, 0 0);
         }
        </style>
        
    
    <body>
        <%@include file="normal_navbar.jsp" %>
        <main class="primary-background p-5 banner-background" style="padding-bottom: 100px;">
            
            <div class="container">
                
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-header text-center">
                            <span class="fa fa-3x fa-user-circle" ></span>
                            <br>
                            Register Here
                            
                        </div>
                        <div class="card-body">
                            <form id="reg-form" action="RegisterServlet" method="post">
                                
                                <div class="form-group">
                                      <label for="user_name">User Name</label>
                                      <input type="text" name="user_name" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Enter name">
                                </div>

                               <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" name="user_email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                               </div>
                                
                            <div class="form-group">
                              <label for="exampleInputPassword1">Password</label>
                              <input type="password" name="user_password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                             <!-- <label for="password-validation" >Password should be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit</label> -->
                            </div>
                                
                             <div class="form-group">
                                      <label for="gender">Select Gender</label>
                                      <br>
                                      <input type="radio" id="gender" name="gender" value="male">Male
                                      <input type="radio" id="gender" name="gender" value="female">Female
                            </div>
                                <div class="form-group">
                                    <textarea name ="about" class="form-control" id=""  rows="5" placeholder="Enter something about yourself"></textarea>
                                   
                                </div>
                                    
                             

                                
                            <div class="form-check">
                                      <input type="checkbox" name="check" class="form-check-input" id="exampleCheck1">
                                      <label class="form-check-label" for="exampleCheck1">Agree Terms and Conditions</label>
                                    </div>
                                 

                             <br>    
                             <div class="container text-center" id="loader" style="display: none">
                                <span class="fa fa-refresh fa-spin fa-2x"></span>
                                <h4>Please Wait..</h4>
                             </div>
                             <button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>
                            </form>
                            
                        </div>
                        
                    </div>
                    
                    
                    
                </div>
                
                
            </div>
            
                
                
         </main>
        
        
         <!--JavaScripts -->
         
       
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
      
       <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>
        <script>
            
            $(document).ready(function(){
                console.log("loaded....");
                $('#reg-form').on('submit',function(event){
                    event.preventDefault();
                    
                    let form=new FormData(this);
                    //send to register servlet
                    
                    $("#submit-btn").hide();
                    $("#loader").show();
                    
                    $.ajax({
                        url: "RegisterServlet",
                        type: 'POST',
                        data: form,
                        success: function (data,textStatus,jqXHR){
                            console.log(data);
                            
                            $("#submit-btn").show();
                            $("#loader").hide();
                            
                            if(data.trim()==='done'){
                                
                            swal("Registration Done Successfully....Redirecting to login page")
                            .then((value) => {
                              window.location="Login_page.jsp";
                            });
                        }else{
                            swal(data);
                        }
                        },
                        error: function(jqXHR, textStatus, errorThrown) {
                            
                            $("#submit-btn").show();
                            $("#loader").hide();
                            swal("Something Went Wrong...Try Again");
                            
                        },
                        processData:false,
                        contentType: false

                    });
                    
                    
                });
            });
            
                     
            
        </script>
        
        <!-- Add the following script block to your HTML file -->

    
    </body>
</html>
