/**
 * 
 */
package incidentsproject.server.model.incidents;

import java.util.List;

/**
 * Interfaz para construir operaciones de incidentes
 * 
 * @author jlsanchez
 *
 */
public interface OperationsFactory {

	/**
	 * A partir de los campos modificados sobre un incidente, los no nulos, en
	 * una operacion de modificacion concreta del incidente, calcula el conjunto
	 * de operaciones derivadas
	 * 
	 * @param incident
	 *            Incidente conteniendo informacion relativa a una modificacion
	 *            concreta de los campos de una entidad incidente
	 * @return Lista de operacione derivadas
	 */
	public List<Operation> buildOperations(Incident incident);
}
