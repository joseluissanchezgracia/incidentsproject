package incidentsproject.client.manager.incidents;

import incidentsproject.dto.incidents.IncidentDto;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Implementacion de la capa de servicio para gestion de incidentes a traves de
 * conexion a servicio REST
 * 
 * @author jlsanchez
 *
 */
@Service("incidentsManager")
public class IncidentsManagerImpl implements IncidentsManager {

	// Logger
	static Logger log = Logger.getLogger(IncidentsManagerImpl.class.getName());

	/**
	 * Propiedades de configuracion para formar URLs de conexion a servicio
	 * REST. Sus valores se inyectan desde el fichero de configuracion
	 */

	// Ruta base para conexion a servicio REST
	@Value("${rest.server.baseURL}")
	private String baseUrl;

	// Path para listar incidentes no cerrados
	@Value("${rest.server.listRelativeURL}")
	private String listRelativeUrl;

	// Path para obtener detalle de incidente
	@Value("${rest.server.showRelativeURL}")
	private String showRelativeUrl;

	// Path para actualizar detalle de incidente
	@Value("${rest.server.saveRelativeURL}")
	private String saveRelativeUrl;

	// Clase para implementacion de cliente REST
	private RestTemplate restTemplate = new RestTemplate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.client.manager.incidents.IncidentsManager#findOpenIncidents
	 * ()
	 */
	@Override
	public List<IncidentDto> findOpenIncidents() {
		String url = baseUrl + listRelativeUrl;

		// Log
		log.info("Listar incidentes abiertos");
		log.debug("Conectando a URL REST '" + url + "'");

		// Conexion como cliente REST para obtener listado
		IncidentDto[] incidents = restTemplate.getForObject(url,
				IncidentDto[].class);
		// Log
		log.info("Obtenida lista con " + incidents.length + " incidentes");

		List<IncidentDto> listaIncidentes = Arrays.asList(incidents);

		// Log debug de lista de incidentes obtenidos
		listaIncidentes.stream().forEach(log::debug);

		return listaIncidentes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * incidentsproject.client.manager.incidents.IncidentsManager#findIncidentById
	 * (int)
	 */
	@Override
	public IncidentDto findIncidentById(int incidentId) {
		String url = baseUrl + showRelativeUrl;

		// Log
		log.info("Obtener detalle del incidente con identificador '"
				+ incidentId + "'");

		// Conexion como cliente REST para obtener detalle de incidente
		IncidentDto incident = restTemplate.getForObject(url,
				IncidentDto.class, incidentId);

		// Log
		log.debug("Obtenido incidente: " + incident.toString());

		return incident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see incidentsproject.client.manager.incidents.IncidentsManager#update(
	 * incidentsproject.dto.incidents.IncidentDto)
	 */
	@Override
	public void update(IncidentDto incident) {
		String url = baseUrl + saveRelativeUrl;

		// Log
		log.info("Actualizar incidente con identificador '" + incident.getId()
				+ "'");
		log.debug("Conectando a URL REST '" + url + "'\n"
				+ "Actualizar valores no nulos de incidente: "
				+ incident.toString());

		// Conexion como cliente REST para actualizar detalle de incidente
		restTemplate.put(url, incident);
	}

}
