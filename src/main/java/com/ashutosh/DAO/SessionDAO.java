package com.ashutosh.DAO;

import com.ashutosh.bean.Session;
import com.ashutosh.bean.Session.DescriptionContent;
import com.ashutosh.bean.Session.DescriptionContent.Content;

import java.sql.*;
import java.util.*;

public class SessionDAO {

    // Method to add a session to the database
    public Session addSession(Session session) throws SQLException {
        String sessionSql = "INSERT INTO Sessions (name, classLevel, subject, language, duration, price, rating, bookings, imageURL, previewVideoURL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String featureSql = "INSERT INTO SessionFeatures (sessionId, feature) VALUES (?, ?)";
        String topicSql = "INSERT INTO SessionTopics (sessionId, topicId) VALUES (?, ?)";
        String subTopicSql = "INSERT INTO SessionSubTopics (sessionTopicId, subTopicId) VALUES (?, ?)";
        String descriptionSql = "INSERT INTO SessionDescriptions (sessionId, type) VALUES (?, ?)";
        String contentSql = "INSERT INTO DescriptionContent (descriptionId, text, format, href) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = GetConnection.getConnection();
            conn.setAutoCommit(false); // Disable auto-commit for transaction

            // Insert into Sessions table
            PreparedStatement sessionStmt = conn.prepareStatement(sessionSql, Statement.RETURN_GENERATED_KEYS);
            sessionStmt.setString(1, session.getName());
            sessionStmt.setInt(2, session.getClassLevel());
            sessionStmt.setString(3, session.getSubject());
            sessionStmt.setString(4, session.getLanguage());
            sessionStmt.setInt(5, session.getDuration());
            sessionStmt.setDouble(6, session.getPrice());
            sessionStmt.setDouble(7, session.getRating());
            sessionStmt.setInt(8, session.getBookings());
            sessionStmt.setString(9, session.getImageURL());
            sessionStmt.setString(10, session.getPreviewVideoURL());

            sessionStmt.executeUpdate();

            // Get generated sessionId
            ResultSet sessionGeneratedKeys = sessionStmt.getGeneratedKeys();
            if (sessionGeneratedKeys.next()) {
                session.setSessionId(sessionGeneratedKeys.getInt(1));
            }

            // Insert into SessionFeatures table
            PreparedStatement featureStmt = conn.prepareStatement(featureSql);
            for (int featureId : session.getFeatureIds()) {
                featureStmt.setInt(1, session.getSessionId());
                featureStmt.setInt(2, featureId);
                featureStmt.addBatch();
            }
            featureStmt.executeBatch();

            // Insert into SessionTopics and SessionSubTopics tables
            PreparedStatement topicStmt = conn.prepareStatement(topicSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement subTopicStmt = conn.prepareStatement(subTopicSql);
            for (Session.Topic topic : session.getTopics()) {
                topicStmt.setInt(1, session.getSessionId());
                topicStmt.setInt(2, topic.getTopicId());
                topicStmt.executeUpdate();

                ResultSet topicGeneratedKeys = topicStmt.getGeneratedKeys();
                int sessionTopicId = 0;
                if (topicGeneratedKeys.next()) {
                    sessionTopicId = topicGeneratedKeys.getInt(1);
                }

                for (Session.Topic.SubTopic subTopic : topic.getSubTopics()) {
                    subTopicStmt.setInt(1, sessionTopicId);
                    subTopicStmt.setInt(2, subTopic.getSubTopicId());
                    subTopicStmt.addBatch();
                }
                subTopicStmt.executeBatch();
            }

            // Insert into SessionDescription and DescriptionContent tables
            PreparedStatement descriptionStmt = conn.prepareStatement(descriptionSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement contentStmt = conn.prepareStatement(contentSql);
            for (DescriptionContent description : session.getDescription()) {
                descriptionStmt.setInt(1, session.getSessionId());
                descriptionStmt.setString(2, description.getType().name());
                descriptionStmt.executeUpdate();

                ResultSet descriptionGeneratedKeys = descriptionStmt.getGeneratedKeys();
                int descriptionId = 0;
                if (descriptionGeneratedKeys.next()) {
                    descriptionId = descriptionGeneratedKeys.getInt(1);
                }

                for (Content content : description.getContent()) {
                    contentStmt.setInt(1, descriptionId);
                    contentStmt.setString(2, content.getText());
                    contentStmt.setString(3, content.getFormat().name());
                    contentStmt.setString(4, content.getHref());
                    contentStmt.addBatch();
                }
                contentStmt.executeBatch();
            }

            conn.commit(); // Commit the transaction
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Rollback in case of an error
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true); // Re-enable auto-commit
                conn.close();
            }
        }
        return session;
    }

    // Method to get a session by ID
    public Session getSessionById(int sessionId) {
        String sessionSql = "SELECT * FROM Sessions WHERE sessionId = ?";
        String featureSql = "SELECT feature FROM SessionFeatures WHERE sessionId = ?";
        // SQL for getting topics by sessionId
        String topicSql = "SELECT t.topicId, t.topicName, st.sessionTopicId FROM Topics t " +
                "JOIN SessionTopics st ON t.topicId = st.topicId WHERE st.sessionId = ?";

        // SQL for getting subtopics by sessionTopicId
        String subTopicSql = "SELECT sub.subTopicId, sub.subTopicName FROM SubTopics sub " +
                "JOIN SessionSubTopics sst ON sub.subTopicId = sst.subTopicId WHERE sst.sessionTopicId = ?";

        String descriptionSql = "SELECT * FROM SessionDescription WHERE sessionId = ?";
        String contentSql = "SELECT * FROM DescriptionContent WHERE descriptionId = ?";

        Session session = null;

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement sessionStmt = conn.prepareStatement(sessionSql);
             PreparedStatement featureStmt = conn.prepareStatement(featureSql);
             PreparedStatement topicStmt = conn.prepareStatement(topicSql);
             PreparedStatement subTopicStmt = conn.prepareStatement(subTopicSql);
             PreparedStatement descriptionStmt = conn.prepareStatement(descriptionSql);
             PreparedStatement contentStmt = conn.prepareStatement(contentSql)) {

            // Get session details
            sessionStmt.setInt(1, sessionId);
            ResultSet rsSession = sessionStmt.executeQuery();
            if (rsSession.next()) {
                session = new Session();
                session.setSessionId(rsSession.getInt("sessionId"));
                session.setName(rsSession.getString("name"));
                session.setClassLevel(rsSession.getInt("classLevel"));
                session.setSubject(rsSession.getString("subject"));
                session.setLanguage(rsSession.getString("language"));
                session.setDuration(rsSession.getInt("duration"));
                session.setPrice(rsSession.getDouble("price"));
                session.setRating(rsSession.getDouble("rating"));
                session.setBookings(rsSession.getInt("bookings"));
                session.setImageURL(rsSession.getString("imageURL"));
                session.setPreviewVideoURL(rsSession.getString("previewVideoURL"));

                // Get features
                featureStmt.setInt(1, sessionId);
                ResultSet rsFeature = featureStmt.executeQuery();
                List<Integer> featureIds = new ArrayList<>();
                while (rsFeature.next()) {
                    featureIds.add(rsFeature.getInt("featureId"));
                }
                session.setFeatureIds(featureIds);

                // Get topics and subtopics
                topicStmt.setInt(1, sessionId);
                ResultSet rsTopic = topicStmt.executeQuery();

                List<Session.Topic> topics = new ArrayList<>();

                while (rsTopic.next()) {
                    // Create a new Topic object
                    Session.Topic topic = new Session.Topic();
                    topic.setTopicId(rsTopic.getInt("topicId"));
                    topic.setTopicName(rsTopic.getString("topicName"));

                    // Get sessionTopicId for subtopic query
                    int sessionTopicId = rsTopic.getInt("sessionTopicId");

                    // Fetch subtopics for the current topic
                    subTopicStmt.setInt(1, sessionTopicId);
                    ResultSet rsSubTopic = subTopicStmt.executeQuery();

                    List<Session.Topic.SubTopic> subTopics = new ArrayList<>();
                    while (rsSubTopic.next()) {
                        // Create a new SubTopic object
                        Session.Topic.SubTopic subTopic = new Session.Topic.SubTopic();
                        subTopic.setSubTopicId(rsSubTopic.getInt("subTopicId"));
                        subTopic.setSubTopicName(rsSubTopic.getString("subTopicName"));
                        subTopics.add(subTopic);
                    }

                    // Set the subtopics to the current topic
                    topic.setSubTopics(subTopics);
                    topics.add(topic); // Add the topic (with subtopics) to the list
                }

                // Set the topics to the session
                session.setTopics(topics);

                // Get descriptions and content
                descriptionStmt.setInt(1, sessionId);
                ResultSet rsDescription = descriptionStmt.executeQuery();
                List<DescriptionContent> descriptions = new ArrayList<>();
                while (rsDescription.next()) {
                    DescriptionContent description = new DescriptionContent();
                    description.setType(DescriptionContent.ContentType.valueOf(rsDescription.getString("type")));

                    int descriptionId = rsDescription.getInt("descriptionId");
                    contentStmt.setInt(1, descriptionId);
                    ResultSet rsContent = contentStmt.executeQuery();
                    List<Content> contents = new ArrayList<>();
                    while (rsContent.next()) {
                        Content content = new Content();
                        content.setText(rsContent.getString("text"));
                        content.setFormat(Content.Format.valueOf(rsContent.getString("format")));
                        content.setHref(rsContent.getString("href"));
                        contents.add(content);
                    }
                    description.setContent(contents);
                    descriptions.add(description);
                }
                session.setDescription(descriptions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return session;
    }

    // Method to get all sessions
    public List<Session> getAllSessions() {
        List<Session> sessions = new ArrayList<>();
        String sql = "SELECT sessionId FROM Sessions";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sessions.add(getSessionById(rs.getInt("sessionId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    // Method to delete a session by ID
    public void deleteSession(int sessionId) throws SQLException {
        String sessionSql = "DELETE FROM Sessions WHERE sessionId = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sessionSql)) {
            stmt.setInt(1, sessionId);
            stmt.executeUpdate();
        }
    }

    // Method to update session
    public void updateSession(Session session) throws SQLException {
        String sql = "UPDATE Sessions SET name=?, classLevel=?, subject=?, language=?, duration=?, price=?, rating=?, bookings=?, imageURL=?, previewVideoURL=? WHERE sessionId=?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, session.getName());
            stmt.setInt(2, session.getClassLevel());
            stmt.setString(3, session.getSubject());
            stmt.setString(4, session.getLanguage());
            stmt.setInt(5, session.getDuration());
            stmt.setDouble(6, session.getPrice());
            stmt.setDouble(7, session.getRating());
            stmt.setInt(8, session.getBookings());
            stmt.setString(9, session.getImageURL());
            stmt.setString(10, session.getPreviewVideoURL());
            stmt.setInt(11, session.getSessionId());

            stmt.executeUpdate();
        }
    }
}
