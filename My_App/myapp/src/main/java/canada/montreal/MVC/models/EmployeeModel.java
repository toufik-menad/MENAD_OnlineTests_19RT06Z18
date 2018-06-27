package canada.montreal.MVC.models;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import canada.montreal.dao.DepartmentDAO;
import canada.montreal.dao.EmployeeDAO;
import canada.montreal.dto.Employee;
import canada.montreal.entities.DepartmentEntity;
import canada.montreal.entities.EmployeeEntity;

@Model
public class EmployeeModel {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Employee> employees;
	private Employee employee;
	private DepartmentEntity departmentEntity;
	private String myDepartmentName;
	private UUID oid;
	private Map<String, String> inputErrors = new HashMap<>();

	@PersistenceContext
	private EntityManager entityManager;

	@Resource
	private UserTransaction transaction;

	@Inject
	DepartmentDAO departmentDao;
	@Inject
	EmployeeDAO employeeDao;

	public void handle(HttpServletRequest request) throws ServletException, IOException {

		logger.info("ENTER EmployeeModel.handle");

		String[] resource = request.getRequestURI().substring(request.getContextPath().length()).split("\\;")[0]
				.split("/");

		try {

			transaction.begin();

			oid = UUID.fromString(resource[2]);
			logger.info("oid: {}", oid);

			employee = employeeDao.findEmployeeByOid(oid);

			final String firstName = request.getParameter("firstName");
			logger.info("FirstName: {}", firstName);

			final String lastName = request.getParameter("lastName");
			logger.info("lastName: {}", lastName);

			Integer salary = null;

			final String departmentName = request.getParameter("department");
			logger.info("departmentName: {}", departmentName);

			final String salaryTmp = request.getParameter("salary");

			EmployeeEntity employeeEntity = new EmployeeEntity();

			employeeEntity = employeeDao.findDTOByOid(oid);

			if (salaryTmp != null) {
				try {
					salary = Integer.parseInt(salaryTmp);
				} catch (final NumberFormatException ex) {
					logger.info("NumberFormatException");
					inputErrors.put("format", "Enter a Correct Number");
				}
			}

			if ((salary >= 10000) & (salary <= 500000)) {
				employeeEntity.setSalary(salary);
			} else {
				salary = employeeEntity.getSalary();
				inputErrors.put("salary", "Salary Must Be between $10 000 and $500 000");
			}

			departmentEntity = employeeEntity.getDepartment();

			if (departmentName != null) {
				departmentEntity = departmentDao.findEntityByName(departmentName);
				logger.info("departmentEntity: {}", departmentEntity.getName());
			} else {
				departmentEntity = employeeEntity.getDepartment();
			}

			myDepartmentName = departmentEntity.getName();

			employeeEntity.setDepartment(departmentEntity);

			entityManager.persist(employeeEntity);
			transaction.commit();

		} catch (final Exception ex) {

			logger.info("Exception Thrown");

		} finally {
			try {
				if ((transaction.getStatus() == Status.STATUS_ACTIVE) && !inputErrors.isEmpty()) {
					transaction.setRollbackOnly();
				}

				if (transaction.getStatus() == Status.STATUS_ACTIVE) {
					transaction.commit();
				} else if (transaction.getStatus() == Status.STATUS_MARKED_ROLLBACK) {
					transaction.rollback();
				}

			} catch (final Exception ex) {
				logger.error(ex.getMessage(), ex);

				try {
					transaction.rollback();
				} catch (final Exception exRollback) {
					logger.error(exRollback.getMessage(), exRollback);
				}
			}

			logger.trace("EXIT handle(request, response)");
		}

		logger.info("EmployeeModel.EXIT handle");
	}

	public void handleRegister(HttpServletRequest request) throws ServletException, IOException {
		logger.info("ENTER EmployeeModel.handleRegister");

		try {
			transaction.begin();

			final String firstName = request.getParameter("firstName");
			logger.info("FirstName :{}", firstName);

			final String lastName = request.getParameter("lastName");
			logger.info("lastName :{}", lastName);

			final String salaryTmp = request.getParameter("salary");
			logger.info("salary :{}", salaryTmp);

			final String department = request.getParameter("department");
			logger.info("department :{}", department);

			EmployeeEntity employeeEntity = new EmployeeEntity();

			employeeEntity.setFirstName(firstName);
			employeeEntity.setLastName(lastName);

			Integer salary = null;
			if (salaryTmp != null) {
				try {
					salary = Integer.parseInt(salaryTmp);
				} catch (final NumberFormatException ex) {
					logger.info("NumberFormatException");
					inputErrors.put("format", "Enter a Correct Number");
				}
			}

			if ((salary >= 10000) & (salary <= 500000)) {
				employeeEntity.setSalary(salary);
			} else {
				salary = employeeEntity.getSalary();
				inputErrors.put("salary", "Salary Must Be between $10 000 and $500 000");
			}

			employeeEntity.setDepartment(departmentDao.findEntityByName(department));

			entityManager.persist(employeeEntity);
			transaction.commit();
			inputErrors.put("successMessage", "New Employee Created");

		} catch (final Exception ex) {

			logger.info("Exception Thrown");

		} finally {
			try {
				if ((transaction.getStatus() == Status.STATUS_ACTIVE) && !inputErrors.isEmpty()) {
					transaction.setRollbackOnly();
				}

				if (transaction.getStatus() == Status.STATUS_ACTIVE) {
					transaction.commit();
				} else if (transaction.getStatus() == Status.STATUS_MARKED_ROLLBACK) {
					transaction.rollback();
				}

			} catch (final Exception ex) {
				logger.error(ex.getMessage(), ex);

				try {
					transaction.rollback();
				} catch (final Exception exRollback) {
					logger.error(exRollback.getMessage(), exRollback);
				}
			}

			logger.info("EXIT EmployeeModel.handleRegister");
		}
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		employees = employeeDao.findAllDTO();
		return employees;
	}

	/**
	 * @return the oid
	 */
	public UUID getOid() {
		return oid;
	}

	/**
	 * @return the inputErrors
	 */
	public Map<String, String> getInputErrors() {
		if (!inputErrors.isEmpty()) {
			return inputErrors;
		} else {
			return null;
		}

	}

	/**
	 * @return the departmentEntity
	 */
	public DepartmentEntity getDepartmentEntity() {

		if (oid != null) {
			return departmentEntity;
		} else {
			return null;
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @return the myDepaartmentName
	 */
	public String getMyDepartmentName() {
		if (oid != null) {
			return myDepartmentName;
		} else {
			return null;
		}
	}

}
