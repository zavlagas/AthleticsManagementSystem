package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.ParticipationGaming;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-19T10:58:22")
@StaticMetamodel(Gaming.class)
public class Gaming_ { 

    public static volatile SingularAttribute<Gaming, Integer> gid;
    public static volatile ListAttribute<Gaming, ParticipationGaming> participationGamingList;
    public static volatile SingularAttribute<Gaming, String> gresult;
    public static volatile SingularAttribute<Gaming, Date> gdate;

}