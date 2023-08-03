<%-- 
    Document   : salary_view
    Created on : Aug 3, 2023, 2:25:19 PM
    Author     : ADMIN
--%>

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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
        <style>
            .my-input {
                width: 100%;
                height: 40px;
                border: 1px solid rgba(235, 236, 241, 1);
                padding: 0 8px;
                color: #000;
                border-radius: 6px;
            }
        </style>
        <script>
            $(document).ready(function () {
                const id = sessionStorage.getItem('id');
                $.ajax({
                    method: "POST",
                    url: "/ITHRManagement/getUserDetailSalary",
                    data: {
                        id: id
                    },
                    success: function (res) {
                        var data = JSON.parse(res);

                        // Populate the user information
                        $('#name').val(data.user.FullName);
                        $('#email').val(data.user.Email);
                        $('#address').val(data.user.Address);
                        var dob = new Date(data.user.Dob);
                        var dobFormatted = dob.getDate() + '/' + (dob.getMonth() + 1) + '/' + dob.getFullYear();
                        $('#dob').val(dobFormatted);
                        $('#role').val(data.user.Role);
                        $('#BNum').val(data.user.BankAccountNumber);
                        $('#BAN').val(data.user.BankAccountName);
                        $('#BName').val(data.user.BankName);

                        // Populate the salary information
                        $('#sId').val(data.salary.Staff_ID);
                        var date = new Date(data.salary.date);
                        var dateFor = date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear();
                        $('#date').val(dateFor);
                        $('#bs').val(data.salary.Basic_salary);
                        $('#wh').val(data.salary.actual_wh);
                        $('#lh').val(data.salary.leave_hour);
//                        $('#otb').val(data.salary.overtimeType1);
//                        $('#otn').val(data.salary.overtimeType2);
                        $('#bhyt').val(data.salary.BHYT);
                        $('#bhxh').val(data.salary.BHXH);
                        $('#bhtn').val(data.salary.BHTN);
                        $('#tax').val(data.salary.Tax);
                        $('#bonus').val(data.salary.Bonus);
                        $('#total').val(data.salary.total);
                    }
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
                                    <li class="breadcrumb-item">
                                        <a href="salary.jsp">Salary</a>
                                    </li>
                                    <li class="breadcrumb-item active">View</li>
                                </ul>
                                <h3>Salary View</h3>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-12 col-sm-12 col-12 ">
                            <div class="card ">
                                <div class="card-body p-3">
                                    <h4 style="margin-bottom: 1rem;">Staff information</h4>
                                    <div class="row">
                                        <div class="col-6">
                                            <label for="name" style="margin: 0;">Staff Name:</label>
                                            <input type="text" class="my-input" readonly id="name" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="email" style="margin: 0;">Email:</label>
                                            <input type="text" class="my-input" readonly id="email" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="address" style="margin: 0;">Address:</label>
                                            <input type="text" class="my-input" readonly id="address" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="dob" style="margin: 0;">Birth day:</label>
                                            <input type="datetime" class="my-input" readonly id="dob" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="role" style="margin: 0;">Role:</label>
                                            <input type="text" class="my-input" readonly id="role" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="role" style="margin: 0;">Bank Number:</label>
                                            <input type="text" class="my-input" readonly id="BNum" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="role" style="margin: 0;">Bank Account Name:</label>
                                            <input type="text" class="my-input" readonly id="BAN" value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="role" style="margin: 0;">Bank Name:</label>
                                            <input type="text" class="my-input" readonly id="BName" value="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card ">
                                <div class="card-body p-3">
                                    <h4 style="margin-bottom: 1rem;">Detail Salary</h4>
                                    <div class="row">
                                        <div class="col-6">
                                            <label for="cId" style="margin: 0;">Staff ID:</label>
                                            <input type="text" class="my-input" id="sId" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="cId" style="margin: 0;">Date:</label>
                                            <input type="datetime" class="my-input" id="date" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="bs" style="margin: 0;">Basic salary:</label>
                                            <input type="text" class="my-input" id="bs" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="wh" style="margin: 0;">Working hour:</label>
                                            <input type="text" class="my-input" id="wh" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="lh" style="margin: 0;">Leave hour:</label>
                                            <input type="text" class="my-input" id="lh" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="otb" style="margin: 0;">Over time type 1:</label>
                                            <input type="text" class="my-input" id="otb" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="otn" style="margin: 0;">Over time type 2:</label>
                                            <input type="text" class="my-input" id="otn" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="bhyt" style="margin: 0;">BHYT:</label>
                                            <input type="text" class="my-input" id="bhyt" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="bhyt" style="margin: 0;">BHXH:</label>
                                            <input type="text" class="my-input" id="bhxh" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="bhyt" style="margin: 0;">BHTN:</label>
                                            <input type="text" class="my-input" id="bhtn" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="tax" style="margin: 0;">Tax:</label>
                                            <input type="text" class="my-input" id="tax" readonly value="">
                                        </div>
                                        <div class="col-6">
                                            <label for="tax" style="margin: 0;">Bonus:</label>
                                            <input type="text" class="my-input" id="bonus" readonly value="">
                                        </div>
                                        <div class="col-12">
                                            <label for="total" style="margin: 0;">Total salary:</label>
                                            <input type="text" class="my-input" id="total" readonly value="">
                                        </div>
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
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="assets/js/feather.min.js"></script>

<!--<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>-->

<script src="assets/plugins/select2/js/select2.min.js"></script>
<script src="assets/js/script.js"></script>
