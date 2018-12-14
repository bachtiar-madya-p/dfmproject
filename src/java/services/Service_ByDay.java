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
public class Service_ByDay {

    public String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List viewDataByDay() {

        getTanggal();
        List<SerialDataResults> data = new ArrayList<SerialDataResults>();
        try {
            String query = "seLECT \"01\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '01/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"02\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '02/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"03\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '03/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"04\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '04/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"05\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '05/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"06\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '06/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"07\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '07/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"08\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '08/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"09\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '09/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"10\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '10/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"11\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '11/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"12\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '12/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"13\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '13/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"14\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '14/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"15\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '15/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"16\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '16/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"17\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '17/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"18\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '18/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"19\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '19/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"20\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '20/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"21\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '21/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"22\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '22/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"23\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '23/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"24\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '24/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"25\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '25/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"26\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '26/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"27\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '27/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"28\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '28/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"29\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '29/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"30\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '30/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n" +
"                    UNION\n" +
"                    SELECT \"31\" AS Date,sum(gross_deliver),site_id,\"Litres\" AS uoms FROM `serial_data_results`\n" +
"                    wHERE SUBSTR(finish,1,8) = '31/10/18' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345' ";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                SerialDataResults serialDataResults = new SerialDataResults();

                serialDataResults.setDate(rs.getString("Date"));
                serialDataResults.setSumDelivery(rs.getString("sum(gross_deliver)"));
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
