package org.hsmak.custom._webOfGlobe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/bar/*") // Not honored by Spring!!
public class RestFilter implements Filter {

    Logger logger = LogManager.getLogger(RestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("RestFilter is invoked");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
