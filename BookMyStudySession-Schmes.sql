CREATE DATABASE BookMyStudySession;
USE BookMyStudySession;
CREATE TABLE Users (
                       userId INT PRIMARY KEY AUTO_INCREMENT,
                       userName VARCHAR(255),
                       password VARCHAR(255),
                       emailId VARCHAR(255),
                       phoneNumber VARCHAR(20),
                       role ENUM('Admin', 'Tutor', 'Student')
);

CREATE TABLE Tutors (
                        tutorId INT PRIMARY KEY,
                        userId INT REFERENCES Users(userId),
                        aadharCardNumber VARCHAR(12),
                        imageURL VARCHAR(255)
);

CREATE TABLE Students (
                          studentId INT PRIMARY KEY,
                          userId INT REFERENCES Users(userId)
);

-- Predefined Topics table
CREATE TABLE Topics (
                        topicId INT PRIMARY KEY AUTO_INCREMENT,
                        classLevel INT,
                        subject VARCHAR(255),
                        topicName VARCHAR(255)
);

-- Predefined Subtopics
CREATE TABLE SubTopics (
                           subTopicId INT PRIMARY KEY AUTO_INCREMENT,
                           topicId INT REFERENCES Topics(topicId),
                           subTopicName VARCHAR(255)
);

-- Predefined Features
CREATE TABLE Features (
                          featureId INT PRIMARY KEY AUTO_INCREMENT,
                          featureName VARCHAR(255)
);

-- Sessions table, referencing predefined Topics and SubTopics
CREATE TABLE Sessions (
                          sessionId INT PRIMARY KEY AUTO_INCREMENT,
                          tutorId INT REFERENCES Tutors(tutorId),
                          name VARCHAR(255),
                          classLevel INT,
                          subject VARCHAR(255),
                          duration INT,
                          price DECIMAL(10, 2),
                          rating DECIMAL(2, 1) DEFAULT 4.5 CHECK (rating >= 1 AND rating <= 5),
                          bookings INT DEFAULT 0,
                          imageURL VARCHAR(255),
                          previewVideoURL VARCHAR(255)
);

-- Many-to-many relationship between Sessions and Topics
CREATE TABLE SessionTopics (
                               sessionId INT REFERENCES Sessions(sessionId),
                               topicId INT REFERENCES Topics(topicId),
                               PRIMARY KEY(sessionId, topicId)
);

-- Many-to-many relationship between Sessions and SubTopics
CREATE TABLE SessionSubTopics (
                                  sessionId INT REFERENCES Sessions(sessionId),
                                  subTopicId INT REFERENCES SubTopics(subTopicId),
                                  PRIMARY KEY(sessionId, subTopicId)
);

-- Many-to-many relationship between Sessions and Features
CREATE TABLE SessionFeatures (
                                 sessionId INT REFERENCES Sessions(sessionId),
                                 featureId INT REFERENCES Features(featureId),
                                 PRIMARY KEY(sessionId, featureId)
);

-- Reviews table
CREATE TABLE Reviews (
                         reviewId INT PRIMARY KEY AUTO_INCREMENT,
                         studentId INT REFERENCES Students(studentId),
                         tutorId INT REFERENCES Tutors(tutorId),
                         sessionId INT REFERENCES Sessions(sessionId),
                         comment TEXT,
                         rating INT CHECK (rating >= 1 AND rating <= 5),
                         createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Bookings table
CREATE TABLE Bookings (
                          bookingId INT PRIMARY KEY AUTO_INCREMENT,
                          studentId INT REFERENCES Students(studentId),
                          sessionId INT REFERENCES Sessions(sessionId),
                          startingDate DATE,
                          endingDate DATE,
                          paymentStatus BOOLEAN DEFAULT FALSE
);
