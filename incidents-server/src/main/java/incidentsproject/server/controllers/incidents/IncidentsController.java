package incidentsproject.server.controllers.incidents;

import incidentsproject.dto.incidents.IncidentDto;
import incidentsproject.server.manager.incidents.IncidentsManager;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controlador para gestionar peticiones REST a la URL /incidents JSON se emplea
 * para el body de las peticiones y las respuestas
 * 
 * @author jlsanchez
 *
 */
@Controller
@RequestMapping(value = "/incidents")
public class IncidentsController {

	// Logger
	static Logger log = Logger.getLogger(IncidentsController.class.getName());

	// Capa de servicio. Gestor de incidentes
	private IncidentsManager incidentsManager;

	/**
	 * Constructor
	 * 
	 * @param incidentsManager
	 *            Gestor de incidentes. Utilizado para obtener informacion de
	 *            incidentes y actualizarlos
	 */
	@Autowired
	public IncidentsController(IncidentsManager incidentsManager) {
		this.incidentsManager = incidentsManager;
	}

	/**
	 * Gestiona peticiones REST para listar incidentes no cerrados Devuelve JSON
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<IncidentDto> listIncidents() {

		// Log
		log.debug("Metodo listIncidents. Listar incidentes abiertos");

		// Llamada a la capa de servicio para listar incidentes no cerrados
		return incidentsManager.findOpenIncidents();
	}

	/**
	 * Gestiona peticiones REST para mostrar el detalle de un incidente a partir
	 * de su identificador incluido en el path de la URL
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody IncidentDto show(@PathVariable("id") Integer id) {
		
		// Log
		log.debug("Metodo show. Obtener detalle del incidente con identificador '"
				+ id + "'");

		// Llamada a la capa de servicio para obtener detalle del incidente
		IncidentDto incident = incidentsManager.findIncidentById(id);

		// Devuelve el incidente
		return incident;
	}

	/**
	 * Gestiona peticiones REST para actualizar el detalle de un incidente
	 * Devuelve por defecto codigo HTTP 200
	 */
	@RequestMapping(value = "/save", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody IncidentDto incident) {

		// Log
		log.debug("Metodo save. Actualizar Incidente con identificador '"
				+ incident.getId() + "'");

		// Llamada a la capa de servicio para actualizar detalle del incidente
		incidentsManager.update(incident);
	}
}
