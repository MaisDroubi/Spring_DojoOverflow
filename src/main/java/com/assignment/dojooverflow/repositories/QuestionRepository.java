package com.assignment.dojooverflow.repositories;

import com.assignment.dojooverflow.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();

}
