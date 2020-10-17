package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.AthleteRegistration;
import system.entities.CoacheRegistration;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile ListAttribute<Team, AthleteRegistration> athletesRegistrationList;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile SingularAttribute<Team, String> sport;
    public static volatile SingularAttribute<Team, Integer> tid;
    public static volatile ListAttribute<Team, CoacheRegistration> coachesRegistrationList;

}