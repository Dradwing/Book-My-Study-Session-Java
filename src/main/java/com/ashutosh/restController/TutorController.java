package com.ashutosh.restController;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ashutosh.business.TutorService;
import com.ashutosh.bean.Tutor;

@Path("/tutor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TutorController {

    private final TutorService tutorService;

    @Inject
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @POST
    @Path("/add")
    public Response addTutor(Tutor tutor) {
        Tutor createdTutor = tutorService.addTutor(tutor);
        return Response.status(Response.Status.CREATED).entity(createdTutor).build();
    }

    @GET
    @Path("/{tutorId}")
    public Response getTutorById(@PathParam("tutorId") int tutorId) {
        Tutor tutor = tutorService.getTutorById(tutorId);
        if (tutor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(tutor).build();
    }

    @PUT
    @Path("/update")
    public Response updateTutor(Tutor tutor) {
        tutorService.updateTutor(tutor);
        return Response.ok(tutor).build();
    }

    @GET
    @Path("/all")
    public Response getAllTutors() {
        List<Tutor> tutors = tutorService.getAllTutors();
        return Response.ok(tutors).build();
    }
}
