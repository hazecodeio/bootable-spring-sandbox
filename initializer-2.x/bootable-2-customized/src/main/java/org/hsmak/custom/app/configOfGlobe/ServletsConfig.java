package org.hsmak.custom.app.configOfGlobe;

import org.hsmak.custom.webOfMvc.MvcConfig;
import org.hsmak.custom.webOfRest.RestConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletsConfig {
    @Bean
    public ServletRegistrationBean restServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThreadContextInheritable(true);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        /*XmlWebApplicationContext xmlWebAppCxt = new XmlWebApplicationContext();
        xmlWebAppCxt.setConfigLocation("classpath:/mvc-dispatcher-servlet.xml");*/

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(RestConfig.class); // Set config specific to this DispatcherServlet
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
        servletRegistrationBean.setName("restServlet");
        servletRegistrationBean.setLoadOnStartup(2);
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean mvcServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThreadContextInheritable(true);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        /*XmlWebApplicationContext xmlWebAppCxt = new XmlWebApplicationContext();
        xmlWebAppCxt.setConfigLocation("classpath:/mvc-dispatcher-servlet.xml");*/

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(MvcConfig.class);
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/mvc/*");
        servletRegistrationBean.setName("mvcServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}
