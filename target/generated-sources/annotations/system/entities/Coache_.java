package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.CoacheRegistration;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-20T14:46:56")
@StaticMetamodel(Coache.class)
public class Coache_ { 

    public static volatile SingularAttribute<Coache, String> name;
    public static volatile SingularAttribute<Coache, Double> salary;
    public static volatile ListAttribute<Coache, CoacheRegistration> coachesRegistrationList;
    public static volatile SingularAttribute<Coache, Integer> cid;

}