package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.core.abstracts.utilities.result.Result;
import com.hrms.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleControllers {

	@Autowired
	private JobTitleService jobtitleService;

	public JobTitleControllers(JobTitleService jobtitleService) {
		super();
		this.jobtitleService = jobtitleService;
	}

	@GetMapping("/getall")
	public List<JobTitle> getAll() {

		return this.jobtitleService.getAll();

	}

	@PostMapping(value = "/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobtitleService.add(jobTitle);
	}

}
