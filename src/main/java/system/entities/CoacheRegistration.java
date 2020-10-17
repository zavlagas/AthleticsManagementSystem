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
@Table(name = "coaches_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoacheRegistration.findAll", query = "SELECT c FROM CoacheRegistration c"),
    @NamedQuery(name = "CoacheRegistration.findById", query = "SELECT c FROM CoacheRegistration c WHERE c.id = :id"),
    @NamedQuery(name = "CoacheRegistration.findByRegdate", query = "SELECT c FROM CoacheRegistration c WHERE c.regdate = :regdate")})
public class CoacheRegistration implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crid")
    private List<Participation> participationsList;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Coache cid;
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Team tid;

    public CoacheRegistration() {
    }

    public CoacheRegistration(Integer id) {
        this.id = id;
    }

    public CoacheRegistration(Integer id, Date regdate) {
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

    public Coache getCid() {
        return cid;
    }

    public void setCid(Coache cid) {
        this.cid = cid;
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
        if (!(object instanceof CoacheRegistration)) {
            return false;
        }
        CoacheRegistration other = (CoacheRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.CoachesRegistration[ id=" + id + " ]";
    }
    
}
