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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author permadi
 */
@Entity
@Table(name = "data_kai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataKai.findAll", query = "SELECT d FROM DataKai d")
    , @NamedQuery(name = "DataKai.findById", query = "SELECT d FROM DataKai d WHERE d.id = :id")
    , @NamedQuery(name = "DataKai.findByTanggal", query = "SELECT d FROM DataKai d WHERE d.tanggal = :tanggal")
    , @NamedQuery(name = "DataKai.findByPeminta", query = "SELECT d FROM DataKai d WHERE d.peminta = :peminta")
    , @NamedQuery(name = "DataKai.findByPengawas", query = "SELECT d FROM DataKai d WHERE d.pengawas = :pengawas")
    , @NamedQuery(name = "DataKai.findByNoReservasi", query = "SELECT d FROM DataKai d WHERE d.noReservasi = :noReservasi")
    , @NamedQuery(name = "DataKai.findByVolume", query = "SELECT d FROM DataKai d WHERE d.volume = :volume")
    , @NamedQuery(name = "DataKai.findByJenis", query = "SELECT d FROM DataKai d WHERE d.jenis = :jenis")
    , @NamedQuery(name = "DataKai.findByNoLama", query = "SELECT d FROM DataKai d WHERE d.noLama = :noLama")
    , @NamedQuery(name = "DataKai.findByNoBaru", query = "SELECT d FROM DataKai d WHERE d.noBaru = :noBaru")})
public class DataKai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "tanggal")
    private String tanggal;
    @Basic(optional = false)
    @Column(name = "peminta")
    private String peminta;
    @Basic(optional = false)
    @Column(name = "pengawas")
    private String pengawas;
    @Basic(optional = false)
    @Column(name = "no_reservasi")
    private String noReservasi;
    @Basic(optional = false)
    @Column(name = "volume")
    private String volume;
    @Basic(optional = false)
    @Column(name = "jenis")
    private String jenis;
    @Basic(optional = false)
    @Column(name = "no_lama")
    private String noLama;
    @Basic(optional = false)
    @Column(name = "no_baru")
    private String noBaru;

    public DataKai() {
    }

    public DataKai(String id) {
        this.id = id;
    }

    public DataKai(String id, String tanggal, String peminta, String pengawas, String noReservasi, String volume, String jenis, String noLama, String noBaru) {
        this.id = id;
        this.tanggal = tanggal;
        this.peminta = peminta;
        this.pengawas = pengawas;
        this.noReservasi = noReservasi;
        this.volume = volume;
        this.jenis = jenis;
        this.noLama = noLama;
        this.noBaru = noBaru;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPeminta() {
        return peminta;
    }

    public void setPeminta(String peminta) {
        this.peminta = peminta;
    }

    public String getPengawas() {
        return pengawas;
    }

    public void setPengawas(String pengawas) {
        this.pengawas = pengawas;
    }

    public String getNoReservasi() {
        return noReservasi;
    }

    public void setNoReservasi(String noReservasi) {
        this.noReservasi = noReservasi;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNoLama() {
        return noLama;
    }

    public void setNoLama(String noLama) {
        this.noLama = noLama;
    }

    public String getNoBaru() {
        return noBaru;
    }

    public void setNoBaru(String noBaru) {
        this.noBaru = noBaru;
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
        if (!(object instanceof DataKai)) {
            return false;
        }
        DataKai other = (DataKai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DataKai[ id=" + id + " ]";
    }
    
}
