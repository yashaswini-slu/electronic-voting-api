package com.techgee.electronicvoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgee.electronicvoting.resource.PollQuestionOptionResource;
import com.techgee.electronicvoting.service.PollQuestionService;
import com.techgee.electronicvoting.shared.Parameters;

@RestController
@RequestMapping("/pollQuestion")
public class PollQuestionController {
	
	@Autowired
	PollQuestionService pollQuestionService;
	
	@PostMapping(value = "/create/{pollId}")
	public PollQuestionOptionResource create(@PathVariable(value = "pollId") Long pollId, @RequestBody PollQuestionOptionResource pollQuestionOptionResource) {
		return pollQuestionService.create(pollQuestionOptionResource, Parameters.builder().id(pollId).build());
	}
	
	@GetMapping(value="list/{pollId}")
	public List<PollQuestionOptionResource> list(@PathVariable(value="pollId") Long pollId) {
		return pollQuestionService.listQuestions(Parameters.builder().id(pollId).build());
	}

}
