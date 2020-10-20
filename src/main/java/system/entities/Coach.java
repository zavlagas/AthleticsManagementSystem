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
    @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c"),
    @NamedQuery(name = "Coach.findByCid", query = "SELECT c FROM Coach c WHERE c.cid = :cid"),
    @NamedQuery(name = "Coach.findByName", query = "SELECT c FROM Coach c WHERE c.name = :name"),
    @NamedQuery(name = "Coach.findBySalary", query = "SELECT c FROM Coach c WHERE c.salary = :salary"),
    @NamedQuery(name = "Coach.findIfExists", query = "SELECT c FROM Coach c WHERE c.name = :name and c.salary =:salary")})
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private int cid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private List<CoachRegistration> coachesRegistrationList;

    public Coach() {
    }

    public Coach(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Coach(Integer cid) {
        this.cid = cid;
    }

    public Coach(Integer cid, String name, double salary) {
        this.cid = cid;
        this.name = name;
        this.salary = salary;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        hash = 89 * hash + this.cid;
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
        final Coach other = (Coach) obj;
        if (this.cid != other.cid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Coaches[ cid=" + cid + " ]";
    }

}
