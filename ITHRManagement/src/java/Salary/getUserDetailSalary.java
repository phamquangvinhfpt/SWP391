/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salary;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.PaySlipDAO;
import sample.dao.UserDAO;
import sample.dto.SalaryDTO;
import sample.dto.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "getUserDetailSalary", urlPatterns = {"/getUserDetailSalary"})
public class getUserDetailSalary extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Staff_ID = request.getParameter("id");
            Calendar cal = Calendar.getInstance();
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            UserDAO userDao = new UserDAO();
            User user = userDao.getUserByID(Staff_ID);
            PaySlipDAO pDAO = new PaySlipDAO();
            SalaryDTO salary = pDAO.getSalaryInMonthOfStaff(Staff_ID, month);
            response.setStatus(200);
            JsonObject jsonObject = new JsonObject();
            Gson gson = new Gson();
            jsonObject.add("user", gson.toJsonTree(user));
            jsonObject.add("salary", gson.toJsonTree(salary));
            out.println(jsonObject.toString());
        } catch (Exception ex) {
            Logger.getLogger(getUserDetailSalary.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
