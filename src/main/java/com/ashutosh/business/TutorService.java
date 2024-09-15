package com.ashutosh.business;

import com.ashutosh.DAO.TutorDAO;

import com.ashutosh.bean.Tutor;
import com.ashutosh.bean.User;

public class TutorService {

    private TutorDAO tutorDao=new TutorDAO();
    private SessionService sessionService=new SessionService();

    public Tutor registerTutor(Tutor tutor) {

        User tutorUser =new User();

        tutorUser.setEmailId(tutor.getEmailId());
        tutorUser.setPassword(tutor.getPassword());
        tutorUser.setPhoneNumber(tutor.getPhoneNumber());
        tutorUser.setUserName(tutor.getUserName());
        tutorUser.setRole(User.Role.Tutor);

        tutorDao.addUser(tutorUser);
        return tutorDao.addTutor(tutorUser, tutor);
    }







}
