/**
 *
 */
package canada.montreal.dto;

import java.util.UUID;

import canada.montreal.entities.DepartmentEntity;

/**
 * @author MENAD
 *
 */
public class Employee {

	private UUID oid;
	private String firstName;
	private String lastName;
	private Integer salary;
	private DepartmentEntity departmentEntity;

	public Employee() {
		this(null, null, null, null, null);
	}

	
	/**
	 * @param oid
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param department
	 */
	public Employee(UUID oid, String firstName, String lastName, Integer salary, DepartmentEntity departmentEntity) {
		super();
		this.oid = oid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.departmentEntity = departmentEntity;
	}

	/**
	 * @return the oid
	 */
	public UUID getOid() {
		return oid;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param oid
	 *            the oid to set
	 */
	public void setOid(UUID oid) {
		this.oid = oid;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the departmentEntity
	 */
	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	/**
	 * @param departmentEntity
	 *            the departmentEntity to set
	 */
	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
