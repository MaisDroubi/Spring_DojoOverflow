package com.assignment.dojooverflow.repositories;

import com.assignment.dojooverflow.models.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAll();

}
