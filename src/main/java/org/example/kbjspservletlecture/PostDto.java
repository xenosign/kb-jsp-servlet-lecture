package org.example.kbjspservletlecture;

import java.sql.Timestamp;

public class PostDto {
    private int postId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private String username;

    public PostDto(int postId, String title, String content, Timestamp createdAt, String username) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.username = username;
    }

    // Getters and setters
    public int getPostId() { return postId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Timestamp getCreatedAt() { return createdAt; }
    public String getUsername() { return username; }
}
