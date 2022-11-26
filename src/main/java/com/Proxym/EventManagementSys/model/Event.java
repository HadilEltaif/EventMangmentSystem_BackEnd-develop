package com.Proxym.EventManagementSys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "eventPost")
public class Event {
    @Id
    @Column(unique = true)
    private Long eventId;

    @NotBlank(message = "Event Title cannot be empty or Null")
    private String TitleEvent;
    @Nullable
    @Lob
    private String Description;
    @JsonIgnore
    private Instant DepositDate;
    private String Keyword;
    private Float TicketPrice;
    @JsonIgnore
    private Integer NumberViews = 0;
    @JsonIgnore
    private Integer voteCount = 0;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "event")
    private List<Comment> commentList;


}
