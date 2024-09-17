package com.ashutosh.restController;

import com.ashutosh.bean.Session;
import com.ashutosh.business.SessionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSession(Session session) {
        try {
            Session createdSession = sessionService.addSession(session);
            return Response.status(Response.Status.CREATED).entity(createdSession).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSessionById(@PathParam("id") int sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        if (session != null) {
            return Response.ok(session).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Session not found").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        return Response.ok(sessions).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSession(@PathParam("id") int sessionId, Session session) {
        try {
            Session existingSession = sessionService.getSessionById(sessionId);
            if (existingSession == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Session not found").build();
            }
            session.setSessionId(sessionId);
            sessionService.updateSession(session);
            return Response.ok(session).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    // Endpoint to delete a session
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSession(@PathParam("id") int sessionId) {
        try {
            Session existingSession = sessionService.getSessionById(sessionId);
            if (existingSession == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Session not found").build();
            }
            sessionService.deleteSession(sessionId);
            return Response.ok("Session deleted successfully").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
