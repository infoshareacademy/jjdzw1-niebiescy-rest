package niebiescy.rest.servlets;


import niebiescy.rest.dao.SearchStringDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class StatisticsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsServlet.class);


    @Inject
    SearchStringDao searchStringDao;





    @GET
    @Path("/add/{string}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveEvent(@PathParam("string") String string) {

        LOGGER.info("Pobrano dane : ".concat(string));

        searchStringDao.saveEvent(string);


        return Response.ok("zapisano dane").build();

    }
}
