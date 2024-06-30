package org.vedu.managerhubfinance.controller.financialblockresource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinPaymentLaunch;
import org.vedu.managerhubfinance.service.finance.PaymentLaunchService;

import jakarta.ejb.EJB;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/accounts-payable")
public class AccountsPayable {
    
    private static final Logger logger = Logger.getLogger(AccountsPayable.class.getName());

    @EJB
    private PaymentLaunchService<String, FinPaymentLaunch> paymentLaunchService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountPayable(@PathParam("id") @NotBlank String id) {
        logger.log(Level.INFO, "Received request to list account payable with id: {0}", id);
        try {
            FinPaymentLaunch result = paymentLaunchService.findBySourceDocumentsId(id);
            if (result == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Account payable not found for id: " + id)
                        .build();
            }
            return Response.ok(result).build();
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Invalid ID: " + id, e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Id cannot be null or empty")
                    .build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while processing request for id: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setAccountPayable(FinPaymentLaunch finPaymentLaunch) {
        try {
        	if(finPaymentLaunch != null) {
        		paymentLaunchService.registerAccountPayable(finPaymentLaunch);
        		return Response
        				.ok(finPaymentLaunch, MediaType.APPLICATION_JSON)
        				.build();
        	} else {
        		logger.log(Level.SEVERE, "Error registering account payable: Entity is null");
        	}
			return Response
					.status(Response.Status.BAD_REQUEST)
					.entity("Entity cannot be null")
					.build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error registering account payable: {0}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccountPayable(FinPaymentLaunch finPaymentLaunch) {
        try {
        	if(finPaymentLaunch != null) {
        		paymentLaunchService.updateAccountPayable(finPaymentLaunch);
        		return Response
        				.ok(finPaymentLaunch, MediaType.APPLICATION_JSON)
        				.build();
        	} else {
        		logger.log(Level.SEVERE, "Error updating account payable: Entity is null");
        	}
        	return Response.status(Response.Status.BAD_REQUEST)
        			.entity("Entity cannot be null")
        			.build();
        	} catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating account payable: {0}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred")
                    .build();
        	}
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAccountPayable(FinPaymentLaunch finPaymentLaunch) {
		try {
			if (finPaymentLaunch != null) {
				paymentLaunchService.deleteAccountPayable(finPaymentLaunch);
				return Response.ok(finPaymentLaunch, MediaType.APPLICATION_JSON).build();
			} else {
				logger.log(Level.SEVERE, "Error deleting account payable: Entity is null");
			}
			return Response.status(Response.Status.BAD_REQUEST).entity("Entity cannot be null").build();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error deleting account payable: {0}", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An unexpected error occurred")
					.build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAccountPayable() {
		try {
			return Response
					.ok(paymentLaunchService
							.listAccountPayable())
					.build();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error listing accounts payable: {0}", e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An unexpected error occurred")
					.build();
		}
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAccountPayable(@PathParam("filters") @NotBlank String filters) {
		Map<String, Object> filter = new HashMap<>();
		filter.put("filters", filters);
		try {
			return Response
					.ok(paymentLaunchService
							.listAccountPayable(filter))
					.build();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error listing accounts payable: {0}", e.getMessage());
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("An unexpected error occurred")
					.build();
		}
	}
}
