package org.hsmak.custom.webOfRest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * Unlike MvcDispatcherServlet, RestDispatcherServlet doesn't need com[plex configs of ViewResolver, etc!
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class _RestConfig {
}
