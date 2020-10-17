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
@Table(name = "training_stats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingStats.findAll", query = "SELECT t FROM TrainingStats t"),
    @NamedQuery(name = "TrainingStats.findByTsid", query = "SELECT t FROM TrainingStats t WHERE t.tsid = :tsid"),
    @NamedQuery(name = "TrainingStats.findByGrade", query = "SELECT t FROM TrainingStats t WHERE t.grade = :grade")})
public class TrainingStats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tsid")
    private Integer tsid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsid")
    private List<Participation> participationsList;

    public TrainingStats() {
    }

    public TrainingStats(Integer tsid) {
        this.tsid = tsid;
    }

    public TrainingStats(Integer tsid, int grade) {
        this.tsid = tsid;
        this.grade = grade;
    }

    public Integer getTsid() {
        return tsid;
    }

    public void setTsid(Integer tsid) {
        this.tsid = tsid;
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
        hash += (tsid != null ? tsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingStats)) {
            return false;
        }
        TrainingStats other = (TrainingStats) object;
        if ((this.tsid == null && other.tsid != null) || (this.tsid != null && !this.tsid.equals(other.tsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.TrainingStats[ tsid=" + tsid + " ]";
    }
    
}
