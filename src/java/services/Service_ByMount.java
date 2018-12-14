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
public class Service_ByMount {

    public String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List viewDataByMount() {

        getTanggal();
        List<SerialDataResults> data = new ArrayList<SerialDataResults>();
        try {
            String query = "SELECT \"Januari\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%01/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Februari\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%02/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Maret\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%03/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"April\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%04/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Mei\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%05/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Juni\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%06/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Juli\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%07/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Agustus\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%08/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"September\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%09/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"October\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%10/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"November\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%11/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'\n"
                    + "UNION\n"
                    + "SELECT \"Desember\" as Bulan,IFNULL(sum(gross_deliver),0) as MountTotal,IFNULL(site_id,'-------') as Side,\"Litres\" as uoms FROM `serial_data_results`\n"
                    + "WHERE SUBSTR(finish,1,8) like '%12/18%' AND site_id = 'JATINEGARA' AND `duplicate` = '' AND `unit_id` = '12345'";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                SerialDataResults serialDataResults = new SerialDataResults();

                serialDataResults.setBulan(rs.getString("Bulan"));
                serialDataResults.setTotalBulan(rs.getString("MountTotal"));
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
