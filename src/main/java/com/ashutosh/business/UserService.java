package com.ashutosh.business;


import com.ashutosh.DAO.UserDAO;

import com.ashutosh.bean.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User getUserById(int userId) {
        return userDAO.findUserById(userId);
    }

    public void registerUser(User user) {
        userDAO.addUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}

