/*
 *
 */

package me.melvins.labs.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static me.melvins.labs.constants.LoggingConstants.CID;

/**
 * {@link Filter} implementation for Logging to inject each Request identifiers in the Logs.
 *
 * @author Mels
 */
public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(LoggingFilter.class,
            new MessageFormatMessageFactory());

    /**
     * Overriding {@code init} implementation of the Filter.
     *
     * @param filterConfig Filter Configuration.
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Initializing LoggingFilter");
    }

    /**
     * <p>
     * Overriding {@code doFilter} implementation of the Filter.
     * </p>
     * <p>
     * This implementation injects Request identifier into the Logging Thread Context.
     * </p>
     *
     * @param servletRequest  the ServletRequest.
     * @param servletResponse the ServletResponse.
     * @param filterChain     the filterChain of the Chain of Responsibility Design Pattern.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        ThreadContext.put(CID.name(), httpServletRequest.getHeader("CorrelationId"));

        LOGGER.debug("Beginning Actual Request Processing");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.debug("Ending Actual Request Processing");

        ThreadContext.clearAll();
    }

    /**
     * Overriding the {@code destroy} implemenation to clear the Thread Context.
     */
    @Override
    public void destroy() {
        ThreadContext.clearAll();
    }

}
