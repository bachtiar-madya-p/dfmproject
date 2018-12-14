
<%@page import="com.google.gson.Gson"%>
<%@page import="services.Service_DataKai"%>
<%@page import="controller.Ctl_GraphByHour"%>
<%@page import="model.DataKai"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Chart | Data Flow Meter | VHS KAI</title>
        <meta name="description" content="Sufee Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-icon.png">
        <link rel="shortcut icon" href="favicon.ico">
        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
        <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
        <link rel="stylesheet" href="assets/scss/style.css">
        <link href="assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>


    </head>
    <body>           

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="./"><img src="images/pe_icon.png" alt="Logo"></a>
                    <a class="navbar-brand hidden" href="./"><img src="images/pe_icon.png" alt="Logo"></a>
                </div>

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="index.jsp"> <i class="menu-icon fa fa-dashboard"></i>Home </a>
                        </li>
                        <!-- START More Panel  -->
                        <h3 class="menu-title">MAIN NAVIGATION</h3><!-- /.menu-title -->
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>General</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><a href="about.jsp"><i class="fa fa-edit"></i> About VHS</a></li>
                                <li class="divider"></li>
                                <li><a href="vhs_locmap.jsp"><i class="fa fa-edit"></i> VHS Location Map</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Charts</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><a href="#"><i class="fa fa-pie-chart"></i> By Hour</a></li>
                                <li class="divider"></li>
                                <li><a href="chartbyday.jsp"><i class="fa fa-pie-chart"></i>By Day</a></li>
                                <li class="divider"></li>
                                <li><a href="chartbymonth.jsp"><i class="fa fa-pie-chart"></i>By Month</a></li>
                                <li class="divider"></li>
                                <li><a href="chartbyyear.jsp"><i class="fa fa-pie-chart"></i>By Year</a></li>
                                <li class="divider"></li>
                                <li><a href="chartbylocation.jsp"><i class="fa fa-pie-chart"></i>By Location</a></li>
                                <li class="divider"></li>
                                <li><a href="chartbyflowmeter.jsp"><i class="fa fa-pie-chart"></i>By Flow Meter</a></li>

                            </ul>
                        </li>

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-newspaper-o"></i>Report Management</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-clipboard"></i><a href="todayreport.jsp">Today report</a></li>
                                <li><i class="menu-icon fa fa-clipboard"></i><a href="reportmanagement.jsp">Report data</a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-wrench"></i>Maintenance</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="menu-icon fa fa-user"></i><a href="#">User Management</a></li>
                                <li><i class="menu-icon fa fa-location-arrow"></i><a href="#">Site Management</a></li>
                                <li><i class="menu-icon fa fa-image"></i><a href="#">Some Management</a></li>
                            </ul>
                        </li>
                        <!-- END of More Panel -->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

            <!-- Header start here-->
            <header id="header" class="header">
                <div class="header-menu">

                    <div class="col-sm-7">
                        <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                        <div class="header-left">
                            <h3> </h3>
                        </div>
                    </div>

                    <div class="col-sm-5">
                        <div class="user-area dropdown float-right">
                            <div class="navbar-custom-menu">
                                <ul class="nav navbar-nav">
                                    <!-- Messages: style can be found in dropdown.less-->
                                    <li><a href="#"><i class="fa fa-sign-out"></i> <span>Logout</span></a></li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </header>
            <div class="breadcrumbs">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h5>Data KAI</h5>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li class="active">Data KAI</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header ends here-->
            <div class="row">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="col-xs-3">

                    <div class="form-group">
                        <label>Date</label> <br>
                        <form name="search" method="post" action="">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input autocomplete="off" type="text" name="date1" class="form-control pull-right" id="datepickerr">
                            </div>

                    </div>
                </div>
                <div class="col-xs-1">
                    <div class="form-group">
                        <label>&nbsp;</label> <br>
                        <input type="submit" name="submit" class="btn btn-block btn-success" value="Search">
                        </form>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            </div>

            
            <!-- BODY START HERE-->


            <div>
                <div class="card">
                    <div class="card-header">
                        <%
                            Service_DataKai tanggal = new Service_DataKai();
                        %>
                        <strong class="card-title"></strong>
                    </div>
                    <div class="card-body">
                        <form role="form" action="databyhour?data" method="post">
                            <table class="table" id="countit">
                                <thead class="thead-dark">

                                    <tr align="Center">
                                        <th scope="col">#</th>
                                        <th scope="col">Tanggal</th>
                                        <th scope="col">Peminta</th>
                                        <th scope="col">Pengawas</th>
                                        <th scope="col">Volume</th>                               
                                        <th scope="col">Jenis</th>
                                        <th scope="col">No Lama</th>
                                        <th scope="col">NO Baru</th>       
                                    </tr>

                                </thead>

                                <tbody>

                                    <%
                                        Service_DataKai service = new Service_DataKai();
                                        List<DataKai> DATA = new ArrayList<DataKai>();

                                        String ket = request.getParameter("ket");
                                        if (ket == null) {
                                            DATA = service.viewDataKai("JATINEGARA", "12345");
                                        }
                                        int no = 1;
                                        for (int x = 0; x < DATA.size(); x++) {
                                    %>
                                    <tr>
                                        <td align="Center" ><%= no++%></td>
                                        <td align="Center" ><%=DATA.get(x).getTanggal()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getPeminta()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getPengawas()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getVolume()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getJenis()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getNoLama()%> </td>
                                        <td align="Center" ><%=DATA.get(x).getNoBaru()%> </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>

                    </div>
                </div>
            </div>

            <!-- BODY ENDS HERE-->
        </div> <!-- .content -->
        <!-- Right Panel -->

        <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
        <script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
        <script src="assets/js/dashboard.js"></script>
        <script src="assets/js/widgets.js"></script>
        <script src="assets/js/lib/vector-map/jquery.vmap.js"></script>
        <script src="assets/js/lib/vector-map/jquery.vmap.min.js"></script>
        <script src="assets/js/lib/vector-map/jquery.vmap.sampledata.js"></script>
        <script src="assets/js/lib/vector-map/country/jquery.vmap.world.js"></script>

        <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <!--  Chart js -->
        <script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
        <script src="assets/js/lib/chart-js/chartjs-init.js"></script>
    </body>
</html>