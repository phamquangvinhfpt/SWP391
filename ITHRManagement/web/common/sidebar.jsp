<%-- 
    Document   : sidebar
    Created on : May 27, 2023, 3:16:26 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {
                $(".sidebar-menu li a").click(function () {
                    $(".sidebar-menu li a").removeClass("active");
                    $(this).addClass("active");
                });
                $("#mobile_btn").click(function () {
                    $(".sidebar-menu").toggleClass("open");
                    $(".sidebar-menu").toggleClass("mobile-show");
                });
                $("#mobile_btn_close").click(function () {
                    $(".sidebar-menu").removeClass("open");
                    $(".sidebar-menu").removeClass("mobile-show");
                });
            });
        </script>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <div class="sidebar-inner slimscroll">
            <div class="sidebar-contents">
                <div id="sidebar-menu" class="sidebar-menu">
                    <div class="mobile-show">
                        <div class="offcanvas-menu">
                            <div class="user-info align-center bg-theme text-center">
                                <span class="lnr lnr-cross  text-white" id="mobile_btn_close">X</span>
                                <a href="javascript:void(0)" class="d-block menu-style text-white">
                                    <div class="user-avatar d-inline-block mr-3">
                                        <img src="/HRManagement/images/<c:out value="${sessionScope.USER.getImage()}"/>" alt="user avatar" class="rounded-circle" width="50">
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="sidebar-input">
                            <div class="top-nav-search">
                                <form>
                                    <input type="text" class="form-control" placeholder="Search here">
                                    <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <ul>
                        <c:if test="${sessionScope.user.getRole() == 'admin'}">
                            <li>
                                <a href="admin.jsp"><img src="assets/img/home.svg" alt="sidebar_img"> <span>Dashboard</span></a>
                            </li>
                        </c:if>
                        <li>
                            <a href="employee.jsp"><img src="assets/img/employee.svg" alt="sidebar_img"><span> Employees</span></a>
                        </li>
                        <c:if test="${sessionScope.user.getRole() == 'admin'}">
                            <li>
                                <a href="teamcontroller"><img src="assets/img/group.png" alt="sidebar_img"> <span> Team</span></a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user.getRole() == 'leader' or sessionScope.user.getRole() == 'user'}">

                            <li>
                                <a href="teammemberservlet?teamid=${sessionScope.user.getTeam_ID()}"><img src="assets/img/group.png" alt="sidebar_img"> <span> Team</span></a>
                            </li>

                        </c:if>
                        <li>
                            <%-- <a href="noStartProject.jsp"><img src="assets/img/calendar.svg" alt="sidebar_img"> <span>Project</span></a> --%>
                            <%-- if role is leader then href = inProgessProject.jsp if role admin then href = noStartProject --%>
                            <c:if test="${sessionScope.user.getRole() == 'leader'}">
                                <a href="inProgressProject.jsp"><img src="assets/img/calendar.svg" alt="sidebar_img"> <span>Project</span></a>
                                </c:if>
                                <c:if test="${sessionScope.user.getRole() == 'admin'}">
                                <a href="noStartProject.jsp"><img src="assets/img/calendar.svg" alt="sidebar_img"> <span>Project</span></a>
                                </c:if>
                        </li>
                        <li>
                            <a href="leave_request.jsp"><img src="assets/img/leave.svg" alt="sidebar_img"> <span>Leave</span></a>
                        </li>
                        <c:if test="${sessionScope.user.getRole() == 'admin'}">
                        <li>
                            <a href="salary.jsp"><img src="assets/img/review.svg" alt="sidebar_img"><span>Salary</span></a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.user.getRole() != 'admin'}">
                        <li>
                            <a href="Salary-view.jsp"><img src="assets/img/review.svg" alt="sidebar_img"><span>Salary</span></a>
                        </li>
                        </c:if>
                        <li>
                            <a href="report.jsp"><img src="assets/img/report.svg" alt="sidebar_img"><span>Report</span></a>
                        </li>
                        <li>
                            <a href="user-contract.jsp"><img src="assets/img/manage.svg" alt="sidebar_img"> <span>User Contract</span></a>
                        </li>
                        <c:if test="${sessionScope.user.getRole() == 'leader'}">
                            <li>
                                <a href="CheckAttendance.jsp"><img src="assets/img/settings.svg" alt="sidebar_img"><span>Schedule</span></a>
                            </li>
                        </c:if>
                        <!--                        <li>
                                                    <a href="profile.html"><img src="assets/img/profile.svg" alt="sidebar_img"> <span>Profile</span></a>
                                                </li>-->
                    </ul>
                    <ul class="logout">
                        <form method="POST" action="mainController">
                            <li>
                                <button type="submit" name="btAction" value="Logout"><span>Log out</span></button>
                            </li>
                        </form>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
