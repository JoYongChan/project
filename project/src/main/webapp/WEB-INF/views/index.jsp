<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Dashboard</title>

<!-- Bootstrap core CSS-->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin.css" rel="stylesheet">

</head>
<body id="page-top">

	<div class="page-header">
		<div id="wrapper">

			<!-- Sidebar -->
			<ul class="sidebar navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i>
						<span>Dashboard</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>Pages</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="pagesDropdown">
						<h6 class="dropdown-header">Login Screens:</h6>
						<a class="dropdown-item" href="login.html">Login</a> <a
							class="dropdown-item" href="register.html">Register</a> <a
							class="dropdown-item" href="forgot-password.html">Forgot
							Password</a>
						<div class="dropdown-divider"></div>
						<h6 class="dropdown-header">Other Pages:</h6>
						<a class="dropdown-item" href="404.html">404 Page</a> <a
							class="dropdown-item" href="blank.html">Blank Page</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="charts.html">
						<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="tables.html">
						<i class="fas fa-fw fa-table"></i> <span>Tables</span>
				</a></li>
			</ul>

			<div id="content-wrapper">

				<div class="container-fluid">

					<!-- Breadcrumbs-->
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
						<li class="breadcrumb-item active">Overview</li>
					</ol>

					<!-- Icon Cards-->
					<div class="row">
						<div class="col-xl-3 col-sm-6 mb-3">
							<div class="card text-white bg-primary o-hidden h-100">
								<div class="card-body">
									<div class="card-body-icon">
										<i class="fas fa-fw fa-comments"></i>
									</div>
									<div class="mr-5">26 New Messages!</div>
								</div>
								<a class="card-footer text-white clearfix small z-1" href="#">
									<span class="float-left">View Details</span> <span
									class="float-right"> <i class="fas fa-angle-right"></i>
								</span>
								</a>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 mb-3">
							<div class="card text-white bg-warning o-hidden h-100">
								<div class="card-body">
									<div class="card-body-icon">
										<i class="fas fa-fw fa-list"></i>
									</div>
									<div class="mr-5">11 New Tasks!</div>
								</div>
								<a class="card-footer text-white clearfix small z-1" href="#">
									<span class="float-left">View Details</span> <span
									class="float-right"> <i class="fas fa-angle-right"></i>
								</span>
								</a>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 mb-3">
							<div class="card text-white bg-success o-hidden h-100">
								<div class="card-body">
									<div class="card-body-icon">
										<i class="fas fa-fw fa-shopping-cart"></i>
									</div>
									<div class="mr-5">123 New Orders!</div>
								</div>
								<a class="card-footer text-white clearfix small z-1" href="#">
									<span class="float-left">View Details</span> <span
									class="float-right"> <i class="fas fa-angle-right"></i>
								</span>
								</a>
							</div>
						</div>
						<div class="col-xl-3 col-sm-6 mb-3">
							<div class="card text-white bg-danger o-hidden h-100">
								<div class="card-body">
									<div class="card-body-icon">
										<i class="fas fa-fw fa-life-ring"></i>
									</div>
									<div class="mr-5">13 New Tickets!</div>
								</div>
								<a class="card-footer text-white clearfix small z-1" href="#">
									<span class="float-left">View Details</span> <span
									class="float-right"> <i class="fas fa-angle-right"></i>
								</span>
								</a>
							</div>
						</div>
					</div>

					<!-- Area Chart Example-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-chart-area"></i> Area Chart Example
						</div>
						<div class="card-body">
							<canvas id="myAreaChart" width="100%" height="30"></canvas>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
				</div>
			</div>
			<!-- Bootstrap core JavaScript-->
			<script src="resources/vendor/jquery/jquery.min.js"></script>
			<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

			<!-- Core plugin JavaScript-->
			<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

			<!-- Page level plugin JavaScript-->
			<script src="resources/vendor/chart.js/Chart.min.js"></script>
			<script src="resources/vendor/datatables/jquery.dataTables.js"></script>
			<script src="resources/vendor/datatables/dataTables.bootstrap4.js"></script>

			<!-- Custom scripts for all pages-->
			<script src="resources/js/sb-admin.min.js"></script>

			<!-- Demo scripts for this page-->
			<script src="resources/js/demo/datatables-demo.js"></script>
			<script src="resources/js/demo/chart-area-demo.js"></script>
</body>
</html>