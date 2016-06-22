package incidentsproject.server.mapper.incidents;

import incidentsproject.dto.incidents.IncidentDto;
import incidentsproject.dto.incidents.IncidentTypeDto;
import incidentsproject.dto.incidents.OperationDto;
import incidentsproject.server.model.incidents.Incident;
import incidentsproject.server.model.incidents.IncidentType;
import incidentsproject.server.model.incidents.Operation;

import java.util.List;

/**
 * Mapeador que convierte Entidades JPA de Incidentes, Operaciones y Tipos de
 * Incidente en DTOs y viceversa para intercambiar informacion de logica de
 * negocio fuera del servicio REST
 * 
 * @author jlsanchez
 *
 */
public interface IncidentsMapper {

	/**
	 * Obtencion simplificada de un DTO de Incidente a partir de una Entidad
	 * incidente. Simplificada porque solo se rellenan los campos basicos. Se
	 * usa para obtencion de informacion no detallada como por ejemplo la
	 * mostrada en listados
	 * 
	 * @param incident
	 *            Entidad Incidente
	 * @return DTO Incidente simplificado
	 */
	public IncidentDto fromModelToGhostDtoIncident(Incident incident);

	/**
	 * Obtencion de un DTO Incidente a partir de una Entidad Incidente
	 * 
	 * @param incident
	 *            Entidad Incidente
	 * @return DTO Incidente
	 */
	public IncidentDto fromModelToDtoIncident(Incident incident);

	/**
	 * Obtencion de una Entidad Incidente a partir de un DTO Incidente
	 * 
	 * @param dto
	 *            DTO Incidente
	 * @return Entidad Incidente
	 */
	public Incident fromDtoToModelIncident(IncidentDto dto);

	/**
	 * Obtencion de una lista de Entidades Incidente a partir de una lista de
	 * DTOs Incidente
	 * 
	 * @param dto
	 *            Lista de DTOs Incidente
	 * @return Lista de Entidades Incidente
	 */
	public List<IncidentDto> fromModelToDtoIncidentList(List<Incident> incidents);

	/**
	 * Obtencion de un DTO Operacion a partir de una Entidad Operacion
	 * 
	 * @param incident
	 *            Entidad Operacion
	 * @return DTO Operacion
	 */
	public OperationDto fromModelToDtoOperation(Operation operation);

	/**
	 * Obtencion de una lista de Entidades Operacion a partir de una lista de
	 * DTOs Operacion
	 * 
	 * @param dto
	 *            Lista de DTOs Operacion
	 * @return Lista de Entidades Operacion
	 */
	public List<OperationDto> fromModelToDtoOperationList(
			List<Operation> operations);

	/**
	 * Obtencion de un DTO Tipo de Incidente a partir de una Entidad Tipo de
	 * Incidente
	 * 
	 * @param incident
	 *            Entidad Tipo de Incidente
	 * @return DTO Tipo de Incidente
	 */
	public IncidentTypeDto fromModelToDtoIncidentType(IncidentType incidentType);

	/**
	 * Obtencion de una lista de Entidades Tipo de Incidente a partir de una
	 * lista de DTOs Tipo de Incidente
	 * 
	 * @param dto
	 *            Lista de DTOs Tipo de Incidente
	 * @return Lista de Entidades Tipo de Incidente
	 */
	public List<IncidentTypeDto> fromModelToDtoIncidentsTypeList(
			List<IncidentType> operations);
}
