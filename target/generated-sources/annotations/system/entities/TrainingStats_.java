package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.ParticipationTraining;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-20T14:46:56")
@StaticMetamodel(TrainingStats.class)
public class TrainingStats_ { 

    public static volatile SingularAttribute<TrainingStats, Integer> grade;
    public static volatile SingularAttribute<TrainingStats, Integer> tsid;
    public static volatile ListAttribute<TrainingStats, ParticipationTraining> participationTrainingList;

}