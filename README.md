"#incidentsproject"

Simple example of frontend client application and backend REST application using Spring MVC 4.2 - Hibernate - Maven - Bootstrap.

Build process:
- Clone or download source code
- Open Spring Tool Suite (Eclipse)
- Select proper JDK as default JRE
- Import "Existing Maven Projects" and select incidentsproject root folder
- In the parent project (incidents-project-parent) execute Maven build -> mvn clean install
- Get/install a MySQL Server
- Unzip with 7zip the database script located in incidents-server\basedatos
- Populate database with script
- Change, if needed, connection parameters in config.properties file inside incidents-server project
- Change, if needed, connection URL in config.properties file inside incidents-client project
- Deploy both projects (client and server) in a Tomcat server i.e.
- Browse http://localhost:8080/incidents-client
