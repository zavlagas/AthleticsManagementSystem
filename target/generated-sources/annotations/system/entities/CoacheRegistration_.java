package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Coache;
import system.entities.Team;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-20T14:46:56")
@StaticMetamodel(CoacheRegistration.class)
public class CoacheRegistration_ { 

    public static volatile SingularAttribute<CoacheRegistration, Date> regdate;
    public static volatile SingularAttribute<CoacheRegistration, Integer> id;
    public static volatile SingularAttribute<CoacheRegistration, Team> tid;
    public static volatile SingularAttribute<CoacheRegistration, Coache> cid;

}