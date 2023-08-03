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
import java.util.ArrayList;
import sample.utils.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.dto.ContractDTO;

/**
 *
 * @author ADMIN
 */
public class ContractDAO {
    
    private List<ContractDTO> listContract;

    public List<ContractDTO> getListContract() {
        return listContract;
    }
    public void getAllListContract(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractDTO dto = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "Select ID, User_ID, StartDate, EndDate, Job, Basic_Salary, "
                        + "(select Name from Salary_Type where ID = c.SalaryType_ID) as type, Status from Contract as c";
                
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String Staff_ID = rs.getString("User_ID");
                    Date sDate = rs.getDate("StartDate");
                    Date eDate = rs.getDate("EndDate");
                    String job = rs.getString("Job");
                    double bSal = rs.getDouble("Basic_Salary");
                    String type = rs.getString("type");
                    boolean status = rs.getBoolean("Status");
                    dto = new ContractDTO(id, Staff_ID, sDate, eDate, job, bSal, type, status);
                    if(this.listContract == null){
                        listContract = new ArrayList<>();
                        
                    }
                    this.listContract.add(dto);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    public void getContractByStaffID(String User_id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractDTO dto = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql = "Select ID, User_ID, StartDate, EndDate, Job, Basic_Salary, "
                        + "(select Name from Salary_Type where ID = c.SalaryType_ID) as type, Status from Contract as c"
                        + " Where User_ID = ?";
                
                ps = con.prepareStatement(sql);
                ps.setString(1, User_id);
                rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("ID");
                    Date sDate = rs.getDate("StartDate");
                    Date eDate = rs.getDate("EndDate");
                    String job = rs.getString("Job");
                    double bSal = rs.getDouble("Basic_Salary");
                    String type = rs.getString("type");
                    boolean status = rs.getBoolean("Status");
                    dto = new ContractDTO(id, User_id, sDate, eDate, job, bSal, type, status);
                    if(this.listContract == null){
                        listContract = new ArrayList<>();
                        
                    }
                    this.listContract.add(dto);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
}
