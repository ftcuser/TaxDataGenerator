<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
	<style>
		.header-desktop2 {
		    height: 75px;
		    background: #00477f;
		    position: fixed;
		    z-index: 1001;
		    top: 0;
		    right: 0;
		    left: 0px;
		}
	</style>
</head>

<body class="">
    <div class="page-wrapper">
        <!-- PAGE CONTAINER-->
            <!-- HEADER DESKTOP-->
            <header class="header-desktop2">
                <div class="section__content">
                    <div class="container-fluid">
                        <div class="header-wrap2">                         
                            <div>  
                            <img src="resources/images/irs_logo_3.png" alt="IRS" /> &nbsp;&nbsp;                         
								<span style="font-size:30px;color:white">Individual Tax Return Data Generator</span> 
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
                                            <li class="list-inline-item">Generated Data</li>
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
                            <div class="col-xl-12">
                                <!-- RECENT REPORT 2-->
                                <div class="recent-report2">
                                    <h3 class="title-3">Tax Year ${taxYear}</h3>
                                    <a class="btn btn-primary float-right" href="/download">Download Sample Data</a>
                                    <hr/>
                                    <div class="">                                      
                                        <div class="chart-info-right">
                                	        <div>									         									            
									            <table id="dataList" style="width:100%;font-size:0.75em;"  class="table table-stripped">
									            <thead>
									            	<tr>
									            		<th>Name</th>
									            		<th>SSN</th>
									            		<th>Filling Status</th>
									            		<th>Spouse Name</th>
									            		<th>Spouse SSN</th>
									            		<th>Address</th>
									            		<th>Dependents</th>
									            		<th>Gross Income</th>
									            		<th>Taxable Income</th>
									            		<th>Total Tax</th>
									            		<th>Total Payments</th>
									            		<th></th>
									            	</tr>
									            	</thead>
									            	<tbody>
									            	<c:forEach var="form" items="${forms}" varStatus="loop">
 									            	<tr>
									            		<td>${form.firstName} ${form.lastName}</td>
									            		<td>${form.ssn}</td>
									            		<td>${form.fillingStatus}</td>
									            		<td>${form.spouseFirstName} ${form.spouseLastname}</td>	
									            		<td>${form.spouseSsn}</td>	
									            		<td>${form.homeAddress}, 
									            			<br>${form.homeCity} ${form.homeState} ${form.homeZipCode}</td>
									            		<td>${fn:length(form.dependents)}</td>
									            		<td>${form.income.adjustGrossIncome_8b} </td>		
									            		<td>${form.income.taxableIncome} </td>		
									            		<td>${form.payment.totalTax_16} </td>	
									            		<td>${form.payment.totalPayments_19} </td>	
									            		<td><a href="#" onclick='showDetails(${loop.index});'><i class="fa fa-search"></i></td>							            		
									            	</tr>
									            	</c:forEach>
									           		 </tbody>
									            </table>									   				
									        </div>
                                           
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

    
    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>    
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <!-- Main JS-->
	<script>
		$("#dataList").DataTable();
		function showDetails(index){
			window.open("/showDetails?index=" + index) ;
		}
	</script>
</body>

</html>
<!-- end document-->
