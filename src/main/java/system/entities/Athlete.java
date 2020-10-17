/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "athletes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Athlete.findAll", query = "SELECT a FROM Athlete a"),
    @NamedQuery(name = "Athlete.findByAid", query = "SELECT a FROM Athlete a WHERE a.aid = :aid"),
    @NamedQuery(name = "Athlete.findByName", query = "SELECT a FROM Athlete a WHERE a.name = :name"),
    @NamedQuery(name = "Athlete.findByHeight", query = "SELECT a FROM Athlete a WHERE a.height = :height"),
    @NamedQuery(name = "Athlete.findByWeight", query = "SELECT a FROM Athlete a WHERE a.weight = :weight"),
    @NamedQuery(name = "Athlete.findByDob", query = "SELECT a FROM Athlete a WHERE a.dob = :dob")})
public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private BigDecimal height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aid")
    private List<AthleteRegistration> athletesRegistrationList;

    public Athlete() {
    }

    public Athlete(Integer aid) {
        this.aid = aid;
    }

    public Athlete(Integer aid, String name, BigDecimal height, BigDecimal weight, Date dob) {
        this.aid = aid;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dob = dob;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public List<AthleteRegistration> getAthletesRegistrationList() {
        return athletesRegistrationList;
    }

    public void setAthletesRegistrationList(List<AthleteRegistration> athletesRegistrationList) {
        this.athletesRegistrationList = athletesRegistrationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Athlete)) {
            return false;
        }
        Athlete other = (Athlete) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Athletes[ aid=" + aid + " ]";
    }
    
}
