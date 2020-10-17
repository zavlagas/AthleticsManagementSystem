package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Participation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Gaming.class)
public class Gaming_ { 

    public static volatile ListAttribute<Gaming, Participation> participationsList;
    public static volatile SingularAttribute<Gaming, Integer> gid;
    public static volatile SingularAttribute<Gaming, String> gresult;
    public static volatile SingularAttribute<Gaming, Date> gdate;

}