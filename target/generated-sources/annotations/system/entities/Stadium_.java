package system.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Participation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Stadium.class)
public class Stadium_ { 

    public static volatile ListAttribute<Stadium, Participation> participationsList;
    public static volatile SingularAttribute<Stadium, String> name;
    public static volatile SingularAttribute<Stadium, String> location;
    public static volatile SingularAttribute<Stadium, Integer> sid;

}