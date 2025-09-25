package com.jscyril.unilink.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "clubs")

public class Club {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private ClubVisibility visibility = ClubVisibility.PUBLIC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    private Instant createdAt;
    private Instant updatedAt;

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private Set<Post> posts;
}

enum ClubVisibility {
    PUBLIC,
    PRIVATE,
    SECRET}
