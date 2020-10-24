package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.CoachRegistration;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-24T18:25:40")
@StaticMetamodel(Coach.class)
public class Coach_ { 

    public static volatile SingularAttribute<Coach, String> name;
    public static volatile SingularAttribute<Coach, Double> salary;
    public static volatile ListAttribute<Coach, CoachRegistration> coachesRegistrationList;
    public static volatile SingularAttribute<Coach, Integer> cid;

}