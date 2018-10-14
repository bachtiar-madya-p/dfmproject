/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bachtiar
 */
@Entity
@Table(name = "site_location")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SiteLocation.findAll", query = "SELECT s FROM SiteLocation s")
  , @NamedQuery(name = "SiteLocation.findById", query = "SELECT s FROM SiteLocation s WHERE s.id = :id")
  , @NamedQuery(name = "SiteLocation.findBySite", query = "SELECT s FROM SiteLocation s WHERE s.site = :site")
  , @NamedQuery(name = "SiteLocation.findByLongitud", query = "SELECT s FROM SiteLocation s WHERE s.longitud = :longitud")
  , @NamedQuery(name = "SiteLocation.findByLatitud", query = "SELECT s FROM SiteLocation s WHERE s.latitud = :latitud")})
public class SiteLocation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "site")
  private String site;
  @Basic(optional = false)
  @Column(name = "longitud")
  private String longitud;
  @Basic(optional = false)
  @Column(name = "latitud")
  private String latitud;
  @Basic(optional = false)
  @Lob
  @Column(name = "address")
  private String address;
  @Basic(optional = false)
  @Lob
  @Column(name = "description")
  private String description;

  public SiteLocation() {
  }

  public SiteLocation(Integer id) {
    this.id = id;
  }

  public SiteLocation(Integer id, String site, String longitud, String latitud, String address, String description) {
    this.id = id;
    this.site = site;
    this.longitud = longitud;
    this.latitud = latitud;
    this.address = address;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    if (!(object instanceof SiteLocation)) {
      return false;
    }
    SiteLocation other = (SiteLocation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.SiteLocation[ id=" + id + " ]";
  }
  
}
