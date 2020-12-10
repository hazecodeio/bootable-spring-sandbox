package org.hsmak.custom.app.configOfGlobe;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {
    @Bean
    public FilterRegistrationBean<MvcFilter> mvcFilter() {
        FilterRegistrationBean<MvcFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MvcFilter());
        filterRegistrationBean.setName("MvcFilter");
        filterRegistrationBean.addUrlPatterns("/mvc/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<RestFilter> restFilter() {
        FilterRegistrationBean<RestFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new RestFilter());
        filterRegistrationBean.setName("RestFilter");
        filterRegistrationBean.addUrlPatterns("/rest/*");
        return filterRegistrationBean;
    }
}
