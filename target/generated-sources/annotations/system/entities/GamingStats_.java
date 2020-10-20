package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.ParticipationGaming;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-21T01:45:44")
@StaticMetamodel(GamingStats.class)
public class GamingStats_ { 

    public static volatile SingularAttribute<GamingStats, Integer> gsid;
    public static volatile SingularAttribute<GamingStats, Integer> grade;
    public static volatile ListAttribute<GamingStats, ParticipationGaming> participationGamingList;

}