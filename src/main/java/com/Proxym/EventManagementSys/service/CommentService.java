package com.Proxym.EventManagementSys.service;

import com.Proxym.EventManagementSys.dto.commentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CommentService {
    commentDto save(commentDto Dto);

    commentDto findCommentById(Long id);

    List<commentDto> findAll();

    void delete(Long id);
}
