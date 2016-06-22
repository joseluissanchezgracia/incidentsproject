package incidentsproject.client.controllers.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para gestionar peticiones HTTP a la URL /home, pagina de inicio
 */
@Controller
@RequestMapping(value="/home")
public class WelcomeController {

	/**
	 * Gestiona peticiones HTTP GET para navegar a la pagina de bienvenida
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
}
