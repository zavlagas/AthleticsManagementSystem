package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.AthleteRegistration;
import system.entities.Stadium;
import system.entities.Training;
import system.entities.TrainingStats;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-20T14:46:56")
@StaticMetamodel(ParticipationTraining.class)
public class ParticipationTraining_ { 

    public static volatile SingularAttribute<ParticipationTraining, AthleteRegistration> arid;
    public static volatile SingularAttribute<ParticipationTraining, Integer> id;
    public static volatile SingularAttribute<ParticipationTraining, TrainingStats> tsid;
    public static volatile SingularAttribute<ParticipationTraining, Stadium> sid;
    public static volatile SingularAttribute<ParticipationTraining, Training> trid;

}