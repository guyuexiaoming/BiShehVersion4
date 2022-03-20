<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/12
  Time: 11:19
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
    <title>Ventura - Users</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css">

    <!-- Feathericon CSS -->
    <link rel="stylesheet" href="../assets/css/feathericon.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="../assets/css/style.css">

    <!--[if lt IE 9]>
    <script src="../assets/js/html5shiv.min.js"></script>
    <script src="../assets/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function deleteById(id) {
            alert("id"+id);
            window.location.href="${pageContext.request.contextPath }/user/deleteUserById?id="+id;
        }
        function editUser(id) {
            alert("id"+id);
            window.location.href="${pageContext.request.contextPath }/user/edict?id="+id;
        }
        function togo(username) {
            window.location.href="${pageContext.request.contextPath }/p/toListP?username="+username;

        }
    </script>
</head>
<body>

<!-- Main Wrapper -->
<div class="main-wrapper">

    <!-- Header -->
    <div class="header">

        <!-- Logo -->
        <div class="header-left">
            <a href="${pageContext.request.contextPath }/man/toIndex.action?username=${manager.username}" class="logo">
                <img src="../assets/img/logo.png" alt="Logo">
            </a>
            <a href="${pageContext.request.contextPath }/man/toIndex.action?username=${manager.username}" class="logo logo-small">
                <img src="../assets/img/logo-small.png" alt="Logo" width="30" height="30">
            </a>
        </div>
        <!-- /Logo -->




        <!-- /Mobile Menu Toggle -->

        <!-- Header Right Menu -->
        <ul class="nav user-menu">

            <!-- App Lists -->

            <!-- /App Lists -->

            <!-- Notifications -->

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
                            <h6>${manager.username}</h6>
                            <p class="text-muted mb-0">Administrator</p>
                        </div>
                    </div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath }/pages/profile.jsp">个人信息</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath }/pages/profile.jsp">账户设置</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath }/pages/login.jsp">安全退出</a>
                </div>
            </li>
            <!-- /User Menu -->

        </ul>
        <!-- /Header Right Menu -->

    </div>
    <!-- /Header -->

    <!-- Sidebar -->

    <!-- /Sidebar -->

    <!-- Main Wrapper -->
    <div class="main-wrapper login-body">
        <div class="login-wrapper">
            <div class="container">



                <!-- Form -->
                <form action="${pageContext.request.contextPath }/p/toUpdateP?id=${id}&user_name=${manager.username}" method="post">
                    <br><center><th>&#32; </th></center>
                    <br><center><th>&#32; </th></center>
                    <br><center><th> &#32;</th></center>
                    <center><th>管理员姓名</th></center>
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="username"name="username">
                    </div>
                    <center><th>管理员密码</th></center>
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="password"name="password">
                    </div>
                    <center><th>管理员手机号</th></center>
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="phone"name="phone">
                    </div>



                    <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit">确认修改</button>
                        <button class="btn btn-primary btn-block" type="button" onclick="togo('${manager.username}')" >返回上一页</button>

                    </div>

                </form>
                <!-- /Form -->


                <!-- Social Login -->
                <!--<div class="social-login">
                    <span>Login with</span>
                    <a href="#" class="facebook"><i class="fa fa-facebook"></i></a><a href="#" class="google"><i class="fa fa-google"></i></a>
                </div>-->
                <!-- /Social Login -->





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

<!-- Custom JS -->
<script src="../assets/js/script.js"></script>
</body>
</html>

