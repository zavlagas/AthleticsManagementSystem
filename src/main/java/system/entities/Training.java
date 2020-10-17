/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "trainings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t"),
    @NamedQuery(name = "Training.findByTrid", query = "SELECT t FROM Training t WHERE t.trid = :trid"),
    @NamedQuery(name = "Training.findByTrdate", query = "SELECT t FROM Training t WHERE t.trdate = :trdate")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trid")
    private Integer trid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.DATE)
    private Date trdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private List<Participation> participationsList;

    public Training() {
    }

    public Training(Integer trid) {
        this.trid = trid;
    }

    public Training(Integer trid, Date trdate) {
        this.trid = trid;
        this.trdate = trdate;
    }

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    @XmlTransient
    public List<Participation> getParticipationsList() {
        return participationsList;
    }

    public void setParticipationsList(List<Participation> participationsList) {
        this.participationsList = participationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trid != null ? trid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.trid == null && other.trid != null) || (this.trid != null && !this.trid.equals(other.trid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Trainings[ trid=" + trid + " ]";
    }
    
}
