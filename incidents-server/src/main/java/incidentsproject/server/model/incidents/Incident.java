package incidentsproject.server.model.incidents;

import static incidentsproject.server.model.incidents.IncidentConstans.TIPO_SERVICIO_ROOT;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad JPA que contiene informacion sobre un incidente gestionado por un
 * ente policial
 * 
 * @author jlsanchez
 *
 */
@Entity
@Table(name = "servicios_historico")
public class Incident {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "prioridad")
	private Integer priority;

	@Column(name = "estado")
	private Integer state;

	@Column(name = "fechaCreacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date creationDate;

	@Column(name = "operador")
	private String operator;

	@Column(name = "direccion")
	private String address;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
	private List<IncidentType> type = new LinkedList<IncidentType>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
	private List<Operation> operations = new LinkedList<Operation>();

	/**
	 * Constructor sin argumentos requerido por JPA
	 */
	public Incident() {
	}

	/**
	 * Constructor con campos
	 * 
	 * @param priority
	 * @param state
	 * @param operator
	 * @param address
	 * @param descripcion
	 */
	public Incident(Integer priority, Integer state, String operator,
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
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the type
	 */
	public List<IncidentType> getType() {
		return type;
	}

	/**
	 * Devuelve el tipo de incidente raiz. Un incidente pertenece a una
	 * jerarquia de tipos de incidente y con este metodo se obtiene el raiz o
	 * tipo de incidente al que pertenece directamente dicho incidente
	 * 
	 * @return root type
	 */
	public Optional<IncidentType> getRootType() {
		type.stream().filter(t -> t.getPk().getLevel() == 0);
		return getType().stream()
				.filter(t -> t.getPk().getLevel() == TIPO_SERVICIO_ROOT)
				.findFirst();
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(List<IncidentType> type) {
		this.type = type;
	}

	/**
	 * Devuelve un conjunto read-only de las operaciones del incidente.
	 * 
	 * @return operaciones del incidente
	 */
	public List<Operation> getOperations() {
		return Collections.unmodifiableList(operations);
	}

	/**
	 * @param operations
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	/**
	 * @param operation
	 */
	public void addOperation(Operation operation) {
		operations.add(operation);
	}

	/**
	 * @param operations
	 */
	public void addOperations(List<Operation> operations) {
		this.operations.addAll(operations);
	}

}
