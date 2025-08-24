//  Step 1: Import required Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of a Spring Boot Application.
 * 
 * How Spring Boot application starts:
 * 1. JVM looks for the main() method as entry point.
 * 2. @SpringBootApplication tells Spring Boot:
 *      - @Configuration → Marks this as a source of bean definitions.
 *      - @EnableAutoConfiguration → Auto configures beans based on classpath (like DataSource, MVC).
 *      - @ComponentScan → Scans the package and sub-packages for @Component, @Service, @Repository, @Controller.
 * 3. SpringApplication.run() → Bootstraps Spring:
 *      - Creates ApplicationContext (IoC container).
 *      - Registers all beans.
 *      - Starts embedded Tomcat (or Jetty/Undertow).
 *      - Application is now ready to serve requests.
 */
@SpringBootApplication  // Combines 3 annotations: @Configuration + @EnableAutoConfiguration + @ComponentScan
public class Main {

    //  JVM entry point
    public static void main(String[] args) {
        // Starts the Spring Boot application
        SpringApplication.run(Main.class, args);

        // This line will be printed only once Spring Boot has started
        System.out.println(" Spring Boot Application Started!");
    }
}


//Interview Answer:
//"Spring Boot application always starts from the main() method, where @SpringBootApplication triggers component scanning and auto-configuration, and SpringApplication.run() starts the IoC container and embedded server