package com.Proxym.EventManagementSys.model;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(unique = true)
    private Long id;

    @NotBlank(message = "Username is required")
    private String userName;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @Embedded
    private  Address address;

    private Instant created;
    private Boolean enabled;
    private Long PhoneNumber;
    private String photo;

    @ManyToMany(fetch = LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id"))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy="user")
    private Set<Event> events;
}
