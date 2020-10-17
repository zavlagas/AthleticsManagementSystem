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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findByTid", query = "SELECT t FROM Team t WHERE t.tid = :tid"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findBySport", query = "SELECT t FROM Team t WHERE t.sport = :sport")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sport")
    private String sport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private List<AthleteRegistration> athletesRegistrationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private List<CoacheRegistration> coachesRegistrationList;

    public Team() {
    }

    public Team(Integer tid) {
        this.tid = tid;
    }

    public Team(Integer tid, String name, String sport) {
        this.tid = tid;
        this.name = name;
        this.sport = sport;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @XmlTransient
    public List<AthleteRegistration> getAthletesRegistrationList() {
        return athletesRegistrationList;
    }

    public void setAthletesRegistrationList(List<AthleteRegistration> athletesRegistrationList) {
        this.athletesRegistrationList = athletesRegistrationList;
    }

    @XmlTransient
    public List<CoacheRegistration> getCoachesRegistrationList() {
        return coachesRegistrationList;
    }

    public void setCoachesRegistrationList(List<CoacheRegistration> coachesRegistrationList) {
        this.coachesRegistrationList = coachesRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Teams[ tid=" + tid + " ]";
    }
    
}
