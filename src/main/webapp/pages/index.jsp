<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/8
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>“帕克”--智能停车场管理系统--大厅</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css">

    <!-- Feathericon CSS -->
    <link rel="stylesheet" href="../assets/css/feathericon.min.css">

    <link rel="stylesheet" href="../assets/plugins/morris/morris.css">


    <!-- Main CSS -->
    <link rel="stylesheet" href="../assets/css/style.css">


    <!--[if lt IE 9]>
    <script src="../assets/js/html5shiv.min.js"></script>
    <script src="../assets/js/respond.min.js"></script>

    <![endif]-->
    <!--试图数据分析动态js-->
    <script src="../assets/js/echarts.min.js"></script>
    <script src="../assets/js/jquery-3.6.0.js"></script>



</head>
<body>

<!-- Main Wrapper -->
<div class="main-wrapper">

    <!-- Header -->
    <div class="header">

        <!-- Logo -->
        <div class="header-left">
            <a href="${pageContext.request.contextPath }/pages/index.jsp?username=${manager.username}" class="logo">
                <img src="../assets/img/logo.png" alt="Logo">
            </a>
            <a href="${pageContext.request.contextPath }/pages/index.jsp?username=${manager.username}"
               class="logo logo-small">
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
            <!--<li class="nav-item dropdown app-dropdown">
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
            -->
            <!-- /App Lists -->

            <!-- Notifications -->
            <li class="nav-item dropdown noti-dropdown">
                <!--<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                    <i class="fe fe-bell"></i> <span class="badge badge-pill">3</span>
                </a>
                -->
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
													<img class="avatar-img rounded-circle" alt="User Image"
                                                         src="../assets/img/profiles/avatar-02.jpg">
												</span>
                                        <div class="media-body">
                                            <p class="noti-details"><span class="noti-title">Carlson Tech</span> has
                                                approved <span class="noti-title">your estimate</span></p>
                                            <p class="noti-time"><span class="notification-time">4 mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="#">
                                    <div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image"
                                                         src="../assets/img/profiles/avatar-11.jpg">
												</span>
                                        <div class="media-body">
                                            <p class="noti-details"><span
                                                    class="noti-title">International Software Inc</span> has sent you a
                                                invoice in the amount of <span class="noti-title">$218</span></p>
                                            <p class="noti-time"><span class="notification-time">6 mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="#">
                                    <div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image"
                                                         src="../assets/img/profiles/avatar-17.jpg">
												</span>
                                        <div class="media-body">
                                            <p class="noti-details"><span class="noti-title">John Hendry</span> sent a
                                                cancellation request <span class="noti-title">Apple iPhone XR</span></p>
                                            <p class="noti-time"><span class="notification-time">8 mins ago</span></p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="notification-message">
                                <a href="#">
                                    <div class="media">
												<span class="avatar avatar-sm">
													<img class="avatar-img rounded-circle" alt="User Image"
                                                         src="../assets/img/profiles/avatar-13.jpg">
												</span>
                                        <div class="media-body">
                                            <p class="noti-details"><span class="noti-title">Mercury Software Inc</span>
                                                added a new product <span class="noti-title">Apple MacBook Pro</span>
                                            </p>
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
                    <span class="user-img"><img class="rounded-circle" src="../assets/img/profiles/avatar-01.jpg"
                                                width="31" alt="Ryan Taylor"></span>
                </a>
                <div class="dropdown-menu">
                    <div class="user-header">
                        <div class="avatar avatar-sm">
                            <img src="../assets/img/profiles/avatar-01.jpg" alt="User Image"
                                 class="avatar-img rounded-circle">
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
    <div class="sidebar" id="sidebar">
        <div class="sidebar-inner slimscroll">
            <div id="sidebar-menu" class="sidebar-menu">
                <ul>
                    <li class="menu-title">
                        <span>主要功能</span>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath }/man/toIndex.action?username=${manager.username}"><i
                                class="fe fe-home"></i> <span>数据分析大厅</span></a>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fe fe-cart"></i> <span> 数据管理</span> <span class="menu-arrow"></span></a>
                        <ul style="display: none;">
                            <li><a href="${pageContext.request.contextPath }/pages/products.jsp">产品</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/product-details.jsp">产品视图</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath }/order/toListOrders?username=${manager.username}">订单管理</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath }/pages/customers.jsp">顾客</a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/invoice.jsp">Invoice</a></li>
                        </ul>
                    </li>

                    <li class="menu-title">
                        <span>主要管理功能</span>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/pages/profile.jsp"><i class="fe fe-user-plus"></i>
                            <span>个人信息详情</span></a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/order/toListOrders?username=${manager.username}"><i
                                class="fe fe-users"></i> <span>订单管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/p/toListP?username=${manager.username}"><i
                                class="fe fe-users"></i> <span>停车场管理员管理</span></a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/user/toListUser?username=${manager.username}"><i
                                class="fe fe-users"></i> <span>用户管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/announ/toListAnnoun?username=${manager.username}"><i
                                class="fe fe-users"></i> <span>公告管理</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/repair/toListRepair?username=${manager.username}"><i
                                class="fe fe-users"></i> <span>维修审批与管理</span></a>
                    </li>

                    <li class="menu-title">
                        <span>UI Interface</span>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/pages/components.jsp"><i class="fe fe-vector"></i>
                            <span>Components</span></a>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fe fe-layout"></i> <span> Forms </span> <span
                                class="menu-arrow"></span></a>
                        <ul style="display: none;">
                            <li><a href="${pageContext.request.contextPath }/pages/form-basic-inputs.jsp">Basic
                                Inputs </a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/form-input-groups.jsp">Input
                                Groups </a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/form-horizontal.jsp">Horizontal
                                Form </a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/form-vertical.jsp"> Vertical
                                Form </a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/form-mask.jsp"> Form Mask </a></li>
                            <li><a href="${pageContext.request.contextPath }/pages/form-validation.jsp"> Form
                                Validation </a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fe fe-table"></i> <span> Tables </span> <span
                                class="menu-arrow"></span></a>
                        <ul style="display: none;">
                            <li><a href="${pageContext.request.contextPath }/pages/tables-basic.jsp">Basic Tables </a>
                            </li>
                            <li><a href="data-tables.jsp">Data Table </a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="javascript:void(0);"><i class="fe fe-code"></i> <span>Multi Level</span> <span
                                class="menu-arrow"></span></a>
                        <ul style="display: none;">
                            <li class="submenu">
                                <a href="javascript:void(0);"> <span>Level 1</span> <span class="menu-arrow"></span></a>
                                <ul style="display: none;">
                                    <li><a href="javascript:void(0);"><span>Level 2</span></a></li>
                                    <li class="submenu">
                                        <a href="javascript:void(0);"> <span> Level 2</span> <span
                                                class="menu-arrow"></span></a>
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
                        <h3 class="page-title">欢迎你 管理者!</h3>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /Page Header -->
            <!--视图分析-->
            <!--年分析-->
            <center><div id="main" style="width: 700px;height:500px;" class="row">
                <script   >

                    // 基于准备好的dom，初始化echarts实例
                    var chartDom = document.getElementById('main');
                    var myChart = echarts.init(chartDom);
                    var option;
                    option = {
                        title: {
                            text: '年收支分析图'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['年收入折线', '年支出折线', 'Video Ads', 'Direct', 'Search Engine']
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: []
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [
                            {
                                name: '年收入折线',
                                type: 'line',

                                data: []
                            },
                            {
                                name: '年支出折线',
                                type: 'line',

                                data: []
                            }
                        ]
                    };
                    myChart.showLoading();
                    var names = [];
                    var  nums = [];
                    var values = [];
                    //ajax后台获取数据
                    $.ajax({
                        type: "post",
                        async : true,
                        url: "${pageContext.request.contextPath }/eCharts/getDataYear",
                        dataType : "json",
                        success : function (data) {

                            if (data){


                                const m = JSON.stringify(data[0]);

                                for (var i = 0; i<data.length-5; i++){
                                    const m1 = JSON.stringify(data[i]);
                                    const m11 = JSON.parse(m1);
                                    names.push(m11.time);
                                }
                                for (var i = 0; i<data.length-5; i++){
                                    const m2 = JSON.stringify(data[i]);
                                    const m22 = JSON.parse(m2);
                                    nums.push(m22.moneys);

                                }
                                for (var i = data.length-1; i>3; i--){
                                    const m3 = JSON.stringify(data[i]);
                                    const m33 = JSON.parse(m3);
                                    values.push(m33.moneys);

                                }
                                myChart.hideLoading();
                                myChart.setOption({
                                    xAxis: {
                                        data: names
                                    },
                                    series: [

                                        {
                                            name: '年收入折线',
                                            data: nums
                                        },
                                        {
                                            name:'年支出折线',
                                            data:values
                                        }
                                    ]



                                });
                            }
                        },
                        error : function (errorMsg) {
                            alert("图表请求数据失败!");
                            myChart.hideLoading();
                        }
                    })

                    option && myChart.setOption(option);
                </script>
            </div></center>
            <!--季度分析-->
            <center><div id="main1" style="width: 700px;height:500px;" class="row">
                <script   >


                    // 基于准备好的dom，初始化echarts实例
                    var chartDomMonth = document.getElementById('main1');
                    var myChartMonth = echarts.init(chartDomMonth);
                    var optionMonth;
                    optionMonth = {
                        title: {
                            text: '月收支分析图'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['月收入折线', '月支出折线', 'Video Ads', 'Direct', 'Search Engine']
                        },
                        grid: {
                            left: '5%',
                            right: '6%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: []
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [
                            {
                                name: '月收入折线',
                                type: 'line',

                                data: []
                            },
                            {
                                name: '月支出折线',
                                type: 'line',

                                data: []
                            }
                        ]
                    };
                    myChartMonth.showLoading();
                    var namesMonth = [];
                    var  numsMonth = [];
                    var valuesMonth = [];
                    //ajax后台获取数据
                    $.ajax({
                        type: "post",
                        async : true,
                        url: "${pageContext.request.contextPath }/eCharts/getDataThreeMonth",
                        dataType : "json",
                        success : function (data) {


                            if (data){

                                const m = JSON.stringify(data[0]);
                                console.log("("+m+")");
                                console.log((JSON.parse(m)).moneys);

                                for (var i = data.length-35; i>=0; i--){
                                    const m1 = JSON.stringify(data[i]);
                                    const m11 = JSON.parse(m1);
                                    namesMonth.push(m11.time);
                                    console.log(m11.time);
                                }

                                for (var i = 0; i<data.length-34; i++){
                                    const m2 = JSON.stringify(data[i]);
                                    const m22 = JSON.parse(m2);
                                    numsMonth.push(m22.moneys);

                                }
                                for (var i = data.length-1; i>=34; i--){
                                    const m3 = JSON.stringify(data[i]);
                                    const m33 = JSON.parse(m3);

                                    valuesMonth.push(m33.moneys);

                                }
                                myChartMonth.hideLoading();
                                myChartMonth.setOption({
                                    xAxis: {
                                        data: namesMonth
                                    },
                                    series: [

                                        {
                                            name: '月收入折线',
                                            data: numsMonth
                                        },
                                        {
                                            name:'月支出折线',
                                            data:valuesMonth
                                        }
                                    ]
                                });
                            }
                        },
                        error : function (errorMsg) {
                            alert("图表请求数据失败!");
                            myChartMonth.hideLoading();
                        }
                    })

                    optionMonth && myChartMonth.setOption(optionMonth);
                </script>
            </div></center>
            <!--月析-->



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
<script src="../assets/js/chart.morris.js"></script>
<script src="../assets/plugins/raphael/raphael.min.js"></script>
<script src="../assets/plugins/morris/morris.min.js"></script>




<!-- Custom JS -->
<script src="../assets/js/script.js"></script>

</body>
</html>