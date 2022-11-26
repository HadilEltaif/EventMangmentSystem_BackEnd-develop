package com.Proxym.EventManagementSys.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/***
 *
 * les categories :
 * concerts
 * randonnées
 * séminaires
 *
 *  ***/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id

    @Column(unique = true)
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Event> events;

}
