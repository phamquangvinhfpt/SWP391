<%-- 
    Document   : login.jsp
    Created on : Aug 1, 2023, 10:10:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Login Page</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<link rel="shortcut icon" href="https://anitestlab.tech/extra-pages/landingpage/assets/logos/favicon.ico">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">

<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<script>
    //call ajax login
    $(document).ready(function () {
        $("form[name='login']").submit(function (event) {
            event.preventDefault();
            var email = $("input[name='txtEmail']").val();
            var password = $("input[name='txtPassword']").val();
            var rememberMe = $("input[name='remember-me']").val();
            $.ajax({
                url: "/ITHRManagement/loginServlet",
                type: "GET",
                data: {
                    txtEmail: email,
                    txtPassword: password,
                    rememberMe: rememberMe
                },
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        if (data.role === 'manager') {
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Login success!',
                            showConfirmButton: false,
                            timer: 1500
                        }).then((value) => {
                                        window.location.href = 'newjsp.jsp';
                                    });
                                }
                    } else {
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: 'Login failed!',
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
                }
            });
        });
    });
</script>


<div class="main-wrapper login-body">
<div class="login-wrapper">
<div class="container">
<img class="img-fluid logo-dark mb-2" src="assets/img/logo.png" alt="Logo">
<div class="loginbox">
<div class="login-right">
<div class="login-right-wrap">
<h1>Login</h1>

<form method="POST" name="login">
<div class="form-group">
<label class="form-control-label">Email Address</label>
<input type="email" class="form-control" name="txtEmail">
</div>
<div class="form-group">
<label class="form-control-label">Password</label>
<div class="pass-group">
    <input type="password" class="form-control pass-input" name="txtPassword">
<span class="fas fa-eye toggle-password"></span>
</div>
</div>
<div class="form-group">
<div class="row">
<div class="col-6">
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" id="cb1" name="remember-me">
<label class="custom-control-label" for="cb1">Remember me</label>
</div>
</div>
<div class="col-6 text-right">
    <a class="forgot-link" href="forgot-password.html">Forgot Password ?</a>
</div>
</div>
</div>
<button class="btn btn-lg btn-block btn-primary" type="submit">Login</button>
</form>
</div>
</div>
</div>
</div>
</div>
</div>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!--<script src="assets/js/feather.min.js"></script>-->

<script src="assets/js/script.js"></script>
</body>
</html>
