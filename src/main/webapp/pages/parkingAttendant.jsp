<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/12
  Time: 8:25
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
        function deleteById(id,username) {
            alert("id"+id);
            window.location.href="${pageContext.request.contextPath }/p/toDeleteP?id="+id+"&username="+username;
        }
        function editP(id,username) {
            alert("id"+id);
            window.location.href="${pageContext.request.contextPath }/p/toUpdateP.action?id="+id+"&username="+username;
        }
        function addP(username) {
            window.location.href="${pageContext.request.contextPath }/p/toAddP.action?username="+username;

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



        <!-- Mobile Menu Toggle -->
        <a class="mobile_btn" id="mobile_btn">
            <i class="fa fa-bars"></i>
        </a>
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
                    <a class="dropdown-item" href="login.jsp">安全退出</a>
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
                        <span>主要功能</span>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath }/man/toIndex.action?username=${manager.username}"><i class="fe fe-home"></i> <span>数据分析大厅</span></a>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fe fe-cart"></i> <span> 数据管理</span> <span class="menu-arrow"></span></a>
                        <ul style="display: none;">
                            <li><a href="${pageContext.request.contextPath }/pages/products.jsp">产品</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/product-details.jsp">产品视图</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/orders.jsp">订单管理</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/customers.jsp">顾客</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/invoice.jsp">Invoice</a></li>
                        </ul>
                    </li>

                    <li class="menu-title">
                        <span>主要管理功能</span>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/pages/profile.jsp"><i class="fe fe-user-plus"></i> <span>个人信息详情</span></a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/order/toListOrders?username=${manager.username}"><i class="fe fe-users"></i> <span>订单管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/p/toListP?username=${manager.username}"><i class="fe fe-users"></i> <span>停车场管理员管理</span></a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/user/toListUser?username=${manager.username}"><i class="fe fe-users"></i> <span>用户管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/announ/toListAnnoun?username=${manager.username}"><i class="fe fe-users"></i> <span>公告管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/repair/toListRepair?username=${manager.username}"><i class="fe fe-users"></i> <span>维修审批与管理</span></a>
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
                            <li><a href="data-tables.jsp">Data Table </a></li>
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

            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col">
                        <h3 class="page-title">停车场管理员管理</h3>
                        <th><button class="btn btn-sm bg-success-light mr-2" id="edit_Account_btn1" onclick = "addP('${manager.username}')"><i class="fe fe-pencil"></i>添加停车场管理员</button></th>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/man/toIndex.action?username=${manager.username}">回到主页</a></li>
                            <li class="breadcrumb-item active">停车场管理员列表</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">

                    <div class="card card-table">
                        <div class="card-header">
                            <h4 class="card-title">List of ParkingAttendant</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover table-center mb-0">
                                    <thead>
                                    <tr>
                                        <th>停车场管理员账号名</th>
                                        <th>停车场管理员密码</th>
                                        <th>停车场管理员手机号</th>


                                        <th class="text-right">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    <c:forEach items="${pList}" var="p" varStatus="status">

                                        <ul>

                                            <tr>

                                                <th>${p.PName }</th>
                                                <th>${p.PPassword }</th>
                                                <th>${p.PPhone }</th>
                                                <th><button class="btn btn-sm bg-danger-light" onclick = "deleteById('${p.PId}','${manager.username}')"><i class="fe fe-trash"></i>删除</button></th>
                                                <th><button class="btn btn-sm bg-success-light mr-2" id="edit_Account_btn" onclick = "editP('${p.PId}','${manager.username}')"><i class="fe fe-pencil"></i>编辑</button></th>
                                            </tr>

                                        </ul>

                                    </c:forEach>
                                    <ul>
                                        <th>
                                            <a href="${pageContext.request.contextPath }/p/toListP?pn=1&username=${manager.username}">1</a>
                                        </th>
                                        <th>
                                            <a href="${pageContext.request.contextPath }/p/toListP?pn=2&username=${manager.username}">2</a>
                                        </th>

                                        <!-- <li>3<>
                                        <li>4<> -->
                                        <th>
                                            …
                                        </th>
                                        <th>
                                            <a href="${pageContext.request.contextPath }/p/toListP?pn=${orders1.pageNum-1}&username=${manager.username}">上一页</a>
                                        </th>
                                        <th>
                                            <a href="${pageContext.request.contextPath }/p/toListP?pn=${pages.pages}&username=${manager.username}">尾页</a>
                                        </th>
                                        <th>
                                            <a href="${pageContext.request.contextPath }/p/toListP?pn=${pages.pageNum+1}&username=${manager.username}">下一页</a>
                                        </th>


                                    </ul>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

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

<!-- Custom JS -->
<script src="../assets/js/script.js"></script>
</body>
</html>