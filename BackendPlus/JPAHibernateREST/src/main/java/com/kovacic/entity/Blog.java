package com.kovacic.entity;

import com.kovacic.entity.base.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
        * Created by ikovacic.
        */
@Entity
@Table(name = "blogs")
@Getter
@Setter
public class Blog extends AuditModel implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;
    @Lob
    @Column
    private byte[] attachment;

    @JoinColumn(name = "comment_id")
    @ManyToMany(
            fetch = FetchType.EAGER)
    private List<Comment> comments;

    @JoinColumn(name = "user_id")
    @OneToOne(
            fetch = FetchType.EAGER)
    private User userId;

    public Blog() {
    }

}
