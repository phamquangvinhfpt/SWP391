<%-- 
    Document   : navbar
    Created on : May 27, 2023, 3:09:46 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="header-left">
                    <a href="index.html" class="logo">
                        <span>HR Management</span>
                    </a>
                    <a href="index.html" class="logo logo-small">
                        <span>HRMS</span>
                    </a>
                    <a href="javascript:void(0);" id="toggle_btn">
                        <span class="bar-icon">
                            <span></span>
                            <span></span>
                            <span></span>
                        </span>
                    </a>
                </div>




                <div class="top-nav-search">
                    <form>
                        <input type="text" class="form-control" placeholder="">
                        <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                    </form>
                </div>


                <a class="mobile_btn" id="mobile_btn">
                    <i class="fas fa-bars"></i>
                </a>
        
                <ul class="nav user-menu">
                    <li class="nav-item dropdown has-arrow main-drop">
                        <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                            <span class="user-img">
                                <img src="/HRManagement/images/<c:out value="${sessionScope.USER.getImage()}"/>" alt="">
                                <span class="status online"></span>
                            </span>
                            <span><c:out value="${sessionScope.USER.getFullName()}"/></span>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="profile.jsp"><i data-feather="user" class="mr-1"></i> Profile</a>
                            <a class="dropdown-item" href="logoutServlet"><i data-feather="log-out" class="mr-1"></i> Logout</a>
                        </div>
                    </li>

                </ul>
                <div class="dropdown mobile-user-menu show">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                    <div class="dropdown-menu dropdown-menu-right ">
                        <a class="dropdown-item" href="profile.jsp">My Profile</a>
                        <a class="dropdown-item" href="logoutServlet">Logout</a>
                    </div>
                </div>
    </body>
</html>
