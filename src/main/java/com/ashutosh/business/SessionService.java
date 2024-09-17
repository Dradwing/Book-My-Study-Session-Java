package com.ashutosh.business;

import com.ashutosh.bean.Session;
import com.ashutosh.DAO.SessionDAO;

import java.sql.SQLException;
import java.util.List;

public class SessionService {

    private SessionDAO sessionDAO;

    public SessionService(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    public Session addSession(Session session) throws SQLException {
        return sessionDAO.addSession(session);
    }

    public Session getSessionById(int sessionId) {
        return sessionDAO.getSessionById(sessionId);
    }

    public List<Session> getAllSessions() {
        return sessionDAO.getAllSessions();
    }

    public void updateSession(Session session) throws SQLException {
        sessionDAO.updateSession(session);
    }

    public void deleteSession(int sessionId) throws SQLException {
        sessionDAO.deleteSession(sessionId);
    }
}
