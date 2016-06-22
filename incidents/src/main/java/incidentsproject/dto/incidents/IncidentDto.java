package incidentsproject.dto.incidents;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase DTO conteniendo informacion del estado de un Incidente. Usada para el
 * intercambio de informacion entre el servidor y los posibles clientes de
 * informacion de Incidentes
 * 
 * @author jlsanchez
 *
 */
public class IncidentDto implements Serializable {

	// UID generado para serializacion
	private static final long serialVersionUID = 8443984356233582159L;

	// Identificador del Incidente
	protected Integer id;

	// Prioridad del incidente
	private Integer priority;

	// Estado del incidente.
	private Integer state;

	private Date creationDate;

	// Operador que creo el incidente en primera instancia
	private String operator;

	// Direccion donde ha ocurrido un incidente
	private String address;

	// Descripcion de lo ocurrido en el incidente
	private String descripcion;

	// Tipo del Incidente
	private IncidentTypeDto type;

	// Lista de operaciones que auditan Incidente
	private List<OperationDto> operations = new LinkedList<OperationDto>();

	/**
	 * Constructor sin argumentos requerido para conversion JSON
	 */
	public IncidentDto() {
	}

	/**
	 * Constructor
	 * 
	 * @param priority
	 *            Prioridad del incidente
	 * @param state
	 *            Estado del Incidente
	 * @param operator
	 *            Operador que creo el incidente
	 * @param address
	 *            Direccion del Incidente
	 * @param descripcion
	 *            Descripcion detallada de lo ocurrido en el Incidente
	 */
	public IncidentDto(Integer priority, Integer state, String operator,
			String address, String descripcion, Date creationDate) {
		super();
		this.priority = priority;
		this.state = state;
		this.operator = operator;
		this.address = address;
		this.descripcion = descripcion;
		this.creationDate = creationDate;
	}

	/**
	 * @return id del incidente
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            id del incidente
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return prioridad del incidente
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            prioridad del incidente
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return estado del incidente
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            estado del incidente
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return fecha de creacion del incidente
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            fecha de creacion del incidente
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return operador que creo el incidente
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            operador que creo el incidente
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return direccion del incidente
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            direccion del incidente
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return descripcion detallada del incidente
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            descripcion detallada del incidente
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve un conjunto read-only de las operaciones auditadas del
	 * incidente.
	 * 
	 * @return operaciones del incidente
	 */
	public List<OperationDto> getOperations() {
		return Collections.unmodifiableList(operations);
	}

	/**
	 * Resetea y asigna un nuevo conjunto de operaciones auditadas al incidente
	 * 
	 * @param operation
	 *            conjunto de operaciones auditadas del incidente
	 */
	public void setOperations(List<OperationDto> operation) {
		for (OperationDto o : operation) {
			this.operations.add(o);
		}
	}

	/**
	 * Añade una operacion auditada al incidente
	 * 
	 * @param operation
	 *            operacion auditada del incidente
	 */
	public void addOperation(OperationDto operation) {
		operations.add(operation);
	}

	/**
	 * @return tipo primario del incidente
	 * 
	 */
	public IncidentTypeDto getType() {
		return type;
	}

	/**
	 * @param type
	 *            tipo primario del incidente
	 */
	public void setType(IncidentTypeDto type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Incidente [ ID='" + getId() + "', prioridad='" + getPriority()
				+ "', estado='" + getState() + "', fecha creacion='"
				+ getCreationDate() + "', operador='" + getOperator()
				+ "', direccion='" + getAddress() + "' descripcion='"
				+ getDescripcion() + "' tipo='" + getType()
				+ "']\n  Operaciones = " + getOperations();
	}

}
