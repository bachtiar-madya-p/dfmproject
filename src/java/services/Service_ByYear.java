/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SerialDataResults;
import model.Userlogin;
import util.Db_Connection;

/**
 *
 * @author HP
 */
public class Service_ByYear {

    public String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List viewDataByYear() {

        getTanggal();
        List<SerialDataResults> data = new ArrayList<SerialDataResults>();
        try {
            String query = "SELECT \"2018\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2019\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/19%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2020\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/20%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2021\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/21%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2022\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/22%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2023\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/23%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2024\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/24%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2025\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/25%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2026\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/26%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2027\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/27%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2028\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/28%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"2029\" as Year,IFNULL(sum(gross_deliver),0) as YearTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,5,8) like '%/29%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                SerialDataResults serialDataResults = new SerialDataResults();

                serialDataResults.setYear(rs.getString("Year"));
                serialDataResults.setTotalYear(rs.getString("YearTotal"));
                data.add(serialDataResults);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return data;
    }

    public boolean LoginUser(String username, String password) throws SQLException {
        boolean status = false;
        try {
            String query = "SELECT `name`, `username`, `password`  FROM `userlogin` WHERE `username`= '" + username + "' AND `password`= MD5('" + password + "')";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
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
