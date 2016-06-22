package incidentsproject.server.model.incidents;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad JPA que contiene informacion sobre un tipo de incidente gestionado
 * por un ente policial. Por ejemplo 'ATRACO'.
 * 
 * Los tipos de incidente se organizan jerarquicamente. Por ejemplo un incidente
 * puede ser directamente de tipo ATRACO (relacion de nivel 0 o tipo raiz) y a
 * la vez ser indirectamente DELITO tambien puesto que todos los ATRACOS son a
 * la vez DELITOS
 * 
 * @author jlsanchez
 *
 */
@Entity
@Table(name = "relacion_tiposservicio_servicios_historico")
public class IncidentType {

	@EmbeddedId
	private IncidentTypePK pk;

	@Column(name = "tiposservicio_nombre")
	private String typeName;

	/**
	 * Constructor
	 */
	public IncidentType() {
		this(new IncidentTypePK(0, 0), "");
	}

	/**
	 * Constructor
	 * 
	 * @param pk
	 *            Clave primaria
	 * @param typeName
	 *            Nombre del tipo de incidente
	 */
	public IncidentType(IncidentTypePK pk, String typeName) {
		this.pk = pk;
		this.typeName = typeName;
	}

	/**
	 * @return the pk
	 */
	public IncidentTypePK getPk() {
		return pk;
	}

	/**
	 * @param pk
	 *            the pk to set
	 */
	public void setPk(IncidentTypePK pk) {
		this.pk = pk;
	}

	/**
	 * @return Nombre del tipo de incidente
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param serviceType
	 *            Nombre del tipo de incidente
	 */
	public void setServiceType(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Clase para contener la clave primaria compuesta de un tipo de incidente
	 * 
	 * @author jlsanchez
	 *
	 */
	@Embeddable
	public static class IncidentTypePK implements Serializable {

		// UID para serializacion
		private static final long serialVersionUID = 1L;

		@Column(name = "idServicio")
		private Integer serviceId;

		@Column(name = "nivel")
		private Integer level;

		/**
		 * Constructor
		 */
		public IncidentTypePK() {

		}

		/**
		 * Constructor
		 * 
		 * @param idServicio
		 *            Identificador del incidente asociado a este tipo
		 * @param nivel
		 *            de la relacion entre el incidente y su tipo de incidente
		 *            en la jerarquia de tipos. La relacion directa es un nivel
		 *            0
		 */
		public IncidentTypePK(Integer idServicio, Integer nivel) {
			this.serviceId = idServicio;
			this.level = nivel;
		}

		/**
		 * @return the serviceId
		 */
		public Integer getServiceId() {
			return serviceId;
		}

		/**
		 * @param serviceId
		 *            the serviceId to set
		 */
		public void setServiceId(Integer serviceId) {
			this.serviceId = serviceId;
		}

		/**
		 * @return the level
		 */
		public Integer getLevel() {
			return level;
		}

		/**
		 * @param level
		 *            the level to set
		 */
		public void setLevel(Integer level) {
			this.level = level;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			IncidentTypePK pk = (IncidentTypePK) o;
			return Objects.equals(serviceId, pk.serviceId)
					&& Objects.equals(level, pk.level);
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return Objects.hash(serviceId, level);
		}
	}
}
