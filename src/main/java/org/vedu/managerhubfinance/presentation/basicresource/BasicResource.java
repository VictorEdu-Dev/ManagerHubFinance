package org.vedu.managerhubfinance.service.basic;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.repository.base.impl.CepDAOImpl;

import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ceps")
public class BasicResource {
    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private CepDAOImpl cepDAO;

    @GET
    @Path("/get-employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cep findCep(@PathParam("id") String id) {
        logger.info("Getting coffee by id " + id);
        return cepDAO.findSingleEntity(id)
            .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    public List<Cep> findAll() {
        logger.info("Getting all coffee");
        return cepDAO.findListEntity();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Cep create(Cep cep) {
        logger.info("Creating coffee " + cep.getCep());
        try{
        	cepDAO.save(cep);
            return cep;
        }catch (PersistenceException ex){
            logger.info("Error creating coffee " + cep.getCep());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        logger.info("Deleting coffee by id " + id);
        try{
            cepDAO.makeTransientById(String.valueOf(id));
        }catch (IllegalArgumentException e){
            logger.info("Error deleting coffee by id " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }


    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Cep update(Cep cep) {
        logger.info("Updating coffee " + cep.getCep());
        try{
        	cepDAO.makePersistent(cep);
            return cep;
        }catch (PersistenceException ex){
            logger.info("Error updating coffee " + cep.getCep());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
