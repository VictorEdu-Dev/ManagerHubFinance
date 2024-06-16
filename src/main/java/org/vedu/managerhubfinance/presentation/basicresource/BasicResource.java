package org.vedu.managerhubfinance.presentation.basicresource;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.service.basic.BasicService;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/basic")
public class BasicResource implements Serializable {
	private static final long serialVersionUID = -8123149342539582297L;
	private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	@EJB
    BasicService basicService;
    
    @GET
    @Path("/cep/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findCityNameByCep(@PathParam("id") String cep) {
        logger.info("Getting city by cep " + cep);
        return basicService.getCityName(cep)
            .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
    
    @GET
    @Path("/state/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer findStateCodeByName(@PathParam("id") String name) {
        logger.info("Getting state code by name " + name);
        return basicService.getStateCode(name)
            .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
    
    
    @GET
    @Path("/address/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> findAddressInfo(@PathParam("id") String cep) {
        logger.info("Getting address info by cep " + cep);
        return basicService.getAddressInfo(cep)
            .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }
}
