package canada.montreal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-27T15:25:35.608-0600")
@StaticMetamodel(EmployeeEntity.class)
public class EmployeeEntity_ extends AbstractEntity_ {
	public static volatile SingularAttribute<EmployeeEntity, String> firstName;
	public static volatile SingularAttribute<EmployeeEntity, String> lastName;
	public static volatile SingularAttribute<EmployeeEntity, Integer> salary;
	public static volatile SingularAttribute<EmployeeEntity, DepartmentEntity> department;
}