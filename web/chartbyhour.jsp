
<%@page import="com.google.gson.Gson"%>
<%@page import="services.Service_ByHour"%>
<%@page import="controller.Ctl_GraphByHour"%>
<%@page import="model.SerialDataResults"%>

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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Data KAI</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><a href="dataKai.jsp"><i class="fa fa-pie-chart"></i> Data KAI</a></li>
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
                            <h5>Data liter by hour</h5>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li class="active">Graph / Graph by hour</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header ends here-->

            <div class="card">
                <div class="row">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <form name="search" method="post" action="">
                        <div class="col-xs-3">

                            <div class="form-group">
                                <label>Date</label> <br>

                                <p><input class="form-control pull-right" type="text" id="datepicker" name="selectedDate"></p>
                            </div>
                        </div>
                        <div class="col-xs-3">
                            <div class="form-group">
                                <label>Site </label> <br>
                                <p><input class="form-control pull-right" type="text" id="datepicker" name="selectedSite"></p>
                            </div>
                        </div>
                        <div class="col-xs-3">
                            <div class="form-group">
                                <label>Flowmeter </label> <br>
                                <p><input class="form-control pull-right" type="text" id="datepicker" name="selectedFlow"></p>
                            </div>
                        </div>
                        <div class="col-xs-3">
                            <div class="form-group">
                                <label>&nbsp;</label> <br>
                                <input type="submit" name="submit" class="btn btn-block btn-success" value="Search">

                            </div>
                        </div>
                    </form>
                </div>
                &nbsp;


                <div class="card">

                    <div class="active tab-pane" id="graph">
                        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                        <%
                            Gson gsonObj = new Gson();
                            Map<Object, Object> map = null;
                            List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

                            String tanggal = request.getParameter("selectedDate");
                            String site = request.getParameter("selectedSite");
                            String flowmeter = request.getParameter("selectedFlow");

                            String selectedDate;
                            if (tanggal == "" || tanggal == null) {
                                Service_ByHour getTanggal = new Service_ByHour();
                                selectedDate = getTanggal.getTanggal();
                            } else {
                                selectedDate = tanggal;
                            }

                            Service_ByHour service1 = new Service_ByHour();
                            List<SerialDataResults> DATA1 = new ArrayList<SerialDataResults>();
                            DATA1 = service1.viewDataByHour(site, flowmeter, selectedDate);
                            String ket1 = request.getParameter("ket");
                            if (ket1 == null) {
                                DATA1 = service1.viewDataByHour(site, flowmeter, selectedDate);
                            }
                            for (int x = 0; x < DATA1.size(); x++) {
                                map = new HashMap<Object, Object>();

                                String a = DATA1.get(x).getGrossDeliver();
                                int b = Integer.parseInt(a);
                                //  Object a =  DATA1.get(x).getSiteId();
                                map.put("label", DATA1.get(x).getFinish());
                                map.put("y", b);
                                list.add(map);
                                String dataPoints = gsonObj.toJson(list);

                        %>
                        <script type="text/javascript">


                            window.onload = function () {

                                var chart = new CanvasJS.Chart("chartContainer1", {
                                    zoomEnabled: true,
                                    panEnabled: true,
                                    title: {
                                        text: "Data Liter By Hour"
                                    },
                                    data: [{
                                            indexLabelPlacement: "outside",
                                            showInLegend: true,
                                            color: "LightSeaGreen",
                                            legendText: "<%=DATA1.get(x).getSiteId()%>",
                                            type: "column",
                                            dataPoints: <%out.print(dataPoints);%>,
                                        }]
                                });

                                chart.render();
                            }
                        </script>
                        <% }%>
                    </div>


                </div> 
                <!-- BODY START HERE-->

                <div id="chartContainer" style="height: 440px; width: 100%;">
                    <div id="Sarah_chart_div" style="border: 1px solid #ccc"></div>
                    <div id="chartContainer1" style="border: 1px solid #ccc"></div>

                </div>
                <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
                <div>
                    <div class="card">
                        <div class="card-header">

                            <strong class="card-title">Detail by Liter : <% out.print(selectedDate); %> </strong>
                        </div>
                        <div class="card-body">
                            <form role="form" action="databyhour?data" method="post">
                                <table class="table" id="countit">
                                    <thead class="thead-dark">

                                        <tr align="Center">
                                            <th scope="col">#</th>
                                            <th scope="col">FLOWMETER</th>
                                            <th scope="col">START</th>
                                            <th scope="col">FINISH</th>
                                            <th scope="col">SALE NUMBER</th>                               
                                            <th scope="col">METER NUMBER</th>
                                            <th scope="col">DIPO LOCATION</th>
                                            <th scope="col">TICKET NO</th>                  
                                            <th scope="col">GROSS DELIVER</th>
                                            <th scope="col">UOM</th>
                                            <th scope="col">AVG FLOW RATE</th>
                                            <th scope="col">UOM</th>
                                            <th scope="col">END TOTALIZER</th>
                                        </tr>

                                    </thead>

                                    <tbody>

                                        <%
                                            Service_ByHour service = new Service_ByHour();
                                            List<SerialDataResults> DATA = new ArrayList<SerialDataResults>();

                                            String ket = request.getParameter("ket");
                                            if (ket == null) {
                                                DATA = service1.viewDataByHour(site, flowmeter, selectedDate);
                                            }
                                            int no = 1;
                                            for (int x = 0; x < DATA.size(); x++) {
                                        %>
                                        <tr>
                                            <td align="Center" ><%= no++%></td>
                                            <td align="Center" ><%=DATA.get(x).getUnitId()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getStart()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getFinish()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getSaleNumber()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getMeterNumber()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getSiteId()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getTicketNo()%> </td>
                                            <td align="Center" class ="count-me"><%=DATA.get(x).getGrossDeliver()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getGrossDeliverUom()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getAvgFlowRate()%> </td>
                                            <td align="Center" ><%=DATA.get(x).getAvgFlowRateUom()%> </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <script language="javascript" type="text/javascript">
                            var tds = document.getElementById('countit').getElementsByTagName('td');
                            var sum = 0;
                            for (var i = 0; i < tds.length; i++) {
                                if (tds[i].className == 'count-me') {
                                    sum += isNaN(tds[i].innerHTML) ? 0 : parseInt(tds[i].innerHTML);
                                }
                            }
                            document.getElementById('countit').innerHTML += '<tr><td style="width: 400px"></td><td style="width: 400px"></td><td style="width: 400px"></td><td style="width: 400px"></td><td style="width: 400px"></td><td style="width: 400px"></td><td style="width: 400px"></td><td>Total :</td><td>' + sum + '</td><td>Litres</td></tr>';
                                </script>

                        </div>
                    </div>
                </div>

                <!-- BODY ENDS HERE-->
            </div> <!-- .content -->
            <!--                Right Panel -->

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
            <!--                Chart js -->
            <script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
            <script src="assets/js/lib/chart-js/chartjs-init.js"></script>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <link rel="stylesheet" href="/resources/demos/style.css">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script>
                            $(function () {
                                $("#datepicker").datepicker({dateFormat: "dd/mm/y"}).val()
                            });

            </script>
    </body>
</html>