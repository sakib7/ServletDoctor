<%-- 
    Document   : history
    Created on : Apr 10, 2019, 10:39:07 PM
    Author     : sakib
--%>

<%@page import="java.util.List"%>
<%@page import="model.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Appointment> appointmentList = (List<Appointment>) request.getAttribute("appointmentList");
%>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Doctor Login</title>

        <!-- css -->
        <link href="/Medical/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="/Medical/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="/Medical/static/plugins/cubeportfolio/css/cubeportfolio.min.css" rel="stylesheet" type="text/css" >
        <link href="/Medical/static/css/nivo-lightbox.css" rel="stylesheet" />
        <link href="/Medical/static/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
        <link href="/Medical/static/css/owl.carousel.css" rel="stylesheet" media="screen" />
        <link href="/Medical/static/css/owl.theme.css" rel="stylesheet" media="screen" />
        <link href="/Medical/static/css/animate.css" rel="stylesheet" />
        <link href="/Medical/static/css/style.css" rel="stylesheet">

        <!-- boxed bg -->
        <link id="bodybg" href="/Medical/static/bodybg/bg1.css" rel="stylesheet" type="text/css" />
        <!-- template skin -->
        <link id="t-colors" href="/Medical/static/color/default.css" rel="stylesheet">

        <!-- =======================================================
          Theme Name: Medicio
          Theme URL: https://bootstrapmade.com/medicio-free-bootstrap-theme/
          Author: BootstrapMade
          Author URL: https://bootstrapmade.com
        ======================================================= -->
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-custom">

        <div id="wrapper">

            <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">

                <div class="container navigation">

                    <div class="navbar-header page-scroll">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.html">
                            <img src="/Medical/static/img/logo.png" alt="" width="150" height="40" />
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <ul class="nav navbar-nav">
                            <li ><a href="/Medical">Home</a></li>
                            <li ><a href="doctor-profile">Doctor Area</a></li>
                            <li class="active"><a href="appointment-view">View Appointments</a></li>
                            <li><a href="logout">Logout</a></li>

                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>



            <div class="well" style="margin-top: 100px;">
                <table class="table table-striped table-bordered " style="color: black; ">
                <thead>
                    <tr>
                        <th>Visiting Date</th>
                        <th>Serial</th>
                        <th>Patient's Name</th>
                        <th>Patient's Number</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < appointmentList.size(); i++) {
                            Appointment appointment = appointmentList.get(i);
                    %>
                    <tr>
                        <td><%= appointment.getVisitingDate()%> </td>
                        <td><%= appointment.getSerial()%> </td>
                        <td><%= appointment.getName()%> </td>
                        <td><%= appointment.getContactNumber()%> </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            </div>

            <!-- /Section: intro -->
            <section>
                <div>
                    <div>
                        <ul>
                            <li class="cbp-item cardiologist">
                                <a href="doctors/member3.html" class="cbp-caption cbp-singlePage">
                                    <div class="cbp-caption-defaultWrap">
                                        <img src="/Medical/static/img/team/3.jpg" alt="" width="100%">
                                    </div>
                                    <div class="cbp-caption-activeWrap">
                                        <div class="cbp-l-caption-alignCenter">
                                            <div class="cbp-l-caption-body">
                                                <div class="cbp-l-caption-text">VIEW PROFILE</div>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <a href="doctors/member3.html" class="cbp-singlePage cbp-l-grid-team-name">Alison Davis</a>
                                <div class="cbp-l-grid-team-position">Cardiologist</div>
                            </li>
                            <li class="cbp-item neurologist">
                                <a href="doctors/member4.html" class="cbp-caption cbp-singlePage">
                                    <div class="cbp-caption-defaultWrap">
                                        <img src="/Medical/static/img/team/4.jpg" alt="" width="100%">
                                    </div>
                                    <div class="cbp-caption-activeWrap">
                                        <div class="cbp-l-caption-alignCenter">
                                            <div class="cbp-l-caption-body">
                                                <div class="cbp-l-caption-text">VIEW PROFILE</div>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <a href="doctors/member4.html" class="cbp-singlePage cbp-l-grid-team-name">Adam Taylor</a>
                                <div class="cbp-l-grid-team-position">Neurologist</div>
                            </li>

                        </ul>
                    </div>
                </div>

            </section>
            <!-- Section: boxes -->
            <!-- /Section: boxes -->


            <section id="callaction" class="home-section paddingtop-40">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="callaction bg-gray">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="wow fadeInUp" data-wow-delay="0.1s">
                                            <div class="cta-text">
                                                <h3>In an emergency? Need help now?</h3>
                                                <p>Book an appointment by following easy steps </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="wow lightSpeedIn" data-wow-delay="0.1s">
                                            <div class="cta-btn">
                                                <a href="#" class="btn btn-skin btn-lg">Book an appoinment</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- /Section: team -->

            <!-- /Section: testimonial -->


            <section id="partner" class="home-section paddingbot-60">
                <div class="container marginbot-50">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="wow lightSpeedIn" data-wow-delay="0.1s">
                                <div class="section-heading text-center">
                                    <h2 class="h-bold">Our partner</h2>
                                    <p>Take charge of your health today with our specially designed health packages</p>
                                </div>
                            </div>
                            <div class="divider-short"></div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-3">
                            <div class="partner">
                                <a href="#"><img src="/Medical/static/img/dummy/partner-1.jpg" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="partner">
                                <a href="#"><img src="/Medical/static/img/dummy/partner-2.jpg" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="partner">
                                <a href="#"><img src="/Medical/static/img/dummy/partner-3.jpg" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="partner">
                                <a href="#"><img src="/Medical/static/img/dummy/partner-4.jpg" alt="" /></a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <footer>

                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>About Melitus Detecor</h5>
                                    <p>
                                        Melitus Detector is a Servlet based software which can perform several operations
                                    </p>
                                </div>
                            </div>
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Information</h5>
                                    <ul>
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Appointment</a></li>
                                        <li><a href="#">Profile</a></li>
                                        <li><a href="#">Report</a></li>
                                        <li><a href="#">Terms & conditions</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Melitus Detector</h5>
                                    <p>
                                        Network Programming Lab | CSE 4226
                                        <br/><b>Ms. Raqeebir Rab</b><br/>
                                        <b>Mazharul Islam</b>
                                    </p>
                                    <ul>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-calendar-o fa-stack-1x fa-inverse"></i>
                                            </span> Monday - Saturday, 8am to 10pm
                                        </li>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-phone fa-stack-1x fa-inverse"></i>
                                            </span> +88 01521 220 462
                                        </li>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
                                            </span> sakib6900@gmail.com 
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Our location</h5>
                                    Ahsanullah University of Science and Technology         	
                                    141 & 142, Love Road,<br/>
                                    Tejgaon Industrial Area, Dhaka-1208	 <br/>
                                    BANGLADESH

                                </div>
                            </div>
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Follow us</h5>
                                    <ul class="company-social">
                                        <li class="social-facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li class="social-twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li class="social-google"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                        <li class="social-vimeo"><a href="#"><i class="fa fa-vimeo-square"></i></a></li>
                                        <li class="social-dribble"><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sub-footer">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6 col-lg-6">
                                <div class="wow fadeInLeft" data-wow-delay="0.1s">
                                    <div class="text-left">
                                        <p>&copy;Copyright - Melitus Dtector. All rights reserved.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-6">
                                <div class="wow fadeInRight" data-wow-delay="0.1s">
                                    <div class="text-right">
                                        <div class="credits">
                                            <!--
                                              All the links in the footer should remain intact. 
                                              You can delete the links only if you purchased the pro version.
                                              Licensing information: https://bootstrapmade.com/license/
                                              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Medicio
                                            -->
                                            Designed by <a href="https://bootstrapmade.com/">TSS</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

        </div>
        <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

        <!-- Core JavaScript Files -->
        <script src="/Medical/static/js/jquery.min.js"></script>
        <script src="/Medical/static/js/bootstrap.min.js"></script>
        <script src="/Medical/static/js/jquery.easing.min.js"></script>
        <script src="/Medical/static/js/wow.min.js"></script>
        <script src="/Medical/static/js/jquery.scrollTo.js"></script>
        <script src="/Medical/static/js/jquery.appear.js"></script>
        <script src="/Medical/static/js/stellar.js"></script>
        <script src="/Medical/static/plugins/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script src="/Medical/static/js/owl.carousel.min.js"></script>
        <script src="/Medical/static/js/nivo-lightbox.min.js"></script>
        <script src="/Medical/static/js/custom.js"></script>

    </body>

</html>
