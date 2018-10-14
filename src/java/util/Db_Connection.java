/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bachtiar
 */
public class Db_Connection {

  private static Connection conn;

  public static Connection getConnection() throws ClassNotFoundException {

    if (conn == null) {

      try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(Strings_Management.MYSQL_URL, Strings_Management.MYSQL_UNAME, Strings_Management.MYSQL_PASSWORD);
        System.out.println("Connection Successfull");

      } catch (SQLException t) {
        System.out.println("Cannot open mysql connection. Couse " + t);
      }
    }

    return conn;
  }
}
