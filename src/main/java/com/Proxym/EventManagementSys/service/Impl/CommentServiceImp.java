package com.Proxym.EventManagementSys.service.Impl;

import com.Proxym.EventManagementSys.dto.CategoryDto;
import com.Proxym.EventManagementSys.dto.commentDto;
import com.Proxym.EventManagementSys.exception.entityNotFoundException;
import com.Proxym.EventManagementSys.exception.errorCodes;
import com.Proxym.EventManagementSys.exception.invalidEntityException;
import com.Proxym.EventManagementSys.model.Category;
import com.Proxym.EventManagementSys.model.Comment;
import com.Proxym.EventManagementSys.repository.commentRepository;
import com.Proxym.EventManagementSys.service.CommentService;
import com.Proxym.EventManagementSys.validator.CategoryValidator;
import com.Proxym.EventManagementSys.validator.CommentValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Data
@Service
public class CommentServiceImp implements CommentService {
    private final commentRepository commentRepository;

    @Override
    public commentDto save(commentDto Dto) {
        List<String> errors = CommentValidator.validate(Dto);
        if (!errors.isEmpty()) {
            log.error("Comment is invalid !{}", Dto);
            throw new invalidEntityException("Comment is  invalid !",
                    errorCodes.COMMENT_NOT_VALID, errors);
        }
        commentDto dto;
        dto = Dto.fromEntity(commentRepository.save(Dto.toEntity(Dto)));
        return dto;

    }

    @Override
    public commentDto findCommentById(Long id) {
        if (id == null) {
            log.error("the comment id is null{}");
            return null;
        }
        Optional<Comment> comment = commentRepository.findById(id);
        commentDto dto = commentDto.fromEntity(comment.get());
        return Optional.of(dto).orElseThrow(()
                -> new entityNotFoundException("No comment with ID : "
                + id + "was not found in the DB ", errorCodes.COMMENT_NOT_FOUND));
    }

    @Override
    public List<commentDto> findAll() {
        return commentRepository.findAll().stream()
                .map(commentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("the category id is null{}");
        }
        commentRepository.deleteById(id);

    }
}
