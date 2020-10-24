package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Coach;
import system.entities.Team;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-24T18:25:40")
@StaticMetamodel(CoachRegistration.class)
public class CoachRegistration_ { 

    public static volatile SingularAttribute<CoachRegistration, Date> regdate;
    public static volatile SingularAttribute<CoachRegistration, Integer> id;
    public static volatile SingularAttribute<CoachRegistration, Team> tid;
    public static volatile SingularAttribute<CoachRegistration, Coach> cid;

}