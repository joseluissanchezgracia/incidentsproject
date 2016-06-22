package incidentsproject.server.manager.incidents;

import incidentsproject.dto.incidents.IncidentDto;
import incidentsproject.server.dao.incidents.IncidentsRepository;
import incidentsproject.server.mapper.incidents.IncidentsMapper;
import incidentsproject.server.model.incidents.Incident;
import incidentsproject.server.model.incidents.OperationsFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion de Manager para gestion de Incidentes y entidades asociadas
 * 
 * @author jlsanchez
 *
 */
@Service("incidentsManager")
public class IncidentsManagerImpl implements IncidentsManager {

	// Logger
	static Logger log = Logger.getLogger(IncidentsManagerImpl.class.getName());

	// Repositorio de Incidentes, Operaciones y Tipos de Incidente
	@Autowired
	private IncidentsRepository incidentsRepository;

	// Mapeador de Entidades a DTOs y viceversa
	@Autowired
	private IncidentsMapper incidentsMapper;

	// Factory de Operaciones auditadas de Incidentes
	@Autowired
	private OperationsFactory operationsFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.server.manager.incidents.IncidentsManager#findOpenIncidents
	 * ()
	 */
	@Override
	public List<IncidentDto> findOpenIncidents() {

		// Log
		log.info("Listar incidentes abiertos");

		// Se accede al repositorio, se obtiene la lista de entidades y se
		// convierte a lista de DTOs
		List<IncidentDto> incidents = incidentsMapper
				.fromModelToDtoIncidentList((incidentsRepository
						.findOpenIncidents()));

		// Logs
		log.info("Obtenida lista con " + incidents.size() + " incidentes");
		incidents.stream().forEach(log::debug);

		// Se devuelve la lista de incidentes
		return incidents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.server.manager.incidents.IncidentsManager#findIncidentById
	 * (java.lang.Integer)
	 */
	@Override
	public IncidentDto findIncidentById(Integer incidentId) {

		// Log
		log.info("Obtener detalle del incidente con identificador '"
				+ incidentId + "'");

		// Se obtiene la entidad Incidente del repositorio y se convierte a DTO
		IncidentDto incident = incidentsMapper
				.fromModelToDtoIncident(incidentsRepository
						.findIncidentById(incidentId));

		// Log
		log.debug("Obtenido incidente: " + incident.toString());

		// Se devuelve el incidente
		return incident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see incidentsproject.server.manager.incidents.IncidentsManager#update(
	 * incidentsproject.dto.incidents.IncidentDto)
	 */
	@Override
	public void update(IncidentDto incident) {

		// Log
		log.info("Actualizar incidente con identificador '" + incident.getId()
				+ "'");
		log.debug("Actualizar valores no nulos de incidente: "
				+ incident.toString());

		// Se mapea el incidente del modelo a partir del incidente DTO
		Incident modelIncident = incidentsMapper
				.fromDtoToModelIncident(incident);

		// Log
		log.debug("Generar operaciones a partir del incidente ':"
				+ incident.getId() + "'");

		// Se generan las operaciones que auditan los cambios segun los campos
		// rellenos en el incidente
		modelIncident.addOperations(operationsFactory
				.buildOperations(modelIncident));

		// Se persisten los cambios en el repositorio
		incidentsRepository.update(modelIncident);

	}

}
