package com.kovacic.repository;

import com.kovacic.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
