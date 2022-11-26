package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class voteDto {
    private Long voteId;
    private VoteType voteType;
    private EventDto eventPost;
    private userDto user;


}
