package org.hsmak.custom.app.configOfGlobe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/foo/*") // Not honored by Spring!!
public class MvcFilter implements Filter {

    Logger logger = LogManager.getLogger(MvcFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MvcFilter is invoked");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
