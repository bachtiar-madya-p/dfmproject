/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author bachtiar
 */
public class Query_Management {
  
  public static final String QUERY_LOGIN ="SELECT id,name,username,password FROM userlogin WHERE username = ? AND PASSWORD = ?";
  
}
