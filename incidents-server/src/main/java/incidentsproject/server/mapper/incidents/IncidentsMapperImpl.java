/**
 * 
 */
package incidentsproject.server.mapper.incidents;

import incidentsproject.dto.incidents.IncidentDto;
import incidentsproject.dto.incidents.IncidentTypeDto;
import incidentsproject.dto.incidents.OperationDto;
import incidentsproject.server.model.incidents.Incident;
import incidentsproject.server.model.incidents.IncidentType;
import incidentsproject.server.model.incidents.IncidentType.IncidentTypePK;
import incidentsproject.server.model.incidents.Operation;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Implementacion de mapeador que convierte Entidades JPA de Incidentes,
 * Operaciones y Tipos de Incidente en DTOs y viceversa
 * 
 * @author jlsanchez
 *
 */
@Component
public class IncidentsMapperImpl implements IncidentsMapper {

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToGhostDtoIncident(incidentsproject.server.model.incidents.Incident)
	 */
	@Override
	public IncidentDto fromModelToGhostDtoIncident(Incident incident) {

		IncidentDto dto = new IncidentDto();

		dto.setId(incident.getId());
		dto.setOperator(incident.getOperator());
		dto.setPriority(incident.getPriority());
		dto.setState(incident.getState());
		dto.setAddress(incident.getAddress());
		dto.setCreationDate(incident.getCreationDate());
		dto.setDescripcion(incident.getDescripcion());
		incident.getRootType().ifPresent(
				rt -> dto.setType(fromModelToDtoIncidentType(rt)));

		return dto;
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoIncident(incidentsproject.server.model.incidents.Incident)
	 */
	@Override
	public IncidentDto fromModelToDtoIncident(Incident incident) {

		IncidentDto dto = fromModelToGhostDtoIncident(incident);

		dto.setOperations(fromModelToDtoOperationList(incident.getOperations()));

		return dto;
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromDtoToModelIncident(incidentsproject.dto.incidents.IncidentDto)
	 */
	@Override
	public Incident fromDtoToModelIncident(IncidentDto dto) {

		Incident incident = new Incident();

		incident.setId(dto.getId());
		incident.setOperator(dto.getOperator());
		incident.setPriority(dto.getPriority());
		incident.setState(dto.getState());
		incident.setAddress(dto.getAddress());
		incident.setCreationDate(dto.getCreationDate());
		incident.setDescripcion(dto.getDescripcion());

		if (dto.getType() != null) {
			IncidentType type = new IncidentType();
			type.setPk(new IncidentTypePK(dto.getType().getId(), 0));
			LinkedList<IncidentType> incidentTypes = new LinkedList<IncidentType>();
			incidentTypes.add(type);
			incident.setType(incidentTypes);
		}

		return incident;
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoIncidentList(java.util.List)
	 */
	@Override
	public List<IncidentDto> fromModelToDtoIncidentList(List<Incident> incidents) {

		return incidents.stream().map(this::fromModelToGhostDtoIncident)
				.collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoOperation(incidentsproject.server.model.incidents.Operation)
	 */
	@Override
	public OperationDto fromModelToDtoOperation(Operation operation) {

		OperationDto dto = new OperationDto();
		dto.setId(operation.getId());
		dto.setIncidentId(operation.getIncidentId());
		dto.setDate(operation.getDate());
		dto.setOperationId(operation.getOperationId());
		dto.setOperator(operation.getOperator());
		dto.setParameters(operation.getParameters());

		return dto;
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoOperationList(java.util.List)
	 */
	@Override
	public List<OperationDto> fromModelToDtoOperationList(
			List<Operation> operations) {

		return operations.stream().map(this::fromModelToDtoOperation)
				.collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoIncidentType(incidentsproject.server.model.incidents.IncidentType)
	 */
	@Override
	public IncidentTypeDto fromModelToDtoIncidentType(IncidentType incidentType) {
		IncidentTypeDto dto = new IncidentTypeDto();
		dto.setId(incidentType.getPk().getServiceId());
		dto.setTypeName(incidentType.getTypeName());

		return dto;
	}

	/* (non-Javadoc)
	 * @see incidentsproject.server.mapper.incidents.IncidentsMapper#fromModelToDtoIncidentsTypeList(java.util.List)
	 */
	@Override
	public List<IncidentTypeDto> fromModelToDtoIncidentsTypeList(
			List<IncidentType> incidentTypes) {
		return incidentTypes.stream().map(this::fromModelToDtoIncidentType)
				.collect(Collectors.toList());
	}

}
