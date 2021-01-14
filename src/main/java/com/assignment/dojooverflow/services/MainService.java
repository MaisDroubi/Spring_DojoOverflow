package com.assignment.dojooverflow.services;


import com.assignment.dojooverflow.models.Answer;
import com.assignment.dojooverflow.models.NewQuestion;
import com.assignment.dojooverflow.models.Question;
import com.assignment.dojooverflow.models.Tag;
import com.assignment.dojooverflow.repositories.AnswerRepository;
import com.assignment.dojooverflow.repositories.QuestionRepository;
import com.assignment.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    public MainService(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
    }
    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id).orElse(null);
    }
    public void createQuestion(NewQuestion question) {
        // TODO: make a real question here
        List<Tag> questionsTags = new ArrayList<Tag>();
        for(String subject: question.splitTags()) {
            Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
            if(tag == null) {
                tag = new Tag(subject);
                this.tagRepository.save(tag);
            }
            if(!questionsTags.contains(tag))
                questionsTags.add(tag);
        }
        Question newQuestion = new Question(question.getQuestion(), questionsTags);
        this.questionRepository.save(newQuestion);
    }
    public Answer createAnswer(Answer answer) {
        return this.answerRepository.save(answer);
    }


}
