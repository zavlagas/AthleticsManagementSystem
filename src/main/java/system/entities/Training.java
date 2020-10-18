/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.util.Date;
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
    private int trid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trdate")
    @Temporal(TemporalType.DATE)
    private Date trdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trid")
    private List<ParticipationTraining> participationTrainingList;

    public Training() {
    }

    public Training(int trid) {
        this.trid = trid;
    }

    public Training(int trid, Date trdate) {
        this.trid = trid;
        this.trdate = trdate;
    }

    public int getTrid() {
        return trid;
    }

    public void setTrid(int trid) {
        this.trid = trid;
    }

    public Date getTrdate() {
        return trdate;
    }

    public void setTrdate(Date trdate) {
        this.trdate = trdate;
    }

    @XmlTransient
    public List<ParticipationTraining> getParticipationTrainingList() {
        return participationTrainingList;
    }

    public void setParticipationTrainingList(List<ParticipationTraining> participationTrainingList) {
        this.participationTrainingList = participationTrainingList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.trid;
        hash = 97 * hash + Objects.hashCode(this.trdate);
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
        final Training other = (Training) obj;
        if (this.trid != other.trid) {
            return false;
        }
        if (!Objects.equals(this.trdate, other.trdate)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "system.entities.Trainings[ trid=" + trid + " ]";
    }
    
}
