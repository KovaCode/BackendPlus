package com.kovacic.repository;

import com.kovacic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface FileRepository extends JpaRepository<File, Long> {
}
