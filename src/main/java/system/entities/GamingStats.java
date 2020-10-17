/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "gaming_stats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GamingStats.findAll", query = "SELECT g FROM GamingStats g"),
    @NamedQuery(name = "GamingStats.findByGsid", query = "SELECT g FROM GamingStats g WHERE g.gsid = :gsid"),
    @NamedQuery(name = "GamingStats.findByGrade", query = "SELECT g FROM GamingStats g WHERE g.grade = :grade")})
public class GamingStats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gsid")
    private Integer gsid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsid")
    private List<Participation> participationsList;

    public GamingStats() {
    }

    public GamingStats(Integer gsid) {
        this.gsid = gsid;
    }

    public GamingStats(Integer gsid, int grade) {
        this.gsid = gsid;
        this.grade = grade;
    }

    public Integer getGsid() {
        return gsid;
    }

    public void setGsid(Integer gsid) {
        this.gsid = gsid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
        hash += (gsid != null ? gsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamingStats)) {
            return false;
        }
        GamingStats other = (GamingStats) object;
        if ((this.gsid == null && other.gsid != null) || (this.gsid != null && !this.gsid.equals(other.gsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.GamingStats[ gsid=" + gsid + " ]";
    }
    
}
