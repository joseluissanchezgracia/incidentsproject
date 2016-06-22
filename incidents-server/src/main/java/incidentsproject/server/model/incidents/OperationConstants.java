package incidentsproject.server.model.incidents;

/**
 * Constantes de Operaciones auditadas de Incidentes
 * 
 * @author jlsanchez
 *
 */
public interface OperationConstants {

	// Identificadores de operaciones
	public final static int SERVICE_OF_TYPE_CREATION = 0;
	public final static int SERVICE_CHANGE_OF_STATUS = 1;
	public final static int SERVICE_CLOSED = 2;
	public final static int SERVICE_FILE_IN_HISTORICAL = 3;
	public final static int TYPE_OF_SERVICE_CHANGE = 4;
	public final static int RESOURCE_ASSIGNATION = 5;
	public final static int RESOURCE_CHANGE_OF_STATUS = 6;
	public final static int RESOURCE_UNASSIGNATION = 7;
	public final static int EVENT_SECTION_UPDATE = 8;
	public final static int CALLER_SECTION_UPDATE = 9;
	public final static int CLOSE_SECTION_UPDATE = 10;
	public final static int SERVICE_GEOGRAPHICAL_POSITION_CHANGE = 11;
	public final static int PARTICIPANT_SECTION_UPDATE = 12;
	public final static int PROCESSING_SECTION_UPDATE = 13;
	public final static int PARTICIPANT_SECTION_DELETION = 14;
	public final static int PROCESSING_SECTION_DELETION = 15;
	public final static int PARTICIPANT_SECTION_ADDITION = 16;
	public final static int PROCESSING_SECTION_ADDITION = 17;
	public final static int PRIORITY_CHANGE = 18;
	public final static int OPERATOR_OBSERVATION = 100;
}
