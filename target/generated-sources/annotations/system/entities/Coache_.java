package system.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.CoacheRegistration;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Coache.class)
public class Coache_ { 

    public static volatile SingularAttribute<Coache, String> name;
    public static volatile SingularAttribute<Coache, BigDecimal> salary;
    public static volatile ListAttribute<Coache, CoacheRegistration> coachesRegistrationList;
    public static volatile SingularAttribute<Coache, Integer> cid;

}