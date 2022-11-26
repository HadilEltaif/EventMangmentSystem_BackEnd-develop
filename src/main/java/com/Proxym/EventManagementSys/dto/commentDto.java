package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class commentDto {
    private Long id;
    private String text;
    @JsonIgnore
    private EventDto event;


   public static commentDto fromEntity(Comment comment){
       if (comment==null){
           return  null;
           //TODO throw new exception
           //comment -> CommentDto
       }
       return commentDto.builder().id(comment.getId())
               .text(comment.getText()).build();
   }

    public Comment toEntity(commentDto commentDto){
      if(commentDto == null)
          //TODO throw exception
          return  null ;
      //commentDto -> Comment
      Comment comment =  new Comment();
      comment.setId(commentDto.getId());
      comment.setText(commentDto.getText());
      return comment;
    }
}
