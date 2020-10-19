package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Athlete;
import system.entities.ParticipationGaming;
import system.entities.ParticipationTraining;
import system.entities.Team;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-19T10:58:22")
@StaticMetamodel(AthleteRegistration.class)
public class AthleteRegistration_ { 

    public static volatile SingularAttribute<AthleteRegistration, Date> regdate;
    public static volatile ListAttribute<AthleteRegistration, ParticipationGaming> participationGamingList;
    public static volatile SingularAttribute<AthleteRegistration, Integer> id;
    public static volatile SingularAttribute<AthleteRegistration, Athlete> aid;
    public static volatile SingularAttribute<AthleteRegistration, Team> tid;
    public static volatile ListAttribute<AthleteRegistration, ParticipationTraining> participationTrainingList;

}