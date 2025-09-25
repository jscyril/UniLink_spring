package com.jscyril.unilink.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "events", indexes = {
    @Index(name = "idx_events_target", columnList = "target_type, target_id")
})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type", nullable = false, length = 100)
    private String eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_user_id")
    private User actorUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type")
    private EventTargetType targetType;

    @Column(name = "target_id")
    private Long targetId;

    @Column(columnDefinition = "JSONB")
    private String metadata; // Store JSON as String

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    // Constructors
    public Event() {}

    public Event(String eventType, User actorUser, EventTargetType targetType, Long targetId) {
        this.eventType = eventType;
        this.actorUser = actorUser;
        this.targetType = targetType;
        this.targetId = targetId;
    }
}
