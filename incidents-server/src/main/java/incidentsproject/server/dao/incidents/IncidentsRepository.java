package incidentsproject.server.dao.incidents;

import incidentsproject.server.model.incidents.Incident;

import java.util.List;

/**
 * Repositorio de informacion sobre incidentes, operaciones y tipos de incidente
 * 
 * @author jlsanchez
 *
 */
public interface IncidentsRepository {

	/**
	 * Devuelve listado de incidentes no cerrados: pendientes, asignados, en
	 * desplazamiento, atendiendo y atendido
	 * 
	 * @return Lista de Incidentes no cerrados
	 */
	List<Incident> findOpenIncidents();

	/**
	 * Devuelve incidente completo a partir de identificador de incidente
	 * 
	 * @param incidentId
	 *            Identificador del incidente
	 * @return Incidente
	 */
	Incident findIncidentById(int incidentId);

	/**
	 * Actualiza incidente a partir de los campos no nulos contenidos en el
	 * incidente parametro del metodo. El incidente debe contener un
	 * identificador valido para encontrar el indicente que se desea actualizar
	 * 
	 * @param incident
	 *            incidente con informacion para actualizar
	 */
	public void update(Incident incident);


}
