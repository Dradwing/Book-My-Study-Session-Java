package com.ashutosh.app;

/**
 * Hello world!
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashutosh.business.*;
import com.ashutosh.DAO.*;
import com.ashutosh.restController.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainApplication extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");


        StudentDAO studentDAO = new StudentDAO();
        TutorDAO tutorDAO = new TutorDAO();
        BookingDAO bookingDAO = new BookingDAO();
        ReviewDAO reviewDAO = new ReviewDAO();
        SessionDAO sessionDAO = new SessionDAO();

        StudentService studentService = new StudentService(studentDAO);
        TutorService tutorService = new TutorService(tutorDAO);
        SessionService sessionService=new SessionService(sessionDAO);


        e.jersey().register(new StudentController(studentService));
        e.jersey().register(new TutorController(tutorService));
        e.jersey().register(new SessionController(sessionService));
        System.out.println("HERE");
    }

    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }


}