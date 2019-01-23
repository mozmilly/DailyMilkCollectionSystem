<%-- 
    Document   : welcome
    Created on : Jan 23, 2019, 11:42:12 AM
    Author     : AMO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
        <title>DAIRY MILK </title>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/footer.jsp"/>
        <link href="css/style.css" rel="stylesheet">
  </head>

    <body>
        <div class="green darken-3 topnav ">
            <a class="active" href="#home">Home</a>
            <a href="#about">About</a>
            <a href="#contact">Contact</a>
            <a href="#contact">Tenders</a>
            <div class="login-container">
                <form action="/action_page.php">
                    <input type="text" placeholder="Username" name="username" required >
                    <input type="password" placeholder="Password" name="psw" required >
                    <button type="submit">Login</button>
                </form>
                <a href="" class="forgotpass">forgot password </a>
                </div>
        </div>
        <div>
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="./img/img1.jpg" height=600px>
</div>
            </div>


        </div>

    </body>
</html>
