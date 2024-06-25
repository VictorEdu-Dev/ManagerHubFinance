package org.vedu.managerhubfinance.controller.security.interceptors;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationInterceptor implements ContainerRequestFilter {

    private static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authToken = requestContext.getHeaderString("Authorization");

        logger.info("Request intercepted: " + requestContext.getUriInfo().getRequestUri());

//        if (authToken == null || !authToken.equals("Bearer my-secret-token")) {
//            logger.warning("Unauthorized access attempt to: " + requestContext.getUriInfo().getRequestUri());
//            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.").build());
//        }
    }
}

