package com.Proxym.EventManagementSys.controller;

import com.Proxym.EventManagementSys.controller.api.commentApi;
import com.Proxym.EventManagementSys.dto.commentDto;
import com.Proxym.EventManagementSys.service.CommentService;
import com.Proxym.EventManagementSys.service.categoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
public class CommentController implements commentApi {

    private final CommentService commentService;

    @Override
    public commentDto save(commentDto commentDto) {
        return commentService.save(commentDto);
    }

    @Override
    public commentDto findByCategoryId(Long id) {
        return commentService.findCommentById(id);
    }

    @Override
    public List<commentDto> findAll() {
        return commentService.findAll();
    }

    @Override
    public void delete(Long id) {
        commentService.delete(id);
    }
}
