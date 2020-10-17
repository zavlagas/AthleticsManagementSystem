package system.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import system.entities.Participation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-17T18:03:19")
@StaticMetamodel(Training.class)
public class Training_ { 

    public static volatile ListAttribute<Training, Participation> participationsList;
    public static volatile SingularAttribute<Training, Date> trdate;
    public static volatile SingularAttribute<Training, Integer> trid;

}