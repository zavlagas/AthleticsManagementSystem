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
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regdate")
    @Temporal(TemporalType.DATE)
    private Date regdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arid")
    private List<Participation> participationsList;
    @JoinColumn(name = "aid", referencedColumnName = "aid")
    @ManyToOne(optional = false)
    private Athlete aid;
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Team tid;

    public AthleteRegistration() {
    }

    public AthleteRegistration(Integer id) {
        this.id = id;
    }

    public AthleteRegistration(Integer id, Date regdate) {
        this.id = id;
        this.regdate = regdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @XmlTransient
    public List<Participation> getParticipationsList() {
        return participationsList;
    }

    public void setParticipationsList(List<Participation> participationsList) {
        this.participationsList = participationsList;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AthleteRegistration)) {
            return false;
        }
        AthleteRegistration other = (AthleteRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.AthletesRegistration[ id=" + id + " ]";
    }
    
}
