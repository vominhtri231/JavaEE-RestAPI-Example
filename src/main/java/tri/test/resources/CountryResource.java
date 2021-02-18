package tri.test.resources;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tri.test.dto.CountryDto;
import tri.test.manager.CountryManager;

@Path("countries")
public class CountryResource {

    @Inject
    private CountryManager countryManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getAll() {
        return countryManager.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto get(@PathParam("id") Long id) {
        return countryManager.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CountryDto countryDto) {
        try {
            Long id = countryManager.save(countryDto);
            return Response.created(URI.create("/" + id)).build();
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
