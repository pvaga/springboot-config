# *SpringBoot Configuration Details*

## Profiles
	By default 'Default' profile will be active, in application.properties file if we provide 'spring.profiles.active' value then this profile will be loaded to start SpringBoot application.
	
## Externalize property file
	If we place application.property file in the same path as Jar, SpringBoot will use that property file to start the application.
	Below command from JAR path will start SpringBoot application with externalize application property file.
	
	>java -jar testing-web-0.0.1-SNAPSHOT.jar
	
## Command line property for application
   Below command will use property value provided in command line, this command value will override default value.
   
   > java -jar testing-web-0.0.1-SNAPSHOT.jar --app.description="Welcome to command line property application"
   
## Default value for property value injection
	If "app.description" property value is not available then spring boot will use "default value" as value to load application.
	@Value("${app.description: default value}")
	
## MVN Commad
	> mvn install -DskipTests : Skips test for build