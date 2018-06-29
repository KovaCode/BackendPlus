package com.kovacic.entity.dto;

import com.kovacic.entity.User;
import com.kovacic.entity.base.AuditModel;
import lombok.Getter;
import lombok.Setter;

/**
        * Created by ikovacic.
        */
@Getter
@Setter
public class CommentDto extends AuditModel {
    private Long id;
    private String comment;
    private User user;

    public CommentDto() {
    }

}
