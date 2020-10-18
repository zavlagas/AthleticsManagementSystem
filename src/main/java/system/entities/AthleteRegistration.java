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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "athletes_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AthleteRegistration.findAll", query = "SELECT a FROM AthleteRegistration a"),
    @NamedQuery(name = "AthleteRegistration.findById", query = "SELECT a FROM AthleteRegistration a WHERE a.id = :id"),
    @NamedQuery(name = "AthleteRegistration.findByRegdate", query = "SELECT a FROM AthleteRegistration a WHERE a.regdate = :regdate")})
public class AthleteRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regdate")
    @Temporal(TemporalType.DATE)
    private Date regdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arid")
    private List<ParticipationTraining> participationTrainingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arid")
    private List<ParticipationGaming> participationGamingList;
    @JoinColumn(name = "aid", referencedColumnName = "aid")
    @ManyToOne(optional = false)
    private Athlete aid;
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Team tid;

    public AthleteRegistration() {
    }

    public AthleteRegistration(int id) {
        this.id = id;
    }

    public AthleteRegistration(int id, Date regdate) {
        this.id = id;
        this.regdate = regdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @XmlTransient
    public List<ParticipationTraining> getParticipationTrainingList() {
        return participationTrainingList;
    }

    public void setParticipationTrainingList(List<ParticipationTraining> participationTrainingList) {
        this.participationTrainingList = participationTrainingList;
    }

    @XmlTransient
    public List<ParticipationGaming> getParticipationGamingList() {
        return participationGamingList;
    }

    public void setParticipationGamingList(List<ParticipationGaming> participationGamingList) {
        this.participationGamingList = participationGamingList;
    }

    public Athlete getAid() {
        return aid;
    }

    public void setAid(Athlete aid) {
        this.aid = aid;
    }

    public Team getTid() {
        return tid;
    }

    public void setTid(Team tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
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
        final AthleteRegistration other = (AthleteRegistration) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "system.entities.AthletesRegistration[ id=" + id + " ]";
    }
    
}
