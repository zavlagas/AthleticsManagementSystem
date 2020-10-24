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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import system.enums.TeamSportType;

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
    @NamedQuery(name = "Team.findBySport", query = "SELECT t FROM Team t WHERE t.sport = :sport"),
    @NamedQuery(name = "Team.findIfExists", query = "SELECT t FROM Team t WHERE t.name = :name and t.sport = :sport")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private int tid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sport")
    @Enumerated(EnumType.STRING)
    private TeamSportType sport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private List<AthleteRegistration> athletesRegistrationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private List<CoachRegistration> coachesRegistrationList;

    public Team() {
    }

    public Team(int tid) {
        this.tid = tid;
    }

    public Team(String name, TeamSportType sport) {
        this.name = name;
        this.sport = sport;
    }

    public Team(int tid, String name, TeamSportType sport) {
        this.tid = tid;
        this.name = name;
        this.sport = sport;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamSportType getSport() {
        return sport;
    }

    public void setSport(TeamSportType sport) {
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
    public List<CoachRegistration> getCoachesRegistrationList() {
        return coachesRegistrationList;
    }

    public void setCoachesRegistrationList(List<CoachRegistration> coachesRegistrationList) {
        this.coachesRegistrationList = coachesRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.sport);
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
        final Team other = (Team) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sport, other.sport)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Teams[ tid=" + tid + " ]";
    }

}
