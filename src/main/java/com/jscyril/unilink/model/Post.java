package com.jscyril.unilink.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "text")
    private String body;

    private String imageUrl;
    private Instant createdAt;
    private Instant updatedAt;
}
