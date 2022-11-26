package com.Proxym.EventManagementSys.validator;

import com.Proxym.EventManagementSys.dto.EventDto;
import com.Proxym.EventManagementSys.dto.commentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommentValidator {

    public static List<String> validate(commentDto commentDto) {
        List<String> errors = new ArrayList<>();
        if (commentDto == null) {
            errors.add("Please enter a text for the comment!!! ");
        } else {
            if (!StringUtils.hasLength(commentDto.getText()))
                errors.add("Please enter a text for the comment!!! ");
        }
        return errors;
    }
}
