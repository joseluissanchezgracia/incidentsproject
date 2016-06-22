package incidentsproject.dto.incidents;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase DTO conteniendo informacion de una operacion auditada del incidente.
 * Por ejemplo la operación de creacion del incidente. Usada para el intercambio
 * de informacion entre el servidor y los posibles clientes de informacion de
 * Incidentes
 * 
 * @author jlsanchez
 *
 */
public class OperationDto implements Serializable {

	// UID generado para serializacion
	private static final long serialVersionUID = -699993089311177507L;

	// Identificador de la operacion
	protected Integer id;

	// Identificador del incidente asociado a la operacion
	private Integer incidentId;

	// Identificador del tipo de operacion
	private Integer operationId;

	// Operador que realizo la operacion
	private String operator;

	// Fecha y hora en la que se realizo la operacion
	private Date date;

	// Parametros e info de la operacion
	private String parameters;

	/**
	 * Constructor sin argumentos requeridos para conversion JSON
	 */
	public OperationDto() {
	}

	/**
	 * Constructor
	 * 
	 * @param incidentId
	 *            Identificador del incidente asociado a la operacion
	 * @param idOperacion
	 *            Identificador del tipo de operacion
	 * @param operator
	 *            Operador que realizo la operacion
	 * @param date
	 *            Fecha en la que se realizo la operacion
	 * @param parameters
	 *            Parametros e info de la operacion
	 */
	protected OperationDto(Integer incidentId, Integer idOperacion,
			String operator, Date date, String parameters) {
		super();
		this.incidentId = incidentId;
		this.operationId = idOperacion;
		this.operator = operator;
		this.date = date;
		this.parameters = parameters;
	}

	/**
	 * @return Identificador de la operacion
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            Identificador de la operacion
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Identificador del Incidente asociado a la operacion
	 */
	public Integer getIncidentId() {
		return incidentId;
	}

	/**
	 * @param incidentId
	 *            Identificador del Incidente asociado a la operacion
	 */
	public void setIncidentId(Integer incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return Identificador del tipo de operacion
	 */
	public Integer getOperationId() {
		return operationId;
	}

	/**
	 * @param operationId
	 *            Identificador del tipo de operacion
	 */
	public void setOperationId(Integer idOperacion) {
		this.operationId = idOperacion;
	}

	/**
	 * @return Operador que realizo la operacion
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            Operador que realizo la operacion
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return Fecha en la que se realizo la operacion
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            Fecha en la que se realizo la operacion
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return Parametros e info de la operacion
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            Parametros e info de la operacion
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operacion [ ID='" + getId() + "', incidente='"
				+ getIncidentId() + "', tipo operacion='" + getOperationId()
				+ "', fecha='" + getDate() + "', operador='" + getOperator()
				+ "', parameters='" + getParameters() + "']";
	}

}
