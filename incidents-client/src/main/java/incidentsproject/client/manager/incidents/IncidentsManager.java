package incidentsproject.client.manager.incidents;

import incidentsproject.dto.incidents.IncidentDto;

import java.util.List;

/**
 * Manager para gestion de Incidentes y entidades asociadas
 * 
 * @author jlsanchez
 *
 */
public interface IncidentsManager {

	/**
	 * Devuelve listado de incidentes no cerrados: pendientes, asignados, en
	 * desplazamiento, atendiendo y atendido
	 * 
	 * @return Lista de Incidentes no cerrados
	 */
	public List<IncidentDto> findOpenIncidents();

	/**
	 * Devuelve incidente completo a partir de identificador de incidente
	 * 
	 * @param incidentId
	 *            Identificador del incidente
	 * @return Incidente
	 */
	public IncidentDto findIncidentById(int incidentId);

	/**
	 * Actualiza incidente a partir de los campos no nulos contenidos en el
	 * incidente parametro del metodo. El incidente debe contener un
	 * identificador valido para encontrar el indicente que se desea actualizar
	 * 
	 * @param incident
	 *            incidente con informacion para actualizar
	 */
	public void update(IncidentDto incident);
}
