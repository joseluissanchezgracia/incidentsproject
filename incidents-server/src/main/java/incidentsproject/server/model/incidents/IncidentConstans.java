package incidentsproject.server.model.incidents;


/**
 * Constantes de Incidentes
 * 
 * @author jlsanchez
 *
 */
public interface IncidentConstans {

	// Estados del incidente
	public final static int PENDIENTE = 1;
	public final static int ASIGNADO = 2;
	public final static int EN_DESPLAZAMIENTO = 3;
	public final static int ATENDIENDOSE = 4;
	public final static int ATENDIDO = 5;
	public final static int CERRADO = 0;
	
	// Nivel root de tipos de incidente
	public final static int TIPO_SERVICIO_ROOT = 0;
}
