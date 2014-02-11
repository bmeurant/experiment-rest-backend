package org.experiment;

import javax.servlet.*;

import com.thetransactioncompany.cors.CORSFilter;
import org.h2.server.web.WebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.EnumSet;

/**
 * This class replaces the "old" web.xml and is automatically scanned at the application startup
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.getEnvironment().setActiveProfiles("resthub-jpa", "resthub-web-server");
        String[] locations = { "classpath*:resthubContext.xml", "classpath*:applicationContext.xml" };
        appContext.setConfigLocations(locations);

        FilterRegistration corsFilter = servletContext.addFilter("cors", CORSFilter.class);
        corsFilter.addMappingForUrlPatterns(null, false, "/*");
        corsFilter.setInitParameter("cors.supportedMethods", "OPTIONS, GET, POST, PUT, DELETE, HEAD");
        corsFilter.setInitParameter("cors.supportedHeaders", "Accept, Content-Type");

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        servletContext.addListener(new ContextLoaderListener(appContext));

        //Database Console for managing the app's database (TODO : profile)
        ServletRegistration.Dynamic h2Servlet = servletContext.addServlet("h2console", WebServlet.class);
        h2Servlet.setLoadOnStartup(2);
        h2Servlet.addMapping("/console/database/*");
    }
}
