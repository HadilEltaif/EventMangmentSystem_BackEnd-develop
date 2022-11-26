package com.Proxym.EventManagementSys.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {
    @Id
    @Column(unique = true)
    private Long id;

    private VoteType voteType;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "event_id")
    private Event eventPost;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
