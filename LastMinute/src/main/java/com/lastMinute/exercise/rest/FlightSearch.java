package com.lastMinute.exercise.rest;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lastMinute.exercise.exception.LastMinuteException;
import com.lastMinute.exercise.exception.NotFoundException;
import com.lastMinute.exercise.services.FlightSearchService;

/**
 * Class for implementing the service.
 *
 */
@Path("/flightSearch")
public class FlightSearch implements Serializable {

	private static final long serialVersionUID = 2038343436064008329L;

	@GET
	@Path("/search")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response search(@QueryParam("origin") String origin, @QueryParam("destination") String destination,
			@QueryParam("departureDate") String departureDate, @QueryParam("adults") int adults,
			@QueryParam("children") int children, @QueryParam("infants") int infants) {
		try {
			FlightSearchService service = new FlightSearchService(origin, destination, departureDate, adults, children,
					infants);

			return Response.status(200).entity(String.valueOf(service.execute()))
					.header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN).build();
		} catch (NotFoundException exception) {
			return Response.status(404).build();
		} catch (LastMinuteException exception) {
			// since it is not defined, in case of error, we return an empty 500
			// error
			return Response.status(500).build();
		}
	}
}
