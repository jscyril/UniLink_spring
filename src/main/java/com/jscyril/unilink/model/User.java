package com.jscyril.unilink.model;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false, unique = true,length = 320)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.USER;

    private Boolean isActive = true;
    private Boolean isVerified = false;
    private String displayName;
    @Column(columnDefinition = "text")
    private String bio;
    private String avatarUrl;

    private Instant lastLoginAt;
    private Instant createdAt;
    private Instant updatedAt;


}
