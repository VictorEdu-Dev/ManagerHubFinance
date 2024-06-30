package org.vedu.managerhubfinance.controller.config;

import java.util.Set;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpServlet;

public class ContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        if (c != null) {
            for (Class<?> clazz : c) {
                String servletName = clazz.getName();
                ServletRegistration.Dynamic registration = ctx
                		.addServlet(servletName,
                		clazz.asSubclass(HttpServlet.class));
                registration.addMapping("/" + servletName);
            }
        }
    }
}
