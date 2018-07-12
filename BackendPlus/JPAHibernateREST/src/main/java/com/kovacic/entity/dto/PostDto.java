package com.kovacic.entity.dto;

import com.kovacic.entity.Comment;
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
public class PostDto extends AuditModel {
    private Long id;
    private String title;
    private String content;
    private byte[] attachment;
    private List<Comment> comments;
    private User userId;

    public PostDto() {
    }

}
