package com.ashutosh.business;

import com.ashutosh.DAO.TutorDAO;

import com.ashutosh.bean.Tutor;
import com.ashutosh.bean.User;

import java.util.*;

public class TutorService extends UserService {

    private final TutorDAO tutorDAO;

    public TutorService(TutorDAO tutorDAO){
        this.tutorDAO = tutorDAO;
    }

    public Tutor addTutor(Tutor tutor) {

        User tutorUser =new User();

        tutorUser.setEmailId(tutor.getEmailId());
        tutorUser.setPassword(tutor.getPassword());
        tutorUser.setPhoneNumber(tutor.getPhoneNumber());
        tutorUser.setUserName(tutor.getUserName());
        tutorUser.setRole(User.Role.Tutor);
        tutor.setRole(User.Role.Tutor);

        return tutorDAO.addTutor(tutorUser, tutor);
    }

    public List<Tutor> getAllTutors() {
        return tutorDAO.findAllTutors();
    }

    public Tutor getTutorById(int tutorId) {
        return tutorDAO.findTutorById(tutorId);
    }

    public Tutor updateTutor(Tutor tutor) {
        return tutorDAO.updateTutor(tutor);
    }

}
