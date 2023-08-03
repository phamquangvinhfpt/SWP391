/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet.leaveRequest;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.leaveDAO;
import sample.dto.User;
import sample.dto.leave_log;

/**
 *
 * @author Vinh
 */
@MultipartConfig
@WebServlet(name = "LeaveRequest", urlPatterns = {"/LeaveRequest"})
public class LeaveRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
            String type = request.getParameter("leavetype");
            String start = request.getParameter("StartDate");
            String end = request.getParameter("EndDate");
            String reason = request.getParameter("reason");
            java.sql.Date StartDate = java.sql.Date.valueOf(start);
            java.sql.Date EndDate = java.sql.Date.valueOf(end);
            reason = new String(reason.getBytes("iso-8859-1"), "UTF-8");
            User user = (User) request.getSession().getAttribute("USER");
            String userId = user.getID();
            int status = 0;
            //validate start date and end date
            
            leave_log req = new leave_log(userId, StartDate, EndDate, reason, status);
            boolean isRequest = leaveDAO.addLeave(req);
            Gson json = new Gson();
            String message = "";
            if (isRequest) {
                message += "success";
                out.write(json.toJson(message));
            } else {
                message += "fail";
                out.write(json.toJson(message));
            }
        }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LeaveRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LeaveRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
