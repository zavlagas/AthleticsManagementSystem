package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.ParticipationGaming;
import system.entities.ParticipationTraining;
import system.enums.LocationType;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-24T22:17:34")
@StaticMetamodel(Stadium.class)
public class Stadium_ { 

    public static volatile SingularAttribute<Stadium, String> name;
    public static volatile ListAttribute<Stadium, ParticipationGaming> participationGamingList;
    public static volatile SingularAttribute<Stadium, LocationType> location;
    public static volatile SingularAttribute<Stadium, Integer> sid;
    public static volatile ListAttribute<Stadium, ParticipationTraining> participationTrainingList;

}