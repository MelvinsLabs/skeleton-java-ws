/*
 *
 */

package me.melvins.labs.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import javax.servlet.*;
import java.io.IOException;

import static me.melvins.labs.constants.LoggingConstants.CID;

/**
 * @author Mels
 */
public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(LoggingFilter.class,
            new MessageFormatMessageFactory());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Initializing LoggingFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        ThreadContext.put(CID.name(), "TODO"); // TODO

        LOGGER.debug("Beginning Actual Request Processing");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.debug("Ending Actual Request Processing");

        ThreadContext.clearAll();
    }

    @Override
    public void destroy() {
        ThreadContext.clearAll();
    }
}
