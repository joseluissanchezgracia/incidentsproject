package incidentsproject.server.dao.incidents;

import incidentsproject.server.model.incidents.Incident;
import static incidentsproject.server.model.incidents.IncidentConstans.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

/**
 * Implementacion JPA/Hibernate del repositorio
 */
@Repository("incidentsRepository")
public class JpaIncidentsRepository implements IncidentsRepository {

	// EntityManager JPA
	EntityManager entityManager;

	/**
	 * Constructor
	 */
	public JpaIncidentsRepository() {
	}

	/**
	 * Constructor con inyeccion del Proxy EntityManager
	 * 
	 * @param entityManager
	 *            Proxy del Entity Manager JPA para operar contra la base de
	 *            datos
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.server.dao.incidents.IncidentsRepository#findOpenIncidents
	 * ()
	 */
	@Override
	public List<Incident> findOpenIncidents() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Incident> criteria = builder.createQuery(Incident.class);
		Root<Incident> root = criteria.from(Incident.class);
		criteria.select(root)
				.where(builder.notEqual(root.get("state"), CERRADO))
				.orderBy(builder.desc(root.get("priority")),
						builder.desc(root.get("creationDate")));

		return entityManager.createQuery(criteria).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.server.dao.incidents.IncidentsRepository#findIncidentById
	 * (int)
	 */
	@Override
	public Incident findIncidentById(int incidentId) {
		return entityManager
				.createQuery(
						"SELECT i FROM Incident i "
								+ "WHERE i.id = :incidentId", Incident.class)
				.setParameter("incidentId", incidentId).getSingleResult();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see incidentsproject.server.dao.incidents.IncidentsRepository#update(
	 * incidentsproject.server.model.incidents.Incident)
	 */
	@Override
	public void update(Incident incident) {

		// Obtenemos el incidente a actualizar
		Incident managedIncident = findIncidentById(incident.getId());

		// Si existe el incidente se compara campo a campo y se actualiza el
		// campo que no sea nulo en el incidente que vino como parametro
		if (managedIncident != null) {
			if (incident.getAddress() != null) {
				managedIncident.setAddress(incident.getAddress());
			}
			if (incident.getDescripcion() != null) {
				managedIncident.setDescripcion(incident.getDescripcion());
			}
			if (incident.getOperator() != null) {
				managedIncident.setOperator(incident.getOperator());
			}
			if (incident.getPriority() != null) {
				managedIncident.setPriority(incident.getPriority());
			}
			if (incident.getState() != null) {
				managedIncident.setState(incident.getState());
			}
			if (incident.getType() != null && !incident.getType().isEmpty()) {
				managedIncident.setType(incident.getType());
			}
			if (incident.getOperations() != null) {
				managedIncident.addOperations(incident.getOperations());
			}
		}

		// Se persiste en base de datos
		entityManager.flush();
	}

}
