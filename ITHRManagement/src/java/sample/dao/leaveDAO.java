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
import java.util.List;
import sample.dto.leave_log;
import sample.utils.DBUtils;

/**
 *
 * @author Vinh
 */
public class leaveDAO {
    public static List<leave_log> getLeave(String User_ID) throws SQLException {
        List<leave_log> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con!=null) {
                String sql = "SELECT * FROM [dbo].[LeaveLog] WHERE [User_ID] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, User_ID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int leave_id = rs.getInt("ID");
                    String user_id = rs.getString("User_ID");
                    Date start_date = rs.getDate("Start_Date");
                    Date end_date = rs.getDate("End_Date");
                    String reason = rs.getString("Reason");
                    int status = rs.getInt("Status");
                    list.add(new leave_log(leave_id, user_id, start_date, end_date, reason, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            }
    }
    return list;
    }

    //add leave_log to database
    public static boolean addLeave(leave_log leave) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con!=null) {
                String sql = "INSERT INTO [dbo].[LeaveLog]([User_ID],[StartDate],[EndDate],[Reason],[Status]) VALUES(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, leave.getUser_ID());
                stm.setDate(2, leave.getStartDate());
                stm.setDate(3, leave.getEnDate());
                stm.setString(4, leave.getReason());
                stm.setInt(5, leave.getStatus());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
        }
        return false;
    }
}
