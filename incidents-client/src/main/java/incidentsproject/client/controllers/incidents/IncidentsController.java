package incidentsproject.client.controllers.incidents;

import incidentsproject.client.manager.incidents.IncidentsManager;
import incidentsproject.dto.incidents.IncidentDto;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para gestionar peticiones HTTP a la URL /incidents
 * 
 * @author jlsanchez
 *
 */
@Controller
@RequestMapping("/incidents")
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
	 * Gestiona peticiones HTTP GET para listar incidentes no cerrados
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {

		// Log
		log.debug("Metodo list. Listar incidentes abiertos");

		// Llamada a la capa de servicio para listar incidentes no cerrados
		List<IncidentDto> incidents = incidentsManager.findOpenIncidents();

		// Se añade al modelo la lista de incidentes para visualizarla a
		// posteriori en la vista
		model.addAttribute("incidentList", incidents);

		// Se devuelve el nombre de la vista a la que navegar
		return "incidents/list";
	}

	/**
	 * Gestiona peticiones HTTP GET para mostrar el detalle de un incidente a
	 * partir de su identificador incluido en el path de la URL
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Integer id, Model model) {

		// Log
		log.debug("Metodo show. Obtener detalle del incidente con identificador '"
				+ id + "'");

		// Llamada a la capa de servicio para obtener detalle del incidente
		model.addAttribute("incident", incidentsManager.findIncidentById(id));

		// Se devuelve el nombre de la vista a la que navegar
		return "incidents/show";
	}

	/**
	 * Gestiona peticiones HTTP POST para actualizar el detalle de un incidente
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(IncidentDto incident, Model model) {

		// Log
		log.debug("Metodo save. Actualizar Incidente con identificador '"
				+ incident.getId() + "'");

		// Llamada a la capa de servicio para actualizar detalle del incidente
		incidentsManager.update(incident);

		// Se devuelve el nombre de la vista a la que navegar
		return "redirect:";
	}
}
