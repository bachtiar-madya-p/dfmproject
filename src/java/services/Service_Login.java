/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Userlogin;
import util.Db_Connection;
import util.Query_Management;

/**
 *
 * @author bachtiar
 */
public class Service_Login {

  public boolean LoginUser(String username, String password) throws SQLException {
    boolean status = false;
    try {
      String query = "SELECT `name`, `username`, `password`  FROM `userlogin` WHERE `username`= '"+username+"' AND `password`= MD5('"+password+"')";
      Connection conn = Db_Connection.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while(rs.next())
      {
       Userlogin userData = new Userlogin();
       userData.setName(rs.getString("name"));
       userData.setUsername(rs.getString("username"));
       userData.setPassword(rs.getString("password"));
       status = true;
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return status;
  }
}
