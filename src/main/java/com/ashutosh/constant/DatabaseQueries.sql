-- Insert a user (Admin)
INSERT INTO Users (id, userName, password, emailId, phoneNumber, role)
VALUES ('user1', 'adminUser', 'adminPass', 'admin@example.com', '1234567890', 'Admin');

-- Insert a user (Tutor)
INSERT INTO Users (id, userName, password, emailId, phoneNumber, role)
VALUES ('user2', 'tutorUser', 'tutorPass', 'tutor@example.com', '0987654321', 'Tutor');

-- Insert a user (Student)
INSERT INTO Users (id, userName, password, emailId, phoneNumber, role)
VALUES ('user3', 'studentUser', 'studentPass', 'student@example.com', '1122334455', 'Student');

-- Insert a tutor
INSERT INTO Tutors (tutorId, userId, aadharCardNumber, imageURL)
VALUES ('tutor1', 'user2', '123412341234', 'http://example.com/tutor1.png');

-- Insert a student
INSERT INTO Students (studentId, userId)
VALUES ('student1', 'user3');

-- Insert Features
USE BookMyStudySession;
-- Insert Features
INSERT INTO Features (featureName)
VALUES ('Live 1:1 Tutoring'),
       ('Notes'),
       ('Practice Tests'),
       ('Doubt-Chat Support'),
       ('Flexible Timings'),
       ('Session Recordings'),
       ('Discussion Forums' ),
       ('Group Discussions'),
       ('Materials List'),
       ('Writing Prompts'),
       ('Virtual Whiteboard'),
       ('Feedback Sessions'),
       ('Group Projects');


-- Insert a Session
INSERT INTO Sessions (tutorId, name, classLevel, subject, duration, price, rating, bookings, imageURL, previewVideoURL)
VALUES ('tutor1', 'Mathematics Mastery', 10, 'Mathematics', 60, 499.99, 4.7, 5, 'http://example.com/session1.png', 'http://example.com/video1.mp4');

-- Link session to topics (Algebra for class 10 Mathematics)
INSERT INTO SessionTopics (sessionId, topicId)
VALUES (1, 1); -- sessionId 1 is linked to topicId 1 (Algebra)

-- Link session to subtopics (Linear Equations, Quadratic Equations for Algebra)
INSERT INTO SessionSubTopics (sessionId, subTopicId)
VALUES (1, 1), -- Linear Equations
       (1, 2); -- Quadratic Equations
-- Link session to features (Live 1:1 Tutoring, Notes)
INSERT INTO SessionFeatures (sessionId, featureId)
VALUES (1, 1), -- Live 1:1 Tutoring
       (1, 2); -- Notes


-- Insert a review by a student for a session
INSERT INTO Reviews (studentId, tutorId, sessionId, comment, rating, createdAt, updatedAt)
VALUES ('student1', 'tutor1', 1, 'Excellent session, learned a lot!', 5, NOW(), NOW());


-- Insert a booking made by a student for a session
INSERT INTO Bookings (studentId, sessionId, startingDate, endingDate, paymentStatus)
VALUES ('student1', 1, '2024-09-15', '2024-09-22', TRUE);

