package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.AthleteRegistration;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-19T10:58:22")
@StaticMetamodel(Athlete.class)
public class Athlete_ { 

    public static volatile ListAttribute<Athlete, AthleteRegistration> athletesRegistrationList;
    public static volatile SingularAttribute<Athlete, Date> dob;
    public static volatile SingularAttribute<Athlete, String> name;
    public static volatile SingularAttribute<Athlete, Double> weight;
    public static volatile SingularAttribute<Athlete, Integer> aid;
    public static volatile SingularAttribute<Athlete, Double> height;

}