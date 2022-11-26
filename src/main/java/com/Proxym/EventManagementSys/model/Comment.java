package com.Proxym.EventManagementSys.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comment")
public class Comment {
    @Id

    @Column(unique = true)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
