<%-- 
    Document   : Salary
    Created on : Aug 3, 2023, 12:21:45 PM
    Author     : ADMIN
--%>

<%@page import="java.util.Calendar"%>
<%@page import="sample.dto.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/datetime/1.4.1/css/dataTables.dateTime.min.css" />
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="https://kit.fontawesome.com/b3fa33d056.js" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
        <script src="https://cdn.datatables.net/datetime/1.4.1/js/dataTables.dateTime.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <%
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                response.sendRedirect("login.jsp");
//            }
            Calendar calendar = Calendar.getInstance();
            int currentMonth = calendar.get(Calendar.MONTH);
            int currentYear = calendar.get(Calendar.YEAR);
            currentMonth += 1;
            String monthStr = currentMonth + "";
            String yearStr = currentYear + "";
        %>
        <script>
            $(document).ready(function () {
                $.ajax({
                    method: "POST",
                    url: "/ITHRManagement/LoadSalaryServlet",
                    success: function (res) {
                        // Create the datatable with the returned data
                        $('#example').DataTable({
                            data: res,
                            columns: [
                                {data: null,
                                    //set identity for row
                                    render: function (data, type, row, meta) {
                                        return meta.row + meta.settings._iDisplayStart + 1;
                                    }
                                },
                                {data: "Staff_ID"},
                                {data: "Basic_salary",
                                    render(data) {
                                        return data.toLocaleString();
                                    }
                                },
                                {data: "standard_wh"},
                                {data: "actual_wh"},
                                {data: "leave_hour"},
                                {data: "total"},
                                {data: null,
                                    render: function (data, type, row) {
                                        //set id for button = id of employee
                                        return `
        <button class="btn view-btn" style="background-color: white;box-shadow: none">
 <i class="fa-solid fa-eye text-primary"></i>
</button>
                   `;
                                    }
                                }

                            ],
                            "order": [[1, 'asc']]
                        });
                    },
                    error: function (error) {
                        console.log(error);
                        // handle error response
                    }
                });
                $('#example tbody').on('click', '.view-btn', function () {
                    //get data of row which is clicked
                    var data = $('#example').DataTable().row($(this).parents('tr')).data();
                    var id = data.Staff_ID;
                    sessionStorage.setItem('id', id);
                    window.location.href = "salary_view.jsp";
                });
            });
        </script>

    </head>
    <body>
        <div class="main-wrapper">
            <div class="header">
                <jsp:include page="common/navbar.jsp" />  
            </div>

            <div class="sidebar" id="sidebar">
                <jsp:include page="common/sidebar.jsp" />
            </div>
            <div class="page-wrapper">
                <div class="content container-fluid">
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12">
                            <div class="breadcrumb-path mb-4">
                                <ul class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="admin.jsp"><img src="assets/img/dash.png"
                                                                                         class="mr-2" alt="breadcrumb" />Home</a>
                                    </li>
                                    <li class="breadcrumb-item active">Salary</li>
                                </ul>
                                <h3>Salary</h3>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card ">
                                <div class="card-header" style="display: flex; justify-content: space-between; align-items: center;">
                                    <h2 class="card-titles">Payslip</h2>
                                    <!--<button class="btn-add" onclick="$('#mymodal').modal('show')"><i data-feather="plus"></i> Create Payslip</button>-->
                                    <div>
                                        <button class="btn-add" id="btn-approve">Approve all</button>
                                    </div>
                                </div>
                                <div class="card-body p-0">
                                    <div class="table-responsive">
                                        <table id="example" class="display nowrap" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Staff ID</th>
                                                    <th>Basic salary</th>
                                                    <th>Work hour</th>
                                                    <th>Actual Hours</th>
                                                    <th>Leave hour</th>
                                                    <th>Total salary</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
