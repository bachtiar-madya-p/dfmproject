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
public class Service_ByHour {

    public String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public List viewDataByHour(String siteId, String flowMeter, String date) {

        //getTanggal();
        List<SerialDataResults> data = new ArrayList<SerialDataResults>();
        try {

            String query = "SELECT `site_id`, `ticket_no`, SUBSTRING(`start`, 10,17), SUBSTRING(`finish`,10,17),`gross_deliver`,`gross_deliver_uom`, `avg_flow_rate`, `avg_flow_rate_uom`, `sale_number`, `meter_number`, `unit_id` FROM `serial_data_results`WHERE "
                    + "SUBSTR(finish,1,8) = '" + date + "' AND site_id = '" + siteId + "' AND `duplicate` = '' AND `unit_id` = '" + flowMeter + "' ORDER BY finish ASC";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                SerialDataResults serialDataResults = new SerialDataResults();

                serialDataResults.setUnitId(rs.getString("unit_id"));
                serialDataResults.setStart(rs.getString("SUBSTRING(`start`, 10,17)"));
                serialDataResults.setFinish(rs.getString("SUBSTRING(`finish`,10,17)"));
                serialDataResults.setSaleNumber(rs.getString("sale_number"));
                serialDataResults.setMeterNumber(rs.getString("meter_number"));
                serialDataResults.setSiteId(rs.getString("site_id"));
                serialDataResults.setTicketNo(rs.getString("ticket_no"));
                serialDataResults.setGrossDeliver(rs.getString("gross_deliver"));
                serialDataResults.setGrossDeliverUom(rs.getString("gross_deliver_uom"));
                serialDataResults.setAvgFlowRate(rs.getString("avg_flow_rate"));
                serialDataResults.setAvgFlowRateUom(rs.getString("avg_flow_rate_uom"));
                data.add(serialDataResults);

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return data;
    }
}
