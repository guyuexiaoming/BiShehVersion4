<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/8
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Ventura - Vector Maps</title>
		
		<!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">
		
		<!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
        <link rel="stylesheet" href="../assets/css/font-awesome.min.css">
		
		<!-- Feathericon CSS -->
        <link rel="stylesheet" href="../assets/css/feathericon.min.css">
		
        <link rel="stylesheet" href="../assets/plugins/jvectormap/jquery-jvectormap-2.0.3.css">
		
		<!-- Main CSS -->
        <link rel="stylesheet" href="../assets/css/style.css">
		
		<!--[if lt IE 9]>
			<script src="../assets/js/html5shiv.min.js"></script>
			<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
    </head>
    <body>
	
		<!-- Main Wrapper -->
        <div class="main-wrapper">
		
			<!-- Header -->
            <div class="header">
			
				<!-- Logo -->
                <div class="header-left">
                    <a href="${pageContext.request.contextPath }/pages/index.jsp" class="logo">
						<img src="../assets/img/logo.png" alt="Logo">
					</a>
					<a href="${pageContext.request.contextPath }/pages/index.jsp" class="logo logo-small">
						<img src="../assets/img/logo-small.png" alt="Logo" width="30" height="30">
					</a>
                </div>
				<!-- /Logo -->
				
				<a href="javascript:void(0);" id="toggle_btn">
					<i class="fe fe-text-align-left"></i>
				</a>
				
				<div class="top-nav-search">
					<form>
						<input type="text" class="form-control" placeholder="Search here">
						<button class="btn" type="submit"><i class="fa fa-search"></i></button>
					</form>
				</div>
				
				<!-- Mobile Menu Toggle -->
				<a class="mobile_btn" id="mobile_btn">
					<i class="fa fa-bars"></i>
				</a>
				<!-- /Mobile Menu Toggle -->
				
				<!-- Header Right Menu -->
				<ul class="nav user-menu">

					<!-- App Lists -->
					<li class="nav-item dropdown app-dropdown">
						<a class="nav-link dropdown-toggle" aria-expanded="false" role="button" data-toggle="dropdown" href="#"><i class="fe fe-app-menu"></i></a>
						<ul class="dropdown-menu app-dropdown-menu">
							<li>
								<div class="app-list">
									<div class="row">
										<div class="col"><a class="app-item" href="${pageContext.request.contextPath }/pages/inbox.jsp"><i class="fa fa-envelope"></i><span>Email</span></a></div>
										<div class="col"><a class="app-item" href="${pageContext.request.contextPath }/pages/calendar.jsp"><i class="fa fa-calendar"></i><span>Calendar</span></a></div>
										<div class="col"><a class="app-item" href="${pageContext.request.contextPath }/pages/chat.jsp"><i class="fa fa-comments"></i><span>Chat</span></a></div>
									</div>
								</div>
							</li>
						</ul>
					</li>
					<!-- /App Lists -->
					
					<!-- Notifications -->
					<li class="nav-item dropdown noti-dropdown">
						<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
							<i class="fe fe-bell"></i> <span class="badge badge-pill">3</span>
						</a>
						<div class="dropdown-menu notifications">
							<div class="topnav-dropdown-header">
								<span class="notification-title">Notifications</span>
								<a href="javascript:void(0)" class="clear-noti"> Clear All </a>
							</div>
							<div class="noti-content">
								<ul class="notification-list">
									<li class="notification-message">
										<a href="#">
											<div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image" src="../assets/img/profiles/avatar-02.jpg">
												</span>
												<div class="media-body">
													<p class="noti-details"><span class="noti-title">Carlson Tech</span> has approved <span class="noti-title">your estimate</span></p>
													<p class="noti-time"><span class="notification-time">4 mins ago</span></p>
												</div>
											</div>
										</a>
									</li>
									<li class="notification-message">
										<a href="#">
											<div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image" src="../assets/img/profiles/avatar-11.jpg">
												</span>
												<div class="media-body">
													<p class="noti-details"><span class="noti-title">International Software Inc</span> has sent you a invoice in the amount of <span class="noti-title">$218</span></p>
													<p class="noti-time"><span class="notification-time">6 mins ago</span></p>
												</div>
											</div>
										</a>
									</li>
									<li class="notification-message">
										<a href="#">
											<div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image" src="../assets/img/profiles/avatar-17.jpg">
												</span>
												<div class="media-body">
												<p class="noti-details"><span class="noti-title">John Hendry</span> sent a cancellation request <span class="noti-title">Apple iPhone XR</span></p>
												<p class="noti-time"><span class="notification-time">8 mins ago</span></p>
												</div>
											</div>
										</a>
									</li>
									<li class="notification-message">
										<a href="#">
											<div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image" src="../assets/img/profiles/avatar-13.jpg">
												</span>
												<div class="media-body">
													<p class="noti-details"><span class="noti-title">Mercury Software Inc</span> added a new product <span class="noti-title">Apple MacBook Pro</span></p>
													<p class="noti-time"><span class="notification-time">12 mins ago</span></p>
												</div>
											</div>
										</a>
									</li>
								</ul>
							</div>
							<div class="topnav-dropdown-footer">
								<a href="#">View all Notifications</a>
							</div>
						</div>
					</li>
					<!-- /Notifications -->
					
					<!-- User Menu -->
					<li class="nav-item dropdown has-arrow">
						<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
							<span class="user-img"><img class="rounded-circle" src="../assets/img/profiles/avatar-01.jpg" width="31" alt="Ryan Taylor"></span>
						</a>
						<div class="dropdown-menu">
							<div class="user-header">
								<div class="avatar avatar-sm">
									<img src="../assets/img/profiles/avatar-01.jpg" alt="User Image" class="avatar-img rounded-circle">
								</div>
								<div class="user-text">
									<h6>Ryan Taylor</h6>
									<p class="text-muted mb-0">Administrator</p>
								</div>
							</div>
							<a class="dropdown-item" href="${pageContext.request.contextPath }/pages/profile.jsp">My Profile</a>
							<a class="dropdown-item" href="${pageContext.request.contextPath }/pages/profile.jsp">Account Settings</a>
							<a class="dropdown-item" href="login.jsp">Logout</a>
						</div>
					</li>
					<!-- /User Menu -->
					
				</ul>
				<!-- /Header Right Menu -->
				
            </div>
			<!-- /Header -->
			
			<!-- Sidebar -->
            <div class="sidebar" id="sidebar">
                <div class="sidebar-inner slimscroll">
					<div id="sidebar-menu" class="sidebar-menu">
						<ul>
							<li class="menu-title"> 
								<span>Main</span>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath }/pages/index.jsp"><i class="fe fe-home"></i> <span>Dashboard</span></a>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-cart"></i> <span> Ecommerce</span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="${pageContext.request.contextPath }/pages/products.jsp">Products</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/product-details.jsp">Product View</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/orders.jsp">Orders</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/customers.jsp">Customers</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/invoice.jsp">Invoice</a></li>
								</ul>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-tiled"></i> <span> Application</span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="${pageContext.request.contextPath }/pages/chat.jsp">Chat</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/calendar.jsp">Calendar</a></li>
									<li><a href="${pageContext.request.contextPath }/pages/inbox.jsp">Email</a></li>
								</ul>
							</li>
							<li class="menu-title"> 
								<span>Pages</span>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath }/pages/profile.jsp"><i class="fe fe-user-plus"></i> <span>Profile</span></a>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-document"></i> <span> Authentication </span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="login.jsp"> Login </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/register.jsp"> Register </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/forgot-password.jsp"> Forgot Password </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/lock-screen.jsp"> Lock Screen </a></li>
								</ul>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-warning"></i> <span> Error Pages </span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="${pageContext.request.contextPath }/pages/error-404.jsp">404 Error </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/error-500.jsp">500 Error </a></li>
								</ul>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath }/pages/users.jsp"><i class="fe fe-users"></i> <span>Users</span></a>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath }/pages/blank-page.jsp"><i class="fe fe-file"></i> <span>Blank Page</span></a>
							</li>
							<li class="active"> 
								<a href="${pageContext.request.contextPath }/pages/maps-vector.jsp"><i class="fe fe-map"></i> <span>Vector Maps</span></a>
							</li>
							<li class="menu-title"> 
								<span>UI Interface</span>
							</li>
							<li> 
								<a href="${pageContext.request.contextPath }/pages/components.jsp"><i class="fe fe-vector"></i> <span>Components</span></a>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-layout"></i> <span> Forms </span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="${pageContext.request.contextPath }/pages/form-basic-inputs.jsp">Basic Inputs </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/form-input-groups.jsp">Input Groups </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/form-horizontal.jsp">Horizontal Form </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/form-vertical.jsp"> Vertical Form </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/form-mask.jsp"> Form Mask </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/form-validation.jsp"> Form Validation </a></li>
								</ul>
							</li>
							<li class="submenu">
								<a href="#"><i class="fe fe-table"></i> <span> Tables </span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li><a href="${pageContext.request.contextPath }/pages/tables-basic.jsp">Basic Tables </a></li>
									<li><a href="${pageContext.request.contextPath }/pages/data-tables.jsp">Data Table </a></li>
								</ul>
							</li>
							<li class="submenu">
								<a href="javascript:void(0);"><i class="fe fe-code"></i> <span>Multi Level</span> <span class="menu-arrow"></span></a>
								<ul style="display: none;">
									<li class="submenu">
										<a href="javascript:void(0);"> <span>Level 1</span> <span class="menu-arrow"></span></a>
										<ul style="display: none;">
											<li><a href="javascript:void(0);"><span>Level 2</span></a></li>
											<li class="submenu">
												<a href="javascript:void(0);"> <span> Level 2</span> <span class="menu-arrow"></span></a>
												<ul style="display: none;">
													<li><a href="javascript:void(0);">Level 3</a></li>
													<li><a href="javascript:void(0);">Level 3</a></li>
												</ul>
											</li>
											<li><a href="javascript:void(0);"> <span>Level 2</span></a></li>
										</ul>
									</li>
									<li>
										<a href="javascript:void(0);"> <span>Level 1</span></a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
                </div>
            </div>
			<!-- /Sidebar -->
			
			<!-- Page Wrapper -->
            <div class="page-wrapper">
                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
						<div class="row">
							<div class="col-sm-12">
								<h3 class="page-title">Vector Maps</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/pages/index.jsp">Dashboard</a></li>
									<li class="breadcrumb-item active">Vector Maps</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /Page Header -->
					
					<!-- World Map -->
					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">World Map</h4>
								</div>
								<div class="card-body">
									<div id="world_map" style="height: 400px"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- /World Map -->
					
					<div class="row">
						<div class="col-lg-6">
						
							<!-- USA Map -->
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">USA Map</h4>
								</div>
								<div class="card-body">
									<div id="usa" style="height: 400px"></div>
								</div>
							</div>
							<!-- /USA Map -->
							
						</div>
	
						<div class="col-lg-6">
						
							<!-- UK Map -->
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">UK Map</h4>
								</div>
								<div class="card-body">
									<div id="uk" style="height: 400px"></div>
	
								</div>
							</div>
							<!-- /UK Map -->
							
						</div>
					</div>
	
	
					<div class="row">
						<div class="col-lg-6">
						
							<!-- India Map -->
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">India Map</h4>
								</div>
								<div class="card-body">
									<div id="india" style="height: 400px"></div>
	
								</div>
							</div>
							<!-- /India Map -->
							
						</div>
	
						<div class="col-lg-6">
						
							<!-- Russia Map -->
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Russia Map</h4>
								</div>
								<div class="card-body">
									<div id="russia" style="height: 400px"></div>
								</div>
							</div>
							<!-- /Russia Map -->
							
						</div>
					</div>
					
				</div>			
			</div>
			<!-- /Page Wrapper -->
		
        </div>
		<!-- /Main Wrapper -->
		
		<!-- jQuery -->
        <script src="../assets/js/jquery-3.2.1.min.js"></script>
		
		<!-- Bootstrap Core JS -->
        <script src="../assets/js/popper.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
		
		<!-- Slimscroll JS -->
        <script src="../assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-2.0.3.min.js"></script>
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-world-mill.js"></script>
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-ru-mill.js"></script>
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-us-aea.js"></script>
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-uk_countries-mill.js"></script>
        <script src="../assets/plugins/jvectormap/jquery-jvectormap-in-mill.js"></script>
        <script src="../assets/js/jvectormap.js"></script>
		
		<!-- Custom JS -->
		<script  src="../assets/js/script.js"></script>
		
    </body>
</html>