package com.jscyril.unilink.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;


@Getter
@Setter
@Entity
@Table(name = "club_memberships")
public class ClubMembership {
    @EmbeddedId
    private ClubMembershipId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("clubId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembershipRole role = MembershipRole.MEMBER;

    @Column(name = "joined_at", nullable = false)
    private Instant joinedAt;

    @Column(nullable = false, length = 50)
    private String status = "ACTIVE";

    @PrePersist
    protected void onCreate() {
        joinedAt = Instant.now();
    }

    public ClubMembership() {}

    public ClubMembership(User user, Club club) {
        this.id = new ClubMembershipId(user.getId(), club.getId());
        this.user = user;
        this.club = club;
    }

    public ClubMembership(User user, Club club, MembershipRole role) {
        this(user, club);
        this.role = role;
    }
}
