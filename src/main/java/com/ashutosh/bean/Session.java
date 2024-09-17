package com.ashutosh.bean;

import java.util.List;

public class Session {

    // Fields representing the main Session schema
    private int sessionId;
    private int tutorId;  // Added tutorId to match the database schema
    private String name;
    private int classLevel; // "class" is a reserved keyword in Java, so renamed to classLevel
    private String subject;
    private String language;
    private int duration;
    private double price;
    private double rating;
    private int bookings;
    private String imageURL; // Changed field name to match schema
    private String previewVideoURL; // Changed field name to match schema
    private List<Integer> featureIds; // Changed to store featureIds
    private List<Topic> topics;
    private List<DescriptionContent> description;

    public static class Topic{

        private int topicId;
        private int sessionTopicId;
        private String topicName;
        private List<SubTopic> subTopics;


        public static class SubTopic{

            private int subTopicId;
            private String subTopicName;

            public int getSubTopicId() {
                return subTopicId;
            }
            public void setSubTopicId(int subTopicId) {
                this.subTopicId = subTopicId;
            }
            public String getSubTopicName() {
                return subTopicName;
            }
            public void setSubTopicName(String subTopicName) {
                this.subTopicName = subTopicName;
            }
        }

        public List<SubTopic> getSubTopics() {
            return subTopics;
        }
        public void setSubTopics(List<SubTopic> subTopics) {
            this.subTopics = subTopics;
        }

        public int getTopicId() {
            return topicId;
        }
        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }
        public int getSessionTopicId() {
            return sessionTopicId;
        }
        public void setSessionTopicId(int sessionTopicId) {
            this.sessionTopicId = sessionTopicId;
        }
        public String getTopicName() {
            return topicName;
        }
        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }

    // Inner class to represent the Description content
    public static class DescriptionContent {

        public enum ContentType {
            paragraph,
            heading,
            bulletList
        }

        private ContentType type;
        private List<Content> content;

        // Inner class to represent Content structure
        public static class Content {

            public enum Format {
                plain,
                bold,
                italic,
                link
            }

            private String text;
            private Format format; // plain, bold, italic, link
            private String href;

            // Getters and Setters
            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public Format getFormat() {
                return format;
            }

            public void setFormat(Format format) {
                this.format = format;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        // Getters and Setters
        public ContentType getType() {
            return type;
        }

        public void setType(ContentType type) {
            this.type = type;
        }

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }
    }

    // Getters and Setters

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = Math.round(rating * 10.0) / 10.0; // Mimicking the setter logic
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPreviewVideoURL() {
        return previewVideoURL;
    }

    public void setPreviewVideoURL(String previewVideoURL) {
        this.previewVideoURL = previewVideoURL;
    }

    public List<Integer> getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(List<Integer> featureIds) {
        this.featureIds = featureIds;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<DescriptionContent> getDescription() {
        return description;
    }

    public void setDescription(List<DescriptionContent> description) {
        this.description = description;
    }
}
