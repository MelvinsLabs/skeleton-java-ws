/*
 * 
 */

package me.melvins.labs.config;

import me.melvins.labs.logging.LoggingFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author Mels
 */
public class WebConfig implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);

        createDispatcherServlet(servletContext, ctx);

        createLoggingFilter(servletContext);
    }

    private void createDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx) {

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }

    private void createLoggingFilter(ServletContext servletContext) {

        FilterRegistration.Dynamic logging = servletContext.addFilter("logging", new LoggingFilter());

        EnumSet<DispatcherType> dispatcherTypeEnumSet = EnumSet.of(DispatcherType.REQUEST);
        logging.addMappingForServletNames(dispatcherTypeEnumSet, true, "dispatcher");
    }

}
