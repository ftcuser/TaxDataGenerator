<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard 2</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar2">
            <div class="logo">
                <a href="#">
                    <img src="images/fisheries_logo_3.png" alt="NOAA Fisheries" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="images/user-logo-png-5.png" alt="User" />
                    </div>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
					        <form id="logoutForm" method="POST" action="${contextPath}/logout">
					            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					        </form>
					        <h4>${pageContext.request.userPrincipal.name}</h4>
					        <h5><a onclick="document.forms['logoutForm'].submit()">Logout</a></h5>
					 </c:if>
                </div>
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                         <li class="active has-sub">
                            <a class="js-arrow" href="/dashboard">
                                <i class="fas fa-tachometer-alt"></i>Dashboard                              
                            </a>                          
                        </li>
                        <li>
                            <a href="/control">
                              <i class="fas fa-caret-square-right"></i>Manual Control
                            </a>                           
                        </li>           
                        <li>
                            <a href="/settings">
                              <i class="fas fa-gear"></i>Settings
                            </a>                           
                        </li>                    
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container2">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop2">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap2">
                         
                            <div>
                              
								<h3 class="header-text">Catch Share Backend Process Monitor</h3>
 
                            </div>
                        </div>
                    </div>
                </div>
            </header>

            <!-- END HEADER DESKTOP-->

            <!-- BREADCRUMB-->
            <section class="au-breadcrumb m-t-75">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="au-breadcrumb-content">
                                    <div class="au-breadcrumb-left">
                                        <span class="au-breadcrumb-span">You are here:</span>
                                        <ul class="list-unstyled list-inline au-breadcrumb__list">
                                            <li class="list-inline-item active">
                                                <a href="#">Home</a>
                                            </li>
                                            <li class="list-inline-item seprate">
                                                <span>/</span>
                                            </li>
                                            <li class="list-inline-item">Settings</li>
                                        </ul>
                                    </div>                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END BREADCRUMB-->

        
            <section>
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xl-8">
                                <!-- RECENT REPORT 2-->
                                <div class="recent-report2">
                                    <h3 class="title-3">Procedure Run Schedule</h3>
                                    <div class="">                                      
                                        <div class="chart-info-right">
                                                            
                                 		<form method="POST" action="${contextPath}/login" class="form-signin">
                                 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									        <div class="form-group">								         									            
									            <table style="width:100%;cellpadding:10px;" class="table table-stripped">
									            	<tr>
									            		<th>Procedure</th>
									            		<th>Run Schedule</th>
									            		<th>Dependency</th>
									            	</tr>
									            
									            	<tr>
									            		<td>Procedure 1</td>
									            		<td><input name="Procedure 1" type="text" class="form-control" size="20" value="1:30"/></td>
									            		<td><select multiple size="3">
															  <option value="volvo">Procedure 2</option>
															  <option value="saab">Procedure 3</option>
															  <option value="opel">Procedure 4</option>
															  <option value="audi">Procedure 5</option>
															</select>
														</td>
									            	</tr>
									            	<tr>
									            		<td>Procedure 2</td>
									            		<td><input name="Procedure 2" type="text" class="form-control"  value="2:30"/></td>
									            		<td><select multiple size="3">
															  <option value="volvo">Procedure 2</option>
															  <option value="saab">Procedure 3</option>
															  <option value="opel">Procedure 4</option>
															  <option value="audi">Procedure 5</option>
															</select>
														</td>
									            	</tr>
									            	<tr>
									            		<td>Procedure 3</td>
									            		<td><input name="Procedure 3" type="text" class="form-control" value="3:30" /></td>
									            		<td><select multiple size="3">
															  <option value="volvo">Procedure 2</option>
															  <option value="saab">Procedure 3</option>
															  <option value="opel">Procedure 4</option>
															  <option value="audi">Procedure 5</option>
															</select>
														</td>
									            	</tr>
									            		<tr>
									            		<td>Procedure 4</td>
									            		<td><input name="Procedure 4" type="text" class="form-control"  value="13:30"/></td>
									            		<td><select multiple size="3">
															  <option value="volvo">Procedure 2</option>
															  <option value="saab">Procedure 3</option>
															  <option value="opel">Procedure 4</option>
															  <option value="audi">Procedure 5</option>
															</select>
														</td>
									            	</tr>
									            
									            </table>
									   
									            <button class="btn btn-lg btn-primary btn-block" type="submit">Apply</button>
									            
									        </div>
									      </form>
                                           
                                        </div>
                                    </div>
                                   
                                </div>
                                <!-- END RECENT REPORT 2             -->
                            </div>
                            <div class="col-xl-4">
                                <!-- RECENT REPORT 2-->
                                <div class="recent-report2">
                                    <h4 class="title-3">Notify Email Addresses</h4>
                                    <div class="">                                      
                                        <div class="chart-info-right">
                                                               
                                 		<form method="POST" action="${contextPath}/login" class="form-signin">
                                 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									        <div class="form-group">
									         	<textarea cols="20" rows="12">joe.doe@world.com, jihn@test.com</textarea>								            
									        	
									        </div>
									        <button class="btn btn-lg btn-primary btn-block" type="submit">Apply</button>
									      </form>
                                           
                                        </div>
                                    </div>
                                   
                                </div>
                                <!-- END RECENT REPORT 2             -->
                            </div>
                                    
                        </div>
                    </div>
                </div>
            </section>


   

            <section>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>
    <script src="vendor/vector-map/jquery.vmap.js"></script>
    <script src="vendor/vector-map/jquery.vmap.min.js"></script>
    <script src="vendor/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="vendor/vector-map/jquery.vmap.world.js"></script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
