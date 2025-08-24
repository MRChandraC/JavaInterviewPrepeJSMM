import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

//  Marks this class as a source of bean definitions
@Configuration
@EnableScheduling   // Enables @Scheduled tasks
@EnableAsync        // Enables @Async support
@PropertySource("classpath:application.properties") // Load custom property file
public class AppConfig {

    /*
     * @Bean
     * --------------------
     * - Declares a Spring-managed bean
     * - By default, Singleton scope
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
     * @Value
     * --------------------
     * - Injects values from properties file
     * - Can also use SpEL (Spring Expression Language)
     */
    @Value("${app.name:HotelBookingApp}") // Default = "HotelBookingApp" if not found
    private String appName;

    @Bean
    public String printAppName() {
        System.out.println("Loaded Application Name: " + appName);
        return appName;
    }

    /*
     * @Scope
     * --------------------
     * - Defines bean scope
     * - Types: singleton (default), prototype, request, session
     */
    @Bean
    @Scope("prototype")
    public String prototypeBean() {
        return "I am a prototype bean, new instance every time!";
    }
}
