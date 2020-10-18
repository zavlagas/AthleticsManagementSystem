/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    private int gsid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsid")
    private List<ParticipationGaming> participationGamingList;

    public GamingStats() {
    }

    public GamingStats(int gsid) {
        this.gsid = gsid;
    }

    public GamingStats(int gsid, int grade) {
        this.gsid = gsid;
        this.grade = grade;
    }

    public Integer getGsid() {
        return gsid;
    }

    public void setGsid(int gsid) {
        this.gsid = gsid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @XmlTransient
    public List<ParticipationGaming> getParticipationGamingList() {
        return participationGamingList;
    }

    public void setParticipationGamingList(List<ParticipationGaming> participationGamingList) {
        this.participationGamingList = participationGamingList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.gsid;
        hash = 41 * hash + this.grade;
        hash = 41 * hash + Objects.hashCode(this.participationGamingList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GamingStats other = (GamingStats) obj;
        if (this.gsid != other.gsid) {
            return false;
        }
        if (this.grade != other.grade) {
            return false;
        }
        if (!Objects.equals(this.participationGamingList, other.participationGamingList)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "system.entities.GamingStats[ gsid=" + gsid + " ]";
    }
    
}
