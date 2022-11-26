package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class roleDto {

 public static roleDto fromEntity(Role role ){
     if(role == null){
     return null;
     }
     return roleDto.builder().build();
 }
}
