package com.assignment.dojooverflow.repositories;

import com.assignment.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    Optional<Tag> findBySubject(String subject);
}
