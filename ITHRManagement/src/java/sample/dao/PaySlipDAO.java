/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.dto.ContractDTO;
import sample.dto.SalaryDTO;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class PaySlipDAO {

    private List<SalaryDTO> listSalary;

    public List<SalaryDTO> getSalaryInMonth(int month) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SalaryDTO> Listsal = new ArrayList<>();
        SalaryDTO sal = null;
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select ID, (select User_ID from Contract where p.Contract_ID = ID) as Staff_ID, p.Standard_work_hours, p.Actual_work_hours,\n"
                        + "p.Leave_hours, Basic_Salary, BHYT, BHXH, BHTN, Tax, Bonus, Total_salary, Note, Paid_date, BankAccountNumber, BankAccountName, BankName \n"
                        + "from PaySlip as p\n"
                        + "where MONTH(Paid_date) = ? AND YEAR(Paid_date) = YEAR(GETDATE());";
                ps = con.prepareStatement(sql);
                ps.setInt(1, month);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String Staff_id = rs.getString("Staff_ID");
                    int standard_wh = rs.getInt("Standard_work_hours");
                    int actual_wh = rs.getInt("Actual_work_hours");
                    int leave_hour = rs.getInt("Leave_hours");
                    double Basic_salary = rs.getDouble("Basic_salary");
                    double BHYT = rs.getDouble("BHYT");
                    double BHXH = rs.getDouble("BHXH");
                    double BHTN = rs.getDouble("BHTN");
                    double Tax = rs.getDouble("Tax");
                    double Bonus = rs.getDouble("Bonus");
                    double total = rs.getDouble("Total_salary");
                    String note = rs.getString("Note");
                    date = rs.getDate("Paid_date");
                    String BankNum = rs.getString("BankAccountNumber");
                    String BankAccName = rs.getString("BankAccountName");
                    String BankName = rs.getString("BankName");
                    sal = new SalaryDTO(id, Staff_id, standard_wh, actual_wh, leave_hour, Basic_salary, BHYT, BHXH, BHTN, Tax, Bonus, total, note, date, BankNum, BankAccName, BankName);
                    Listsal.add(sal);
                }
                if (!rs.next()) {
                    ContractDAO dao = new ContractDAO();
                    dao.getAllListContract();
                    List<ContractDTO> listCon = dao.getListContract();
                    UserDAO userDao = new UserDAO();
                    User user = null;
                    if (listCon != null) {
                        for (ContractDTO c : listCon) {
                            sal = new SalaryDTO(0, c.getStaff_ID(), 0, 0, 0, c.getBase_Salary(), 0, 0, 0, 0, 0, 0, "", date, "", "", "");
                            Listsal.add(sal);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PaySlipDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return Listsal;
    }

    public SalaryDTO getSalaryInMonthOfStaff(String Staff_id, int month) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SalaryDTO sal = null;
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select ID, (select User_ID from Contract where User_ID = ?) as Staff_ID, p.Standard_work_hours, p.Actual_work_hours,\n"
                        + "p.Leave_hours, Basic_Salary, BHYT, BHXH, BHTN, Tax, Bonus, Total_salary, Note, Paid_date, BankAccountNumber, BankAccountName, BankName \n"
                        + "from PaySlip as p\n"
                        + "where MONTH(Paid_date) = ? AND YEAR(Paid_date) = YEAR(GETDATE());";
                ps = con.prepareStatement(sql);
                ps.setString(1, Staff_id);
                ps.setInt(2, month);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int standard_wh = rs.getInt("Standard_work_hours");
                    int actual_wh = rs.getInt("Actual_work_hours");
                    int leave_hour = rs.getInt("Leave_hours");
                    double Basic_salary = rs.getDouble("Basic_salary");
                    double BHYT = rs.getDouble("BHYT");
                    double BHXH = rs.getDouble("BHXH");
                    double BHTN = rs.getDouble("BHTN");
                    double Tax = rs.getDouble("Tax");
                    double Bonus = rs.getDouble("Bonus");
                    double total = rs.getDouble("Total_salary");
                    String note = rs.getString("Note");
                    date = rs.getDate("Paid_date");
                    String BankNum = rs.getString("BankAccountNumber");
                    String BankAccName = rs.getString("BankAccountName");
                    String BankName = rs.getString("BankName");
                    sal = new SalaryDTO(id, Staff_id, standard_wh, actual_wh, leave_hour, Basic_salary, BHYT, BHXH, BHTN, Tax, Bonus, total, note, date, BankNum, BankAccName, BankName);

                }
                if (!rs.next()) {
                    ContractDAO dao = new ContractDAO();
                    dao.getAllListContract();
                    List<ContractDTO> listCon = dao.getListContract();
                    UserDAO userDao = new UserDAO();
                    User user = null;
                    if (listCon != null) {
                        for (ContractDTO c : listCon) {
                            if (c.getStaff_ID().equalsIgnoreCase(Staff_id)) {
                                sal = new SalaryDTO(0, c.getStaff_ID(), 0, 0, 0, c.getBase_Salary(), 0, 0, 0, 0, 0, 0, "", date, "", "", "");
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PaySlipDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return sal;
    }
}
