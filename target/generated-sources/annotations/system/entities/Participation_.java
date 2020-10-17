package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.AthleteRegistration;
import system.entities.CoacheRegistration;
import system.entities.Gaming;
import system.entities.GamingStats;
import system.entities.Stadium;
import system.entities.Training;
import system.entities.TrainingStats;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Participation.class)
public class Participation_ { 

    public static volatile SingularAttribute<Participation, AthleteRegistration> arid;
    public static volatile SingularAttribute<Participation, Gaming> gid;
    public static volatile SingularAttribute<Participation, CoacheRegistration> crid;
    public static volatile SingularAttribute<Participation, GamingStats> gsid;
    public static volatile SingularAttribute<Participation, Integer> id;
    public static volatile SingularAttribute<Participation, TrainingStats> tsid;
    public static volatile SingularAttribute<Participation, Training> tid;
    public static volatile SingularAttribute<Participation, Stadium> sid;

}