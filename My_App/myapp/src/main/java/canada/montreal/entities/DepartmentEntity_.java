package canada.montreal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-27T15:25:35.582-0600")
@StaticMetamodel(DepartmentEntity.class)
public class DepartmentEntity_ extends AbstractEntity_ {
	public static volatile SingularAttribute<DepartmentEntity, String> name;
	public static volatile SingularAttribute<DepartmentEntity, Long> id;
	public static volatile ListAttribute<DepartmentEntity, EmployeeEntity> employeelist;
}
