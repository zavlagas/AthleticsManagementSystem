/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "coaches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coache.findAll", query = "SELECT c FROM Coaches c"),
    @NamedQuery(name = "Coache.findByCid", query = "SELECT c FROM Coache c WHERE c.cid = :cid"),
    @NamedQuery(name = "Coache.findByName", query = "SELECT c FROM Coache c WHERE c.name = :name"),
    @NamedQuery(name = "Coache.findBySalary", query = "SELECT c FROM Coache c WHERE c.salary = :salary")})
public class Coache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private BigDecimal salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private List<CoacheRegistration> coachesRegistrationList;

    public Coache() {
    }

    public Coache(Integer cid) {
        this.cid = cid;
    }

    public Coache(Integer cid, String name, BigDecimal salary) {
        this.cid = cid;
        this.name = name;
        this.salary = salary;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coache)) {
            return false;
        }
        Coache other = (Coache) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Coaches[ cid=" + cid + " ]";
    }

}
