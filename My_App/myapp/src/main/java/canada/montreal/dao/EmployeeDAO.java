/**
 *
 */
package canada.montreal.dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import canada.montreal.dto.Employee;
import canada.montreal.entities.EmployeeEntity;

/**
 * @author MENAD
 *
 */

@Stateless
@LocalBean
public class EmployeeDAO {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	public EmployeeDAO() {
	}

	/**
	 * @param entityManager
	 */
	public EmployeeDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Employee findEmployeeByOid(UUID oid) {
		logger.info("ENTER findEmployeeByOid");
		final TypedQuery<Employee> query = getEntityManager().createNamedQuery(EmployeeEntity.QUERY_O_FIND_BY_OID,
				Employee.class);
		query.setParameter("oid", oid);
		logger.info("EXIT findEmployeeByOid");
		return query.getSingleResult();
	}

	public EmployeeEntity findDTOByOid(UUID oid) {

		logger.info("ENTER findEntityByOid");
		final TypedQuery<EmployeeEntity> query = getEntityManager()
				.createNamedQuery(EmployeeEntity.QUERY_FIND_DTO_BY_OID, EmployeeEntity.class);
		query.setParameter("oid", oid);
		logger.info("EXIT findEntityByOid");
		return query.getSingleResult();
	}

	public List<Employee> findAllDTO() {

		logger.info("ENTER findAllDTO");
		final TypedQuery<Employee> query = getEntityManager().createNamedQuery(EmployeeEntity.QUERY_DTO_FIND_ALL,
				Employee.class);
		return query.getResultList();
	}

}
