/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Userlogin;
import services.Service_Login;

/**
 *
 * @author bachtiar
 */
public class Ctl_Login extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action.equals("logout")) {
      HttpSession session = request.getSession();
      session.invalidate();
      response.sendRedirect("index.jsp");
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String proses = request.getParameter("post");

    if (proses.equals("Login")) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      //String tag=request.getParameter("tag");
      if (username == null || username.equals("") || password == null || password.equals("")) {   //validasi apabila field belum diisi
        response.sendRedirect("login.jsp");
      } else {
        Service_Login loginAccess = new Service_Login();
        try {
          //loginAccess.LoginUser(username, password);
          if (loginAccess.LoginUser(username, password) == true) {
            Userlogin userData = new Userlogin();
            HttpSession session = request.getSession(true);
            session.setAttribute("name", userData.getName());

            response.sendRedirect("index.jsp");
          } else {
            response.sendRedirect("login.jsp");
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("login.jsp").include(request, response);
          }
        } catch (SQLException ex) {
          Logger.getLogger(Ctl_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }
}
