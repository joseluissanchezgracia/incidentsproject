package incidentsproject.server.model.incidents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad JPA que contiene informacion sobre una operacion de un incidente
 * gestionado por un ente policial.
 * 
 * Una operacion es un registro que audita que modificacion se realizo sobre la
 * informacion de un incidente, a que hora y que operador la realizo
 * 
 * @author jlsanchez
 *
 */
@Entity
@Table(name = "operaciones_historico")
public class Operation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "idOperacion")
	private Integer operationId;

	@Column(name = "idServicio")
	private Integer incidentId;

	@Column(name = "operador")
	private String operator;

	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date date;

	@Lob
	@Column(name = "parametros")
	private String parameters;

	/**
	 * Constructor sin argumentos requerido por JPA
	 */
	public Operation() {
	}

	/**
	 * Constructor
	 * 
	 * @param operationId Identificador de la operacion
	 * @param operator Operador que realizo la operacion
	 * @param date Fecha en la que se realizo la operacion
	 * @param parameters Parametros de la operacion
	 */
	protected Operation(Integer incidentId, Integer idOperacion,
			String operator, Date date, String parameters) {
		super();
		this.incidentId = incidentId;
		this.operationId = idOperacion;
		this.operator = operator;
		this.date = date;
		this.parameters = parameters;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the incidentId
	 */
	public Integer getIncidentId() {
		return incidentId;
	}

	/**
	 * @param incidentId
	 *            the incidentId to set
	 */
	public void setIncidentId(Integer incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return the operationId
	 */
	public Integer getOperationId() {
		return operationId;
	}

	/**
	 * @param operationId
	 *            the operationId to set
	 */
	public void setOperationId(Integer idOperacion) {
		this.operationId = idOperacion;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the parameters
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}
