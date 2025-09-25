package com.jscyril.unilink.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ClubMembershipId implements Serializable {
    private Long userId;
    private Long clubId;

    // Constructors
    public ClubMembershipId() {}

    public ClubMembershipId(Long userId, Long clubId) {
        this.userId = userId;
        this.clubId = clubId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMembershipId that = (ClubMembershipId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(clubId, that.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, clubId);
    }
}