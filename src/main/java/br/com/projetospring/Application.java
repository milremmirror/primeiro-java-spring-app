package br.com.projetospring;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;


@SpringBootApplication
@ComponentScan("br.com.projetospring.controller")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /* Registra o JFS e mapeia o arquivo xhmtl em .jr */
    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        registration.addUrlMappings("*.jr");
        return registration;
    }

    /* Mapeia o contexto do servlet, força o parâmetro e tema */
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "redmond");
        };
    }

    /* configura os bits inicializados */
    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    /* biblioteca de comunicação REST*/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
