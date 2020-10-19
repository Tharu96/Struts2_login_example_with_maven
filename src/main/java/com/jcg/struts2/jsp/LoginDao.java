package com.jcg.struts2.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Sashini Tharuka on 10/14/2020.
 */
public class LoginDao {

    public static ResultSet validate(String username, String userpass) throws Exception {
        boolean status = false;
        User user = new User();
        try {
            String URL = "jdbc:mysql://localhost/struts";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, "root", "ijse");

            PreparedStatement ps = con.prepareStatement(
                    "select * from user where userName=? and password=?");
            ps.setString(1, username);
            ps.setString(2, userpass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            System.out.println(status);
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}