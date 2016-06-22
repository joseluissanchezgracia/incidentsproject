package incidentsproject.server.tests;

import static org.junit.Assert.assertTrue;
import incidentsproject.dto.incidents.IncidentDto;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * Test unitario sobre Controller REST de incidentes
 * 
 * @author jlsanchez
 *
 */
public class IncidentsServerTests {

	protected static final String BASE_URL = "http://localhost:8080/incidents-server/admin";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void listIncidents() {
		String url = BASE_URL + "/incidents";
		// Se usa IncidentDto[] para que Jackson sepa como hacer el
		// unmarshalling. De ahi se podra luego convertir a List
		IncidentDto[] incidents = restTemplate.getForObject(url,
				IncidentDto[].class);

		assertTrue(incidents.length >= 0);

	}

}
