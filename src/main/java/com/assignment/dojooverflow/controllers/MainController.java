package com.assignment.dojooverflow.controllers;

import com.assignment.dojooverflow.models.Answer;
import com.assignment.dojooverflow.models.NewQuestion;
import com.assignment.dojooverflow.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String Index(Model model) {
        model.addAttribute("questions", this.mainService.getQuestions());
        return "index.jsp";
    }
    @GetMapping("/new")
    public String New(@ModelAttribute("newQuest") NewQuestion newQuest) {
        return "new.jsp";
    }
    @GetMapping("/{id}")
    public String Show(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
        model.addAttribute("question", this.mainService.getQuestion(id));
        return "show.jsp";
    }
    @PostMapping("/")
    public String Create(@Valid @ModelAttribute("newQuest") NewQuestion newQuest,
                         BindingResult result) {
        if(result.hasErrors())
            return "new.jsp";
        this.mainService.createQuestion(newQuest);
        return "redirect:/";
    }
    @PostMapping("/answers")
    public String CreateAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
        if(result.hasErrors())
            return "show.jsp";
        Answer newAnswer = this.mainService.createAnswer(answer);
        return "redirect:/" + newAnswer.getQuestion().getId();
    }

}
