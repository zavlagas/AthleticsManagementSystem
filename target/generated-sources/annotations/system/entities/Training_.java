package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.ParticipationTraining;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-23T15:17:16")
@StaticMetamodel(Training.class)
public class Training_ { 

    public static volatile SingularAttribute<Training, Date> trdate;
    public static volatile SingularAttribute<Training, Integer> trid;
    public static volatile ListAttribute<Training, ParticipationTraining> participationTrainingList;

}