package com.kovacic.entity.dto;

import com.kovacic.entity.File;
import com.kovacic.entity.User;
import com.kovacic.entity.base.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
        * Created by ikovacic.
        */
@Getter
@Setter
public class BlogDto extends AuditModel {
    private Long id;
    private String title;
    private String content;
    private List<CommentDto> commentDtos;
    private User user;
    private File attachment;

    public BlogDto() {
    }

}
