package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.AthleteRegistration;
import system.entities.Gaming;
import system.entities.GamingStats;
import system.entities.Stadium;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-20T14:46:56")
@StaticMetamodel(ParticipationGaming.class)
public class ParticipationGaming_ { 

    public static volatile SingularAttribute<ParticipationGaming, AthleteRegistration> arid;
    public static volatile SingularAttribute<ParticipationGaming, Gaming> gid;
    public static volatile SingularAttribute<ParticipationGaming, GamingStats> gsid;
    public static volatile SingularAttribute<ParticipationGaming, Integer> id;
    public static volatile SingularAttribute<ParticipationGaming, Stadium> sid;

}