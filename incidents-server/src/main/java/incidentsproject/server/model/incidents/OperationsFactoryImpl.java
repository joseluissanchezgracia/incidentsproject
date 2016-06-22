package incidentsproject.server.model.incidents;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static incidentsproject.server.model.incidents.OperationConstants.*;

/**
 * Implementacion del Factory de Operaciones de Incidentes
 * 
 * @author jlsanchez
 *
 */
@Component
public class OperationsFactoryImpl implements OperationsFactory {

	//TODO jlsanchez Obtener nombre de operador de usuario registrado en sesion
	@Value("${operations.defaultOperator}")
	private String defaultOperatorName;
	
	/* (non-Javadoc)
	 * @see incidentsproject.server.model.incidents.OperationsFactory#buildOperations(incidentsproject.server.model.incidents.Incident)
	 */
	@Override
	public List<Operation> buildOperations(Incident incident) {
		// Se introduce la fecha del sistema como fecha de las operaciones
		Date operationDate = new Date();

		// TODO Obtener operador que introduce la operacion

		List<Operation> operations = new LinkedList<>();

		// Se genera una lista de operaciones a registrar segun los campos no
		// nulos del incidente

		// Cambio de tipo de incidente
		if (incident.getRootType().isPresent()) {
			operations.add(new Operation(incident.getId(), TYPE_OF_SERVICE_CHANGE, defaultOperatorName,
					operationDate, incident.getRootType().get().getTypeName()));
		}
		// Cambio de prioridad
		if (incident.getPriority() != null) {
			operations.add(new Operation(incident.getId(), PRIORITY_CHANGE, defaultOperatorName, operationDate,
					incident.getPriority().toString()));
		}
		// Cambio en seccion evento o descripcion
		if (incident.getDescripcion() != null) {
			operations.add(new Operation(incident.getId(), EVENT_SECTION_UPDATE, defaultOperatorName,
					operationDate, ""));
		}
		
		// Se devuelve la lista de operaciones generadas
		return operations;
	}
}
