<%-- 
    Document   : Contactus
    Created on : Jan 30, 2019, 1:16:51 PM
    Author     : AMO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
        <title>Contact us</title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <link href="css/style.css" rel="stylesheet">
        
        
    </head>
    <body>  <div class="green darken-3 topnav ">
            <a class="active" href="/DailyMilkCollectionSystem/">Home</a>
            <a href="#about">About Us</a>
            </div>
        
        <h1 align="center"> Contact us </h1>
       
  <div class="container">
      <form action="Contact-us" method="POST">

    <label for="fname">Full Name</label>
    <input type="text" id="fullname" name="fullname" placeholder="Your full name..">

    <label for="email">Email</label>
    <input type="email" id="email" name="email" placeholder="Your email.."required>
    
    <label for="phone">Phone Number</label>
    <input type="tel" id="phonenumber" name="phonenumber" placeholder="Your number..">

    <label for="subject">Subject</label>
    <textarea id="subject" name="subject" placeholder="Write something.." style="height:80px"></textarea>

    <input type="submit" value="Contact us">

  </form>
</div>
        <jsp:include page="includes/footer.jsp"/>
    </body>
</html>
