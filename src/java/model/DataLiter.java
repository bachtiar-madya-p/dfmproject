/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bachtiar
 */
@Entity
@Table(name = "data_liter")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DataLiter.findAll", query = "SELECT d FROM DataLiter d")
  , @NamedQuery(name = "DataLiter.findById", query = "SELECT d FROM DataLiter d WHERE d.id = :id")
  , @NamedQuery(name = "DataLiter.findBySite", query = "SELECT d FROM DataLiter d WHERE d.site = :site")
  , @NamedQuery(name = "DataLiter.findByStartdate", query = "SELECT d FROM DataLiter d WHERE d.startdate = :startdate")
  , @NamedQuery(name = "DataLiter.findByStarttime", query = "SELECT d FROM DataLiter d WHERE d.starttime = :starttime")
  , @NamedQuery(name = "DataLiter.findByFinishdate", query = "SELECT d FROM DataLiter d WHERE d.finishdate = :finishdate")
  , @NamedQuery(name = "DataLiter.findByFinishtime", query = "SELECT d FROM DataLiter d WHERE d.finishtime = :finishtime")
  , @NamedQuery(name = "DataLiter.findByStartcount", query = "SELECT d FROM DataLiter d WHERE d.startcount = :startcount")
  , @NamedQuery(name = "DataLiter.findByEndcount", query = "SELECT d FROM DataLiter d WHERE d.endcount = :endcount")
  , @NamedQuery(name = "DataLiter.findByGrossdeliver", query = "SELECT d FROM DataLiter d WHERE d.grossdeliver = :grossdeliver")
  , @NamedQuery(name = "DataLiter.findByAvgflow", query = "SELECT d FROM DataLiter d WHERE d.avgflow = :avgflow")
  , @NamedQuery(name = "DataLiter.findByParam1", query = "SELECT d FROM DataLiter d WHERE d.param1 = :param1")
  , @NamedQuery(name = "DataLiter.findBySalenumber", query = "SELECT d FROM DataLiter d WHERE d.salenumber = :salenumber")
  , @NamedQuery(name = "DataLiter.findByMeterNumber", query = "SELECT d FROM DataLiter d WHERE d.meterNumber = :meterNumber")
  , @NamedQuery(name = "DataLiter.findByUnitid", query = "SELECT d FROM DataLiter d WHERE d.unitid = :unitid")
  , @NamedQuery(name = "DataLiter.findByConvDate", query = "SELECT d FROM DataLiter d WHERE d.convDate = :convDate")})
public class DataLiter implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;
  @Column(name = "site")
  private String site;
  @Column(name = "startdate")
  private String startdate;
  @Column(name = "starttime")
  @Temporal(TemporalType.TIME)
  private Date starttime;
  @Column(name = "finishdate")
  private String finishdate;
  @Column(name = "finishtime")
  @Temporal(TemporalType.TIME)
  private Date finishtime;
  @Column(name = "startcount")
  private String startcount;
  @Column(name = "endcount")
  private String endcount;
  @Column(name = "grossdeliver")
  private String grossdeliver;
  @Column(name = "avgflow")
  private String avgflow;
  @Column(name = "param1")
  private String param1;
  @Column(name = "salenumber")
  private String salenumber;
  @Column(name = "meter_number")
  private String meterNumber;
  @Column(name = "unitid")
  private String unitid;
  @Column(name = "conv_date")
  @Temporal(TemporalType.DATE)
  private Date convDate;

  public DataLiter() {
  }

  public DataLiter(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getStartdate() {
    return startdate;
  }

  public void setStartdate(String startdate) {
    this.startdate = startdate;
  }

  public Date getStarttime() {
    return starttime;
  }

  public void setStarttime(Date starttime) {
    this.starttime = starttime;
  }

  public String getFinishdate() {
    return finishdate;
  }

  public void setFinishdate(String finishdate) {
    this.finishdate = finishdate;
  }

  public Date getFinishtime() {
    return finishtime;
  }

  public void setFinishtime(Date finishtime) {
    this.finishtime = finishtime;
  }

  public String getStartcount() {
    return startcount;
  }

  public void setStartcount(String startcount) {
    this.startcount = startcount;
  }

  public String getEndcount() {
    return endcount;
  }

  public void setEndcount(String endcount) {
    this.endcount = endcount;
  }

  public String getGrossdeliver() {
    return grossdeliver;
  }

  public void setGrossdeliver(String grossdeliver) {
    this.grossdeliver = grossdeliver;
  }

  public String getAvgflow() {
    return avgflow;
  }

  public void setAvgflow(String avgflow) {
    this.avgflow = avgflow;
  }

  public String getParam1() {
    return param1;
  }

  public void setParam1(String param1) {
    this.param1 = param1;
  }

  public String getSalenumber() {
    return salenumber;
  }

  public void setSalenumber(String salenumber) {
    this.salenumber = salenumber;
  }

  public String getMeterNumber() {
    return meterNumber;
  }

  public void setMeterNumber(String meterNumber) {
    this.meterNumber = meterNumber;
  }

  public String getUnitid() {
    return unitid;
  }

  public void setUnitid(String unitid) {
    this.unitid = unitid;
  }

  public Date getConvDate() {
    return convDate;
  }

  public void setConvDate(Date convDate) {
    this.convDate = convDate;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DataLiter)) {
      return false;
    }
    DataLiter other = (DataLiter) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.DataLiter[ id=" + id + " ]";
  }
  
}
