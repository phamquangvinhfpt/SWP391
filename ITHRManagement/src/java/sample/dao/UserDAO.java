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
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public static boolean checkLogin(String Email, String Password) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT * from [dbo].[User] where [Email] = ? and [Password] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Email);
                pst.setString(2, Password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    public static User getUser(String Email, String Password) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [ID], [Email], [FullName], [Dob], [Gender], [Address] ,[Password], [Image], [BankAccountNumber]\n"
                        + ", [BankAccountName], [BankName], [Status], (select [Name] from [dbo].[Role] "
                        + "where [dbo].[Role].ID = [dbo].[User].RoleId) as Role_Name, [leave_balance] from [dbo].[User] \n"
                        + "where [Email] = ? and [Password] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, Email);
                pst.setString(2, Password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("ID");
                    String email = rs.getString("Email");
                    String fullname = rs.getString("FullName");
                    Date dob = rs.getDate("DOB");
                    Boolean gender = rs.getBoolean("Gender");
                    String address = rs.getString("Address");
                    String password = rs.getString("Password");
                    String image = rs.getString("Image");
                    String bankAccountNumber = rs.getString("BankAccountNumber");
                    String bankAccountName = rs.getString("BankAccountName");
                    String bankName = rs.getString("BankName");
                    String role = rs.getString("Role_Name");
                    int leave_balance = rs.getInt("leave_balance");
                    user = new User(id, email, fullname, dob, gender, address, password, image, bankAccountNumber, bankAccountName, bankName, role, leave_balance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }
    
    public User getUserByID(String ID) throws Exception {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [ID], [Email], [FullName], [Dob], [Gender], [Address] ,[Password], [Image], [BankAccountNumber]\n"
                        + ", [BankAccountName], [BankName], [Status], (select [Name] from [dbo].[Role] "
                        + "where [dbo].[Role].ID = [dbo].[User].RoleId) as Role_Name, leave_balance from [dbo].[User] \n"
                        + "where [ID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, ID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("ID");
                    String email = rs.getString("Email");
                    String fullname = rs.getString("FullName");
                    Date dob = rs.getDate("DOB");
                    Boolean gender = rs.getBoolean("Gender");
                    String address = rs.getString("Address");
                    String password = rs.getString("Password");
                    String image = rs.getString("Image");
                    String bankAccountNumber = rs.getString("BankAccountNumber");
                    String bankAccountName = rs.getString("BankAccountName");
                    String bankName = rs.getString("BankName");
                    String role = rs.getString("Role_Name");
                    int leave_balance = rs.getInt("leave_balance");
                    user = new User(id, email, fullname, dob, gender, address, password, image, bankAccountNumber, bankAccountName, bankName, role, leave_balance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }
}
