/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "participation_gaming")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipationGaming.findAll", query = "SELECT p FROM ParticipationGaming p"),
    @NamedQuery(name = "ParticipationGaming.findById", query = "SELECT p FROM ParticipationGaming p WHERE p.id = :id")})
public class ParticipationGaming implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @JoinColumn(name = "arid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AthleteRegistration arid;
    private int grade;
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    @ManyToOne(optional = false)
    private Gaming gid;
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    @ManyToOne(optional = false)
    private Stadium sid;

    public ParticipationGaming() {
    }

    public ParticipationGaming(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AthleteRegistration getArid() {
        return arid;
    }

    public void setArid(AthleteRegistration arid) {
        this.arid = arid;
    }

    public Gaming getGid() {
        return gid;
    }

    public void setGid(Gaming gid) {
        this.gid = gid;
    }

    public Stadium getSid() {
        return sid;
    }

    public void setSid(Stadium sid) {
        this.sid = sid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.arid);
        hash = 67 * hash + this.grade;
        hash = 67 * hash + Objects.hashCode(this.gid);
        hash = 67 * hash + Objects.hashCode(this.sid);
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
        final ParticipationGaming other = (ParticipationGaming) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.grade != other.grade) {
            return false;
        }
        if (!Objects.equals(this.arid, other.arid)) {
            return false;
        }
        if (!Objects.equals(this.gid, other.gid)) {
            return false;
        }
        return Objects.equals(this.sid, other.sid);
    }

    @Override
    public String toString() {
        return "system.entities.ParticipationGaming[ id=" + id + " ]";
    }

}
