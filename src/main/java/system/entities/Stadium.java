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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "stadiums")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stadium.findAll", query = "SELECT s FROM Stadium s"),
    @NamedQuery(name = "Stadium.findBySid", query = "SELECT s FROM Stadium s WHERE s.sid = :sid"),
    @NamedQuery(name = "Stadium.findByName", query = "SELECT s FROM Stadium s WHERE s.name = :name"),
    @NamedQuery(name = "Stadium.findByLocation", query = "SELECT s FROM Stadium s WHERE s.location = :location"),
    @NamedQuery(name = "Stadium.findIfExists", query = "SELECT s FROM Stadium s WHERE s.name =:name and s.location = :location")})
public class Stadium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private int sid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private List<ParticipationTraining> participationTrainingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private List<ParticipationGaming> participationGamingList;

    public Stadium() {
    }

    public Stadium(int sid) {
        this.sid = sid;
    }

    public Stadium(Integer sid, String name, String location) {
        this.sid = sid;
        this.name = name;
        this.location = location;
    }

    public Stadium(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.location);
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
        final Stadium other = (Stadium) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Stadiums[ sid=" + sid + " ]";
    }

}
