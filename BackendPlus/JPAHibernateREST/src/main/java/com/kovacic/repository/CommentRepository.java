package com.kovacic.repository;

import com.kovacic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CommentRepository extends JpaRepository<Comment, Long> {
}


