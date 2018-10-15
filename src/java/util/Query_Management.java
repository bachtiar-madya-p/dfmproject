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
  public static final String QUERY_CHART_BY_HOUR = "SELECT `site_id`, `ticket_no`, SUBSTRING(`start`, 10,17), SUBSTRING(`finish`,10,17),`gross_deliver`,`gross_deliver_uom`, `avg_flow_rate`, `avg_flow_rate_uom`, `sale_number`, `meter_number`, `unit_id` FROM `serial_data_results`WHERE SUBSTR(start,1,8) = '11/10/18' AND SUBSTR(finish,1,8) = '11/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' ";
  
}
