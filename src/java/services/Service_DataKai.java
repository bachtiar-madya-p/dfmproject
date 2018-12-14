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
import model.DataKai;

import model.Userlogin;
import util.Db_Connection;

/**
 *
 * @author HP
 */

public class Service_DataKai {
     
     public String getTanggall() {  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");  
        Date date = new Date();  
        return dateFormat.format(date);  
    }  

   

    public List viewDataKai(String Id, String Peminta) {
        
        getTanggall();
        List<DataKai> data = new ArrayList<DataKai>();
        try {
            String query = "SELECT `ID`, `tanggal`, `peminta`, 'pengawas', 'no_reservasi',`volume`,`jenis`, `no_lama`, `no_baru` FROM `data_kai`";
            Connection conn = Db_Connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
          
            while (rs.next()) {
                DataKai dataKai = new DataKai();
             
                dataKai.setId(rs.getString("ID"));
                dataKai.setTanggal(rs.getString("tanggal"));
                dataKai.setPeminta(rs.getString("peminta"));
                dataKai.setPengawas(rs.getString("pengawas"));
                dataKai.setNoReservasi(rs.getString("no_reservasi"));
                dataKai.setVolume(rs.getString("volume"));
                dataKai.setJenis(rs.getString("jenis"));
                dataKai.setNoLama(rs.getString("no_lama"));
                dataKai.setNoBaru(rs.getString("no_baru"));
                
                data.add(dataKai);

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