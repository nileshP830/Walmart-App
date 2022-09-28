package com.perfios.walmartapp.dao;

import com.perfios.walmartapp.beans.CustomerDetails;
import com.perfios.walmartapp.database.Database;

import java.sql.*;

public class CustomerDao {

    Database database = new Database();
    Connection con = null;
    PreparedStatement pst =null;
    Statement st = null;


    public void addUserDetails(String firstName,String lastName,String emailId,String password, String mobileNumber) {
        con = database.getConnection();
        String query = "INSERT INTO customer_details (customer_first_name, customer_last_name, customer_email, customer_password, customer_mobile_number) VALUES (?,?,?,?,?)";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, emailId);
            pst.setString(4, password);
            pst.setString(5,mobileNumber);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerDetails getUserDetails(String email,String password) {
        CustomerDetails customerDetails= new CustomerDetails();
        con = database.getConnection();
        String query = "select * from customer_details where customer_email='"+email+"' and customer_password='"+password+"';";
        try {
            pst = con.prepareStatement(query);
            System.out.println("statement created");
            System.out.println("query="+query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                customerDetails.setId(rs.getInt(1));
                customerDetails.setFirstName(rs.getString(2));
                customerDetails.setLastName(rs.getString(3));
                customerDetails.setEmailId(rs.getString(4));
                customerDetails.setPassword(rs.getString(5));
                customerDetails.setMobileNumber(rs.getString(6));
                return customerDetails;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public String updateUserPassword(String email,String newPassword){
        con = database.getConnection();
        String query = "update customer_details set customer_password='"+newPassword+"'"+" where customer_email='"+email+"';";
        try {
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            return "Password updated successfully";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
