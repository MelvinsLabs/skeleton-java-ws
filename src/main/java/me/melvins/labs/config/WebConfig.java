/*
 * 
 */

package me.melvins.labs.config;

import me.melvins.labs.logging.LoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author Mels
 */
public class WebConfig implements WebApplicationInitializer {

    private static final Logger LOGGER = LogManager.getLogger(WebConfig.class, new MessageFormatMessageFactory());

    public static final String DISPATCHER = "dispatcher";

    public static final String LOGGING = "logging";

    public void onStartup(ServletContext servletContext) throws ServletException {

        LOGGER.info("------- WebConfig Startup -------");

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);

        createDispatcherServlet(servletContext, ctx);

        createLoggingFilter(servletContext);
    }

    private void createDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx) {

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }

    private void createLoggingFilter(ServletContext servletContext) {

        FilterRegistration.Dynamic logging = servletContext.addFilter(LOGGING, new LoggingFilter());

        EnumSet<DispatcherType> dispatcherTypeEnumSet = EnumSet.of(DispatcherType.REQUEST);
        logging.addMappingForServletNames(dispatcherTypeEnumSet, true, DISPATCHER);
    }

}
