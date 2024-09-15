package com.ashutosh.bean;

import java.util.List;

public class Session {

    // Fields representing the main Session schema
    private String name;
    private int classLevel; // "class" is a reserved keyword in Java, so renamed to classLevel
    private String subject;
    private String language;
    private List<Topic> topics;
    private int duration;
    private double price;
    private double rating;
    private int bookings;
    private String image;
    private String previewVideo;
    private List<Features> features;
    private List<DescriptionContent> description;

    public enum Features {
        Live_1_1_Tutoring,
        Notes,
        Practice_Tests,
        Doubt_Chat_Support,
        Flexible_Timings,
        Session_Recordings,
        Materials_List,
        Writing_Prompts,
        Discussion_Forums,
        Virtual_Whiteboard,
        Group_Discussions,
        Feedback_Sessions,
        Group_Projects
    }

    // Inner class to represent the Topic structure
    public static class Topic {
        private String topicName;
        private List<String> subTopics;

        // Getters and Setters
        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public List<String> getSubTopics() {
            return subTopics;
        }

        public void setSubTopics(List<String> subTopics) {
            this.subTopics = subTopics;
        }
    }

    // Inner class to represent the Description content

    public static class DescriptionContent {

        public enum ContentType{
            paragraph,
            heading,
            bulletList
        }
        private ContentType type;
        private List<Content> content;

        // Inner class to represent Content structure
        public static class Content {

            public enum Format{
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

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPreviewVideo() {
        return previewVideo;
    }

    public void setPreviewVideo(String previewVideo) {
        this.previewVideo = previewVideo;
    }

    public List<Features> getFeatures() {
        return features;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }

    public List<DescriptionContent> getDescription() {
        return description;
    }

    public void setDescription(List<DescriptionContent> description) {
        this.description = description;
    }
}
