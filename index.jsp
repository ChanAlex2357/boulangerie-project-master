<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" href="assets/css/login/linearicons.css">
        <link rel="stylesheet" href="assets/css/login/owl.carousel.css">
        <link rel="stylesheet" href="assets/css/login/themify-icons.css">
        <link rel="stylesheet" href="assets/css/login/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/login/nice-select.css">
        <link rel="stylesheet" href="assets/css/login/nouislider.min.css">
        <link rel="stylesheet" href="assets/css/login/main.css">
        <link rel="stylesheet" href="assets/css/login/bootstrap.css">

        <title>Login</title>
    </head>
    <body>
        <div class="wrapper">
            <!--================Login Box Area =================-->
            <section class="login_box_area section_gap">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="login_box_img">
                                <img  src="assets/img/ecommerce1.png" alt="">
                            </div>
                        </div>
                        <div class=" offset-1 col-lg-5">
                            <div class="login_form_inner">
                                <h3>Log in</h3>
                                <form class="row login_form" action="/CrudVacance/Login" method="POST" id="contactForm" novalidate="novalidate">
                                    <div class="col-md-12 form-group">
                                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Entrez votre pseudo" required>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <input type="password" class="form-control" id="motdepasse" name="motdepasse" placeholder="Entrez votre Mot de passe" required>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <button type="submit" value="submit" class="primary-btn">CONFIRMER</button>
                                    </div>
                                </form>
                                <div class="container mt-1 login_form">
                                    <div class="row ">
                                        <div class=" col-md-6 form-group">
                                            <a href="/CrudVacance/inscription.jsp" style="color:white;"> <button type="submit" value="submit" class="primary-btn"> INSCRIPTION </button> </a>
                                        </div>
                                        <div class=" col-md-6 form-group">
                                            <a href="/CrudVacance/inscription.jsp"  style="color:white;"> <button type="submit" value="submit" class="primary-btn"> VISITER </button>  </a>
                                        </div>
                                    </div>
                                </div>

                                <%
                                    String error = (String)request.getAttribute("error");
                                    if (error != null) {
                                        out.print("<h6 style=\"color:red;\">"+error+" </h6>");
                                    }
                                    
                                    String message = (String)request.getParameter("message");
                                    if(message != null){
                                        out.print("<h6 style=\"color:green;\">"+error+" </h6>");
                                    }
                                %>


                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div> <!-- .wrapper -->

        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.min.js"></script>
    </body>
</html>