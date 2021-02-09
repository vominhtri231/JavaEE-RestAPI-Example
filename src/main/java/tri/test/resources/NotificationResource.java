package tri.test.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import tri.test.manager.HelloManager;

@Path("/notification")
public class NotificationResource {

    @Inject
    private HelloManager helloManager;

    @GET
    public Response ping() {
        String hello = helloManager.getHello();
        return Response.ok().entity(hello).build();
    }
}
