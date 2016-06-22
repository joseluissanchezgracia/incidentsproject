package incidentsproject.dto.incidents;

import java.io.Serializable;

/**
 * Clase DTO conteniendo informacion del tipo de incidente. Por ejemplo tipo
 * ATRACO A MANO ARMADA. Usada para el intercambio de informacion entre el
 * servidor y los posibles clientes de informacion de Incidentes
 * 
 * @author jlsanchez
 *
 */
public class IncidentTypeDto implements Serializable {

	// UID generado para serializacion
	private static final long serialVersionUID = 7619262602249219546L;

	// Identificador del tipo de incidente
	protected Integer id;

	// Nombre del tipo de incidente
	private String typeName;

	/**
	 * Constructor sin argumentos requerido para conversion JSON
	 */
	public IncidentTypeDto() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Identificador del tipo de incidente
	 * @param typeName
	 *            Nombre del tipo de incidente
	 */
	public IncidentTypeDto(Integer id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	/**
	 * @return Identificador del tipo de incidente
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            Identificador del tipo de incidente
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Nombre del tipo de incidente
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName
	 *            Nombre del tipo de incidente
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tipo de incidente [ ID='" + getId() + "', nombre='"
				+ getTypeName() + "']";
	}

}
