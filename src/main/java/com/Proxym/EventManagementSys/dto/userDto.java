package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class userDto {
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private addressDto address;
    private String photo;
    private Instant created;
    private Boolean enabled;
    private Long PhoneNumber;
    private Set<roleDto> roles ;
    @JsonIgnore
    private Set<EventDto> events;



    public static userDto fromEntity(User user){
        if (user == null){
            return  null;
            //TODO throw new Exception
        }
        return  userDto.builder().userId(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .photo(user.getPhoto())
                .address(addressDto.fromEntity(user.getAddress()))
                .photo(user.getPhoto())
                .created(user.getCreated())
                .enabled(user.getEnabled())
                .PhoneNumber(user.getPhoneNumber())
                //.roles((Set<RoleDto>) RoleDto.fromEntity((Role) user.getRoles()))
                //.events((Set<EventDto>) EventDto.fromEntity((Event) user.getEvents()))
                .build();

    }

    public static User toEntity(userDto userDto){
        if (userDto == null){
            return  null;
            //TODO throw an exception
        }
        User user = new User();
        user.setId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPhoto(userDto.getPhoto());
        user.setCreated(userDto.getCreated());
        user.setEnabled(userDto.getEnabled());
        user.setPhoneNumber(userDto.getPhoneNumber());
        //user.setRoles(userDto.getRoles());
        return user;

    }
}
