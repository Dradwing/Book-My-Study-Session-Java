package com.ashutosh.restController;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ashutosh.bean.Tutor;
import com.ashutosh.business.StudentService;
import com.ashutosh.bean.Student;
import com.ashutosh.business.TutorService;


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    @Path("/add")
    public Response addStudent(Student student) {
        Student createdStudent = studentService.addStudent(student);
        return Response.status(Response.Status.CREATED).entity(createdStudent).build();
    }
}
